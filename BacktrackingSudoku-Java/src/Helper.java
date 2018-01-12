import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Helper {
   static int[][] ReadBoardFromFile(String filePath){
       int[][] board = new int[9][9];
       int rowCounter = 0;

       String line;
       try {
           // FileReader reads text files in the default encoding.
           FileReader fileReader = new FileReader(filePath);

           // Always wrap FileReader in BufferedReader.
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           while((line = bufferedReader.readLine()) != null) {
//               System.out.println(line);

               String[] split = line.split("\\s+");

               for(int i = 0; i < split.length; i++){
                   if(i < board[rowCounter].length&&rowCounter<board.length){
                       board[rowCounter][i] = Integer.parseInt(split[i]);
                   }
               }
               rowCounter++;
           }

           // Always close files.
           bufferedReader.close();
       }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + filePath + "'");
       }
       catch(IOException ex) {
           System.out.println("Error reading file '" + filePath + "'");
            ex.printStackTrace();
       }

       return board;
   }

   static void printBoard(int[][] board){
       System.out.println("##################################");

       for(int y = 0; y < board.length; y++){
           for(int x = 0; x < board[y].length; x++){
               if(board[y][x]==0){
                   System.out.print(" ");
               }else {
                   System.out.print(board[y][x]);
               }

               if((x+1) < board[y].length && (x+1)%3 == 0){
                   System.out.print(" # ");
               }else if((x+1) < board[y].length){
                   System.out.print(" | ");
               }
           }

           if((y+1) < board.length && (y+1)%3 == 0){
               System.out.println("\n##################################");
           }else if((y+1) < board.length){
               System.out.println("\n----------#-----------#-----------");
           }
       }
       System.out.println("\n##################################");
   }
}
