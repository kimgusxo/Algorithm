import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int max = 0;
		int num = 1;
				
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			max = arr[0];
		}
		
		for (int j = 0; j < arr.length; j++) {
			if(arr[j] > max) {
				max = arr[j];
			}
		}
		
		for(int k = 0; k < arr.length; k++) {
			if(arr[k] != max) {
				num++;
			}
			else {
				break;
			}
		}
		
		System.out.println(max);
		System.out.println(num);
		
	}
}