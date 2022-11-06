import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player;
        boolean done = false;
        do{
        char[][] board ={{' ', ' ', ' '},
                         {' ', ' ', ' '},
                         {' ', ' ', ' '}};

        gameBoard(board);



while (true) {
    playerTurn(board, scanner);
    if (isGameFinished(board)){
        break;
    }
    gameBoard(board);
    computerturn(board);
    if (isGameFinished(board)){
        break;
    }
    gameBoard(board);
}
            System.out.println("Do you want to play again [Y/N]");
            player = scanner.nextLine();
            if (player.equalsIgnoreCase("N")) {
                System.out.println("Thanks for playing");
                done = true;
            }
        } while (!done);
scanner.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if (hasPlayerWon(board, 'X'))
        {
            gameBoard(board);
            System.out.println("Player wins!");
            return true;
        }

        if (hasPlayerWon(board, 'O'))
        {
            gameBoard(board);
            System.out.println("Computer wins!");
            return true;
        }


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        gameBoard(board);
        System.out.println("The game ended in a tie!");
        return true;

    }


    private static boolean isSpaceAvaible (char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void gameBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);


    }
    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true){
        System.out.println("place your marker in any spot from 1-9");
            System.out.println("1|2|3 \n4|5|6 \n7|8|9" );
        userInput = scanner.nextLine();
        if(isSpaceAvaible(board, userInput)){
                break;
            }else {
            System.out.println(userInput + "is not a valid move");
        }
            }
        placeMove(board, userInput, 'X');
    }
    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("please put down a integer between 1-9");
        }
    }
    private static void computerturn(char[][]board){
        Random rand = new Random();
        int  computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isSpaceAvaible(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("The computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }
private static boolean hasPlayerWon(char[][] board, char symbol){
    if ((board [0][0] == symbol && board [0][1] == symbol && board  [0][2] == symbol) ||
            (board [1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
            (board [2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

            (board [0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
            (board [0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
            (board [0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

            (board [0][0] == symbol && board [1][1] == symbol && board  [2][2] == symbol) ||
            (board [0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ){
        return true;
    }
    return false;
}



}
