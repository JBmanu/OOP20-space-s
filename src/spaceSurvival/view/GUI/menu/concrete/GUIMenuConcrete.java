package spaceSurvival.view.GUI.menu.concrete;

import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.AbstractGUI;
import spaceSurvival.view.GUI.menu.GUIMenu;
import spaceSurvival.view.utilities.ButtonID;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUIMenuConcrete extends AbstractGUI implements GUIMenu {
    private final JLabel lbTitle;
    private final JTextField txfNamePlayer;
    private final List<ButtonID> links;

    public GUIMenuConcrete(){
        super();
        this.lbTitle = new JLabel();
        this.txfNamePlayer = new JTextField();
        this.links = Stream.generate(ButtonID::new)
                .limit(EngineGame.N_BUTTONS).collect(Collectors.toList());
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return this.links;
    }


    @Override
    public void setNameButtons(final List<String> listName) {
        for(int i = 0; i < listName.size(); i++){
            this.links.get(i).setText(listName.get(i));
        }
    }

    @Override
    public void setIdButtons(final List<IdGUI> linksID) {
        for(int i = 0; i < linksID.size(); i++){
            this.links.get(i).setIdGUICurrent(this.getId());
            this.links.get(i).setIdGUINext(linksID.get(i));
        }
    }

    @Override
    public ButtonID getButton(final int ind){
        return this.links.get(ind);
    }

    @Override
    public void setForegroundGUI(final Color color) {
        this.lbTitle.setForeground(color);
        this.links.forEach(button -> button.setForeground(color));
    }

    @Override
    public void setFontTitleGUI(final Font font){
        this.lbTitle.setFont(font);
    }

    @Override
    public void setFontGUI(final Font font){
        this.txfNamePlayer.setFont(font);
        this.links.forEach(button -> button.setFont(font));
    }

    @Override
    public void setTitleGUI(final String title){
        this.lbTitle.setText(title);
    }

    @Override
    public void setColumnsNamePlayer(final int sizeColumn) {
        this.txfNamePlayer.setColumns(sizeColumn);
    }


    public JLabel getLbTitle(){
        return this.lbTitle;
    }

    public JTextField getTxfNamePlayer(){
        return this.txfNamePlayer;
    }
}