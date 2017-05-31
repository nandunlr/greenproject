package challenge2;

import org.apache.log4j.Logger;

/**
 * 
 * @author Narendra
 *
 */
public class PolindromFinder {

	private static Logger logger = Logger.getLogger(PolindromFinder.class);
	static public boolean isPonlindrom(String input){
		if(input != null && input.equals(ReverseOfString.reverse(input))){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		String input = "aba";
		logger.info(" Given input is polidrom :"+isPonlindrom(input));
		
	}
	
}
