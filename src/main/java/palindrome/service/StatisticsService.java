package palindrome.service;

import palindrome.dto.response.StatisticsResponseDto;
import palindrome.dto.response.TopPlayersStatisticsResponseDto;
import palindrome.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface StatisticsService {
    StatisticsResponseDto createPlayerStatistics(UserEntity user, String palindrome);
    StatisticsResponseDto updatePlayerStatistics(UserEntity user, String palindrome);
    StatisticsResponseDto getPlayerStatistics(UserEntity user);
    int getPlayerPlace(UUID userId);
    int getTotalPlayers();
    List<TopPlayersStatisticsResponseDto> getTopPlayers();
}
