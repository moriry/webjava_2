package jp.co.systena.tigerscave.rpg.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.rpg.common.Constants.ActionKey;
import jp.co.systena.tigerscave.rpg.common.Constants.SessionKey;
import jp.co.systena.tigerscave.rpg.common.Constants.Url;
import jp.co.systena.tigerscave.rpg.common.Job;

@Controller
public class ResultController {
    /** ロギング */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultController.class);

    /** 表示画面 */
    private static final String RESULT_VIEW = "DISP-03_Result";

    /** エラーメッセージ */
    private static final String ERROR_MESSAGE = "エラーが発生しました！";

    @Autowired
    private HttpSession session;

    /**
     * 結果画面表示メソッド
     * @return モデル/ビュー情報
     */
    @GetMapping(Url.RESULT)
    public ModelAndView showResult() {
        LOGGER.info("showResult start");
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        String resultMessage = null;
        if (session.getAttribute(SessionKey.WARRIOR) != null) {
        	resultMessage = createResultMessage(SessionKey.WARRIOR);
        } else if (session.getAttribute(SessionKey.WIZARD) != null) {
            resultMessage = createResultMessage(SessionKey.WIZARD);
        } else {
        	resultMessage = createResultMessage(SessionKey.FIGHTER);
        }
        mav.addObject("resultMessage", resultMessage);
        return mav;
    }

    /**
     * 結果メッセージ作成メソッド
     * @param 職業
     * @return 結果メッセージ
     */
    private String createResultMessage(String Job) {
        String name = session.getAttribute(SessionKey.NAME).toString();
    	Job job = (Job)session.getAttribute(Job);
    	String result = null;
    	switch ((Integer)session.getAttribute(SessionKey.COMMAND_ACTION)) {
    	case ActionKey.FIGHT:
    		result = job.fight(name);
    		break;
    	case ActionKey.HEAL:
    		result = job.heal(name);
    		break;
       	default:
       		result = ERROR_MESSAGE;
    	}
        return result;
    }
}
