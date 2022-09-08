package four;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Engine {


    static Map<String, JButton> board = new HashMap<>();
    private static boolean firstPlayer = true;


     static void fillBoard(String nameOfButton) {
         String keyOfButton = nameOfButton.substring(nameOfButton.length() - 2);
         for (int i = 1; i <= ConnectFour.HEIGHT; i++) {
             String generatedKey = keyOfButton.charAt(0) + String.valueOf(i);
             if (" ".equals(board.get(generatedKey).getText())) {
                 fillCell(board.get(generatedKey));
                 break;
             }
         }
     }

    private static void fillCell(JButton button) {
        if (firstPlayer) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        firstPlayer = !firstPlayer;
    }

    static void resetAll() {
        for (JButton button : board.values()) {
            button.setText(" ");
            button.setBackground(Color.GRAY);
        }
    }

    static void checkWinner() {

    }


}
