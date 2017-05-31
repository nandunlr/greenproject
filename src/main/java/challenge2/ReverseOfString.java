package challenge2;

import org.apache.log4j.Logger;
/**
 * 
 * @author Narendra
 *
 */
public class ReverseOfString {

	private static Logger logger = Logger.getLogger(ReverseOfString.class);

	public static String reverse(String orig)
	{
	    char[] s = orig.toCharArray();
	    int n = s.length;
	    int halfLength = n / 2;
	    for (int i=0; i<halfLength; i++)
	    {
	        char temp = s[i];
	        s[i] = s[n-1-i];
	        s[n-1-i] = temp;
	    }
	    return new String(s);
	}
	
	public static void main(String a[])
	{
		logger.info(reverse("LeeMo32re"));
	}
}
