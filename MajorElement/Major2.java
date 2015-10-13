import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Major2{
	public static List<Integer> majorElement(int[] nums){
		List<Integer> result=new ArrayList<Integer>();
		int n=nums.length;
		if(n==0) return result;
		else if(n==1){
			result.add(nums[0]);
			return result;
		}
		int num1=nums[0],c1=1, num2=0, c2=0;
		for(int i=1; i<n; i++){
			int curr=nums[i];
			if(curr==num1)
				c1++;
			else if(curr==num2)
				c2++;
			else if(c1==0){
				c2=1;
				num1=curr;
			}
			else if(c2==0){
				c2=1;
				num2=curr;
			}
			else{
				c1--;c2--;
			}
			//System.out.println(num1+":"+c1+", "+num2+":"+c2);
		}
		c1=0;c2=0;
		for(int i:nums){
			if(i==num1) c1++;
			if(i==num2) c2++;
		}
		if(c1>n/3) result.add(num1);
		if(c2>n/3) result.add(num2);
		return result;
	}

	public static void main(String[] args) {
		int[] nums={1};
		System.out.println("The major elements in "+Arrays.toString(nums)+" are: "+Arrays.deepToString(majorElement(nums).toArray()));
	}
}