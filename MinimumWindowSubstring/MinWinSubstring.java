import java.util.HashMap;
import java.lang.StringBuilder;

public class MinWinSubstring{
	public static String minWindow(String s, String t){
		int m=s.length();
		int n=t.length();
		System.out.println(t.hashCode());
		if(m<n || m==0 || n==0) return "";
		HashMap<Character,Integer> mapS=new HashMap<Character,Integer>();
		HashMap<Character,Integer> mapT=new HashMap<Character,Integer>();
		for(int i=0; i<n; i++){
			if(!mapT.containsKey(t.charAt(i)))
				mapT.put(t.charAt(i),1);
			else 
				mapT.put(t.charAt(i),mapT.get(t.charAt(i))+1);
		}

		String str="";
		int left=0, minLen=m+1, count=0;
		for(int i=0; i<m; i++){
			char c=s.charAt(i);
			if(mapT.containsKey(c)){
				if(mapS.containsKey(c)){
					if(mapS.get(c)<mapT.get(c)){
						count++;
					}
					mapS.put(c,mapS.get(c)+1);
				}
				else{
					mapS.put(c,1);
					count++;
				}
			}

			if(count==n){
				char cc=s.charAt(left);
				while(!mapT.containsKey(cc) || mapS.get(cc)>mapT.get(cc)){
					if(mapS.containsKey(cc) && mapS.get(cc)>mapT.get(cc))
						mapS.put(cc,mapS.get(cc)-1);
					cc=s.charAt(++left);
				}
				if(i-left+1<minLen){
					minLen=i-left+1;
					str=s.substring(left,i+1);
				}
			} 
		}
		return str;
	}

	public static void main(String[] args) {
		String s="abc";
		String t="cba";
		System.out.println("The shortest substring containing '"+t+"' in '"+s+"' is: '"+minWindow(s,t)+"'.");
	}
}