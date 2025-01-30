import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] square1 = new int[3];
		int[] square2 = new int[3];
		
		int result1 = 0;
		int result2 = 0;
		
		for(int i = 0; i < 3; i++) {
			square1[i] = sc.nextInt();
			square2[i] = sc.nextInt();
		}
		
		if(square1[0] == square1[1]) {
			square1[0] = 0;
			square1[1] = 0;
		} else if(square1[0] == square1[2]) {
			square1[0] = 0;
			square1[2] = 0;
		} else if(square1[1] == square1[2]) {
			square1[1] = 0;
			square1[2] = 0;
		} 
		
		if(square2[0] == square2[1]) {
			square2[0] = 0;
			square2[1] = 0;
		} else if(square2[0] == square2[2]) {
			square2[0] = 0;
			square2[2] = 0;
		} else if(square2[1] == square2[2]) {
			square2[1] = 0;
			square2[2] = 0;
		} 
		
		for(int i = 0; i < 3; i++) {
			if(square1[i] != 0) {
				result1 = square1[i];
			}
			if(square2[i] != 0) {
				result2 = square2[i];
			}
		}
		
		System.out.println(result1 + " " + result2);
		
	}
}