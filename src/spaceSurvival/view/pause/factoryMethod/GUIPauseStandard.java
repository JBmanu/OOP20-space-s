package spacesurvival.view.pause.factorymethod;

import spacesurvival.model.gui.pause.EnginePause;
import spacesurvival.view.utilities.DesignGraphics;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.view.pause.FactoryGUIPause;
import spacesurvival.view.pause.GUIPause;
import spacesurvival.view.pause.concrete.GUIPauseConcrete;
import spacesurvival.view.pause.utilities.IconsButton;
import spacesurvival.view.utilities.FactoryGUIs;

import java.awt.*;

public class GUIPauseStandard implements FactoryGUIPause {

    @Override
    public GUIPause create() {
        final GUIPauseConcrete concrete = new GUIPauseConcrete();

        concrete.setFontGUITitle(DesignGraphics.getFontForTitle(DesignGraphics.SIZE_FONT_H1));

        concrete.setForegroundGUI(DesignGraphics.COLOR_4);
        concrete.setFontButtons(DesignGraphics.FONT_MEDIUM_STANDARD);

        concrete.setBorder(DesignGraphics.COLOR_4, FactoryGUIs.MIN_INSET);

        this.createGraphics(concrete);

        return concrete;
    }

    private void createGraphics(final GUIPauseConcrete concrete){
        concrete.setLayout(new BorderLayout());

        concrete.getBtnActionLinks().forEach(FactoryGUIs::setTransparentDesignJButton);

        concrete.getBtnActionLinks().forEach(btn -> btn.setFocusable(false));
        concrete.add(FactoryGUIs.encapsulatesInPanelFlow(concrete.getLbTitle()), BorderLayout.NORTH);

        concrete.add(FactoryGUIs.createPanelGridBagUnionComponentsVertical(concrete.getBtnActionLinks(),
                FactoryGUIs.MEDIUM_INSET), BorderLayout.CENTER);

        for (int i = 0; i < concrete.getBtnActionLinks().size(); i++){
            FactoryGUIs.setIconJButtonFromRate(concrete.getActionBtn(i), IconsButton.values()[i].getPath(),
                    ScaleOf.ICON_SMALL, EnginePause.RECTANGLE.width);
        }

    }
}
