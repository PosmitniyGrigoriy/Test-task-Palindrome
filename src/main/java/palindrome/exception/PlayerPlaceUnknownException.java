package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

public class PlayerPlaceUnknownException extends BaseException {
    public PlayerPlaceUnknownException() {
        super(HttpStatus.NOT_FOUND, "Игрок пока не добавил ни одного палиндрома, поэтому его нет в таблице участников.");
    }
}
