import java.util.HashMap;

public class LongestSubstringWithoutRepeat{
	public static int lengthOfLongestSubstring(String s) {
		int len=s.length();
		if(len==0) return 0;
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		int maxLen=0;
		int i=0, j=0;
		while(i<len){
			char ci=s.charAt(i);
			if(!map.containsKey(ci)){
				map.put(ci,1);
				i++;
			}
			else{
				maxLen=Math.max(maxLen, i-j);
				while(ci!=s.charAt(j)){
					map.remove(s.charAt(j));
					j++;
				}
				i++;
				j++;
			}
		}
		maxLen=Math.max(maxLen,len-j);
        return maxLen;
    }

    public static void main(String[] args) {
    	String[] s={"abcabcdb","bbbb"};
    	for(String ss:s){
    		System.out.println("The length of longest non-repeating substring in '"+ss+"' is: "+lengthOfLongestSubstring(ss));
    	}
    }
}