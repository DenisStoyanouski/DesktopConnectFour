package four;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class ConnectFour extends JFrame {

    static ArrayList<JButton> buttons = new ArrayList<>();
    final int LENGTH = 7;
    static final int HEIGHT = 6;
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Connect Four");

        for (int i = HEIGHT; i >= 1; i--) {
            for (int j = 0; j < LENGTH; j++) {
                char ch = (char) ('A' + j);
                String name = String.format("Button%c%d", ch, i);
                JButton button = new JButton(" ");
                button.setName(name);
                button.setFocusPainted(false);
                button.addActionListener(actionEvent -> Engine.fillingBoard(ch));
                add(button);
                buttons.add(button);
            }
        }
        setLayout(new GridLayout(6, 7, 1, 1));
        setVisible(true);
    }

}