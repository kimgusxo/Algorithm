import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void input(int num, int[][] rank) throws IOException {
		for(int i = 0; i < num; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			rank[i][0] = Integer.parseInt(st.nextToken());
			rank[i][1] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static int choice(int[][] rank) {
		int result = 1;
		
		int possible = rank[0][1];
		
		for(int i = 1; i < rank.length; i++) {
			if(rank[i][1] < possible) {
				possible = rank[i][1];
				result++;
			}
		}		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		
		String strCycle = br.readLine();
		int cycle = Integer.parseInt(strCycle);
		
		for(int i = 0; i < cycle; i++) {
			String strNum = br.readLine();
			int num = Integer.parseInt(strNum);
			int[][] rank = new int[num][2];
			
			input(num, rank);
			
			Arrays.sort(rank, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
		
			
			System.out.println(choice(rank));
			
		}
		
	}
}