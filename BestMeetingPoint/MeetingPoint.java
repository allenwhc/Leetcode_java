import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MeetingPoint{
	public static int minTotalDistance(int[][] grid){
		int m=grid.length;
		int n=grid[0].length;
		List<int[]> homes=new ArrayList<int[]>();
		for(int i=0; i<m; i++)
			for(int j=0; j<n ;j++)
				if(grid[i][j]==1){
					int[] home={i,j};
					homes.add(home);
				}

		int minDistance=Integer.MAX_VALUE;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int totalDistance=0;
				for(int[] h:homes){
					totalDistance+=Math.abs(h[0]-i)+Math.abs(h[1]-j);
				}
				minDistance=Math.min(minDistance,totalDistance);
			}
		}
		return minDistance;
	}

	public static void main(String[] args) {
		//int[][] grid={{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		int[][] grid={{1,0,1,0,1}};
		System.out.println("The grid is: ");
		for(int[] g:grid)
			System.out.println(Arrays.toString(g));
		System.out.println("The total distance to ideal meeting point is: "+minTotalDistance(grid));
	}
}