package palindrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import palindrome.entity.PalindromeEntity;
import palindrome.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PalindromeRepository extends JpaRepository<PalindromeEntity, UUID> {
    @Query(value = "SELECT palindrome FROM palindromes p WHERE p.user_id = :userId ORDER BY palindrome", nativeQuery = true)
    List<String> getPalindromes(@Param("userId") UUID userId);

    @Query("SELECT s.palindrome FROM PalindromeEntity s WHERE s.user = :user AND s.palindrome = :palindrome")
    Optional<PalindromeEntity> getPalindrome(@Param("user") UserEntity user, @Param("palindrome") String palindrome);
}