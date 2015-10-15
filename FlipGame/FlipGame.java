import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class FlipGame{
	public static List<String> generatePossibleNextMoves(String s){
		List<String> allPossibleMoves=new ArrayList<String>();
		int n=s.length();
		if(n==0) return allPossibleMoves;
		StringBuilder str=new StringBuilder();
		str.setLength(n);
		for(int i=0; i<n; i++) 
			str.setCharAt(i,s.charAt(i));
		getAllMoves(allPossibleMoves,s,str,0);
		return allPossibleMoves;
	}

	private static void getAllMoves(List<String> allPossibleMoves, String s, StringBuilder str, int idx){
		if(idx==s.length()){
			return;
		}
		// System.out.println("idx="+idx+": "+s.charAt(idx));
		// System.out.println(str);
		if(s.charAt(idx)=='-'){
			str.setCharAt(idx,'-');
		}
		else if(idx<s.length()-1 && s.charAt(idx)=='+' && s.charAt(idx+1)=='+'){
			str.setCharAt(idx,'-');
			str.setCharAt(idx+1,'-');
			allPossibleMoves.add(str.toString());
			str=new StringBuilder(s);
		}
		getAllMoves(allPossibleMoves,s,str,idx+1);
	}

	public static void main(String[] args) {
		String s="++++";
		System.out.println("Possible next moves of '"+s+"' are: "+Arrays.deepToString(generatePossibleNextMoves(s).toArray()));
	}
}