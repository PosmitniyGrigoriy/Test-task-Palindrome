package palindrome.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import palindrome.dto.request.RegisterRequestDto;
import palindrome.dto.response.UserResponseDto;
import palindrome.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto entityToDto(UserEntity entity);

    @Mapping(target = "password", ignore = true)
    UserEntity dtoToEntity(RegisterRequestDto requestDto);
}
