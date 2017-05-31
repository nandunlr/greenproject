package challenge2;

public class PolindromFinder {

	static public boolean isPonlindrom(String input){
		if(input != null && input.equals(ReverseOfString.reverse(input))){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		String input = "aba";
		System.out.println(" Given input is polidrom :"+isPonlindrom(input));
		
	}
	
}
