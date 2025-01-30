import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10000];
		int result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i = 1; i < 10000; i++) {
			int a = i;
			result = selfNumber(a);
			if(result < 10000) {
			arr[result] = result;
			}
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == -1) {
				System.out.println(i);
			}
		}
	}
	
	public static int selfNumber(int a) {
		int num = 0;
		if(0 < num && num < 10) {
		num = a + a%10; //한자리 수
		}
		else if(10 <= num && num < 100) {
		num = a + a/10 + a%10; //두자리 수
		}
		else if(100 <= num && num < 1000) {
		num = a + a/100 + a/10%10 + a%10; //세자리 수
		}
		else {
		num = a + a/1000 + a/100%10 + a/10%10 + a%10; //네자리 수
		}
		return num;
	}
}
