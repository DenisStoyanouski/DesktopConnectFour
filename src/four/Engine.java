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
                 checkWinner(keyOfButton, board.get(generatedKey).getText());
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

    static void checkWinner(String keyOfButton, String letter) { //check winner by keyOfButton and letter;//
        String checker = letter.repeat(4);
        Map<String, String> line = new HashMap<>();

        String letterOfKey = String.valueOf(keyOfButton.charAt(0));
        String numberOfKey = String.valueOf(keyOfButton.charAt(1));
        StringBuilder horizontal = new StringBuilder();
        for (var entry : board.entrySet()) {
            if (entry.getKey().contains(letterOfKey)) {
                line.put(entry.getKey(), entry.getValue().getText());
            }
        }


        String vertical;
        String diagonalLeftRight;
        String diagonalRightLeft;


    }


}
