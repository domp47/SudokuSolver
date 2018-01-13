import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        boolean continueRunning = true;

        //loop while user wants to run program
        while (continueRunning){
            System.out.print("Enter path for file: ");

            String inputFile = reader.next();

            System.out.println("Using file: " + inputFile);

            int[][] board;
            try {
                //load board from file using helper class
                board = Helper.ReadBoardFromFile(inputFile);
            }catch (IOException e){
                System.out.println("Error Generating Board From File");
                continue;
            }

            //create new board object from file data
            SudokuBoard sudokuBoard = new SudokuBoard(board);

            //check if the board is valid, if not ask again for file
            if (!sudokuBoard.isBoardvalid()) {
                System.out.println("Error: Board is an invalid Puzzle.");
                continue;
            }

            //IF puzzle was solved print solved board. ELSE print message saying unsolvable
            if (sudokuBoard.SolvePuzzle()) {
                System.out.println("Puzzle Solved");
                Helper.printBoard(sudokuBoard.getBoard());
            } else {
                System.out.println("Puzzle Not Solvable");
            }
            System.out.print("Press \"Y\" to Continue: ");

            //get user response for continuing and convert to boolean
            continueRunning = reader.next().toUpperCase().equals("Y");
        }

        reader.close();
    }
}
