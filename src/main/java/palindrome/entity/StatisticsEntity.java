package palindrome.entity;

import jakarta.persistence.*;
import lombok.*;
import palindrome.base.BaseEntity;

@ToString
@Entity
@Table(name = "statistics")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatisticsEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @Column(name = "palindromes_number", nullable = false)
    private Integer palindromesNumber;

    @Column(name = "total_points", nullable = false)
    private Integer totalPoints;
}
