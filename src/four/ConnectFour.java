package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Connect Four");


        Engine newArray = new Engine();
        for (String[] row : newArray.fillGrid()) {
            for(String column : row) {
                JButton button = new JButton();
                add(button);
                JLabel label = new JLabel(column);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Courier", Font.BOLD,12));
                label.setFont(label.getFont().deriveFont(15f));

                button.add(label);
            }
        }
        setLayout(new GridLayout(6, 7, 1, 1));
        setVisible(true);






    }


}