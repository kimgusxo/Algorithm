import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {	
	public static int[] setArray(int[] notationBox) {
		if(notationBox.length <= 10) {
			for(int i = 0; i < notationBox.length; i++) {
				notationBox[i] = i;
			}
		}
		else {
			for(int i = 0; i < 10; i++) {
				notationBox[i] = i;
			}
		
			for(int j = 10; j < notationBox.length; j++) {
				notationBox[j] = j;
			}
		}
		
		return notationBox;
	}
	
	public static int change(int[] notationBox, String num) {
		int result = 0;
		
		for(int i = 0; i < num.length(); i++) {
			for(int j = 0; j < notationBox.length; j++) {
				if(notationBox[j] == Character.getNumericValue(num.charAt(num.length()-i-1))) {
					result += (j*Math.pow(notationBox.length, i));
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		String num = st.nextToken();
		int notation = Integer.parseInt(st.nextToken());
		
		int[] notationBox = new int[notation];
		
		setArray(notationBox);
		System.out.println(change(notationBox, num));
	}
}