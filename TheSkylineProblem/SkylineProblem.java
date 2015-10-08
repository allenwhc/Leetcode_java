import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SkylineProblem{
	public static List<int[]> getSkyline(int[][] buildings){
		List<int[]> skyline=new ArrayList<int[]>();
		if(buildings.length==0 || buildings[0].length==0) return skyline;
		skyline=divide(buildings,0,buildings.length-1);
		return skyline;
	} 

	private static List<int[]> divide(int[][] buildings, int start, int end){
		if(start==end){
			List<int[]> result=new ArrayList<int[]>();
			int[] arr=new int[2];
			arr={buildings[start][0],buildings[start][2]};
			result.add(arr);
			arr={buildings[start][1],0};
			result.add(arr);
			return result;
		}
		int middle=(end-start)/2+start;
		List<int[]> l1=divide(buildings,start,middle);
		List<int[]> l2=divide(buildings,middle+1,end);
		return merge(l1,l2);
	}

	private static List<int[]> merge(List<int[]> l1, List<int[]> l2){

	}

	public static void main(String[] args) {
		int[][] buildings={{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8};
		for(int[] b:buildings)
			System.out.println("The buildings' configurations are: "+Arrays.toString(b));
		System.out.println("The skyline of buildings is: "+Arrays.deepToString(getSkyline(buildings).toArray()));
	}
}