package palindrome.dto.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PalindromeResponseDto {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private String palindrome;
    private UserResponseDto user;
}
