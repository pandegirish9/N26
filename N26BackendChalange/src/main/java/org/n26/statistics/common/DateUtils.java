package org.n26.statistics.common;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static boolean isInLastMin(Long ts) {
        LocalDateTime date = Instant.ofEpochMilli(ts).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime oneMinBefore = LocalDateTime.now().minus(60, ChronoUnit.SECONDS);
        return date.isAfter(oneMinBefore);
    }

    public static int getSecond(Long ts) {
        LocalDateTime date = Instant.ofEpochMilli(ts).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return date.getSecond();
    }

}
