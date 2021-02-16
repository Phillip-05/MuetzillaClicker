package muetzillaclicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {


    JProgressBar pbar;
    JButton button;
    JLabel label;
    int timesKlicked = 0;

    public Main() {
        initComponents();

    }

    private void initComponents() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Muetzilla Clicker");
        button = new JButton("Klick on me!");
        label = new JLabel("Klicks: " + timesKlicked);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setValue(timesKlicked * 10);
        pbar.setStringPainted(true);
        add(label, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);
        button.addActionListener(this);
        add(pbar, BorderLayout.SOUTH);
        
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            timesKlicked++;
            label.setText("Klicks: " + timesKlicked);

            pbar.setValue(timesKlicked);

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}