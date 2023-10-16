package palindrome.utils;

import palindrome.dto.request.LoginRequestDto;
import palindrome.dto.request.RegisterRequestDto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import static palindrome.utils.ConstantsUtils.*;

public class AuthenticationUtils {

    private AuthenticationUtils() {}

    public static RegisterRequestDto fillRegistrationDto() {
        Scanner scannerRegistration = new Scanner(System.in);
        System.out.println(TITLE_NEW_PLAYER_REGISTRATION);
        System.out.print(TITLE_NAME);
        String firstName = scannerRegistration.nextLine();
        System.out.print(TITLE_LOGIN);
        String login = scannerRegistration.nextLine();
        System.out.print(TITLE_PASSWORD);
        String password = scannerRegistration.nextLine();
        return new RegisterRequestDto(firstName, login, password);
    }

    public static LoginRequestDto fillLoginDto() {
        Scanner scannerLogin = new Scanner(System.in);
        System.out.println(TITLE_LOGIN_TO_GAME);
        System.out.print(TITLE_LOGIN);
        String login = scannerLogin.nextLine();
        System.out.print(TITLE_PASSWORD);
        String password = scannerLogin.nextLine();
        return new LoginRequestDto(login, password);
    }

    public static String getPasswordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

}
