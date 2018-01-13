import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Helper {

    /**
     * Reads sudoku board from file given and returns it into 2D int array
     *
     * @param filePath file path that contains the board data
     * @return int array corresponding to sudoku board
     */
   static int[][] ReadBoardFromFile(String filePath)throws IOException{
       int[][] board = new int[9][9];
       int rowCounter = 0;

       String line;
       // FileReader reads text files in the default encoding.
       FileReader fileReader = new FileReader(filePath);

       // Always wrap FileReader in BufferedReader.
       BufferedReader bufferedReader = new BufferedReader(fileReader);

       //read file line by line inserting each line into first dimension of board.
       while((line = bufferedReader.readLine()) != null) {

           //split the line by delimited spaces
           String[] split = line.split("\\s+");

           //for each item that's delimited insert it into array
           for(int i = 0; i < split.length; i++){
               if(i < board[rowCounter].length&&rowCounter<board.length){
                   board[rowCounter][i] = Integer.parseInt(split[i]);
               }
           }
           rowCounter++;
       }

       // Always close files.
       bufferedReader.close();

       return board;
   }

    /**
     * Prints the board in ASCII using javas standard output.
     *
     * @param board int array containing board data
     */
   static void printBoard(int[][] board){
       System.out.println("##################################");

       //loop through every element printing it unless it's 0, then print a space
       for(int y = 0; y < board.length; y++){
           for(int x = 0; x < board[y].length; x++){
               if(board[y][x]==0){
                   System.out.print(" ");
               }else {
                   System.out.print(board[y][x]);
               }

               //if we've printed a quadrant print pound, if not dash
               if((x+1) < board[y].length && (x+1)%3 == 0){
                   System.out.print(" # ");
               }else if((x+1) < board[y].length){
                   System.out.print(" | ");
               }
           }

           //if we've printed a quadrant then print solid pound sign, if not then print dashes
           if((y+1) < board.length && (y+1)%3 == 0){
               System.out.println("\n##################################");
           }else if((y+1) < board.length){
               System.out.println("\n----------#-----------#-----------");
           }
       }
       System.out.println("\n##################################");
   }
}
