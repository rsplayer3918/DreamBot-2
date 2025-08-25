package nezz.dreambot.tools;

import org.junit.Test;
import static org.junit.Assert.*;

public class PriceGrabTest {
    private static class MockPriceGrab extends PriceGrab {
        @Override
        protected String fetchUrl(String urlString) {
            if (urlString.contains("mapping")) {
                return "[{\"id\":2,\"name\":\"Cannonball\"}]";
            } else if (urlString.contains("latest")) {
                return "{\"data\":{\"2\":{\"high\":200,\"low\":100}}}";
            }
            return null;
        }
    }

    @Test
    public void testLowPrice() {
        PriceGrab grab = new MockPriceGrab();
        assertEquals(100, grab.getPrice("Cannonball", 1));
    }

    @Test
    public void testAveragePrice() {
        PriceGrab grab = new MockPriceGrab();
        assertEquals(150, grab.getPrice("Cannonball", 2));
    }

    @Test
    public void testHighPrice() {
        PriceGrab grab = new MockPriceGrab();
        assertEquals(200, grab.getPrice("Cannonball", 3));
    }
}
