import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence{
	public static int longestConsecutive(int[] nums){
		int n=nums.length;
		if(n==0) return 0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i:nums)
			map.put(i,1);
		int maxLen=1;
		for(int i=0; i<n; i++){
			int count=1;
			int currNum=nums[i];
			if(!map.containsKey(currNum)) continue;
			currNum++;
			while(map.containsKey(currNum)){
				count++;
				map.remove(currNum);
				currNum++;
			}
			currNum=nums[i];
			currNum--;
			while(map.containsKey(currNum)){
				count++;
				map.remove(currNum);
				currNum--;
			}
			maxLen=Math.max(maxLen,count);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums={100,4,200,99,1,97,98,3,2,101};
		System.out.println("The unsorted array is: "+Arrays.toString(nums));
		System.out.println("The length of longest consecutive sequence is: "+longestConsecutive(nums));
	}
}