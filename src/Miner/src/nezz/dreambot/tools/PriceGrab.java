package nezz.dreambot.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility for grabbing prices from the OSRS Wiki price API.
 */
public class PriceGrab {

    private static final String MAPPING_URL = "https://prices.runescape.wiki/api/v1/osrs/mapping";
    private static final String PRICE_URL = "https://prices.runescape.wiki/api/v1/osrs/latest?id=";
    private static final String USER_AGENT = "DreamBot PriceGrab";
    private static final int TIMEOUT = 5000;

    private static PriceGrab oneInstance;
    private final Map<String, Integer> nameToId = new HashMap<>();

    public static PriceGrab getInstance() {
        if (oneInstance == null) {
            oneInstance = new PriceGrab();
        }
        return oneInstance;
    }

    public int getPrice(String itemName, int command) {
        if (itemName == null) {
            return 0;
        }
        ensureMappingLoaded();
        Integer id = nameToId.get(itemName.toLowerCase());
        if (id == null) {
            System.out.println("Could not find item id for " + itemName);
            return 0;
        }
        String json = fetchUrl(PRICE_URL + id);
        if (json == null) {
            return 0;
        }
        int high = parseValue(json, "\"high\":(\\d+)");
        int low = parseValue(json, "\"low\":(\\d+)");
        if (high == -1 || low == -1) {
            System.out.println("Could not retrieve price");
            return 0;
        }
        switch (command) {
            case 1:
                return low;
            case 2:
                return (high + low) / 2;
            case 3:
                return high;
            default:
                return 0;
        }
    }

    private void ensureMappingLoaded() {
        if (!nameToId.isEmpty()) {
            return;
        }
        String json = fetchUrl(MAPPING_URL);
        if (json == null) {
            return;
        }
        Pattern pattern = Pattern.compile("\\{\\\"id\\\":(\\d+),\\\"name\\\":\\\"([^\\\"]+)\\\"");
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            int id = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2).toLowerCase();
            nameToId.put(name, id);
        }
    }

    protected String fetchUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int parseValue(String json, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(json);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return -1;
    }
}
