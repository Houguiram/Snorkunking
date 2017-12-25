package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, this.getWidth(),50);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50,50);
    }
}
