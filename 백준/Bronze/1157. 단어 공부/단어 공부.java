import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		String chStr = str.toUpperCase();
		int[] arr = new int[26];
		
		for(int i = 0; i < chStr.length(); i++) {
			for(int j = 0; j < arr.length; j++) {
				if(((int)chStr.charAt(i) - 65) == j) {
					arr[j] += 1;
				}
			}
		}
		
		int max = arr[0];
		int numMax = 0;
		char mulStr;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				numMax = i;
			}
		}
		
		mulStr = (char)(numMax + 65);
		
		for(int i = numMax+1; i < arr.length; i++) {
			if(max == arr[i]) {
				mulStr = '?';
			}
		}
		
		System.out.println(mulStr);
		
	}
}