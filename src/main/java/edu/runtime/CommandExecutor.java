package main.java.edu.runtime;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CommandExecutor {
    public void exceuteCommand(String commandString,String
            directoryToExecuteCommand) {
        try {
            //commandString = "bash " + "-c " +commandString;
            ProcessBuilder processBuilder = new ProcessBuilder(commandString);
            Map<String, String> env = processBuilder.environment();
            //processBuilder.directory(new File(directoryToExecuteCommand));
            processBuilder.start();
//            String envPath="/usr/bin/nodejs";
//            env.put("PATH",envPath);
           // processBuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) throws IOException {
//        CommandExecutor commandExecutor=new CommandExecutor();
//        //commandExecutor.exceuteCommand();
//        commandExecutor.exceuteCommand("node", "server.js");
        ProcessBuilder process = new ProcessBuilder("node", "server.js");
                //.directory(navigatePath)

        process.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        process.redirectError(ProcessBuilder.Redirect.INHERIT);
        process.start();
    }

}