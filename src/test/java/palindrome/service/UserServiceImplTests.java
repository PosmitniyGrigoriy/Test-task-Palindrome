package palindrome.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import palindrome.dto.request.LoginRequestDto;
import palindrome.dto.request.RegisterRequestDto;
import palindrome.dto.response.UserResponseDto;
import palindrome.entity.UserEntity;
import palindrome.exception.EntityDoesNotExistException;
import palindrome.exception.InvalidPasswordException;
import palindrome.exception.LoginNotFoundException;
import palindrome.exception.LoginRegisteredException;
import palindrome.mapper.UserMapper;
import palindrome.repository.UserRepository;
import palindrome.utils.AuthenticationUtils;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTests {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMapper userMapper;

	private RegisterRequestDto registerRequestDto;
	private LoginRequestDto loginRequestDto;

	private final String FIRST_NAME = "Григорий";
	private final String LOGIN = "Grigo";
	private final String PASSWORD = "VPR3LF";
	private final String WRONG_PASSWORD = "WrongPassword";

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		registerRequestDto = new RegisterRequestDto(FIRST_NAME, LOGIN, PASSWORD);
		loginRequestDto = new LoginRequestDto(LOGIN, PASSWORD);
	}

	@Test
	public void testRegisterWhenUserAlreadyExists() {
		// Подготовка
		when(userRepository.findByLogin(registerRequestDto.getLogin()))
				.thenReturn(Optional.of(new UserEntity()));

		// Проверки
		assertThrows(LoginRegisteredException.class, () -> userService.register(registerRequestDto));
		verify(userRepository, never()).save(any(UserEntity.class));
	}

	@Test
	public void testRegisterWhenUserDoesNotExist() {
		// Подготовка
		UserEntity user = new UserEntity();
		when(userRepository.findByLogin(registerRequestDto.getLogin())).thenReturn(Optional.empty());
		when(userRepository.save(any(UserEntity.class))).thenReturn(user);
		when(userMapper.dtoToEntity(registerRequestDto)).thenReturn(user);
		when(userMapper.entityToDto(user)).thenReturn(new UserResponseDto());

		// Вызов метода
		UserResponseDto userResponseDto = userService.register(registerRequestDto);

		// Проверки
		assertNotNull(userResponseDto);
		verify(userRepository, times(1)).save(any(UserEntity.class));
	}

	@Test
	public void testLoginWhenUserNotFound() {
		// Подготовка
		when(userRepository.findByLogin(loginRequestDto.getLogin())).thenReturn(Optional.empty());

		// Проверка
		assertThrows(LoginNotFoundException.class, () -> userService.login(loginRequestDto));
	}

	@Test
	public void testLoginWhenInvalidPassword() {
		// Подготовка
		UserEntity user = new UserEntity();
		user.setPassword(WRONG_PASSWORD);
		when(userRepository.findByLogin(loginRequestDto.getLogin())).thenReturn(Optional.of(user));

		// Проверка
		assertThrows(InvalidPasswordException.class, () -> userService.login(loginRequestDto));
	}

	@Test
	public void testLoginWhenSuccessful() {
		// Подготовка
		UserResponseDto userResponseDto = new UserResponseDto(UUID.randomUUID(), new Date(), new Date(),
				FIRST_NAME, LOGIN, new Date());
		UserEntity user = mock(UserEntity.class);
		when(userRepository.findByLogin(loginRequestDto.getLogin())).thenReturn(Optional.of(user));
		when(user.getPassword()).thenReturn(AuthenticationUtils.getPasswordHash(PASSWORD));
		when(userMapper.entityToDto(user)).thenReturn(userResponseDto);
		when(userRepository.save(any(UserEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

		// Вызов метода
		UserResponseDto responseDto = userService.login(loginRequestDto);

		// Проверки
		assertNotNull(responseDto);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void testGetUserWhenUserNotFound() {
		// Подготовка
		UUID userId = UUID.randomUUID();
		when(userRepository.findById(userId)).thenReturn(Optional.empty());

		// Проверки
		assertThrows(EntityDoesNotExistException.class, () -> userService.getUser(userId));
		verify(userRepository).findById(userId);
	}

	@Test
	public void testGetUserWhenUserFound() {
		// Подготовка
		UUID userId = UUID.randomUUID();
		UserEntity user = new UserEntity();
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));

		// Вызов метода
		UserEntity currentUser = userService.getUser(userId);

		// Проверки
		assertNotNull(currentUser);
		assertEquals(user, currentUser);
		verify(userRepository).findById(userId);
	}

}
