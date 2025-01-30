import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Integer> arraySet(ArrayList<Integer> list, int arrayWidth) {
		for(int i = 0; i < arrayWidth; i++) {
			list.add(sc.nextInt());
		}
		
		return list;
	}
	
	public static int arrayCalculate(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		Collections.sort(list1);
		Collections.sort(list2, Collections.reverseOrder());
		
		int result = 0;
		
		for(int i = 0; i < list1.size(); i++) {
			result += (list1.get(i)*list2.get(i));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int arrayWidth = sc.nextInt();
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		arraySet(list1, arrayWidth);
		arraySet(list2, arrayWidth);
		
		System.out.println(arrayCalculate(list1, list2));
	}
}