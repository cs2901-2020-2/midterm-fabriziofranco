package cs.lab;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class AuctionTest {
    static final Logger logger = Logger.getLogger(AuctionTest.class.getName());

    private AuctionTest() {
    }

    @Test //REGISTER
    public void testCase0() {
        Subject subject = new DataSubject();
        Observer observer = new PieChartMonitor();
        subject.registerObserver(observer);
        List<Observer> response = subject.getObservers();
        subject.notifyObservers(10);
        subject.notifyObservers(9);
        subject.notifyObservers(8);
        subject.notifyObservers(12);
        Assert.assertEquals(observer, response.get(response.size() - 1));
    }

    @Test //REMOVE
    public void testCase1() {
        Subject subject = new DataSubject();
        Observer observer = new PieChartMonitor();
        subject.registerObserver(observer);
        subject.removeObserver(observer);
        List<Observer> response = subject.getObservers();
        Assert.assertEquals(response.size(), 0);
    }



    @Test //REMOVE
    public void testCase2() {
        Subject subject = new DataSubject();
        Observer observer = new BarChartMonitor();
        subject.registerObserver(observer);
        subject.removeObserver(observer);
        List<Observer> response = subject.getObservers();
        Assert.assertEquals(response.size(), 0);
    }
}