package spaceSurvival.view.GUI.menu.factoryMethod;

import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.utilities.DesignJComponent;
import spaceSurvival.utilities.DesignSpace;
import spaceSurvival.view.GUI.menu.FactoryGUIMenu;
import spaceSurvival.view.GUI.menu.GUIMenu;
import spaceSurvival.view.GUI.menu.concrete.GUIMenuConcrete;
import spaceSurvival.view.GUI.menu.utilities.IconsButton;
import spaceSurvival.view.utilities.FactoryGUIs;

import java.awt.*;
import java.util.List;

public class GUIMenuCompact implements FactoryGUIMenu {

    @Override
    public GUIMenu createGUI() {
        final GUIMenuConcrete menuConcrete = new GUIMenuConcrete();

        menuConcrete.setFontGUI(DesignSpace.FONT_MEDIUM_STANDARD);
        menuConcrete.setForegroundGUI(DesignSpace.color4);
        menuConcrete.setFontTitleGUI(DesignSpace.getFontForTitle(DesignSpace.SIZE_FONT_H1));
        menuConcrete.setColumnsNamePlayer(DesignJComponent.SIZE_COLUMNS_TEXT);
        this.createGraphics(menuConcrete);
        return menuConcrete;
    }

    private void createGraphics(final GUIMenuConcrete menu) {
        menu.setBackgroundLayout(new GridBagLayout());
        int nBtnUsed = 0;

        GridBagConstraints lim = FactoryGUIs.createGBConstraintsWithSpaceTitle(DesignJComponent.SIZE_SPACE_TITLE);
        menu.add(menu.getLbTitle(), lim);

        FactoryGUIs.resetGridBagConstraints(lim);
        lim.gridy++;

        menu.getButtonLinks().forEach(FactoryGUIs::setTransparentDesignJButton);

        menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getTxfNamePlayer(),
                menu.getButtonLinks().get(nBtnUsed++))), lim);

        while(nBtnUsed < EngineGame.N_BUTTONS){
            lim.gridy++;
            menu.add(FactoryGUIs.createPanelFlowUnionComponents(List.of(menu.getButtonLinks().get(nBtnUsed++),
                    nBtnUsed + 1 < EngineGame.N_BUTTONS ? menu.getButtonLinks().get(nBtnUsed++) : FactoryGUIs.getJComponentEmpty())), lim);
        }

        nBtnUsed = 0;
        while(nBtnUsed < EngineGame.N_BUTTONS){
            FactoryGUIs.setIconJButtonFromRate(menu.getButton(nBtnUsed),
                    IconsButton.values()[nBtnUsed++].getPath(), 25, menu.getWidth());
        }
    }
}