package spacesurvival.factories;

import spacesurvival.view.dead.FactoryGUIDead;
import spacesurvival.view.dead.GUIDead;
import spacesurvival.view.dead.factorymethod.GUIDeadStandard;
import spacesurvival.view.loading.FactoryGUILoading;
import spacesurvival.view.loading.GUILoading;
import spacesurvival.view.loading.factorymethod.GUILoadingStandard;
import spacesurvival.view.game.FactoryGUIGame;
import spacesurvival.view.game.GUIGame;
import spacesurvival.view.game.factorymethod.GUIGameStandard;
import spacesurvival.view.help.factorymethod.GUIHelpStandard;
import spacesurvival.view.help.FactoryGUIHelp;
import spacesurvival.view.help.GUIHelp;
import spacesurvival.view.menu.factorymethod.GUIMenuStandard;
import spacesurvival.view.menu.FactoryGUIMenu;
import spacesurvival.view.menu.GUIMenu;
import spacesurvival.view.pause.FactoryGUIPause;
import spacesurvival.view.pause.GUIPause;
import spacesurvival.view.pause.factorymethod.GUIPauseStandard;
import spacesurvival.view.scoreboard.factorymethod.GUIScoreboardStandard;
import spacesurvival.view.scoreboard.FactoryGUIScoreboard;
import spacesurvival.view.scoreboard.GUIScoreboard;
import spacesurvival.view.settings.factorymethod.GUISettingsStandard;
import spacesurvival.view.settings.FactoryGUISettings;
import spacesurvival.view.settings.GUISettings;
import spacesurvival.view.sound.FactoryGUISound;
import spacesurvival.view.sound.GUISound;
import spacesurvival.view.sound.factorymethod.GUISoundStandard;

public class StaticFactoryGUI {

    public static GUILoading createLoading() {
        final FactoryGUILoading factoryGUILoading = new GUILoadingStandard();
        return factoryGUILoading.create();
    }

    public static GUIMenu createMenuGUI() {
        final FactoryGUIMenu menuGUI = new GUIMenuStandard();
        return menuGUI.createGUI();
    }

    public static GUIScoreboard createScoreboardGUI() {
        final FactoryGUIScoreboard scoreboardGUI = new GUIScoreboardStandard();
        return scoreboardGUI.createGUI();
    }

    public static GUISettings createSettingsGUI() {
        final FactoryGUISettings settingsGUI = new GUISettingsStandard();
        return settingsGUI.create();
    }

    public static GUIHelp createHelpGUI() {
        final FactoryGUIHelp helpGUI = new GUIHelpStandard();
        return helpGUI.create();
    }

    public static GUISound createSoundGUI() {
        final FactoryGUISound soundGUI = new GUISoundStandard();
        return soundGUI.create();
    }

    public static GUIGame createGameGUI() {
        final FactoryGUIGame gameGUI = new GUIGameStandard();
        return gameGUI.create();
    }

    public static GUIPause createPauseGUI() {
        final FactoryGUIPause pauseGUI = new GUIPauseStandard();
        return pauseGUI.create();
    }

    public static GUIDead createDeadGUI() {
        final FactoryGUIDead deadGUI = new GUIDeadStandard();
        return deadGUI.create();
    }

}
