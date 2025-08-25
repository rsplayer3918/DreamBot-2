package nezz.dreambot.tools;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

class PriceGrabTest {

    @Test
    void formatReplacesSpacesWithPlus() throws Exception {
        PriceGrab pg = PriceGrab.getInstance();
        Method format = PriceGrab.class.getDeclaredMethod("format", String.class);
        format.setAccessible(true);
        assertEquals("iron+ore", format.invoke(pg, "iron ore"));
        assertEquals("coal", format.invoke(pg, "coal"));
    }

    @Test
    void parseInfoExtractsPrice() throws Exception {
        PriceGrab pg = PriceGrab.getInstance();
        Method parseInfo = PriceGrab.class.getDeclaredMethod("parseInfo", String.class, String.class);
        parseInfo.setAccessible(true);
        String data = "{\"average\":150,\"recent_high\":200,\"recent_low\":100}";
        int price = (Integer) parseInfo.invoke(pg, data, "average");
        assertEquals(150, price);
    }
}
