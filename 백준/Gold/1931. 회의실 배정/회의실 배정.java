import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Comparator;

public class Main {	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int meeting = sc.nextInt();
		
		int[][] meetingBox = new int[meeting][2];
		
		for(int i = 0; i < meeting; i++) {
			meetingBox[i][0] = sc.nextInt();
			meetingBox[i][1] = sc.nextInt();
		}
		
		Arrays.sort(meetingBox, (o1, o2) -> {
			if(o1[0] == o2[0]){
		    	return Integer.compare(o1[1],o2[1]);
			}
		    else{
		    	return Integer.compare(o1[0],o2[0]);
		    }
		});
		
		int result = 1;
		
		int min = meetingBox[0][1];
		
		for(int i = 1; i < meeting; i++) {
			if(meetingBox[i][0] >= min) {
				min = meetingBox[i][1];
				result++;
			}
			else if(meetingBox[i][1] < min) {
				min = meetingBox[i][1];
			}
		}
		
		System.out.println(result);
		
	}
	
}