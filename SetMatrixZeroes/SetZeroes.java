import java.util.Arrays;

public class SetZeroes{
	public static void setZeroes(int[][] matrix){
		int m=matrix.length;
		if(m==0) return;
		int n=matrix[0].length;
		if(n==0) return;

		boolean firstRowZero=false;
		boolean firstColumnZero=false;
		for(int i=0; i<m; i++){
			if(matrix[i][0]==0){
				firstColumnZero=true;
				break;
			}
		}

		for(int j=0; j<n; j++){
			if(matrix[0][j]==0){
				firstRowZero=true;
				break;
			}
		}

		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}

		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j]=0;
			}
		}

		if(firstColumnZero){
			for(int i=0; i<m; i++)
				matrix[i][0]=0;
		}
		if(firstRowZero){
			for(int j=0; j<n; j++)
				matrix[0][j]=0;
		}
	}

	public static void main(String[] args) {
		int[][] matrix={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		System.out.println("The original matrix is: ");
		for(int[] m:matrix)
			System.out.println(Arrays.toString(m));
		setZeroes(matrix);
		System.out.println("The zero-set matrix is: ");
		for(int[] m:matrix)
			System.out.println(Arrays.toString(m));
	}
}