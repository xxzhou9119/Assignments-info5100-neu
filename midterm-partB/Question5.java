//extra credit 10
import java.util.ArrayList;

/*
	for input = { {1,1,0,1,0},
                      {1,1,1,1,1},
                      {1,0,0,1,0},
                      {1,1,0,1,1}};
	expected output = [[0, 0], [1, 0], [1, 1], [1, 2], [1, 3], [2, 3], [3, 3], [3, 4]]
	your output 	= [[0, 0], [1, 0], [1, 1], [1, 2], [1, 3], [2, 3], [3, 3]]
	however we asked for N*N, your code works fine for N*N

 */

public class Question5 {
	class Cell{
		int x,y;
		Cell(int x, int y){
		this.x = x;
		this.y = y;
	}
		public String toString(){
		return "["+this.x +", "+this.y+ "]";
   }
}
	 public static void main(String args[]) {
	        
	        int maze[][] = 
	           {{1, 0, 0, 0},
	            {1, 1, 1, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}
	        };
	        System.out.println(findPath(maze));
	    }
	
	
	public static ArrayList<Cell> findPath(int[][] maze){
          int[][] path=new int[maze.length][maze[0].length];
          ArrayList<Cell> result=new ArrayList<Cell>();
		  backTracking(maze,0,0,path);
		  for(int i=0;i<path.length;i++){
			  for(int j=0;j<path[0].length;j++){
				  if(path[i][j]==1){
					  Question5 q=new Question5();
					  Cell cell=q.new Cell(i,j);
					  result.add(cell);
				  }
			  }
		  }
		return result;
		}
		
		public static boolean backTracking(int[][] maze,int x,int y,int[][] path){
			int n=maze.length;
			if(x == n - 1 && y == n - 1) {
	           path[x][y] = 1;
	           return true;
			}
			if(isValid(maze,x,y)){
				path[x][y]=1;
				if(backTracking(maze,x+1,y,path)){
					return true;
				}
				if(backTracking(maze,x,y+1,path)){
					return true;
				}
				path[x][y]=0;
				return false;
			}
			return false;
		}
		
		public static boolean isValid(int maze[][], int x, int y){
		        if(x >= 0 && x < maze.length && y >= 0 &&
		                y < maze[0].length && maze[x][y] == 1){
		        	return true;
		        }
		        return false;
		    }

}
