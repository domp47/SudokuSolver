import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String file;

        System.out.print("Enter full path for file: ");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String inputFile = reader.next();
        reader.close();

        System.out.println("Using file: "+inputFile);

        file = "/home/dom/Projects/BacktrackingSudoku/BacktrackingSudoku-Java/board.txt";
        int[][] board = Helper.ReadBoardFromFile(file);

        System.out.println("Puzzle To Solve");
        Helper.printBoard(board);

        Solver solver = new Solver(board);
        if(solver.SolvePuzzle()){
            System.out.println("Puzzle Solved");
            Helper.printBoard(solver.getBoard());
        }else{
            System.out.println("Puzzle Not Solvable");
        }

    }
}
