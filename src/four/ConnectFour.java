package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConnectFour extends JFrame implements ActionListener {

    private int clickCounter = 0;
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Connect Four");

        Engine newArray = new Engine();
        for (String[] row : newArray.fillGrid()) {
            for(String column : row) {
                JButton button = new JButton(" ");
                button.setName("Button" + column);
                button.addActionListener(this);
                add(button);

                /*JLabel label = new JLabel(" ");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setName(column);
                label.setFont(new Font("Courier", Font.BOLD,12));
                label.setFont(label.getFont().deriveFont(15f));
                label.setVisible(true);
                button.add(label);*/

            }
        }
        setLayout(new GridLayout(6, 7, 1, 1));
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        JButton change = (JButton) e.getSource();
        if (clickCounter % 2 != 0) {
            change.setText("O");
        } else {
            change.setText("X");
        }
        clickCounter++;



    }

}