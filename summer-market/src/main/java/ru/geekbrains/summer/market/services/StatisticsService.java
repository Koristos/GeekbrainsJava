package ru.geekbrains.summer.market.services;

import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.dto.StatisticsDto;
import ru.geekbrains.summer.market.utils.StatisticsWatcher;

import java.util.Map;

@Component
public class StatisticsService {
    public StatisticsDto getStatistics(){
        StatisticsDto statisticsDto = new StatisticsDto();
        Map<String, Long> statistics = StatisticsWatcher.getStatistics();
        statistics.forEach((key, value) -> {
            String[] nameParts = key.split("\\.");
            statisticsDto.getServiceWorkingTime()
                    .put(nameParts[nameParts.length - 1], value);
        });
        return statisticsDto;
    }
}
