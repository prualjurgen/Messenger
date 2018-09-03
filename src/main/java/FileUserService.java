import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUserService {

    IOUtils ioUtils;

    public FileUserService(IOUtils ioUtils) {

        this.ioUtils = ioUtils;
    }

    public void addUser() {
        try {
            ioUtils.writeMessage("Enter email: ");
            String email = ioUtils.readNextLine();
            if (ioUtils.fileExist(email + ".txt")) {
                ioUtils.writeMessage("user already exist");
                return;
            }
            ioUtils.writeMessage("All Good");
            ioUtils.writeMessage("Enter your password");
            String password = ioUtils.readNextLine();
            ioUtils.writeMessage("Enter your full name: ");
            String name = ioUtils.readNextLine();
            ioUtils.writeMessage("Enter your age: ");
            int age = ioUtils.scanner.nextInt();
            PrintWriter writer = new PrintWriter(email + ".txt");
            writer.println(email);
            writer.println(name);
            writer.println(age);
            writer.println(password);
            writer.close();
        } catch (IOException e) {
            ioUtils.writeMessage("file not found");
        }
    }

    public void login() {
        ioUtils.writeMessage("Enter your email: ");
        String enteredEmail = ioUtils.readNextLine();
        ioUtils.writeMessage("Enter password: ");
        String enteredPassword = ioUtils.readNextLine();
        try {
            Path filePath = Paths.get(enteredEmail + ".txt");
            List<String> lines = Files.readAllLines(filePath);

            if (lines.get(0).equals(enteredEmail) && lines.get(3).equals(enteredPassword)) {
                ioUtils.writeMessage("Welcome " + lines.get(1));
            } else {
                ioUtils.writeMessage("Entered Email or password is Incorrect");
                return;
            }

        } catch (IOException e) {
            ioUtils.writeMessage("Password or email is incorrect");
        }

    }


    public void chat() throws IOException {
        ioUtils.writeMessage("Enter your email: ");
        String enteredEmail = ioUtils.readNextLine();
        ioUtils.writeMessage("Enter password: ");
        String enteredPassword = ioUtils.readNextLine();
        Path filePath = Paths.get(enteredEmail + ".txt");
        List<String> lines = Files.readAllLines(filePath);
        if (lines.get(0).equals(enteredEmail) && lines.get(3).equals(enteredPassword)) {
            ioUtils.writeMessage("Welcome " + lines.get(1));
        } else {
            ioUtils.writeMessage("Entered Email or password is Incorrect");
            return;
        }
        ///STARTING CHAT -- TAKING FRIEND EMAIL

        ioUtils.writeMessage("IT IS THE TIME...what is your friends email?");
        String friendsEmail = ioUtils.readNextLine();

        //CHECKING IF FRIENDS EMAIL IS IN SYSTEM
        try {
            if (ioUtils.fileExist(friendsEmail + ".txt")) {
                ioUtils.writeMessage("great say hello to your buddy(found friend email)");
            } else {
                ioUtils.writeMessage("no such email in our system");

            }

            //CHECKING IF CONVERSATION EXISTS
            try {
                Path filePath2 = Paths.get(enteredEmail + " " + friendsEmail);
                List<String> conversation = Files.readAllLines(filePath2);


                if (ioUtils.fileExist(enteredEmail + " " + friendsEmail + ".txt")) {
                    for (String line: conversation) {
                        ioUtils.writeMessage(line);

                    }
                } else {
                    PrintWriter writer = new PrintWriter(enteredEmail + " " + friendsEmail + ".txt");
                    writer.println("new Conversation");
                    ioUtils.writeMessage("This is a new conversation");
                    writer.close();
                }

                //WRITE MESSAGE
                PrintWriter writer2 = new PrintWriter(enteredEmail + " " + friendsEmail + ".txt");
                ioUtils.writeMessage("message: ");
                String message = ioUtils.readNextLine();
                writer2.println(message);
                writer2.close();

            } catch (IOException e) {
                ioUtils.writeMessage("error wtf");
                ioUtils.writeMessage(String.valueOf(e));
            }
        } catch (Exception e) {
        }
    }
}

