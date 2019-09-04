package jp.co.systena.tigerscave.rpg.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.rpg.common.Constants.SessionKey;
import jp.co.systena.tigerscave.rpg.common.Constants.Url;
import jp.co.systena.tigerscave.rpg.common.Fighter;
import jp.co.systena.tigerscave.rpg.common.Warrior;
import jp.co.systena.tigerscave.rpg.common.Wizard;
import jp.co.systena.tigerscave.rpg.model.form.CharacterForm;

@Controller
public class CreateCharacterController {
    /** ロギング */
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCharacterController.class);

    /** 表示画面 */
    private static final String CREATE_CHARACTER_VIEW = "DISP-01_CreateCharacter";

    @Autowired
    private HttpSession session;

    /**
     * キャラ作成画面表示メソッド
     * @return モデル/ビュー情報
     */
    @GetMapping(Url.CHARACTER)
    public ModelAndView showCreateCharacter() {
        LOGGER.info("showCreateCharacter start");
        session.removeAttribute(SessionKey.WARRIOR);
        session.removeAttribute(SessionKey.WIZARD);
        session.removeAttribute(SessionKey.FIGHTER);
        session.removeAttribute(SessionKey.NAME);
        ModelAndView mav = new ModelAndView(CREATE_CHARACTER_VIEW);
        mav.addObject("characterForm", new CharacterForm());
        return mav;
    }

    /**
     * 戦うボタン
     * @return モデル/ビュー情報
     */
    @PostMapping(Url.CREATE)
    public ModelAndView create(@Valid @ModelAttribute("characterForm") CharacterForm form) {
        LOGGER.info("create start");
        //TODO 必須項目チェックして、職業・名前入力強制させる
        if (form.getJob().equals("戦士")) {
            LOGGER.info("インスタンス化するのは... " + form.getJob());
            Warrior warrior = new Warrior();
            session.setAttribute(SessionKey.WARRIOR, warrior);
        } else if (form.getJob().equals("魔法使い")) {
        	LOGGER.info("インスタンス化するのは... " + form.getJob());
        	Wizard wizard = new Wizard();
        	session.setAttribute(SessionKey.WIZARD, wizard);
        } else {
        	LOGGER.info("インスタンス化するのは... " + form.getJob());
        	Fighter fighter = new Fighter();
        	session.setAttribute(SessionKey.FIGHTER, fighter);
        }
        LOGGER.info("form.getName = " + form.getName());
    	session.setAttribute(SessionKey.NAME, form.getName());
        return new ModelAndView("redirect:" + Url.COMMAND);
    }

}
