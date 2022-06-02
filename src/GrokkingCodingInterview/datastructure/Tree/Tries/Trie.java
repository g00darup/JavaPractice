package GrokkingCodingInterview.datastructure.Tree.Tries;

public class Trie{
    private TrieNode root; //Root Node

    //Constructor
    Trie(){
        root = new TrieNode();
    }
    //Function to get the index of a character 't'
//    public int getIndex(char t){
//        return t - 'a';
//    }

    //Function to insert a key,value pair in the Trie
    //public void insert(String key,int value){}

    //Function to get the index of a character 'x'
    public int getIndex(char x)
    {
        return x - 'a';  // the index is based on the position of character in alphabets
    }

    //Function to insert a key in the Trie
    public void insert(String key)
    {
        if(key == null) //Null keys are not allowed
        {
            System.out.println("Null Key can not be Inserted!");
            return;
        }
        key = key.toLowerCase(); //Keys are stored in lowercase
        TrieNode currentNode = this.root;
        int index = 0; //to store character index

        //Iterate the Trie with given character index,
        //If it is null, then simply create a TrieNode and go down a level
        for (int level = 0; level < key.length(); level++)
        {
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null)
            {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        //Mark the end character as leaf node
        currentNode.markAsLeaf();
    }
/*
Explanation #
The Search() function takes in the “key” of type string as an argument and returns a boolean true or false based on if the “key” is found in Trie or not.

As we know from insertion, null keys aren’t allowed and all characters are stored in lowercase.

Just like we did in insertion, we’ll traverse the key character by character, and for each character, we will see if children exist for currentNode for that particular index. We generate an index of each character by calling getIndex()), and we will simply return false if children don’t exist. We only return true if the key is completely traversed and isEndWord() is set for the last node in the path.

Time Complexity #
If the length of the word is hh, the worst-case time complexity is O(h)O(h). In the worst case, we have to look at hh consecutive levels of a trie for a character in the key being searched for. The presence or absence of each character from the key in the trie can be determined in O(1)O(1) because the size of the alphabet is fixed. Thus, the running time of search in a trie is O(h)O(h)
 */
    //Function to search given key in Trie
    //Function to search given key in Trie
    public boolean search(String key) {

        if (key == null) return false; //Null Key

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        //Iterate the Trie with given character index,
        //If it is null at any point then we stop and return false
        //We will return true only if we reach leafNode and have traversed the
        //Trie based on the length of the key

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }
        if (currentNode.isEndWord) return true;

        return false;
    }
    /*
    Deleting a word in Trie #
While deleting a word from a Trie, we make sure that the node that we are trying to delete does not have any further branches. If there are no branches, then we can easily remove the node. However, if the node contains further branches then this opens up a lot of the scenarios covered below.

Case 1: If the word to be deleted has no common subsequence #
If the word to be deleted has no common subsequence, then all the nodes of that word are deleted.
For example, in the figure given below, we have to delete all characters of “bat” in order to delete the word bat.

    root
    t
    b
    h
    a
    e
    t
    i
    r
1 of 9







Case 2: If the word to be deleted is a prefix of some other word #
If the word to be deleted is a prefix of some other word, then the value of isEndWord of the last node of that word is set to false, and no node is deleted.
For example, we will simply unmark e to delete the word the and show that it doesn’t exist anymore.

    root
    t
    b
    h
    a
    e
    t
    i
    r
1 of 6







Case 3: If the word to be deleted has a common prefix #
If the word to be deleted has a common prefix and the last node of that word is also the leaf node (i.e. the last node of its branch), then this node is deleted along with all the higher-up nodes in its branch that do not have any other children and whose isEndWord is false.
For example, we’ll traverse the common path up to the and delete the characters “i” and “r” in order to delete their.

    root
    t
    b
    h
    a
    e
    t
    i
    r
1 of 15







Implementation #
The following is the code snippet, so try to understand the code. If you don’t understand any point, you can read the explanation below.
     */

    /*

     */

    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++){
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {
        boolean deletedSelf = false;

        if (currentNode == null){
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)){
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else
            {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }
        else
        {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted)
            {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord){
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else{
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
    //Function to get root
    public TrieNode getRoot() {
        return root;
    }
}