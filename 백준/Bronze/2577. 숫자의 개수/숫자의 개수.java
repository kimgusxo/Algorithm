import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String result = Integer.toString(a*b*c);
		
		for(int i = 0; i < arr.length; i++) {
			int num = 0;
			for(int j = 0; j < result.length(); j++) {
				if(i == Character.getNumericValue(result.charAt(j))) {
					num++;
				}
			}
			arr[i] = num;
		}
		
		for(int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
	}
}