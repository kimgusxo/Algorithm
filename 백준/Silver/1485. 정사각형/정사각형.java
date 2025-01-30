import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	static final int LENGTH_ROW = 4;
	static final int LENGTH_COLUMN = 2;
	
	public static int[][] setInput(int[][] point) {
		for(int i = 0; i < LENGTH_ROW; i++) {
			for(int j = 0; j < LENGTH_COLUMN; j++) {
				point[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(point, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		return point;
	}
	
	
	public static int findSquare(int[][] point) {
		int isSquare = 0;
		
		int crossLength1 = (int) (Math.pow((point[3][0]-point[0][0]), 2) + Math.pow((point[3][1]-point[0][1]), 2));
		int crossLength2 = (int) (Math.pow((point[2][0]-point[1][0]), 2) + Math.pow((point[2][1]-point[1][1]), 2));
		
		int Length1 = (int) (Math.pow((point[1][0]-point[0][0]), 2) + Math.pow((point[1][1]-point[0][1]), 2));
		int Length2 = (int) (Math.pow((point[2][0]-point[0][0]), 2) + Math.pow((point[2][1]-point[0][1]), 2));

		
		if(crossLength1 == crossLength2) {
			if(Length1 == Length2) {
				isSquare = 1;
			}
		}
		
		return isSquare;
	}
	
	public static void main(String[] args) {
	
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int[][] point = new int[LENGTH_ROW][LENGTH_COLUMN];
			
			System.out.println(findSquare(setInput(point)));
		}
	}
}