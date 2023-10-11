package palindrome.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import palindrome.dto.response.StatisticsResponseDto;
import palindrome.dto.response.TopPlayersStatisticsResponseDto;
import palindrome.entity.StatisticsEntity;
import palindrome.entity.UserEntity;
import palindrome.mapper.StatisticsMapper;
import palindrome.repository.StatisticsRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final StatisticsMapper statisticsMapper;

    @Transactional
    @Override
    public
    StatisticsResponseDto createPlayerStatistics(UserEntity user, String palindrome) {
        StatisticsEntity statistics = new StatisticsEntity(user, 1, palindrome.length());
        statistics = statisticsRepository.save(statistics);
        return statisticsMapper.entityToDto(statistics);
    }

    @Transactional
    @Override
    public StatisticsResponseDto updatePlayerStatistics(UserEntity user, String palindrome) {
        StatisticsEntity statistics = statisticsRepository.getPlayerStatistics(user)
                .orElse(new StatisticsEntity());
        statistics.setPalindromesNumber(statistics.getPalindromesNumber() + 1);
        statistics.setTotalPoints(statistics.getTotalPoints() + palindrome.length());
        statistics = statisticsRepository.save(statistics);
        return statisticsMapper.entityToDto(statistics);
    }

    @Override
    public StatisticsResponseDto getPlayerStatistics(UserEntity user) {
        return statisticsRepository.getPlayerStatistics(user)
                .map(statisticsMapper::entityToDto)
                .orElseGet(StatisticsResponseDto::new);
    }

    @Override
    public int getPlayerPlace(UUID userId) {
        return statisticsRepository.getPlayerPlace(userId);
    }

    @Override
    public int getTotalPlayers() {
        return statisticsRepository.getTotalPlayers();
    }

    @Override
    public List<TopPlayersStatisticsResponseDto> getTopPlayers() {
        List<StatisticsEntity> topPlayersStatistics = statisticsRepository.getTopPlayers();
        return statisticsMapper.entitiesToListDto(topPlayersStatistics);
    }

}
