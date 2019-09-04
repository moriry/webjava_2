package jp.co.systena.tigerscave.rpg.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.rpg.common.Constants.ActionKey;
import jp.co.systena.tigerscave.rpg.common.Constants.SessionKey;
import jp.co.systena.tigerscave.rpg.common.Constants.Url;
import jp.co.systena.tigerscave.rpg.model.display.CommandDto;

@Controller
public class CommandController {
    /** ロギング */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandController.class);

    /** 表示画面 */
    private static final String COMMAND_VIEW = "DISP-02_Command";

    private static final String JOB_WARRIOR = "戦士";

    private static final String JOB_WIZARD = "魔法使い";

    private static final String JOB_FIGHTER = "武闘家";

    @Autowired
    private HttpSession session;

    /**
     * コマンド画面表示メソッド
     * @return モデル/ビュー情報
     */
    @GetMapping(Url.COMMAND)
    public ModelAndView showCommand() {
        LOGGER.info("showCommand start");
        session.removeAttribute(SessionKey.COMMAND_ACTION);
        ModelAndView mav = new ModelAndView(COMMAND_VIEW);
        CommandDto cmd = new CommandDto();
        if (session.getAttribute(SessionKey.WARRIOR) != null) {
        	cmd.setJob(JOB_WARRIOR);
        } else if (session.getAttribute(SessionKey.WIZARD) != null){
        	cmd.setJob(JOB_WIZARD);
        } else {
        	cmd.setJob(JOB_FIGHTER);
        }
        cmd.setName(session.getAttribute(SessionKey.NAME).toString());
        mav.addObject("commandDto", cmd);
        return mav;
    }

    /**
     * 戦うボタン
     * @return モデル/ビュー情報
     */
    @PostMapping(Url.FIGHT)
    public ModelAndView fight() {
        LOGGER.info("fight start");
        session.setAttribute(SessionKey.COMMAND_ACTION, ActionKey.FIGHT);
        return new ModelAndView("redirect:" + Url.RESULT);
    }

    /**
     * 回復ボタン
     * @return モデル/ビュー情報
     */
    @PostMapping(Url.HEAL)
    public ModelAndView heal() {
        LOGGER.info("heal start");
        session.setAttribute(SessionKey.COMMAND_ACTION, ActionKey.HEAL);
        return new ModelAndView("redirect:" + Url.RESULT);
    }
 }
