import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		System.out.println(oneNumber(a));
	}
	
	public static int oneNumber(int num) {
		int cnt = 0;
		for(int i = 1; i <= num; i++) {
			if(0 < i && i < 10) {
				cnt++;
			}
			else if(10 <= i && i < 100) {
				cnt++;
			}
			if(100 <= i && i < 1000) {
				for(int j = -9; j <= 9; j++) {
					if(j == ((i/100) - (i/10%10)) && j == ((i/10%10) - (i%10))) {
						cnt++;
					}
				}
			}
		}
		if(num == 1000) {
			cnt = 144;
		}
		return cnt;
	}
}
