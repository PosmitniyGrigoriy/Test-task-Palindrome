package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class NotPalindromeException extends BaseException {
    public NotPalindromeException() {
        super(HttpStatus.FORBIDDEN, "Ваш вариант не является палиндромом. Попробуйте еще раз.");
    }
}
