import java.util.HashMap;
import java.util.Map;

public class WordPattern2{
	public static boolean wordPatternMatch(String pattern, String str){
		if(pattern.length()==0) return str.length()==0;
		return dfs(str.toCharArray(), 0, pattern.toCharArray(), 0, "", new HashMap<>());
	}

	private static boolean dfs(char[] str, int strIdx, char[] pattern, int patternIdx, String currStr, Map map){
		if(strIdx>=str.length) return patternIdx==pattern.length;	//If str index reaches the end, check if pattern index does the same.
		if(patternIdx==pattern.length) return strIdx>=str.length;	//If pattern index reaches the end, check if str index does the same.

		String s=currStr+str[strIdx];
		Object prevPattern=map.put(pattern[patternIdx],patternIdx);
		Object preStr=map.put(s,patternIdx);

		if(Objects.equals(prevPattern,preStr)){
			boolean isMatched=dfs(str,strIdx+1,pattern,patternIdx+1,"",map);
			if(isMatched) return isMatched;
		}
		map.put(pattern[patternIdx],prevPattern);
		map.put(s,preStr);
		return dfs(str,strIdx+1,pattern,patternIdx,currStr+str[strIdx],map);
	}

	public static void main(String[] args) {
		String[] patterns={"abab","aaaa","aabb"};
		String[] strs={"redblueredblue","asdasdasdasd","xyzabcxyzabc"};
		for(int i=0; i<patterns.length; i++){
			if(wordPatternMatch(patterns[i],strs[i]))
				System.out.println("'"+strs[i]+"' follows pattern '"+patterns[i]+"'.");
			else
				System.out.println("'"+strs[i]+"' doesn't follow pattern '"+patterns[i]+"'.");
		}
 	}
}