package palindrome.service;

import palindrome.dto.request.LoginRequestDto;
import palindrome.dto.request.RegisterRequestDto;
import palindrome.dto.response.UserResponseDto;
import palindrome.entity.UserEntity;

import java.util.UUID;

public interface UserService {
    UserResponseDto register(RegisterRequestDto requestDto);
    UserResponseDto login(LoginRequestDto requestDto);
    UserEntity getUser(UUID userId);
    UserEntity updateLastVisit(UserEntity user);
}
