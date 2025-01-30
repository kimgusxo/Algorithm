import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[42];
		int cnt = 0;
		int num = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i = 0; i < 10; i++) {
			num = sc.nextInt()%42;
			arr[num] = num;
		}
		
		for(int i = 0; i < 42; i++) {
			if(arr[i] >= 0) {
				cnt++;
			}
		}

		System.out.println(cnt);
		
	}
}
