import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FactorCombinations{
	public static List<List<Integer>> getFactors(int n){
		List<List<Integer>> allSols=new ArrayList<List<Integer>>();
		List<Integer> sol=new ArrayList<Integer>();
		compute(allSols,sol,n,2);
		return allSols;
	}

	private static void compute(List<List<Integer>> allSols, List<Integer> sol, int n, int start){
		if(n<=1){
			if(sol.size()>1)
				allSols.add(new ArrayList(sol));
			return;
		}

		for(int i=start; i<=n; i++){
			if(n%i==0){
				sol.add(i);
				compute(allSols,sol,n/i,i);
				sol.remove(sol.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums={32,15,105,28,37};
		for(int n:nums){
			System.out.println("All factors of "+n+" are:");
			for(List<Integer> l:getFactors(n))
				System.out.println(Arrays.deepToString(l.toArray()));
			System.out.println();
		}
	}
}