package SCJPTest.Examples;
import java.io.IOException;
import java.sql.SQLException;

public class Propagate {
	public void rethrowException(String exceptionName)
			throws IOException, SQLException {
			    try {
			    	if(exceptionName == "io") throw new IOException();
			    	else
			    	throw new SQLException();
			    	
			        //foo.delete();
			    } catch (IOException|SQLException e) {
			        throw e;
			    }
			}
	public static void main(String a[])
	{
		try{
			String concat = "";
			if( a.length > 0){
				
				for(String s:a)
					concat = concat + s + " " ;
			}
			String S = "big Surprise";
			System.out.println(S.toString());
			System.out.println(S);
			
			
			//System.out.println("Input: " + concat);
			//System.out.println("Output: " + reverse(concat.trim()));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static String reverse(String arg) throws Exception
	{
		if(arg.length()<=0){
			throw new Exception("Empty String");
		}
		String rev = "";
		for(int i=arg.length()-1; i >= 0 ; --i){
			rev += arg.charAt(i);
			//System.out.println(rev);
		}
		return rev;
	}
}
