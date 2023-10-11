package palindrome.exception;

import org.springframework.http.HttpStatus;
import palindrome.base.BaseException;

import java.util.UUID;

public class EntityDoesNotExistException extends BaseException {
    public EntityDoesNotExistException(UUID userId, Class<?> clazz) {
        super(HttpStatus.NOT_FOUND, String.format("Не найден объект класса '%s' с айди '%s'", clazz, userId));
    }
}
