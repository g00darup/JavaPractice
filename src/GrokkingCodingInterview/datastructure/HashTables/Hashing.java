package GrokkingCodingInterview.datastructure.HashTables;

class Hashing {
    public static String getValue(int key)
    {
        String [] myString = // pun intended
                {
                        "I am a programmer, I have no life.",
                        "8 bytes walk into a bar, the bartenders asks \"What will it be?\"One of them says, \"Make us a double.\"",
                        "Computers are useless. They can only give you answers.\n-Pablo Picasso"
                };
        if (key <= myString.length)
            return myString[key];    // value returned in constant time
        else
            System.out.println("Key Not Found!\n");
        return "";
    }
    public static void main( String args[] )
    {
        System.out.println( getValue(1) ); // Test your output for other keys
    }
}
