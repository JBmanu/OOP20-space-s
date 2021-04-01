package view.GUI.scoreboard.concrete;

import utilities.IdGUI;
import model.GUI.scoreboard.NameScoreboardGUI;
import view.GUI.AbstractGUI;
import view.GUI.scoreboard.GUIScoreboard;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;


public class GUIScoreboardConcrete extends AbstractGUI implements GUIScoreboard {
    private JLabel lbTitle;
    private JTextField txtSearchName;
    private JButton btnSearch;
    private List scoreboard;
    private ButtonID btnBack;

    public GUIScoreboardConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.txtSearchName = new JTextField();
        this.btnSearch = new JButton();
        this.scoreboard = new List();
        this.btnBack = new ButtonID();
    }

    @Override
    public java.util.List<? extends JButton> getLinks() {
        return java.util.List.of(this.btnSearch, this.btnBack);
    }
    @Override
    public java.util.List<ButtonID> getButtonLinks() {
        return java.util.List.of(this.btnBack);
    }

    @Override
    public void setNameButtons(java.util.List<NameScoreboardGUI> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.getButton(i).setText(listName.get(i).getName());
        }
    }
    @Override
    public void setBtnBackID(IdGUI intoID) {
        this.btnBack.setIdGUICurrent(this.getId());
        this.btnBack.setIdGUINext(intoID);
    }
    @Override
    public void setTitleGUI(final String title){
        this.lbTitle.setText(title);
    }

    public void setAllFontNotLbTitle(final Font font){
        this.txtSearchName.setFont(font);
        this.btnSearch.setFont(font);
        this.scoreboard.setFont(font);
        this.btnBack.setFont(font);
    }

    public void setAllForeground(Color color) {
        this.lbTitle.setForeground(color);
        this.btnSearch.setForeground(color);
        this.scoreboard.setForeground(color);
        this.btnBack.setForeground(color);
    }

    public void setFontLbTitle(final Font font){
        this.lbTitle.setFont(font);
    }

    public JButton getButton(int ind) {
        return getLinks().get(ind);
    }
    public JLabel getLbTitle() {
        return lbTitle;
    }
    public JTextField getTxtSearchName() {
        return txtSearchName;
    }
    public JButton getBtnSearch() {
        return btnSearch;
    }
    public List getScoreboard() {
        return scoreboard;
    }
    public JButton getBtnBack() {
        return btnBack;
    }



}
