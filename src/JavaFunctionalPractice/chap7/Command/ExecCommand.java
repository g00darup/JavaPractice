package JavaFunctionalPractice.chap7.Command;

public class ExecCommand {
    public static void main(String[] args) {
        Character character1 = new Character();
        Commands commands = new Commands();

        commands.addCommand(new WalkCommand(character1));
        commands.addCommand(new RunCommand(character1));
        commands.addCommand(new JumpCommand(character1));
        commands.executeCommand();

        Character character2 = new Character();
        FunctionalCommands fc = new FunctionalCommands();
        fc.addCommand(() -> character2.walk());
        fc.addCommand(() -> character2.run());
        fc.addCommand(() -> character2.jump());
        fc.executeCommand();
    }
}
