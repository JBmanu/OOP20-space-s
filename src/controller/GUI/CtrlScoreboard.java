package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.scoreboard.EngineScoreboard;
import view.GUI.GUI;
import view.GUI.scoreboard.GUIScoreboard;

public class CtrlScoreboard implements ControllerGUI {
    private final GUIScoreboard scoreboardGUI;
    private final EngineScoreboard scoreboardEngine;

    public CtrlScoreboard(final GUIScoreboard scoreboardGUI, final EngineScoreboard scoreboardEngine){
        this.scoreboardGUI = scoreboardGUI;
        this.scoreboardEngine = scoreboardEngine;
        this.initScoreboard();
    }

    private void initScoreboard(){
        this.scoreboardGUI.setId(this.scoreboardEngine.getId());
        this.scoreboardGUI.setTitleGUI(this.scoreboardEngine.getTitleGUI());
        this.scoreboardGUI.setNameButtons(this.scoreboardEngine.getListName());
        this.scoreboardGUI.setBtnBackID(this.scoreboardEngine.getBackLink());
        this.scoreboardGUI.setVisible(this.scoreboardEngine.isVisible());
    }

    public GUI getGUI() {
        return this.scoreboardGUI;
    }

    public EngineGUI getEngine() {
        return this.scoreboardEngine;
    }
}