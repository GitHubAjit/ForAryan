package com.aryan.knighttour;

public class KnightTour {
    static int CHECKS = 8;

  
   
    static boolean isPositionOk(int x, int y, int checkBoardArr[][])
    {
        return (x >= 0 && x < CHECKS && y >= 0 && y < CHECKS
                && checkBoardArr[x][y] == 0);
    }
  
    
    static void printChessBoard(int checkBoardArr[][])
    {
    	System.out.println("---------------------------------------------------------------------------------");
    	System.out.println(" ");
        for (int x = 0; x < CHECKS; x++) {
            for (int y = 0; y < CHECKS; y++)
            	if (checkBoardArr[x][y] != -1 && checkBoardArr[x][y] < 10)
            		System.out.print("|     " + checkBoardArr[x][y] + "   ");
            	else if (checkBoardArr[x][y] != -1 && checkBoardArr[x][y] < 10)
            		System.out.print("|     " + checkBoardArr[x][y] + "   ");
            	else
            		System.out.print("|    " + checkBoardArr[x][y] + "   ");
            System.out.println("|");
        }
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------");
    }
  
    
    static boolean run()
    {
        int checkBoardArr[][] = new int[8][8];
  
        for (int x = 0; x <CHECKS; x++)
            for (int y = 0; y < CHECKS; y++)
                checkBoardArr[x][y] = 0;
  
        
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
  
        // Start with value 1 in 0,0
        checkBoardArr[0][0] = 1;
  

        if (!recursiveKT(0, 0, 2, checkBoardArr, xMove, yMove)) {
            System.out.println("error");
            return false;
        }
        else {
        	printChessBoard(checkBoardArr);
        } 	
  
        return true;
    }
  
  
    static boolean recursiveKT(int x, int y, int movei,
                               int checkBoardArr[][], int xMove[],
                               int yMove[])
    {
        int k, next_x, next_y;
        if (movei == (CHECKS * CHECKS)+1)
            return true;
  
        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            boolean isDroppingSafe=isPositionOk(next_x, next_y, checkBoardArr);
            if (isDroppingSafe) {
                checkBoardArr[next_x][next_y] = movei;
                if (recursiveKT(next_x, next_y, movei + 1, checkBoardArr, xMove, yMove))
                    return true;
                else
                    checkBoardArr[next_x][next_y]
                        = 0; 
            }
        }
  
        return false;
    }
  
    public static void main(String args[])
    {
        run();
    }
}