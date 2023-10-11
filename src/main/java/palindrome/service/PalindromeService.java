package palindrome.service;

import palindrome.dto.request.PalindromeRequestDto;
import palindrome.dto.response.PalindromeResponseDto;
import palindrome.entity.UserEntity;

import java.util.List;

public interface PalindromeService {
    PalindromeResponseDto save(UserEntity user, PalindromeRequestDto requestDto);
    List<String> getPalindromes(UserEntity user);
}
