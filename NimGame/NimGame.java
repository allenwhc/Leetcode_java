public class NimGame{
	public static boolean canWinNim(int n){
		return n%4!=0;
	}

	public static void main(String[] args) {
		int[] ns={4,5,10,17,25,109,315};
		for(int i=0; i<ns.length; i++){
			System.out.println("If "+ns[i]+" stones, ");
			if(canWinNim(ns[i]))
				System.out.println("you can win NimGame.");
			else
				System.out.println("you can't win NimGame.");
		}
	}
}