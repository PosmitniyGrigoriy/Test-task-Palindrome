package palindrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import palindrome.entity.StatisticsEntity;
import palindrome.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsEntity, UUID> {
    @Query("SELECT s FROM StatisticsEntity s WHERE s.user = :user")
    Optional<StatisticsEntity> getPlayerStatistics(@Param("user") UserEntity user);

    @Query(value = "SELECT COUNT(DISTINCT total_points) FROM statistics WHERE total_points >= " +
            "(SELECT total_points FROM statistics s WHERE s.user_id = :userId);", nativeQuery = true)
    Integer getPlayerPlace(UUID userId);

    @Query(value = "SELECT COUNT(*) FROM statistics", nativeQuery = true)
    Integer getTotalPlayers();

    @Query(value = "SELECT * FROM statistics ORDER BY total_points DESC LIMIT 5", nativeQuery = true)
    List<StatisticsEntity> getTopPlayers();
}
