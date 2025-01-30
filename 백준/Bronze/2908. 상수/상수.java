import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();
		
		String str3 = "";
		String str4 = "";
		
		for(int i = str1.length()-1; i >= 0; i--) {
			str3 += str1.charAt(i);
		}
		
		for(int i = str2.length()-1; i >= 0; i--) {
			str4 += str2.charAt(i);
		}
		
		
		if(Integer.parseInt(str3) >= Integer.parseInt(str4)) {
			System.out.println(Integer.parseInt(str3));
		}
		else {
			System.out.println(Integer.parseInt(str4));
		}
	}
}