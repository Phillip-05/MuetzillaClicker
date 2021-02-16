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
    JLabel levelCost;
    JButton levelUp;
    Icon buttonIcon;

    int clicks = 0;
    int hunderterStelle = 0;
    int clickDamage = 1;
    int clickerLevel = 1;
    int clicksNeededForNextLevel = 10;

    final int MAX_VALUE = 100;
    final int MIN_VALUE = 0;


    public Main() {
        initComponents();

    }

    private void initComponents() {
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MuetzillaClicker");
        GridLayout headerLayout = new GridLayout(0, 4);

        buttonIcon = new ImageIcon("images/clicker.png");
        head = new JPanel();
        levelCost = new JLabel("Level Kosten: " + clicks + "/" + clicksNeededForNextLevel);

        levelUp = new JButton("LEVEL UP");
        button = new JButton(buttonIcon);

        button.setMnemonic('O');
        label = new JLabel("Klicks: " + clicks);
        currentLevel = new JLabel("Current Level: " + clicks);

        pbar = new JProgressBar();

        pbar.setMinimum(MIN_VALUE);
        pbar.setMaximum(MAX_VALUE);

        pbar.setStringPainted(true);
        add(head, BorderLayout.NORTH);
        head.setLayout(headerLayout);
        head.add(label);
        head.add(currentLevel);
        head.add(levelCost);
        head.add(levelUp);
        add(button, BorderLayout.CENTER);
        button.addActionListener(this);
        add(pbar, BorderLayout.SOUTH);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            clicks += clickDamage;
            label.setText("Klicks: " + clicks);
            levelCost.setText("Level Kosten: " + clicks + "/" + clicksNeededForNextLevel);
            levelSetValue();

        } else if (e.getSource() == levelUp && clicks >= clicksNeededForNextLevel) {
            clickerLevelUp();
        }
    }

    private void clickerLevelUp() {

    }

    private void levelSetValue() {
        int timesClickedThis100 = 0;
        if (clicks <= MAX_VALUE) {
            pbar.setValue(timesClickedThis100);
        }
        if (clicks % 100 == 0) {
            pbar.setValue(0);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}