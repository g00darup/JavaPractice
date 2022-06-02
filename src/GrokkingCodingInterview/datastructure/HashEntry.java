package GrokkingCodingInterview.datastructure;

public //One Entry in the Hash Table
class HashEntry
{
    String key;
    int value;

    // Reference to next node
    HashEntry next;

    // Constructor
    public HashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }
}