package GrokkingCodingInterview.datastructure.Tree.Tries;
/*
Problem Statement #
In this problem, you have to implement the findWords() function to return all of the words stored in the Trie in alphabetically sorted order.

Function Prototype: #
ArrayList<String> findWords(TrieNode root);
Here, root is the root node of Trie.

Output: #
In the form of an ArrayList, it returns all of the words stored in the Trie in lexicographic order.

Sample Input #
String keys[] = {"the", "a", "there", "answer", "any",
                     "by", "bye", "their","abc"};
Sample Output #
"a", "abc","answer","any","by","bye","the","their","there"
 */

import java.util.ArrayList;
import java.util.Arrays;

public class TrieWords {
    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str) {
        //Leaf denotes end of a word
        if (root.isEndWord) {
            //current word is stored till the 'level' in the character array
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                //Non-null child, so add that index to the character array
                str[level] = (char)(i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }
    public static ArrayList< String > findWords(TrieNode root) {
        ArrayList < String > result = new ArrayList < String > ();
        char[] chararr = new char[20];
        getWords(root, result, 0, chararr);
        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = findWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
