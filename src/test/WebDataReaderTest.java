package src.test;

import org.junit.jupiter.api.Test;
import src.network.WebDataReader;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDataReaderTest {

    private String url = "https://www.example.com";
    private WebDataReader webDataReader;

    @Test
    public void testObservable() throws IOException {
        WebDataReader reader = new WebDataReader();
        TestObserver observer = new TestObserver();
        reader.addObserver(observer);
        assertFalse(observer.notified);

        reader.readData(url);
        assertTrue(observer.notified);
    }

    private class TestObserver implements Observer {
        public boolean notified = false;

        @Override
        public void update(Observable o, Object arg) {
            notified = true;
        }
    }
}