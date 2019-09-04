package jp.co.systena.tigerscave.rpg.common;

public class Warrior extends Job{

    private static final String FIGHT_MESSAGE = "は剣で攻撃した！";
    private static final String HEAL_MESSAGE = "はやくそうで回復した！";

    public String fight(String name) {
        String resultMessage = name + FIGHT_MESSAGE;
        return resultMessage;
    }

    public String heal(String name) {
        String resultMessage = name + HEAL_MESSAGE;
        return resultMessage;
    }
}
