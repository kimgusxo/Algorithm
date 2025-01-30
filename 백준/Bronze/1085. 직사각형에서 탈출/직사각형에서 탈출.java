import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int width = w-x;
		int height = h-y;
		
		int[] box = new int[4];
		
		box[0] = x;
		box[1] = y;
		box[2] = width;
		box[3] = height;
		
		int min = 1000;
		
		for(int i = 0; i < 4; i++) {
			if(min > box[i]) {
				min = box[i];
			}
		}
		
		System.out.println(min);
		
	}
}