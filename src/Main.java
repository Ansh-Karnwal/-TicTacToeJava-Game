import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static TicTacToe Board = new TicTacToe();
    public static void main(String[] args) {
        Board.getBoard();
        Main main = new Main();
        Player player1 = new Player(null);
        Player player2 = new Player(null);
        for (int i = 0; i < 5; i++) {
            main.getPlayerInformation(player1, 1);
            main.getPlayerInformation(player2, 2);
        }
    }

    private void getPlayerInformation(Player player, int playerNum) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(getMovementString(playerNum));
                int nextIntVal = scanner.nextInt();
                if (!Board.isPlaceValid(nextIntVal)) {
                    while (!Board.isPlaceValid(nextIntVal)) {
                        System.out.println("Sorry, illegal input! Please input again.");
                        Board.getBoard();
                        System.out.print(getMovementString(playerNum));
                        nextIntVal = scanner.nextInt();
                        player.setPosition(nextIntVal);
                    }
                }
                else {
                    player.setPosition(nextIntVal);
                }
                while (Board.isSpotChosen(player.getPosition())) {
                    System.out.println("Sorry, spot has been chosen please chose another.");
                    Board.getBoard();
                    System.out.print(getMovementString(playerNum));
                    player.setPosition(scanner.nextInt());
                    while (!Board.isPlaceValid(player.getPosition())) {
                        System.out.println("Sorry, illegal input! Please input again.");
                        Board.getBoard();
                        System.out.print(getMovementString(playerNum));
                        player.setPosition(scanner.nextInt());
                    }
                }
                if (playerNum == 1) {
                    Board.place(player.getPosition(), 'X');
                }
                if (playerNum == 2) {
                    Board.place(player.getPosition(), 'O');
                }

                if (Board.isGameWon('X')) {
                    Board.getBoard();
                    System.out.println("Player 1 Won!");
                    System.exit(0);
                }
                if (Board.isGameWon('O')) {
                    Board.getBoard();
                    System.out.println("Player 2 Won!");
                    System.exit(0);
                }
                if (Board.isFull()) {
                    Board.getBoard();
                    System.out.println("Its a tie!");
                    System.exit(0);
                }
                break;
            }
            catch (InputMismatchException inputMismatchException) {
                System.out.println("Sorry, illegal input! Please input again.");
                Board.getBoard();
            }
        }
        Board.getBoard();
    }

    private String getMovementString(int playerNum) {
        return String.format("Where does Player %o move: ", playerNum);
    }
}