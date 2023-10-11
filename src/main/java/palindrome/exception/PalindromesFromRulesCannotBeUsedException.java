package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class PalindromesFromRulesCannotBeUsedException extends BaseException {
    public PalindromesFromRulesCannotBeUsedException(String palindrome) {
        super(HttpStatus.FORBIDDEN, String.format("Нельзя вводить палиндромы, которые были указаны в правилах игры. " +
                        "Вы ввели: '%s'.", palindrome));
    }
}
