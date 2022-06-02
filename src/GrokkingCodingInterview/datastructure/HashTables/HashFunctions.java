package GrokkingCodingInterview.datastructure.HashTables;

public class HashFunctions
{
    public static int hashModular(int key, int size)
    {
        return key % size;
    }
    public static int hashTruncation(int key)
    {
        return key % 500; // we will use key upto 3 digits
    }

    public static int hashFold(int key, int chunkSize) // Define the size of each divided portion
    {
        System.out.println ("Key: "+ key);
        String strKey = Integer.toString(key); // Convert integer into string for slicing
        int hashVal = 0;
        System.out.println("Chunks:");

        for(int i = 0; i < strKey.length(); i+=chunkSize)
        {
            if(i + chunkSize < strKey.length())
            {
                System.out.println(strKey.substring(i,i+chunkSize));
                hashVal += Integer.parseInt(strKey.substring(i,i+chunkSize));
            }
            else
            {
                System.out.println(strKey.substring(i,strKey.length()));
                hashVal+= Integer.parseInt(strKey.substring(i,strKey.length()));
            }
        }
        return hashVal;
    }
    public static void main( String args[] )
    {
        int [] list = new int[10];// List of size 10
        int key = 35;
        int index = hashModular(key, 10); // Fit the key into the list size
        System.out.println("The index for key " + key + " is " + index);
        int key2 = 123456;
        int inde2 = hashTruncation(key2); // Fit the key into the list size
        System.out.println("The index for key " + key + " is " + index);

        int chunkSize = 2;
        System.out.println("Hash Key: " + hashFold(key, chunkSize));
    }
}

//https://research.cs.vt.edu/AVresearch/hashing/quadratic.php

//https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/BucketHash.html
//https://research.cs.vt.edu/AVresearch/hashing/pseudo.php
//https://courses.cs.washington.edu/courses/cse373/01sp/Lect13.pdf