package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.settings.Difficulty;
import model.GUI.settings.EngineSettings;
import view.GUI.GUI;
import view.GUI.settings.GUISettings;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CtrlSettings implements ControllerGUI {
    private final GUISettings settingsGUI;
    private final EngineSettings settingsEngine;


    public CtrlSettings(final GUISettings GUISettings, final EngineSettings settingsEngine){
        this.settingsGUI = GUISettings;
        this.settingsEngine = settingsEngine;

        this.initSettings();
    }

    private void initSettings() {
        this.settingsGUI.setId(this.settingsEngine.getId());
        this.settingsGUI.setTitleGUI(this.settingsEngine.getTitleGUI());
        this.settingsGUI.setNameUnits(this.settingsEngine.getListNameUnit());
        this.settingsGUI.setNameBtnBack(this.settingsEngine.getNameBtnBack());
        this.settingsGUI.setBtnBackID(this.settingsEngine.getBackLink());
        this.settingsGUI.setSkinSpaceShip(this.settingsEngine.getSkinSpaceShip());

        this.settingsGUI.getUnitSkin().forEach(btn -> btn.addActionListener(this.changeSkin(btn)));
        this.settingsGUI.getUnitDifficult().forEach(radio -> radio.addActionListener(this.changeDifficult(radio)));

        this.settingsGUI.setDifficult(this.settingsEngine.getDifficultActivate());
        this.settingsGUI.setVisible(this.settingsEngine.isVisible());
    }

    private ActionListener changeSkin(JButton btn){
        return e -> {
            if(btn.getText() == "<"){
                CtrlSettings.this.settingsEngine.changeSkinSx();
            } else {
                CtrlSettings.this.settingsEngine.changeSkinDx();
            }
            CtrlSettings.this.settingsGUI.setSkinSpaceShip(CtrlSettings.this.settingsEngine.getSkinSpaceShip());
        };
    }

    private ActionListener changeDifficult(JRadioButton rBtn){
        return e -> {
            if(rBtn.getText() == "Easy"){
                CtrlSettings.this.settingsEngine.setDifficult(Difficulty.EASY);
            } else if(rBtn.getText() == "Medium") {
                CtrlSettings.this.settingsEngine.setDifficult(Difficulty.MEDIUM);
            } else if(rBtn.getText() == "Hard") {
                CtrlSettings.this.settingsEngine.setDifficult(Difficulty.HARD);
            }
        };
    }

    public GUI getGUI() {
        return this.settingsGUI;
    }

    public EngineGUI getEngine() {
        return this.settingsEngine;
    }
}

