import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		Integer[] arr = new Integer[String.valueOf(testCase).length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (String.valueOf(testCase).charAt(i)-48);
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(Integer c : arr) {
			sb.append(c);
		}
		System.out.print(sb);
	}
}