package four;

public class Engine {

    protected String[][] fillGrid() {
        char letter = 'A';
        int number = 6;
        String[][] grid = new String[6][7];
            for(int row = 0; row < grid.length; row++) {
                for(int column = 0; column < grid[0].length; column++ ) {
                   grid[row][column] = String.valueOf((char) (letter + column)).concat(String.valueOf(number - row));
                }
            }
        return grid;
    }


}
