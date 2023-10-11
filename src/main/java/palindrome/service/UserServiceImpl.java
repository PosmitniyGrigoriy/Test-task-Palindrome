package palindrome.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserResponseDto register(RegisterRequestDto requestDto) {
        Optional<UserEntity> userOptional = userRepository.findByLogin(requestDto.getLogin());
        if (userOptional.isPresent()) {
            throw new LoginRegisteredException(requestDto.getLogin());
        }
        UserEntity user = userMapper.dtoToEntity(requestDto);
        user.setPassword(AuthenticationUtils.getPasswordHash(requestDto.getPassword()));
        user.setLastVisit(new Date());
        user = userRepository.save(user);
        return userMapper.entityToDto(user);
    }

    @Transactional
    @Override
    public UserResponseDto login(LoginRequestDto requestDto) {
        UserEntity user = userRepository.findByLogin(requestDto.getLogin())
                .orElseThrow(() -> new LoginNotFoundException(requestDto.getLogin()));
        if (!user.getPassword().equals(AuthenticationUtils.getPasswordHash(requestDto.getPassword()))) {
            throw new InvalidPasswordException(requestDto.getLogin());
        }
        user = updateLastVisit(user);
        return userMapper.entityToDto(user);
    }

    @Override
    public UserEntity getUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityDoesNotExistException(userId, UserEntity.class));
    }

    @Transactional
    @Override
    public UserEntity updateLastVisit(UserEntity user) {
        user.setLastVisit(new Date());
        return userRepository.save(user);
    }

}
