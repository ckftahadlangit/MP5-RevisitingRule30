
import java.util.*;

class RuleThirty extends Thread{

	private int size;
	private int  grid[][];

	public RuleThirty(int x){
		if(x <= 0){
			throw new IllegalArgumentException("The size is invalid");
		}
		size = x;
		grid = new int[size][size];
	}
    
    //initialize 1st row and set everything to 0 except the middle
	public static int[][] initialize(int[][] grid,int array_size){
		int r = 0 , c = 0;
		    while(c < array_size){
    			grid[r][c] = 0;
                c++;
		  }
		  grid[0][array_size / 2] = 1; //sets the middle element to 1
	   return grid;
	}
    
    public void print() {
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    			System.out.print(grid[i][j] + " ");
    		}
    		System.out.print("\n");
    	}
    }

    //updates the values
	public static int[][] write(int[][] grid, int size){
		int row = 1 , column = 0; //starts with row 1
		while(row < size){
			while(column < size){
				grid[row][column] = val(grid,row,column,size); //sets val to the current cell
                column++;
			}
			column = 0;
			row++;
		}
		return grid;
	}
    
    //given conditions 
	public static int val(int[][]grid, int row,int col, int arr_size){
		int LEFT = (col == 0) ? 0 : grid[row - 1][col - 1], MIDDLE = grid[row - 1][col], RIGHT = (col == arr_size - 1) ? 0 : grid[row - 1][col + 1];

        if((LEFT == 1 && MIDDLE == 0 && RIGHT == 0) || (LEFT == 0 && MIDDLE == 1 && RIGHT == 1) || (LEFT == 0 && MIDDLE == 1 && RIGHT == 0) || (LEFT == 0 && MIDDLE == 0 && RIGHT == 1)){
            return 1;
        }
		return 0;
	}

}