import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;


public class LongestPrefix {
	
	public static ArrayList<String> toList(String str){
		return new ArrayList<String>(Arrays.asList(str.split("")));
	}
	
	public static void longestCommonPrefix(String a, String b){
		List<String> a1 = toList(a);
		List<String> b1 = toList(b);
		Iterator<String> aItr = a1.iterator();
		Iterator<String> bItr = b1.iterator();
		
		while(aItr.hasNext() && bItr.hasNext()){
			String char1 = aItr.next();
			String char2 = bItr.next();
			if(char1.equals(char2)){
				System.out.print(char1);
			}
			else{
				break;
			}
		}
	}
	public static void main(String[] args){
		String str1 = "abcdefghi";
		String str2 = "abcdeifghi";
		longestCommonPrefix(str1, str2);
	}

}
