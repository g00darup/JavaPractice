package GrokkingCodingInterview.datastructure.Tree.Tries;
/*
Previously, we discussed a few properties that a Trie must hold in order to improve the performance.
In this lesson, we will take a look at the basic structure of Trie and then build a class in Java with the help of these concepts.

svg viewer
An example of a Trie.
Representation of a Node #
A node in a Trie represents a letter in an alphabet. For example,
if we want to insert “hello” in the Trie, we will need to add 5 nodes, one for each alphabet.
A typical Node in a Trie consists of two data members:

children[]: An array which consists of the children nodes. The size of this array depends on the number of alphabets
(26 for the English language). By default, all elements are set to Null.
isEndWord: A flag to indicate the end of a word. It is set to false by default
and is only updated when an end of the word is observed during insertion.
 */

public class TrieNode {

    public TrieNode[] children;
    boolean isEndWord; //will be true if the node represents the end of word
    static final int ALPHABET_SIZE = 26; //Total # of English Alphabets = 26
    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    //Function to mark the currentNode as Leaf
    public void markAsLeaf(){
        this.isEndWord = true;
    }

    //Function to unMark the currentNode as Leaf
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }

}
