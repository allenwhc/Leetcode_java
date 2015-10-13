import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class SlidingMaximum{
	public static int[] maxSlidingWindow(int[] nums, int k){
		Deque<Integer> queue=new LinkedList<Integer>();
		int n=nums.length;
		List<Integer> list=new ArrayList<Integer>();
		if(n<k || n==0) return new int[0];
		for(int i=0; i<k; i++){
			while(queue.size()>0 && nums[i]>=nums[queue.getLast()])
				queue.pollLast();
			queue.addLast(i);
		}
		for(int i=k; i<n; i++){
			list.add(nums[queue.getFirst()]);
			while(queue.size()>0 && i>=k+queue.getFirst())
				queue.pollFirst();
			while(queue.size()>0 && nums[i]>nums[queue.getLast()])
				queue.pollLast();
			queue.addLast(i);
		}
		list.add(nums[queue.getFirst()]);
		int[] result=new int[list.size()];
		for(int i=0; i<list.size(); i++)
			result[i]=list.get(i);
		return result;
	} 

	public static void main(String[] args) {
		//int[] nums={1,3,-1,-3,5,3,6,7};
		int[] nums={1};
		int k=1;
		System.out.println("The number array is: "+Arrays.toString(nums));
		System.out.println("The sliding maximum with window size "+k+" is: "+Arrays.toString(maxSlidingWindow(nums,k)));
	}
}