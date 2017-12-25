package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class IHM extends JFrame{
    private JPanel container = new JPanel();

    public IHM(int cave1, int cave2, int cave3){
        // Setup the window
        this.setSize(500,500);
        this.setTitle("Snorkunking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Setup window's content
        container.setBackground(Color.blue);
        container.setLayout(new BorderLayout());
        container.add(new TopBar(), BorderLayout.NORTH);
        this.setContentPane(container);

        this.setVisible(true);
    }
}
