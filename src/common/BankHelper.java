package common;

import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.wrappers.interactive.Player;

public final class BankHelper {

    private BankHelper() {
    }

    public static Area resolve(int bankLocation, Player player) {
        BankLocation location = BankLocation.getNearest(player);
        switch (bankLocation) {
            case 1:
                location = BankLocation.DRAYNOR;
                break;
            case 2:
                location = BankLocation.FALADOR_EAST;
                break;
            case 3:
                location = BankLocation.FALADOR_WEST;
                break;
            case 4:
                location = BankLocation.GRAND_EXCHANGE;
                break;
            case 5:
                location = BankLocation.LUMBRIDGE;
                break;
            case 6:
                location = BankLocation.VARROCK_EAST;
                break;
            case 7:
                location = BankLocation.VARROCK_WEST;
                break;
            default:
                break;
        }
        return location.getArea(3);
    }
}
