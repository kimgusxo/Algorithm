import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int minNum = sc.nextInt();
			
			int[] box = new int[minNum*2+1];
			
			int cnt = 2;
			
			int count = 0;
			
			for(int i = minNum; i <= minNum*2; i++) {
				box[i] = i;
			}
			
			while(true) {
				cnt++;
				if((cnt*cnt) >= minNum*2) break;
			}
			
			for(int i = 2; i <= cnt; i++) {
				for(int j = 2; j <= minNum*2/i; j++) {
					box[i*j] = 0;
				}
			}
			
			box[minNum] = 0;
			
			for(int i = 2; i <= minNum*2; i++) {
				if(box[i] != 0) {
					count++;
				}
			}	
			
			if(minNum == 0) break;
			
			System.out.println(count);
		}
		
	}
}