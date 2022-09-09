package four;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Engine {


    static Map<String, JButton> board = new HashMap<>();
    private static boolean firstPlayer = true;
    static boolean isGameOver = false;


     static void fillBoard(String nameOfButton) {
         String keyOfButton = nameOfButton.substring(nameOfButton.length() - 2);
         for (int i = 1; i <= ConnectFour.HEIGHT; i++) {
             String generatedKey = keyOfButton.charAt(0) + String.valueOf(i);
             if (" ".equals(board.get(generatedKey).getText())) {
                 fillCell(board.get(generatedKey));
                 checkWinner(generatedKey, board.get(generatedKey).getText());
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
        isGameOver = false;
    }

    static void checkWinner(String generatedKey, String letter) { //check winner by keyOfButton and letter;//
        ArrayList<String> horizontalLine = new ArrayList<>();
        ArrayList<String> verticalLine = new ArrayList<>();
        String letterOfKey = String.valueOf(generatedKey.charAt(0));
        String numberOfKey = String.valueOf(generatedKey.charAt(1));
        // check horizontal line
        for (var key : board.keySet()) {
            if (key.matches(String.format("[A-G]%s", numberOfKey))) {
                horizontalLine.add(key);
            }
            if (key.matches(String.format("%s[1-6]", letterOfKey))) {
                verticalLine.add(key);
            }
        }
        hasLineFour(horizontalLine, letter);
        hasLineFour(verticalLine, letter);


    }

    static void hasLineFour(ArrayList<String> line, String letter) {
         String checker = letter.repeat(4);
         line.sort(Comparator.naturalOrder());
         StringBuilder lineLetter = new StringBuilder();
         line.forEach(key -> lineLetter.append(board.get(key).getText()));
         if (lineLetter.toString().contains(checker)) {
             isGameOver = true;
             int index = lineLetter.indexOf(checker);
             for (int j = index; j < index + 4; j++) {
                 board.get(line.get(j)).setBackground(Color.GREEN);
             }
         }
    }

}
