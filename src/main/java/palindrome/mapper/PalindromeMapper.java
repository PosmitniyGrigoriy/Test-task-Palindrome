package palindrome.mapper;

import org.mapstruct.Mapper;
import palindrome.dto.response.PalindromeResponseDto;
import palindrome.entity.PalindromeEntity;

@Mapper(componentModel = "spring")
public interface PalindromeMapper {
    PalindromeResponseDto entityToDto(PalindromeEntity entity);
}
