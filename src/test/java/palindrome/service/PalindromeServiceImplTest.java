package palindrome.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import palindrome.dto.request.PalindromeRequestDto;
import palindrome.dto.response.PalindromeResponseDto;
import palindrome.dto.response.StatisticsResponseDto;
import palindrome.dto.response.UserResponseDto;
import palindrome.entity.PalindromeEntity;
import palindrome.entity.UserEntity;
import palindrome.exception.NotPalindromeException;
import palindrome.exception.PalindromeAddedException;
import palindrome.exception.PalindromesFromRulesCannotBeUsedException;
import palindrome.mapper.PalindromeMapper;
import palindrome.repository.PalindromeRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PalindromeServiceImplTest {

    @InjectMocks
    private PalindromeServiceImpl palindromeService;

    @Mock
    private PalindromeRepository palindromeRepository;

    @Mock
    private PalindromeMapper palindromeMapper;

    @Mock
    private StatisticsService statisticsService;

    private final String PALINDROME_1 = "ага";
    private final String PALINDROME_2 = "радар";
    private final String PALINDROME_FROM_RULES = "топот";
    private final String NOT_PALINDROME = "привет";
    private UserEntity user = null;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new UserEntity();
    }

    @Test
    void testPalindromeAlreadyAdded() {
        // Подготовка
        PalindromeRequestDto palindromeRequestDto = new PalindromeRequestDto(PALINDROME_1);
        when(palindromeRepository.getPalindrome(any(UserEntity.class), eq(palindromeRequestDto.getPalindrome())))
                .thenReturn(Optional.of(new PalindromeEntity()));

        // Проверка
        assertThrows(PalindromeAddedException.class, () -> palindromeService.save(user, palindromeRequestDto));
        verify(palindromeRepository, never()).save(any());
        verify(statisticsService, never()).createPlayerStatistics(any(), any());
        verify(statisticsService, never()).updatePlayerStatistics(any(), any());
    }

    @Test
    void testPalindromesFromRulesCannotBeUsed() {
        // Подготовка
        PalindromeRequestDto palindromeRequestDto = new PalindromeRequestDto(PALINDROME_FROM_RULES);
        when(palindromeRepository.getPalindrome(any(UserEntity.class), eq(palindromeRequestDto.getPalindrome())))
                .thenReturn(Optional.empty());

        // Проверка
        assertThrows(PalindromesFromRulesCannotBeUsedException.class,
                () -> palindromeService.save(user, palindromeRequestDto));
        verify(palindromeRepository, never()).save(any());
        verify(statisticsService, never()).createPlayerStatistics(any(), any());
        verify(statisticsService, never()).updatePlayerStatistics(any(), any());
    }

    @Test
    void testSaveNonPalindrome() {
        // Подготовка
        PalindromeRequestDto palindromeRequestDto = new PalindromeRequestDto(NOT_PALINDROME);

        // Проверки
        assertThrows(NotPalindromeException.class, () -> palindromeService.save(user, palindromeRequestDto));
        verify(palindromeRepository, never()).save(any());
        verify(statisticsService, never()).createPlayerStatistics(any(), any());
        verify(statisticsService, never()).updatePlayerStatistics(any(), any());
    }

    @Test
    void testSaveFirstPalindromeForUser() {
        // Подготовка
        PalindromeRequestDto palindromeRequestDto = new PalindromeRequestDto(PALINDROME_1);
        when(palindromeRepository.getPalindrome(any(UserEntity.class), eq(PALINDROME_1))).thenReturn(Optional.empty());
        when(statisticsService.getPlayerStatistics(user)).thenReturn(new StatisticsResponseDto());
        when(palindromeMapper.entityToDto(any())).thenReturn(new PalindromeResponseDto());

        // Вызов метода
        PalindromeResponseDto responseDto = palindromeService.save(user, palindromeRequestDto);

        // Проверки
        assertNotNull(responseDto);
        verify(palindromeRepository, times(1)).save(any());
        verify(statisticsService, times(1)).createPlayerStatistics(user, PALINDROME_1);
    }

    @Test
    void testSaveAdditionalPalindromesForUser() {
        // Подготовка
        PalindromeRequestDto palindromeRequestDto = new PalindromeRequestDto(PALINDROME_1);
        when(palindromeRepository.getPalindrome(any(UserEntity.class), eq(PALINDROME_1))).thenReturn(Optional.empty());
        when(statisticsService.getPlayerStatistics(user)).thenReturn(new StatisticsResponseDto(
                UUID.randomUUID(), new Date(), new Date(), new UserResponseDto(), 1, 4));
        when(palindromeMapper.entityToDto(any())).thenReturn(new PalindromeResponseDto());

        // Вызов метода
        PalindromeResponseDto responseDto = palindromeService.save(user, palindromeRequestDto);

        // Проверки
        assertNotNull(responseDto);
        verify(palindromeRepository, times(1)).save(any());
        verify(statisticsService, times(1)).updatePlayerStatistics(user, PALINDROME_1);
    }

    @Test
    void testGetPalindromesForUser() {
        // Подготовка
        when(palindromeRepository.getPalindromes(user)).thenReturn(List.of(PALINDROME_1, PALINDROME_2));

        // Вызов метода
        List<String> result = palindromeService.getPalindromes(user);

        // Проверки
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(PALINDROME_1, result.get(0));
        assertEquals(PALINDROME_2, result.get(1));
        verify(palindromeRepository, times(1)).getPalindromes(user);
    }

    @Test
    public void testGetPalindromesForNonexistentUser() {
        // Подготовка
        when(palindromeRepository.getPalindromes(user)).thenReturn(Collections.emptyList());

        // Вызов метода
        List<String> actualPalindromes = palindromeService.getPalindromes(user);

        // Проверки
        assertNotNull(actualPalindromes);
        assertTrue(actualPalindromes.isEmpty());
    }

}
