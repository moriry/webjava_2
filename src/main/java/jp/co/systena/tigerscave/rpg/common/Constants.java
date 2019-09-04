package jp.co.systena.tigerscave.rpg.common;

public class Constants {

    public class Url {
        /** キャラ作成画面 - GET */
        public static final String CHARACTER = "/character";

        /** キャラ作成画面 - POST */
        public static final String CREATE = "/create";

        /** コマンド画面 - GET */
        public static final String COMMAND = "/command";

        /** コマンド画面 - POST */
        public static final String FIGHT = "/fight";

        /** コマンド画面 - POST */
        public static final String HEAL = "/heal";

        /** 結果画面 - GET */
        public static final String RESULT = "/result";
    }

    public class SessionKey {

    	/** 戦士 */
    	public static final String WARRIOR = "warrior";

    	/** 魔法使い */
    	public static final String WIZARD = "wizard";

    	/** 武闘家 */
    	public static final String FIGHTER = "fighter";

    	/** 名前 */
    	public static final String NAME = "name";

    	/** アクションコマンド */
    	public static final String COMMAND_ACTION = "commandAction";

    }

    public class ActionKey {

    	/** 戦う */
    	public static final int FIGHT = 1;

    	/** 回復 */
    	public static final int HEAL = 2;
    }
}
