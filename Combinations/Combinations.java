import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Combinations{
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> allCombinations=new ArrayList<List<Integer>>();
		if(n<k || n==0) return allCombinations;
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
			arr[i]=i+1;
		List<Integer> combination=new ArrayList<Integer>();
		dfs(allCombinations,combination,arr,k,0);
		return allCombinations;
	}

	private static void dfs(List<List<Integer>> allCombinations, List<Integer> combination, int[] arr, int k, int step){
		if(combination.size()==k){
			allCombinations.add(new ArrayList<Integer>(combination));
			return;
		}
		for(int i=step; i<arr.length; i++){
			combination.add(arr[i]);
			dfs(allCombinations,combination,arr,k,i+1);
			combination.remove(combination.size()-1);
		}
	}

	public static void main(String[] args) {
		int n=4;
		int k=2;
		System.out.println("C("+n+","+k+") are: ");
		for(List<Integer> list:combine(n,k))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}