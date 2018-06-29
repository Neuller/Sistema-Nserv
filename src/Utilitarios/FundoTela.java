package Utilitarios;

import GUI.Principal;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class FundoTela extends JDesktopPane {
    private final Image Imagem;
    
public FundoTela(String imagem){
    this.Imagem =  new ImageIcon(Principal.class.getResource(imagem)).getImage();
}

@Override
public void paintComponent(Graphics g){
    g.drawImage(Imagem, 0, 0, getWidth(), getHeight(), this);
}

}
