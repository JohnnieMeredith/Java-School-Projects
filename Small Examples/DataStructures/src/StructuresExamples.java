import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
/**
 * My first foray into data structures
 */
 
public class StructuresExamples {
	
	public StructuresExamples(String s){
		convertStructuresExamples(s);
	}
	public static String convertStructuresExamples(String s)  {
		String ch = s;
		ArrayList<Character> alist = new ArrayList<Character>();
		for(int x = 0; x < s.length(); x++) {
			alist.add((Character)String.valueOf(x).charAt(0));
			alist.add(ch.charAt(x));
			
		}
		String ary = alist.toString();
		return ary;
	}
public static void main(String[] args) {
	char[] f = convertStructuresExamples(args[0]).toCharArray();
	 
	ArrayList<Character> r =  new ArrayList<Character>();
	
	for(int x = 0; x < f.length; x++) {
		
		r.add(f[x]);
	}
	 
	System.out.println(r.toString().replaceAll(", ", ""));
}
}

