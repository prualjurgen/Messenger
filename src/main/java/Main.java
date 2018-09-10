import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileUserService fileUserService = new FileUserService(new IOUtils());
        while (true) {
            System.out.println("0. Save and end program");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Chat");
            int answer = Integer.parseInt(scanner.nextLine());
            switch (answer) {
                case 1:
                    fileUserService.addUser();
                    break;
                case 2:
                    fileUserService.login();
                    break;
                case 0:
                    return;
                case 3:
                    fileUserService.chat();

            }
        }
    }
}