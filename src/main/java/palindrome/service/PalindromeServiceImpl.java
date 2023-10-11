package palindrome.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import palindrome.dto.request.PalindromeRequestDto;
import palindrome.dto.response.PalindromeResponseDto;
import palindrome.entity.PalindromeEntity;
import palindrome.entity.UserEntity;
import palindrome.exception.NotPalindromeException;
import palindrome.exception.PalindromeAddedException;
import palindrome.exception.PalindromesFromRulesCannotBeUsedException;
import palindrome.mapper.PalindromeMapper;
import palindrome.repository.PalindromeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PalindromeServiceImpl implements PalindromeService {

    private final PalindromeRepository palindromeRepository;
    private final PalindromeMapper palindromeMapper;
    private final StatisticsService statisticsService;

    @Transactional
    @Override
    public PalindromeResponseDto save(UserEntity user, PalindromeRequestDto requestDto) {
        checkPalindromeFromRules(requestDto.getPalindrome());
        checkPalindromeAdded(user, requestDto.getPalindrome());
        if (!isPalindrome(requestDto.getPalindrome())) {
            throw new NotPalindromeException();
        } else {
            PalindromeEntity palindrome = new PalindromeEntity(requestDto.getPalindrome().toLowerCase(), user);
            palindrome = palindromeRepository.save(palindrome);
            if (statisticsService.getPlayerStatistics(user).getUser() == null) {
                statisticsService.createPlayerStatistics(user, requestDto.getPalindrome());
            } else {
                statisticsService.updatePlayerStatistics(user, requestDto.getPalindrome());
            }
            return palindromeMapper.entityToDto(palindrome);
        }
    }

    @Override
    public List<String> getPalindromes(UserEntity user) {
        return palindromeRepository.getPalindromes(user);
    }

    private void checkPalindromeFromRules(String palindrome) {
        palindrome = palindrome.toLowerCase().replace(" ", "");
        if (palindrome.equals("топот") || palindrome.equals("арозаупаланалапуазора")) {
            throw new PalindromesFromRulesCannotBeUsedException(palindrome);
        }
    }

    private void checkPalindromeAdded(UserEntity user, String palindrome) {
        Optional<PalindromeEntity> palindromeOptional = palindromeRepository.getPalindrome(user, palindrome);
        if (palindromeOptional.isPresent()) {
            throw new PalindromeAddedException(user.getLogin(), palindrome);
        }
    }

    private boolean isPalindrome(String palindrome) {
        palindrome = palindrome.toLowerCase().replace(" ", "");
        String reverseVariant = new StringBuilder(palindrome).reverse().toString();
        return palindrome.equals(reverseVariant);
    }

}
