package spaceSurvival.controller.GUI.strategy;

import spaceSurvival.controller.GUI.ControllerGUI;
import spaceSurvival.controller.utilities.ListGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;

import java.util.Map;

public class LogicSwitchGame implements LogicSwitchGUI{
    public void algorithm(final ActionGUI actionCurrent, final ActionGUI actionNext,
                          final ListGUI<ActionGUI> chronology, final Map<ActionGUI, ControllerGUI> manager) {

        switch (actionNext) {
            case ID_PAUSE:
                if (chronology.lastElementOfList() != ActionGUI.ID_PAUSE) {
                    chronology.add(actionNext);
                } else {
                    chronology.remove(actionNext);
                }

                manager.get(actionNext).changeVisibility(); break;

            case ID_BACK:
                    manager.get(actionCurrent).turn(Visibility.HIDDEN);
                    chronology.remove(chronology.lastElementOfList());
                    manager.get(chronology.lastElementOfList()).turn(Visibility.VISIBLE);
                break;

            case ID_QUIT: quit(); break;

            default:
                chronology.add(actionNext);
                manager.get(actionNext).turn(Visibility.VISIBLE);
                manager.get(actionCurrent).turn(Visibility.HIDDEN);
                break;
        }
    }

}