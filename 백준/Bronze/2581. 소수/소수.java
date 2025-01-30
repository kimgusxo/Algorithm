import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int minNum = sc.nextInt();
		int maxNum = sc.nextInt();
		
		int[] box = new int[maxNum];
		
		int sum = 0;
		int min = 0;
		
		for(int i = minNum; i <= maxNum; i++) {
			for(int j = 2; j <= i; j++) {
				if(j == i) {
					sum += i;
					box[i-1] = i;
				}
				if(i%j == 0) break;
			}
		}
		
		for(int i = 0; i < maxNum; i++) {
			if(box[i] != 0) {
				min = box[i];
				break;
			}
		}
		
		if(sum == 0) {
			sum = -1;
			System.out.println(sum);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}