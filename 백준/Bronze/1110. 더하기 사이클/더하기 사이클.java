import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); 
		int cnt = 0; 
		int copy = n; 

		if (0 <= n && n <= 99) { 
			int oneN;
			int twoN;
			int newN;

			while (true) {
				oneN = copy / 10; 
				twoN = copy % 10; 
				newN = oneN + twoN; 
				copy = (twoN * 10) + (newN % 10); 
				cnt++;

				if (n == copy) { 
					break;
				}
			}
			System.out.println(cnt);
		} else {
			System.out.println("n값이 옳지않음!");
		}
	}
}