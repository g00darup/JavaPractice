package main.java.edu.runtime;
 import java.util.*;
        import java.lang.*;

// Main class

public class RunChrome{
    // Main driver method
    public static void main(String[] args)
    {
        // Try block to check for exceptions
        try {

            // Creating a process and execute google-chrome
//            Process process = Runtime.getRuntime().exec(
//                    "google-chrome");
//            System.out.println(
//                    "Google Chrome successfully started");

            System.out.println("" + Runtime.getRuntime()
                    .availableProcessors());
           // Method 2: exit()
            // Making program to exit
            Runtime.getRuntime().exit(0);
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            // Display the exception on the console
            e.printStackTrace();
        }
    }
}
