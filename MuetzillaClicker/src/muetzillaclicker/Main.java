package muetzillaclicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Instant;

public class Main extends JFrame implements ActionListener {


    JProgressBar pbar;
    JButton button;
    JLabel label;
    JLabel currentLevel;
    JPanel head;
    JLabel levelCost;
    JLabel currentDamage;
    JButton levelUp;
    Icon buttonIcon;

    int clicks = 0;
    int clicksForStage = 0;
    int clickDamage = 1;
    int clickerLevel = 1;
    int clicksNeededForNextLevel = 10;

    long unixTimeEnd;
    long unixTimeStart;
    final int MAX_VALUE = 100;
    final int MIN_VALUE = 0;


    public Main() {
        unixTimeStart = Instant.now().getEpochSecond();
        initComponents();
        Heroes heroes = new Heroes("TEST");
        heroes.start();
    }

    private void initComponents() {
        setSize(750, 500);
        setTitle("MuetzillaClicker");
        GridLayout headerLayout = new GridLayout(0, 5);

        buttonIcon = new ImageIcon("images/clicker.png");
        head = new JPanel();
        levelCost = new JLabel("Level Kosten: " + clicksNeededForNextLevel);

        currentDamage = new JLabel("Aktueller Schaden:" + clickDamage);

        levelUp = new JButton("LEVEL UP Clicker");
        button = new JButton(buttonIcon);

        button.setMnemonic('O');
        label = new JLabel("Klicks: " + clicks);
        currentLevel = new JLabel("Aktuelles Level: " + clickerLevel);

        pbar = new JProgressBar();


        pbar.setMinimum(MIN_VALUE);
        pbar.setMaximum(MAX_VALUE);

        pbar.setStringPainted(true);
        add(head, BorderLayout.NORTH);
        head.setLayout(headerLayout);
        head.add(label);
        head.add(currentDamage);
        head.add(currentLevel);
        head.add(levelCost);
        head.add(levelUp);
        add(button, BorderLayout.CENTER);
        button.addActionListener(this);
        levelUp.addActionListener(this);
        add(pbar, BorderLayout.SOUTH);

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                unixTimeEnd = Instant.now().getEpochSecond();
                System.exit(0);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            clicks += clickDamage;
            clicksForStage++;
            label.setText("Klicks: " + clicks);
            levelCost.setText("Level Kosten: " + clicksNeededForNextLevel);
            stage();


        } else if (e.getSource() == levelUp && clicks >= clicksNeededForNextLevel) {
            System.out.println("Level Up pressed!");
            clickerLevelUp();
        }
    }

    private void stage() {

        if (clicksForStage <= MAX_VALUE) {
            pbar.setValue(clicksForStage);
        }else{
            clicksForStage = 0;
            button.setBackground(Color.RED);
            button.setForeground(Color.ORANGE);
        }

    }

    private void clickerLevelUp() {
        int nextLevelMulti = 4;
        int damageMulti = 3;
        clicks -= clicksNeededForNextLevel;
        clickDamage += (clickerLevel / 2 * damageMulti + 2);
        clicksNeededForNextLevel += (clicksNeededForNextLevel / 3 * nextLevelMulti + 1);

        clickerLevel++;
        label.setText("Klicks: " + clicks);
        currentDamage.setText("Akuteller Schaden: " + clickDamage);
        currentLevel.setText("Aktuelles Level: " + clickerLevel);
        levelCost.setText("Level Kosten: " + clicksNeededForNextLevel);

    }




    public static void main(String[] args) {
        new Main();
    }
}