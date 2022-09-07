package four;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Engine {


    private static Map<Character, Integer> filled = new HashMap<>();
    private static boolean firstPlayer = true;


     static void fillingBoard(char ch) {
        if (!filled.containsKey(ch)) {
            filled.put(ch, 1);
            JButton button = null;
            for (JButton b : ConnectFour.buttons) {
                if (b.getName().equals(String.format("Button%c1", ch))) {
                    button = b;
                    break;
                }
            }
            fillHelper(button);
            return;
        }
        if (filled.get(ch) == ConnectFour.HEIGHT) {
            return;
        }
        JButton button = null;
        int index = filled.get(ch);
        for (JButton b: ConnectFour.buttons) {
            if (b.getName().equals(String.format("Button%c%d", ch, index + 1))) {
                button = b;
                break;
            }
        }
        fillHelper(button);
        filled.put(ch, index + 1);
    }
    private static void fillHelper(JButton button) {
        assert button.getText().equals(" ");
        if (firstPlayer) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        firstPlayer = !firstPlayer;
    }

    static void resetAll() {
        for (JButton b : ConnectFour.buttons) {
            b.setText(" ");
        }
    }


}
