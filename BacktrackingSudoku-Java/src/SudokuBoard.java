class SudokuBoard {

   /**
    * Data for the sudoku board itself
    */
   private int[][] board;

    /**
     * Sudoku Board that contains a sudoku puzzle to solve.
     *
     * @param board data for the sudoku board.
     */
   SudokuBoard(int[][] board){
      this.board = board;
   }

    /**
     * This function uses backtracking to solve the puzzle if it is solvable.
     *
     * @return True if puzzle was solved. Otherwise returns False
     */
   boolean SolvePuzzle(){

       //get next unassigned coordinates
       int[] unassignedCords = getUnassignedLocation();

       //if no unassigned coordinates then puzzle is solved
       if(unassignedCords[0]==-1&&unassignedCords[1]==-1){
           return true;//puzzle solved
       }

       //loop through every candidate for this position
       for(int number = 0; number <= 9; number++ ){
           //check if the number makes the puzzle invalid and continue if it doesn't
           if(isLocationValid(unassignedCords[0], unassignedCords[1], number)){

                //set the position as the valid candidate
                board[unassignedCords[1]][unassignedCords[0]] = number;

                //recursively try and solve the puzzle, if solved return true
                if(SolvePuzzle()){
                    return true;
                }

                //if puzzle was not solved this candidate does not work, reset the value at this position
                board[unassignedCords[1]][unassignedCords[0]] = 0;
           }
       }

      //if no combination of candidates worked then puzzle is unsolvable
      return false;
   }

    /**
     * Check if putting the number in the position denoted by x and y breaks
     * any of the sudoku rules. If it does then return False otherwise return
     * True.
     *
     * @param x X position on board
     * @param y Y position on board
     * @param number number to test validity of
     * @return True if no rules were broken, otherwise False
     */
    private boolean isLocationValid(int x, int y, int number) {
        //searches the column for occurrences of the given number
       for(int col = 0; col < board.length; col++){
           if(board[col][x]==number){
               return false;
           }
       }
       //searches the row for occurrences of the given number
       for(int row = 0; row < board[y].length; row++){
           if(board[y][row]==number){
               return false;
           }
       }

        //sets quadrant from x and y value
        int yQuad = y / 3;
        int xQuad = x / 3;

        //checks the quadrant for occurrences of the given number
        for(int yy = 0; yy < 3; yy++) {
            for (int xx = 0; xx < 3; xx++) {
                int xPos = (xQuad*3)+xx;
                int yPos = (yQuad*3)+yy;

                if(board[yPos][xPos]==number){
                    return false;
                }
            }
        }
        //if no other occurrences were found return true
        return true;
    }

    /**
     * gets the first unassigned location on the board. If no position is unassigned then it returns
     * -1,-1 to signal that the board is full.
     *
     * @return x and y coordinates of the first unassigned location. if all assigned returns -1, -1
     */
    private  int[] getUnassignedLocation(){
       for(int y = 0; y < board.length; y++) {
           for (int x = 0; x < board[y].length; x++) {
                if(board[y][x]==0){
                    int[] array = {x, y};
                    return array;
                }
           }
       }

       int[] array = {-1, -1};
       return array;
   }

    /**
     * Getter for board data
     *
     * @return Data array for board
     */
    int[][] getBoard() {
        return board;
    }

    /**
     * Default function for checking if the board data breaks any sudoku rules.
     * Starts it's search at coordinates 0, 0
     *
     * @return True if entire board doesn't violate any sudoku rules, False otherwise
     */
    boolean isBoardvalid(){
        return isBoardValid(0,0);
    }

    /**
     * Checks if the position at X and Y breaks any sudoku rules and if not
     * continues checking for rule violations at the next position.
     *
     * @param x X of coordinate to check
     * @param y Y of coordinate to check
     * @return True if from the coordinate on is valid, False otherwise
     */
    boolean isBoardValid(int x, int y){
        //buffer for checking duplicates
        Vector<Integer> buffer = new Vector<>();

        //check column for duplicates
        for(int col = 0; col < board.length; col++) {
            if(board[col][x]!=0){
                if (buffer.containsItem(board[col][x]) || board[col][x] > 9 || board[col][x] < 0) {
                    return false;
                } else {
                    buffer.add(board[col][x]);
                }
            }
        }

        buffer.clear();

        //check row for duplicates
        for(int row = 0; row < board[y].length; row++){
            if(board[y][row]!=0) {
                if (buffer.containsItem(board[y][row]) || board[y][row] > 9 || board[y][row] < 0) {
                    return false;
                } else {
                    buffer.add(board[y][row]);
                }
            }
        }

        buffer.clear();

        int yQuad = y / 3;
        int xQuad = x / 3;

        //check the quadrant for duplicates
        for(int yy = 0; yy < 3; yy++) {
            for (int xx = 0; xx < 3; xx++) {
                int xPos = (xQuad*3)+xx;
                int yPos = (yQuad*3)+yy;

                if(board[yPos][xPos]!=0) {
                    if (buffer.containsItem(board[yPos][xPos]) || board[yPos][xPos] > 9 || board[yPos][xPos] < 0) {
                        return false;
                    } else {
                        buffer.add(board[yPos][xPos]);
                    }
                }
            }
        }

        //next coordinate to check
        int nextX = x+1;
        int nextY = y;

        //if x is out of bounds then reset x and increment y
        if(nextX>=board[y].length){
            nextX = 0;
            nextY++;
        }
        //if y is out of bounds then done searching board, otherwise check next coordinate
        if(nextY >= board.length){
            return true;
        }else{
            return isBoardValid(nextX, nextY);
        }
    }
}