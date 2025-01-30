import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		double[] arr = new double[sc.nextInt()];
		double[] avg = new double[arr.length];
		double max = 0;
		double result = 0.0;
		
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		max = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			avg[i] = arr[i]/max*100;
		}
		
		for(int i = 0; i < arr.length; i++) {
			result += avg[i];
		}
		
		result = result/arr.length;
		System.out.println(result);
		
	}
}
