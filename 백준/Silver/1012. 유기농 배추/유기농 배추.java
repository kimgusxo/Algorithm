import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void dfs(int[][] box, boolean[][] visit, int start1, int start2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		stack1.push(start1);
		stack2.push(start2);
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			int n1 = stack1.pop();
			int n2 = stack2.pop();
			visit[n1][n2] = true;
			
			if(!visit[n1-1][n2] && box[n1-1][n2] == 1) {
				stack1.push(n1-1);
				stack2.push(n2);
			}
			if(!visit[n1+1][n2] && box[n1+1][n2] == 1) {
				stack1.push(n1+1);
				stack2.push(n2);
			}
			if(!visit[n1][n2-1] && box[n1][n2-1] == 1) {
				stack1.push(n1);
				stack2.push(n2-1);
			}
			if(!visit[n1][n2+1] && box[n1][n2+1] == 1) {
				stack1.push(n1);
				stack2.push(n2+1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int width = sc.nextInt()+2;
			int height = sc.nextInt()+2;
			int cabbage = sc.nextInt();
			
			int[][] box = new int[width][height];
			boolean[][] visit = new boolean[width][height];
			
			for(int j = 0; j < cabbage; j++) {
				int num1 = sc.nextInt()+1;
				int num2 = sc.nextInt()+1;
				box[num1][num2] = 1;
			}
			
			int cnt = 0;
			
			for (int k = 0; k < width; k++) {
				for (int w = 0; w < height; w++) {
					if (box[k][w] == 1 && !visit[k][w]) {
						dfs(box, visit, k, w);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}