package jp.co.systena.tigerscave.rpg.common;

public class Wizard extends Job{

  private static final String FIGHT_MESSAGE = "はまほうで攻撃した！";
  private static final String HEAL_MESSAGE = "はまほうで回復した！";

  public String fight(String name) {
      String resultMessage = name + FIGHT_MESSAGE;
      return resultMessage;
  }

  public String heal(String name) {
      String resultMessage = name + HEAL_MESSAGE;
      return resultMessage;
  }
}
