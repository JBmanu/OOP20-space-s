package spacesurvival.controller.gui;

import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.menu.EngineMenu;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.menu.GUIMenu;

/**
 * Implements the controller for the menu GUI.
 */
public class CtrlMenu implements ControllerGUI {
    private final GUIMenu gui;
    private final EngineMenu engine;

    private final SwitchGUI switchGUI;

    public CtrlMenu(final EngineMenu menuEngine, final GUIMenu menuGUI){
        this.gui = menuGUI;
        this.engine = menuEngine;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.switchGUI.turn(this.engine.getVisibility());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignAction(){
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setBtnActions(this.engine.getMainAction(), this.engine.getLinks());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignStrings(){
        this.gui.setTitleGUI(this.engine.getTitleGUI());
        this.gui.setNameButtons(this.engine.getListNameLinks());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignRectangle(){
        this.gui.setBounds(this.engine.getRectangle());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkActionGUI getMainAction() {
        return this.engine.getMainAction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GUI getGUI() {
        return this.gui;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void turn(final Visibility visibility){
        this.switchGUI.turn(visibility);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void closeGUI() {
        this.gui.close();
    }
}
