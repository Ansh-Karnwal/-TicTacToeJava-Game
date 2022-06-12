import java.util.Arrays;
import java.util.List;

public class TicTacToe {

    private List<Character> Board = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public void getBoard() {
        for (int i = 0; i < 9; i += 3) {
            for (int j = i; j < i + 3; j++) {
                System.out.printf(" %c", Board.get(j));
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isPlaceValid(int position) {
        if (position >= 1 && position <=9) {
            return true;
        }
        return false;
    }

    public boolean isSpotChosen(int position) {
        position -= 1;
        if (Board.get(position) == 'X' || Board.get(position) == 'O') {
            return true;
        }
        return false;
    }

    public void place(int position, char letter) {
        if (position == 1) Board.set(0, letter);
        if (position == 2) Board.set(1, letter);
        if (position == 3) Board.set(2, letter);
        if (position == 4) Board.set(3, letter);
        if (position == 5) Board.set(4, letter);
        if (position == 6) Board.set(5, letter);
        if (position == 7) Board.set(6, letter);
        if (position == 8) Board.set(7, letter);
        if (position == 9) Board.set(8, letter);
    }

    public boolean isGameWon(char letter) {
        if (Board.get(0) == letter && Board.get(1) == letter && Board.get(2) == letter) return true;
        if (Board.get(3) == letter && Board.get(4) == letter && Board.get(5) == letter) return true;
        if (Board.get(6) == letter && Board.get(7) == letter && Board.get(8) == letter) return true;
        if (Board.get(0) == letter && Board.get(3) == letter && Board.get(6) == letter) return true;
        if (Board.get(1) == letter && Board.get(4) == letter && Board.get(7) == letter) return true;
        if (Board.get(2) == letter && Board.get(5) == letter && Board.get(8) == letter) return true;
        if (Board.get(0) == letter && Board.get(4) == letter && Board.get(8) == letter) return true;
        if (Board.get(2) == letter && Board.get(4) == letter && Board.get(6) == letter) return true;
        return false;
    }

    public boolean isFull() {
        List<Character> letters = Arrays.asList('X', 'O');
        if (letters.contains(Board.get(0)) && letters.contains(Board.get(1)) && letters.contains(Board.get(2)) && letters.contains(Board.get(3)) &&
                letters.contains(Board.get(4)) && letters.contains(Board.get(5)) && letters.contains(Board.get(6)) && letters.contains(Board.get(7)) &&
                    letters.contains(Board.get(8))) {
            return true;
        }
        return false;
    }

}
