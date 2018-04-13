package org.n26.statistics.service;

import org.n26.statistics.domain.Statistic;
import org.n26.statistics.domain.Transaction;

/**
 * Created by pgasimzade on 5/2/2017.
 */
public interface StatisticService {

    void processTransaction(Transaction transaction);

    Statistic getStatistic();
}
