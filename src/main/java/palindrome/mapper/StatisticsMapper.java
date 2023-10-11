package palindrome.mapper;

import org.mapstruct.Mapper;
import palindrome.dto.response.StatisticsResponseDto;
import palindrome.dto.response.TopPlayersStatisticsResponseDto;
import palindrome.entity.StatisticsEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {
    StatisticsResponseDto entityToDto(StatisticsEntity entity);
    List<TopPlayersStatisticsResponseDto> entitiesToListDto(List<StatisticsEntity> entities);
}
