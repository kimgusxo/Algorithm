import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static String[] setValue(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		
		return arr;
	}
	
	public static String[] compareString(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					int o1Result = 0;
					int o2Result = 0;
					for(int i = 0; i < o1.length(); i++) {
						if(Character.getNumericValue(o1.charAt(i)) < 10) {
							o1Result += Character.getNumericValue(o1.charAt(i));
						}
						if(Character.getNumericValue(o2.charAt(i)) < 10) {
							o2Result += Character.getNumericValue(o2.charAt(i)); 
						}
					}
					if((o1Result - o2Result) == 0) {
						return o1.compareTo(o2);
					}
					else {
						return o1Result - o2Result;
					}
				}
				else {
					return o1.length() - o2.length();
				}
			}
		});
		return arr;
	}
	
	public static void output(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
public static void main(String[] args) {
		
		int testCase = sc.nextInt();
		
		String[] arr = new String[testCase];
		
		setValue(arr);
		compareString(arr);
		output(arr);
		
		}	
	}