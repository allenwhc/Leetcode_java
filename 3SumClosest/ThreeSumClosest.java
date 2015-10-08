import java.util.Arrays;

public class ThreeSumClosest{
	public static int threeSumClosest(int[] nums, int target){
		Arrays.sort(nums);
		int n=nums.length;
		if(n==0) return 0;
		int closestSum=Integer.MAX_VALUE;
		int n1=0,n2=0,n3=0;
		for(int i=0; i<n-2; i++){
			int j=i+1;
			int k=n-1;
			while(j<k){
				int sum=nums[i]+nums[j]+nums[k];
				if(Math.abs(sum-target)<closestSum){
					closestSum=Math.abs(sum-target);
					n1=i;n2=j;n3=k;
				};
				if(sum<target) j++;
				else if(sum>target) k--;
				else return target;
			}
		}
		return nums[n1]+nums[n2]+nums[n3];
	}

	public static void main(String[] args) {
		int[] nums={1,1,1,0};
		int target=-100;
		System.out.println("The input array is: "+Arrays.toString(nums));
		System.out.println("The closest three-sum to "+target+" is: "+threeSumClosest(nums,target));
	}
}