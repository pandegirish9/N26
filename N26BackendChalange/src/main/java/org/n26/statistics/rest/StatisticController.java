package org.n26.statistics.rest;

import org.n26.statistics.domain.Statistic;
import org.n26.statistics.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(method = RequestMethod.GET)
    public Statistic getStatistics() {
        return statisticService.getStatistic();
    }
}
