import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations{
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> allPermutations=new ArrayList<List<Integer>>();
		List<Integer> permutation=new ArrayList<Integer>();
		boolean[] visited=new boolean[nums.length];
		getPermutation(nums,visited,0,permutation,allPermutations);
		return allPermutations;
	}

	private static void getPermutation(int[] nums, boolean[] visited, int step, List<Integer> permutation, List<List<Integer>> allPermutations){
		if(step==nums.length){
			allPermutations.add(new ArrayList<Integer>(permutation));
			return;
		}
		for(int i=0; i<nums.length; i++){
			if(!visited[i]){
				if(i>0 && nums[i]==nums[i-1] && visited[i-1]) continue;
				visited[i]=true;
				permutation.add(nums[i]);
				getPermutation(nums,visited,step+1,permutation,allPermutations);
				permutation.remove(permutation.size()-1);
				visited[i]=false;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums={1,1,2};
		System.out.println("All permutations of "+Arrays.toString(nums)+" are: ");
		for(List<Integer> list:permute(nums))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}