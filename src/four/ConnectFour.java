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
        setLayout(new BorderLayout());

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(6, 7, 1, 1));
        for (int i = HEIGHT; i >= 1; i--) {
            for (int j = 0; j < LENGTH; j++) {
                char ch = (char) ('A' + j);
                String name = String.format("Button%c%d", ch, i);
                JButton button = new JButton(" ");
                button.setName(name);
                button.setBackground(Color.GRAY);
                button.setFocusPainted(false);
                button.addActionListener(actionEvent -> Engine.fillingBoard(ch));
                panelButtons.add(button);
                buttons.add(button);
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