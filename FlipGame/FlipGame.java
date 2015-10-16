import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class FlipGame{
	public static List<String> generatePossibleNextMoves(String s){
		List<String> allPossibleMoves=new ArrayList<String>();
		int n=s.length();
		if(n==0) return allPossibleMoves;
		StringBuilder str=new StringBuilder(s);
		getAllMoves(allPossibleMoves,s,str,0);
		return allPossibleMoves;
	}

	private static void getAllMoves(List<String> allPossibleMoves, String s, StringBuilder str, int idx){
		if(idx==s.length()){
			return;
		}
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

	private static StringBuilder ss;
	private static int len;
	public static boolean canWin(String s){
		len=s.length();
		ss=new StringBuilder(s);
		return canWin();
	}

	private static boolean canWin(){
		for(int i=0; i<=len-2; i++){
			if(ss.charAt(i)=='+' && ss.charAt(i+1)=='+'){
				ss.setCharAt(i,'-');
				ss.setCharAt(i+1,'-');
				boolean win=!canWin();
				ss.setCharAt(i,'+');
				ss.setCharAt(i+1,'+');
				if(win) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s="++++";
		System.out.println("The input string is: "+s);
		System.out.println("Possible next moves of are: "+Arrays.deepToString(generatePossibleNextMoves(s).toArray()));
		if(canWin(s))
			System.out.println("The starting player can always guarantee a win.");
		else
			System.out.println("The starting player can't always guarantee a win.");
	}
}