package palindrome.dto.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserResponseDto {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private String firstName;
    private String login;
    private Date lastVisit;
}
