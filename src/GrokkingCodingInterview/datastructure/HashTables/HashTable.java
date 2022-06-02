package GrokkingCodingInterview.datastructure.HashTables;

import java.util.ArrayList;

/*
Hash Table using Buckets #
As said earlier, Hash Tables are implemented using Arrays. The implementation of a Hash Table is quite simple. In this lesson, we will use Bucket strategy to avoid collisions. In the Bucket strategy, we chain different arrays together to store elements, where each array is called Bucket.

The size of the Hash Table is set as:

n*mn∗m

Here, n is the number of keys it can hold, and m is the number of slots each bucket contains. Each slot holds a key/value pair.

We will start by building a simple class. As discussed earlier, a typical Hash entry consists of three data members: a key, the data itself, and the reference to a new entry.
 */

class HashEntry {
    String key;
    int value;

    // Reference to next entry
    HashEntry next;

    // Constructor
    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

// Class to represent entire hash table
public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    //Constructor
    public HashTable() {
        bucket = new ArrayList<HashEntry>();
        slots = 10;
        size = 0;
        //initialize buckets
        for (int i = 0; i < slots; i++)
            bucket.add(null);

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getIndex(String key) {

        //hashCode is a built in function of Strings
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        //Check if index is negative
        if(index<0){
            index=(index + slots) % slots;
        }
        return index;
    }

    //Inserts a key value pair into table
    public void insert(String key, int value)
    {
        //Find head of the chain
        int b_Index = getIndex(key);
        HashEntry head = bucket.get(b_Index);

        //Checks if the key is already exists
        while(head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Inserts key in the chain
        size++;
        head = bucket.get(b_Index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next = head;
        bucket.set(b_Index, new_slot);


        //Checks if array >60% of the array gets filled
        if ((1.0*size)/slots >= 0.6)
        {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            for (HashEntry head_Node : temp)
            {
                while (head_Node != null)
                {
                    insert(head_Node.key, head_Node.value);
                    head_Node = head_Node.next;
                }
            }
        }


    }

    // Return a value for a given key
    public int getValue(String key)
    {
        // Find the head of chain
        int b_Index = getIndex(key);
        HashEntry head = bucket.get(b_Index);

        // Search key in the slots
        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        // If key not found
        return 0;
    }

    //Remove a value based with key
    public int delete(String key)
    {
        //Find index
        int b_Index = getIndex(key);

        // Get head of the chain for that index
        HashEntry head = bucket.get(b_Index);

        //Find the key in slots
        HashEntry prev = null;
        while (head != null)
        {
            //If key exists
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key does not exist
        if (head == null)
            return 0;

        // Decrease the size by one
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(b_Index, head.next);

        return head.value;
    }


}