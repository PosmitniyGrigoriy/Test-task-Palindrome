package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException(String login) {
        super(HttpStatus.FORBIDDEN, String.format("Кто-то пытался войти под логином '%s', " +
                "но не подошел пароль.", login));
    }
}
