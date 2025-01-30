import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int c = s.nextInt();
		int arr[] = new int[1000];

		for (int j = 0; j < c; j++) {
			int n = s.nextInt();
			
			double sum = 0;
			double cnt = 0;
			double avg = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
				sum += arr[i];
			}

			avg = sum / n;

			for (int i = 0; i < n; i++) {
				if (avg < arr[i]) {
					cnt++;
				}
			}

			System.out.printf("%.3f", 100 * cnt / n);
			System.out.println("%");
		}

	}
}
