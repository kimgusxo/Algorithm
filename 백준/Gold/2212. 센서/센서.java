import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int split(int[] sensor, int center) {
		int sum = 0;
		int max = 0;
		
		if(center >= sensor.length) {
			sum = 0;
			return sum;
		}
		
		int[] arr = new int[sensor.length-1];
		
		for(int i = 0; i < sensor.length-1; i++) {
			arr[i] = sensor[i+1] - sensor[i];
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		while(true) {
			center = maxDelete(arr, center, max);
			max = max(arr);
			if(center == 1) break;
		}
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	
	public static int maxDelete(int[] arr, int center, int max) {
		// 여기서 max값을 0으로 만들고 카운트를 줄임
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				arr[i] = 0;
				center--;
			}
			if(center == 1) break;
		}
		
		return center;
	}
	
	public static int max(int[] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int center = sc.nextInt();
		
		int[] sensor = new int[num];
		
		for(int i = 0; i < num; i++) {
			sensor[i] = sc.nextInt();
		}
		
		Arrays.sort(sensor);
		
		System.out.println(split(sensor, center));
		
	}
}