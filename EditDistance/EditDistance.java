
public class EditDistance{
	public static int minDistance(String word1, String word2){
		int len1=word1.length();
		int len2=word2.length();

		int[][] dp=new int[len1+1][len2+1];

		for(int i=0; i<=len1; i++)
			dp[i][0]=i;
		for(int j=0; j<=len2; j++)
			dp[0][j]=j;


		for(int i=0; i<len1; i++){
			for(int j=0; j<len2; j++){
				char c1=word1.charAt(i);
				char c2=word2.charAt(j);
				if(c1==c2)
					dp[i+1][j+1]=dp[i][j];
				else{
					int insertion=dp[i][j+1]+1;
					int deletion=dp[i+1][j]+1;
					int replacement=dp[i][j]+1;
					dp[i+1][j+1]=Math.min(replacement,Math.min(insertion,deletion));
				}
			}
		}
		return dp[len1][len2];
	}

	public static void main(String[] args) {
		String word1="";
		String word2="a";

		System.out.println("The distance between '"+word1+"' and '"+word2+"' is: "+minDistance(word1,word2));
	}
}