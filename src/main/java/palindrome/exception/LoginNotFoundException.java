package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class LoginNotFoundException extends BaseException {
    public LoginNotFoundException(String login) {
        super(HttpStatus.NOT_FOUND, String.format("Кто-то пытался войти под логином '%s', " +
                "но такого логина в базе нет.", login));
    }
}
