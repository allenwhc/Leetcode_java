import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TwoSum{
	public static int[] twoSum(int[] nums, int target){
		int n=nums.length;
		int[] idx=new int[2];
		if(n<2) return idx;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0; i<n; i++)
			map.put(nums[i],i);

		for(int i=0; i<n; i++){
			int diff=target-nums[i];
			if(map.containsKey(diff)){
				if(i>map.get(diff)){
					idx[0]=map.get(diff)+1;
					idx[1]=i+1;
				}
				else if(i<map.get(diff)){
					idx[0]=i+1;
					idx[1]=map.get(diff)+1;
				}
			}	
		}
		// for(Integer key:map.keySet())
		// 	System.out.println(key+":"+Arrays.deepToString(map.get(key).toArray()));
		return idx;
	}

	public static void main(String[] args) {
		//int[] nums={230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
		//int target=542;
		int[] nums={0,4,3,0};
		int target=0;
		System.out.println("The array is: "+Arrays.toString(nums));
		System.out.println("The indices that sum up to "+target+" are: "+Arrays.toString(twoSum(nums,target)));
	}
}