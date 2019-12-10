package de.hdm_stuttgart.mi.classes;

import org.junit.Assert;
import org.junit.Test;

public class StatisticTest {

    @Test
    public void testWriteStatistic() {
    }

    @Test
    public void testReadStatistic100() {
        Statistic stats = new Statistic("O711squad");
        stats.writeStatistic(stats);
        Assert.assertEquals("O711squad", stats.getUserGameID());
        Assert.assertEquals(0, stats.getRightAnswerCounter());
        Assert.assertEquals(0, stats.getWrongAnswerCounter());
        Assert.assertEquals(0.0, stats.getAverageQuota(), 0.0);

    }

    @Test
    public void testReadStatistic200() {
        Statistic stats = new Statistic("O711squad", 3, 2);
        stats.writeStatistic(stats);
        Assert.assertEquals("O711squad", stats.getUserGameID());
        Assert.assertEquals(3, stats.getRightAnswerCounter());
        Assert.assertEquals(2, stats.getWrongAnswerCounter());
        Assert.assertEquals(0.0, stats.getAverageQuota(), 0.0);

    }
}