public class PerfectSquare{
	public static int numSquares(int n){
		if(n<=0) return 0;
		int[] count=new int[n+1];
		for(int i=0; i<=n; i++)
			count[i]=i;
		int base=(int)Math.sqrt(n);

		for(int i=2; i<=base; i++){
			for(int j=0; j<=n; j++){
				int square=i*i;
				if(j>=square){
					count[j]=Math.min(count[j],count[j-square]+1);
				}
			}
		}
		return count[n];
	}


	public static void main(String[] args) {
		int[] nums={12,13,15,17,19};
		for(int i=0;i<nums.length; i++){
			System.out.println("The least number of perfect square numbers of "+nums[i]+" is: "+numSquares(nums[i]));
		}
	}
}