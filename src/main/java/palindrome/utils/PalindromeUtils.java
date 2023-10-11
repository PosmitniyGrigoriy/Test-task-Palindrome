package palindrome.utils;

import palindrome.dto.response.StatisticsResponseDto;
import palindrome.dto.response.TopPlayersStatisticsResponseDto;

import java.util.List;

public class PalindromeUtils {

    private PalindromeUtils() {}

    public static void printViewerMenu() {
        System.out.println("========================================");
        System.out.println("Добро пожаловать в игру палиндром!\n");
        System.out.println("Меню:");
        System.out.println("1. Узнать правила игры");
        System.out.println("2. Зарегистрироваться и начать играть");
        System.out.println("3. Войти и начать играть");
        System.out.println("4. Посмотреть статистику топ 5 игроков");
        System.out.println("5. Выйти\n");
        System.out.print("Введите номер из меню для продолжения: ");
    }

    public static void printPlayerMenu() {
        System.out.println("Меню:");
        System.out.println("1. Начать играть");
        System.out.println("2. Посмотреть свою статистику");
        System.out.println("3. Выйти\n");
        System.out.print("Введите номер из меню для продолжения: ");
    }

    public static void printRules() {
        System.out.println("\nПравила:");
        System.out.println("1. Палиндром - это слово или фраза, которое можно прочитать слева-направо, " +
                "так и справа-налево. Примеры: топот, а роза упала на лапу Азора. " +
                "Эти два примера вводить в игре нельзя.");
        System.out.println("2. За каждый вариант палиндрома игроку будут начисляться очки. " +
                "Количество очков зависит от количества букв в палиндроме.\n");
        System.out.print("Введите номер из меню для продолжения: ");
    }

    public static void printTopPlayersStatistics(List<TopPlayersStatisticsResponseDto> topPlayersStatistics) {
        if (topPlayersStatistics.size() == 0) {
            System.out.println("\nВ игру пока никто не играл, поэтому статистику по топ игрокам вывести нельзя.\n");
            System.out.print("Введите номер из меню для продолжения: ");
        } else {
            System.out.println("\nСтатистика топ 5 игроков\n");
            System.out.println("----------------------------------------------------------------");
            System.out.printf("| %-10s | %-16s | %-19s | %-6s |\n", "Имя", "Логин", "Кол-во палиндромов", "Очков");
            System.out.println("|--------------------------------------------------------------|");
            topPlayersStatistics.forEach(element -> {
                String firstName = element.getUser().getFirstName();
                String login = element.getUser().getLogin();
                int palindromesNumber = element.getPalindromesNumber();
                int totalPoints = element.getTotalPoints();
                System.out.printf("| %-10s | %-16s | %-19d | %-6d |\n", firstName, login, palindromesNumber, totalPoints);
            });
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            System.out.print("Введите номер из меню для продолжения: ");
        }
    }

    public static void printPlayerStatistics(int playerPlace,
                                             int totalPlayers,
                                             StatisticsResponseDto playerStatistics,
                                             List<String> myPalindromes) {
        if (playerPlace == 0) {
            System.out.println("\nУ вас пока нет ни одного введенного палиндрома, поэтому статистика недоступна.\n");
            System.out.print("Введите номер из меню для продолжения: ");
        } else {
            System.out.println("\nСтатистика:");
            System.out.println("Вы занимаете " + playerPlace + " место из " + totalPlayers +
                    setWordFromQuantity(totalPlayers) + "!");
            System.out.println("Вы ввели палиндромов: " + playerStatistics.getPalindromesNumber());
            System.out.println("Набрали очков: " + playerStatistics.getTotalPoints());
            System.out.println("Список ваших палиндромов: " + myPalindromes + "\n");
        }
    }

    public static void exit() {
        System.out.println("\nВы вышли из игры\n");
        System.exit(0);
    }

    public static void menuWrongNumber() {
        System.out.println("\nВы ввели номер, которого нет в меню. Попробуйте еще раз.\n");
        System.out.print("Введите номер из меню для продолжения: ");
    }

    public static void sendGameStartMessage() {
        System.out.print("Напишите палиндром или наберите 0, чтобы посмотреть свою статистику и выйти: ");
    }

    private static String setWordFromQuantity(int totalPlayers) {
        String baseWord = " игрок";
        if (totalPlayers == 1 || totalPlayers == 21) {
            baseWord = baseWord.concat("а");
        } else {
            baseWord = baseWord.concat("ов");
        }
        return baseWord;
    }

}
