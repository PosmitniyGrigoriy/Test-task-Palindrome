package palindrome.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import palindrome.dto.request.PalindromeRequestDto;
import palindrome.dto.response.StatisticsResponseDto;
import palindrome.dto.response.UserResponseDto;
import palindrome.entity.UserEntity;
import palindrome.utils.PalindromeUtils;
import palindrome.utils.AuthenticationUtils;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Configuration
public class Runner {

    private final PalindromeService palindromeService;
    private final UserService userService;
    private final StatisticsService statisticsService;

    @Bean
    public CommandLineRunner myCommandLineRunner() {
        return args -> {
            PalindromeUtils.printViewerMenu();
            Scanner scannerViewerMenu = new Scanner(System.in);
            while (scannerViewerMenu.hasNext()) {
                int number = scannerViewerMenu.nextInt();
                if (number == 1) { PalindromeUtils.printRules(); }
                if (number == 2) { registerAndPlay(); }
                if (number == 3) { loginAndPlay(); }
                if (number == 4) { PalindromeUtils.printTopPlayersStatistics(statisticsService.getTopPlayers()); }
                if (number == 5) { PalindromeUtils.exit(); }
                if (number < 1 || number > 5) { PalindromeUtils.menuWrongNumber(); }
            }
        };
    }

    private void registerAndPlay() {
        UserResponseDto userResponseDto = userService.register(AuthenticationUtils.fillRegistrationDto());
        UserEntity user = userService.getUser(userResponseDto.getId());
        System.out.println("\nВы зарегистрировались в игре палиндром!\n");
        play(user);
    }

    private void loginAndPlay() {
        UserResponseDto userResponseDto = userService.login(AuthenticationUtils.fillLoginDto());
        UserEntity user = userService.getUser(userResponseDto.getId());
        System.out.println("\nВы вошли в игру палиндром!\n");
        play(user);
    }

    private void play(UserEntity user) {
        PalindromeUtils.printPlayerMenu();
        Scanner scannerPlayerMenu = new Scanner(System.in);
        while (scannerPlayerMenu.hasNext()) {
            int number = scannerPlayerMenu.nextInt();
            if (number == 1) {
                System.out.println();
                PalindromeUtils.sendGameStartMessage();
                Scanner scannerStartGame = new Scanner(System.in);
                while (scannerStartGame.hasNext()) {
                    String variant = scannerStartGame.nextLine();
                    if (variant.equals("0")) {
                        getPlayerStatistics(user);
                        PalindromeUtils.exit();
                    } else {
                        palindromeService.save(user, new PalindromeRequestDto(variant));
                        PalindromeUtils.sendGameStartMessage();
                    }
                }
            }
            if (number == 2) { getPlayerStatistics(user); }
            if (number == 3) { PalindromeUtils.exit(); }
            if (number < 1 || number > 3) { PalindromeUtils.menuWrongNumber(); }
        }
    }

    private void getPlayerStatistics(UserEntity user) {
        int playerPlace = statisticsService.getPlayerPlace(user.getId());
        int totalPlayers = statisticsService.getTotalPlayers();
        StatisticsResponseDto playerStatistics = statisticsService.getPlayerStatistics(user);
        List<String> playerPalindromes = palindromeService.getPalindromes(user);
        PalindromeUtils.printPlayerStatistics(playerPlace, totalPlayers, playerStatistics,
                playerPalindromes);
    }

}
