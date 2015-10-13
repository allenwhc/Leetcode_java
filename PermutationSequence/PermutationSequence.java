import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class PermutationSequence{
	public static String getPermutation(int n, int k){
		if(n==0) return "";
		int[] fac=new int[n];
		for(int i=0; i<n; i++)
			fac[i]=1;
		List<Integer> numList=new ArrayList<Integer>();
		for(int i=1; i<n; i++)
			fac[i]=fac[i-1]*i;
		for(int i=0; i<n; i++)
			numList.add(i+1);
		k--;
		String str="";
		for(int i=n; i>0; i--){
			int j=k/fac[i-1];
			k%=fac[i-1];
			str+=numList.get(j);
			numList.remove(j);
		}
		return str;
	}

	public static void main(String[] args) {
		int n=3;
		int k=3;
		System.out.println("The "+k+"th permutation sequence is: "+getPermutation(n,k));
	}
}