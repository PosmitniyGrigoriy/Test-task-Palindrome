package palindrome.dto.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class StatisticsResponseDto {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private UserResponseDto user;
    private Integer palindromesNumber;
    private Integer totalPoints;
}
