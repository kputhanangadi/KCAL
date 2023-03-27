package src.test;

import org.junit.Before;
import org.junit.Test;
import src.network.Observable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObservableTest {

    private Observable observable;
    private TestObserver testObserver1;
    private TestObserver testObserver2;

    @Before
    public void setUp() {
        observable = new Observable();
        testObserver1 = new TestObserver();
        testObserver2 = new TestObserver();
        observable.addObserver(testObserver1);
        observable.addObserver(testObserver2);
    }

    @Test
    public void testAddObserver() {
        observable.addObserver(new TestObserver());
        assertTrue(observable.observers.contains(testObserver1));
        assertTrue(observable.observers.contains(testObserver2));
    }

    @Test
    public void testRemoveObserver() {
        observable.removeObserver(testObserver1);
        assertFalse(observable.observers.contains(testObserver1));
        assertTrue(observable.observers.contains(testObserver2));
    }

    @Test
    public void testNotifyObservers() {
        observable.setChanged();
        observable.notifyObservers();
        assertTrue(testObserver1.hasBeenCalled());
        assertTrue(testObserver2.hasBeenCalled());
    }

    @Test
    public void testNotifyObserversNotChanged() {
        observable.notifyObservers();
        assertFalse(testObserver1.hasBeenCalled());
        assertFalse(testObserver2.hasBeenCalled());
    }

    private static class TestObserver implements Observable.Observer {

        private boolean called = false;

        public void update(Observable o) {
            called = true;
        }

        public boolean hasBeenCalled() {
            return called;
        }
    }
}

