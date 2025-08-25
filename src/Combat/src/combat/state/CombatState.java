package combat.state;

import GUI.Window;
import common.state.BaseState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombatState extends BaseState {

        private boolean buryBones, takeOtherPlayersLoot;
        private String target, food;
        private int eatPercentage, bankLocation, foodAmt, fightRadius;
        private List<String> loot;

        public CombatState() {
                Window window = new Window(this);
                init(window, window.getRootPanel(), Window.W, Window.H, Window.TITLE);
        }

        public boolean isTakeOtherPlayersLoot() {
                return takeOtherPlayersLoot;
        }

        public void setTakeOtherPlayersLoot(boolean takeOtherPlayersLoot) {
                this.takeOtherPlayersLoot = takeOtherPlayersLoot;
        }

        public int getFoodAmt() {
                return foodAmt;
        }

        public void setFoodAmt(String foodAmt) {
                try {
                        this.foodAmt = Integer.parseInt(foodAmt);
                } catch (Exception e) {
                        e.printStackTrace();
                        this.foodAmt = 5;
                }
        }

        public String getTarget() {
                return target;
        }

        public void setTarget(String target) {
                this.target = target;
        }

        public List<String> getLoot() {
                return loot;
        }

        public void setLoot(String loot) {
                this.loot = new ArrayList<>(Arrays.asList(loot.split(", ")));
        }

        public void setLoot(List<String> loot) {
                this.loot = loot;
        }

        public String getFood() {
                return food;
        }

        public void setFood(String food) {
                this.food = food;
        }

        public boolean isBuryBones() {
                return buryBones;
        }

        public void setBuryBones(boolean buryBones) {
                this.buryBones = buryBones;
        }

        public int getEatPercentage() {
                return eatPercentage;
        }

        public void setEatPercentage(int eatPercentage) {
                this.eatPercentage = eatPercentage;
        }

        public int getBankLocation() {
                return bankLocation;
        }

        public void setBankLocation(int bankLocation) {
                this.bankLocation = bankLocation;
        }

        public int getFightRadius() {
                return fightRadius;
        }

        public void setFightRadius(String fightRadius) {
                try {
                        this.fightRadius = Integer.parseInt(fightRadius);
                } catch (Exception e) {
                        this.fightRadius = 10;
                        System.out.println(e);
                }
        }
}
