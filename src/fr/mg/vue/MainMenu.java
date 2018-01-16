package fr.mg.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel {

    public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(new File("mainBackground.jpg"));
            g.drawImage(img,0, 0,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

