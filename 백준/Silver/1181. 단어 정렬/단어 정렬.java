import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		String[] arr = new String[testCase];
		
		for(int i = 0; i < testCase; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					int index = 0;
					for(int i = 0; i < s1.length(); i++) {
						if(Character.getNumericValue(s1.charAt(i)) != Character.getNumericValue(s2.charAt(i))) {
							index = i;
							break;
						}
					}
					return Character.getNumericValue(s1.charAt(index)) - Character.getNumericValue(s2.charAt(index));
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		for(int i = 0; i < arr.length-1; i++) {
			if(!arr[i].equals(arr[i+1])) {
				System.out.println(arr[i]);
			}
		}
		System.out.println(arr[arr.length-1]);
	}
}