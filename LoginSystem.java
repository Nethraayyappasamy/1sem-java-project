import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String storedUsername = "admin";
        String storedPassword = "Admin123"; // valid password

        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            // Username check
            if (!username.equals(storedUsername)) {
                System.out.println("Invalid Username");
                continue;
            }

            // Password validation rules
            if (!isValidPassword(password)) {
                System.out.println("Password must contain:");
                System.out.println("- At least 8 characters");
                System.out.println("- One uppercase letter");
                System.out.println("- One lowercase letter");
                System.out.println("- One digit");
                continue;
            }

            // Authentication
            if (password.equals(storedPassword)) {
                System.out.println("Login Successful");
                break;
            } else {
                attempts--;
                System.out.println("Incorrect Password");
                System.out.println("Remaining attempts: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Account Locked");
        }

        sc.close();
    }

    // Method to validate password rules
    public static boolean isValidPassword(String password) {
        if (password.length() < 8)
            return false;

        boolean hasUpper = false, hasLower = false, hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))
                hasUpper = true;
            else if (Character.isLowerCase(ch))
                hasLower = true;
            else if (Character.isDigit(ch))
                hasDigit = true;
        }

        return hasUpper && hasLower && hasDigit;
    }
}