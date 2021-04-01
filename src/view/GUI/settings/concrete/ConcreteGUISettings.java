package view.GUI.settings.concrete;

import model.MyJImage.JImageRateEngine;
import model.GUI.settings.Difficult;
import utilities.IdGUI;
import model.GUI.settings.NameSettingsGUI;
import view.GUI.AbstractGUI;
import view.GUI.settings.GUISettings;
import view.GUI.settings.utilities.PanelDifficult;
import view.GUI.settings.utilities.PanelSkin;
import view.GUI.settings.utilities.PanelSound;
import view.utilities.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConcreteGUISettings extends AbstractGUI implements GUISettings {
    private final JLabel lbTitle = new JLabel();
    private final PanelSkin panelSkin = new PanelSkin();
    private final PanelDifficult panelDifficult = new PanelDifficult();
    private final PanelSound panelSound = new PanelSound();
    private final ButtonID btnBack = new ButtonID();

    public ConcreteGUISettings() {
        super();
    }

    public void setAllFontNotLbTitle(Font font) {
        this.panelSound.setFontSliderSound(font);
        this.panelDifficult.setFontGroupRadioButton(font);
        this.panelSkin.setFontButtons(font);
    }

    public void setAllForeground(Color color) {
        this.lbTitle.setForeground(color);
        this.panelSkin.setAllForeground(color);
        this.panelDifficult.setAllForeground(color);
        this.panelSound.setAllForeground(color);
        this.btnBack.setForeground(color);
    }

    public void setFontLbTitle(Font font) {
        this.lbTitle.setFont(font);
    }


    public List<? extends JButton> getLinks() {
        return List.of(this.panelSkin.getBtSX(), this.panelSkin.getBtDX());
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnBack);
    }

    @Override
    public void setTitleGUI(String title) {
        this.lbTitle.setText(title);
    }

    @Override
    public void setFontTitlePanel(Font font) {
        this.panelSkin.setFontLbTitle(font);
        this.panelDifficult.setFontTitleDifficult(font);
        this.panelSound.setFontTitleSound(font);
        this.btnBack.setFont(font);
    }

    @Override
    public void setBtnBackID(IdGUI intoID) {
        this.btnBack.setIdGUICurrent(this.getId());
        this.btnBack.setIdGUINext(intoID);
    }

    @Override
    public void setNameButtons(List<NameSettingsGUI> listName) {
        int i = 0;
        this.panelSkin.setLbTitle(listName.get(i++).getTitle());
        this.panelDifficult.setTitle(listName.get(i++).getTitle());
        this.panelSound.setTitle(listName.get(i++).getTitle());
        this.btnBack.setText(listName.get(i).getTitle());
    }

    @Override
    public void setSkinSpaceShip(JImageRateEngine imageEngine) {
        this.panelSkin.setPnImage(imageEngine.getPathImg());
        this.panelSkin.setRateImg(imageEngine.getRate());
    }

    @Override
    public void setDifficult(Difficult difficult) {
        this.panelDifficult.setDifficult(difficult);
    }

    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public JButton getBtnBack(){
        return this.btnBack;
    }

    public PanelSkin getPanelSkin() {
        return this.panelSkin;
    }

    public PanelDifficult getPanelDifficult(){
        return this.panelDifficult;
    }

    public PanelSound getPanelSound() {
        return this.panelSound;
    }
}
