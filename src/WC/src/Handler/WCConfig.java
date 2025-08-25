package Handler;

/**
 * Configuration values for the WC script.
 */
public class WCConfig {
    private int bankLocation;
    private int radius;
    private String tree;

    public int getBankLocation() {
        return bankLocation;
    }

    public void setBankLocation(int bankLocation) {
        this.bankLocation = bankLocation;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }
}

