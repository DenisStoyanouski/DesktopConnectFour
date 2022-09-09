package four;

import javax.swing.*;
import java.awt.*;

import static four.Engine.board;
import static four.Engine.hasLineFour;


public class ConnectFour extends JFrame {
    final static int LENGTH = 7;
    final static int HEIGHT = 6;
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Connect Four");
        setLayout(new BorderLayout());

        JPanel panelButtons = new JPanel();
        panelButtons.setSize(300,300);
        panelButtons.setLayout(new GridLayout(6, 7, 1, 1));
        for (int i = HEIGHT; i >= 1; i--) {
            for (int j = 0; j < LENGTH; j++) {
                char ch = (char) ('A' + j);
                String name = String.format("Button%c%d", ch, i);
                JButton button = new JButton(" ");
                button.setName(name);
                button.setBackground(Color.GRAY);
                button.setFocusPainted(false);
                button.addActionListener(actionEvent -> {
                    if (!Engine.isGameOver) {
                        Engine.fillBoard(button.getName());
                    }
                });
                panelButtons.add(button);
                board.put(String.format("%c%d", ch, i), button);
            }
        }
        add(panelButtons, BorderLayout.CENTER);
        setVisible(true);

        JPanel panelReset = new JPanel();
        JButton buttonReset = new JButton();
        buttonReset.setName("ButtonReset");
        buttonReset.setText("Reset");
        buttonReset.addActionListener(actionEvent -> Engine.resetAll());
        panelReset.add(buttonReset);
        add(panelReset, BorderLayout.SOUTH);


    }

}