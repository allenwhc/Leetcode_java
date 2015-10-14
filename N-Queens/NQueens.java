import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueens{
	//N-queens I
	public static List<List<String>> solveNQueens(int n){
		List<List<String>> allSols=new ArrayList<List<String>>();
		if(n==0 || n==2 || n==3) return allSols;
		int[] position=new int[n];
		for(int i=0; i<n; i++) 
			position[i]=-1;
		solve(allSols,position,n,0);
		return allSols;
	}
	
	private static void solve(List<List<String>> allSols, int[] position, int n, int row){
		if(row==n){
			//System.out.println(Arrays.toString(position));
			List<String> sol=new ArrayList<String>();
			for(int i=0; i<n; i++){
				char[] addQueen=new char[n];
				for(int j=0; j<n; j++)
					addQueen[j]='.';
				addQueen[position[i]]='Q';
				String line=new String(addQueen);
				sol.add(line);
			}
			allSols.add(sol);
			return;
		}
		for(int col=0; col<n; col++){
			if(isValidPosition(row,col,position)){
				position[row]=col;
				solve(allSols,position,n,row+1);
				position[row]=-1;
			}
		}
	}

	private static boolean isValidPosition(int row, int col, int[] position){
		for(int i=0; i<row; i++){
			if(col==position[i] || Math.abs(row-i)==Math.abs(col-position[i])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n=4;
		System.out.println("The "+n+"-queen solutions are: ");
		for(int i=0; i<solveNQueens(n).size(); i++){
			for(int j=0; j<solveNQueens(n).get(i).size(); j++)
				System.out.println(solveNQueens(n).get(i).get(j));
		}
	}
}