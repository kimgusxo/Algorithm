import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = bf.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int minNum = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		
		int[] box = new int[maxNum+1];
		
		int cnt = 2;
		
		for(int i = minNum; i <= maxNum; i++) {
			box[i] = i;
		}
		
		while(true) {
			cnt++;
			if((cnt*cnt) >= maxNum) break;
		}
		
		for(int i = 2; i <= cnt; i++) {
			for(int j = 2; j <= maxNum/i; j++) {
				box[i*j] = 0;
			}
		}
		
		for(int i = 2; i <= maxNum; i++) {
			if(box[i] != 0) {
				System.out.println(box[i]);
			}
		}
		
	}
}