package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class PalindromeAddedException extends BaseException {
    public PalindromeAddedException(String login, String palindrome) {
        super(HttpStatus.FORBIDDEN, String.format("Игрок с логином '%s' хотел повторно ввести палиндром '%s'. " +
                "Операция отклонена.", login, palindrome));
    }
}
