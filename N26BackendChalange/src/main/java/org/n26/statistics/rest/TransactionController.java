package org.n26.statistics.rest;

import org.n26.statistics.common.DateUtils;
import org.n26.statistics.domain.Transaction;
import org.n26.statistics.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> newTransaction(@RequestBody Transaction transaction) {

        if (transaction == null ||
            transaction.getAmount() == null ||
            transaction.getTimestamp() == null ||
            !DateUtils.isInLastMin(transaction.getTimestamp())) {

            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }

        statisticService.processTransaction(transaction);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

}
