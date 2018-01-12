public class Solver{

    private int[][] board;

   public Solver(int[][] board){
      this.board = board;
   }

   public boolean SolvePuzzle(){

       int[] unassignedCords = getUnassignedLocation();

       if(unassignedCords[0]==-1&&unassignedCords[1]==-1){
           return true;//puzzle solved
       }

       for(int number = 0; number <= 9; number++ ){
           if(isValid(unassignedCords[0], unassignedCords[1], number)){
                board[unassignedCords[1]][unassignedCords[0]] = number;

                if(SolvePuzzle()){
                    return true;
                }

               board[unassignedCords[1]][unassignedCords[0]] = 0;
           }
       }

      return false;
   }

    private boolean isValid(int x, int y, int number) {
       for(int col = 0; col < board.length; col++){
           if(board[col][x]==number){
               return false;
           }
       }
       for(int row = 0; row < board[y].length; row++){
           if(board[y][row]==number){
               return false;
           }
       }

        int yQuad = y / 3;
        int xQuad = x / 3;

        for(int yy = 0; yy < 3; yy++) {
            for (int xx = 0; xx < 3; xx++) {
                int xPos = (xQuad*3)+xx;
                int yPos = (yQuad*3)+yy;

                if(board[yPos][xPos]==number){
                    return false;
                }
            }
        }
        return true;
    }

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

    public int[][] getBoard() {
        return board;
    }
}