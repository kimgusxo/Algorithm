import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int weight = sc.nextInt();
		
		int cnt = 0;
		
		if(weight == 4 || weight == 7) {
			cnt = -1;
		} else if(weight%10 == 0 || weight%10 == 5) {
			while(weight > 0) {
				weight = weight-5;
				cnt++;
			}
		} else if(weight%10 == 1 || weight%10 == 6) {
			weight = weight-6;
			cnt = 2;
			while(weight > 0) {
				weight = weight-5;
				cnt++;
			}
		} else if(weight%10 == 2 || weight%10 == 7) {
			weight = weight-12;
			cnt = 4;
			while(weight > 0) {
				weight = weight-5;
				cnt++;
			}
		} else if(weight%10 == 3 || weight%10 == 8) {
			weight = weight-3;
			cnt = 1;
			while(weight > 0) {
				weight = weight-5;
				cnt++;
			}
		} else if(weight%10 == 4 || weight%10 == 9) {
			weight = weight-9;
			cnt = 3;
			while(weight > 0) {
				weight = weight-5;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}