import java.util.Scanner;

public class Main {
	
	public static boolean prime(int num) {
		for(int i = 2; i < num; i++) {
			if(num%i == 0) {
				return false;
			} if(i == (num-1)) break;
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int select = sc.nextInt();
		
		int[] box = new int[select];
		
		for(int i = 0; i < select; i++) {
			box[i] = sc.nextInt();
		}
		
		for(int i = 0; i < select; i++) {
			int plus = box[i]/2;
			int minus = box[i]/2;
			int half = box[i]/2;
			while(true) {
				if(!prime(plus)) {
					plus++;
				}
				if(!prime(minus)) {
					minus--;
				}
				if(prime(plus) && !prime(minus)) {
					plus++;
					minus--;
				}
				if(!prime(plus) && prime(minus)) {
					minus--;
					plus++;
				}
				if(prime(plus) && prime(minus)) break;
			}
			System.out.println(minus + " " + plus);
		}
		
	}
}