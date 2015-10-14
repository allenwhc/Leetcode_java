import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class ContainsDuplicate{
	public static boolean containsDuplicate1(int[] nums){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int num:nums){
			if(map.containsKey(num))
				return true;
			else 
				map.put(num,1);
		}
		return false;
	}

	public static boolean containsDuplicate2(int[] nums, int k){
		HashMap<Integer, List<Integer>> map=new HashMap<Integer,List<Integer>>();
		for(int i=0; i<nums.length; i++){
			if(!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));
			else
				map.get(nums[i]).add(i);
		}
		for(Integer key:map.keySet()){
			if(map.get(key).size()<2) continue;
			for(int i=1; i<map.get(key).size(); i++){
				if(map.get(key).get(i)-map.get(key).get(i-1)<=k) return true;
			}
		}
		return false;
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int t, int k){
		int n=nums.length;
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0; i<n; i++){
			Integer floor=((long)nums[i]-(long)t<Integer.MIN_VALUE)?Integer.MIN_VALUE:nums[i]-t;
			Integer ceiling=((long)nums[i]+(long)t+1>Integer.MAX_VALUE)?Integer.MAX_VALUE:nums[i]+t+1;
			if(t>=0 && !set.subSet(floor, ceiling).isEmpty()) return true;
			set.add(nums[i]);
			if(i>=k) set.remove(nums[i-k]);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Contains Duplicate I (determine if array contains duplicate elements):");
		int[] nums1={1,2,3,3,2,5,-1};
		System.out.println("The array is: "+Arrays.toString(nums1));
		if(containsDuplicate1(nums1))
			System.out.println("The array has duplicate elements.");
		else
			System.out.println("The array doesn't contain duplicate elements");	
		System.out.println();
		System.out.println("Contains Duplicate II (check if array has duplicate elements within given range): ");
		int[] nums2={1,2,3,4,2,6};
		int k=2;
		System.out.println("The array is: "+Arrays.toString(nums2));
		if(containsDuplicate2(nums2,k))
			System.out.println("The array has duplicate elements whose index differential is less than "+k);
		else
			System.out.println("The array doesn't contain duplicate elements whose index differential is less than "+k);
		System.out.println();
		System.out.println("Contains Duplicate III: ");
		int[] nums3={-1, 2147483647};
		int t=2147483467;
		int k1=1;
		System.out.println("The array is: "+Arrays.toString(nums3));
		if(containsNearbyAlmostDuplicate(nums3,t,k1))
			System.out.println("The array has elements whose value differential is at most "+t+", and index differential is no more than "+k1);
		else
			System.out.println("The array doesn't contain elements whose value differential is at most "+t+", and index differential is no more than "+k1);
	}
}