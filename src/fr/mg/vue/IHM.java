package fr.mg.vue;

import javax.swing.*;

public class IHM extends JFrame{
    private JPanel container = new JPanel();

    public IHM(){
        this.setSize(400,400);
        this.setTitle("Snorkunking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(container);
        this.setVisible(true);
    }
}
