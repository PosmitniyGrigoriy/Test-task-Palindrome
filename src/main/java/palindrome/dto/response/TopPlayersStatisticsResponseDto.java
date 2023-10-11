package palindrome.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TopPlayersStatisticsResponseDto {
    private UserResponseDto user;
    private int palindromesNumber;
    private int totalPoints;
}
