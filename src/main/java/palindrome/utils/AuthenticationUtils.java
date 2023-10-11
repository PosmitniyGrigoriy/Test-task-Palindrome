package palindrome.utils;

import palindrome.dto.request.LoginRequestDto;
import palindrome.dto.request.RegisterRequestDto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class AuthenticationUtils {

    private AuthenticationUtils() {}

    public static RegisterRequestDto fillRegistrationDto() {
        Scanner scannerRegistration = new Scanner(System.in);
        System.out.println("\nРегистрация нового игрока\n");
        System.out.print("Напишите ваше имя:   ");
        String firstName = scannerRegistration.nextLine();
        System.out.print("Напишите ваш логин:  ");
        String login = scannerRegistration.nextLine();
        System.out.print("Напишите ваш пароль: ");
        String password = scannerRegistration.nextLine();
        return new RegisterRequestDto(firstName, login, password);
    }

    public static LoginRequestDto fillLoginDto() {
        Scanner scannerLogin = new Scanner(System.in);
        System.out.println("\nВойти в игру\n");
        System.out.print("Напишите ваш логин:  ");
        String login = scannerLogin.nextLine();
        System.out.print("Напишите ваш пароль: ");
        String password = scannerLogin.nextLine();
        return new LoginRequestDto(login, password);
    }

    public static String getPasswordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

}
