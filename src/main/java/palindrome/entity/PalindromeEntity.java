package palindrome.entity;

import jakarta.persistence.*;
import lombok.*;
import palindrome.base.BaseEntity;

@ToString
@Entity
@Table(name = "palindromes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PalindromeEntity extends BaseEntity {
    @Column(name = "palindrome", nullable = false)
    private String palindrome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
