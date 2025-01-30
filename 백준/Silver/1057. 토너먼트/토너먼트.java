import java.util.Scanner;

public class Main {
	public static int[] arraySet(int[] roundBox, int jimin, int hansu) {
		roundBox[jimin-1] = 1;
		roundBox[hansu-1] = 1;
		return roundBox;
	}
	
	public static int[] roundNext(int[] roundBox) {
		int[] temp;
		
		if(roundBox.length%2 == 0) {
			temp = new int[roundBox.length/2];
			for(int i = 0; i < roundBox.length-1; i = i+2) {
				if(roundBox[i] == 0 && roundBox[i+1] == 0) {
					temp[i/2] = 0;
				} else if(roundBox[i] == 1 && roundBox[i+1] == 1) {
					temp[i/2] = 9;
				} else if(roundBox[i] == 1 || roundBox[i+1] == 1) {
					temp[i/2] = 1;
				}
			}
		} else {
			temp = new int[roundBox.length/2+1];
			for(int i = 0; i < roundBox.length-1; i = i+2) {
				if(roundBox[i] == 0 && roundBox[i+1] == 0) {
					temp[i/2] = 0;
				} else if(roundBox[i] == 1 && roundBox[i+1] == 1) {
					temp[i/2] = 9;
				} else if(roundBox[i] == 1 || roundBox[i+1] == 1) {
					temp[i/2] = 1;
				}
			}
			temp[roundBox.length/2] = roundBox[roundBox.length-1];
		}
		return temp;
	}
	
	public static boolean isArray(int[] roundBox) {
		boolean flag = false;
		for(int i = 0; i < roundBox.length; i++) {
			if(roundBox[i] == 9) {
				flag = true;
			}
		}
		return flag;
	}
	
	public static int roundCalculate(int[] roundBox) {
		int cnt = 0;
		int[] box = roundBox;
		
		while(true) {
			box = roundNext(box);
			cnt++;
			if(isArray(box)) {
				break;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int round = sc.nextInt();
		int jimin = sc.nextInt();
		int hansu = sc.nextInt();
		
		int[] roundBox = new int[round];
		
		arraySet(roundBox, jimin, hansu);
		System.out.println(roundCalculate(roundBox));
		
	}
}