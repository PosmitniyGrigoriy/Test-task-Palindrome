package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class LoginRegisteredException extends BaseException {
    public LoginRegisteredException(String login) {
        super(HttpStatus.FORBIDDEN, String.format("Кто-то пытался зарегистрироваться под логином '%s', " +
                "но он уже зарегистрирован на другого игрока.", login));
    }
}
