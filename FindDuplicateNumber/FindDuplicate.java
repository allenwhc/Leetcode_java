import java.util.Arrays;

public class FindDuplicate{
	public static int findDuplicate(int[] nums){
		int n=nums.length;
		if(n==0) return 0;
		for(int i=0; i<n; i++){
			if(nums[Math.abs(nums[i])]>0){
				nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
			}
			else 
				return Math.abs(nums[i]);
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums={1,2,1,3,4,5};
		System.out.println("The arrays is: "+Arrays.toString(nums));
		System.out.println("The duplicate number is: "+findDuplicate(nums));
	}
}