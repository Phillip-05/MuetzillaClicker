package muetzillaclicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {


    JProgressBar pbar;
    JButton button;
    JLabel label;
    JLabel currentLevel;
    JPanel head;
    JButton levelUp;
    Icon buttonIcon;

    int timesKlicked = 0;
    int hunderterStelle = 0;
    int clickDamage = 1;
    int clickerLevel = 1;

    final int MAX_VALUE = 100;
    final int MIN_VALUE = 0;


    public Main() {
        initComponents();

    }

    private void initComponents() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Muetzilla Clicker");
        GridLayout headerLayout = new GridLayout(0, 3);
        head = new JPanel();
        levelUp = new JButton("Level Up");
        button = new JButton("Click Me!", new ImageIcon("clicker.png"));
        button.setMnemonic('O');
        label = new JLabel("Klicks: " + timesKlicked);
        currentLevel = new JLabel("CurrentLevel: " + timesKlicked);

        pbar = new JProgressBar();

        pbar.setMinimum(MIN_VALUE);
        pbar.setMaximum(MAX_VALUE);

        pbar.setStringPainted(true);
        add(head, BorderLayout.NORTH);
        head.setLayout(headerLayout);
        head.add(label);
        head.add(currentLevel);
        head.add(levelUp);
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
            levelSetValue();

        }
    }

    private void levelSetValue() {
        int timesClickedThis100 = 0;
        if (timesKlicked <= MAX_VALUE) {
            pbar.setValue(timesClickedThis100);
        }
        if (timesKlicked % 100 == 0) {
            pbar.setValue(0);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}