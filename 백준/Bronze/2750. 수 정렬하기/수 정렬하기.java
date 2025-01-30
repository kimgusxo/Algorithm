import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
	public static void quickSort(int[] arr, int l, int r) {
		int left = l;
		int right = r;
		int pivot = arr[(l+r)/2];
		
		while(left <= right) {
			
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		if(l < right) {
			quickSort(arr, l, right);
		}
		if(r > left) {
			quickSort(arr, left, r);
		}
	}
	
	public static void swap(int[] arr, int left, int right) {
		int temp1 = arr[left];
		int temp2 = arr[right];
		
		arr[left] = temp2;
		arr[right] = temp1;
	}
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int count = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[count];
    	
    	for(int i = 0; i < count; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	quickSort(arr, 0, arr.length-1);
    	
    	for(int i = 0; i < count; i++) {
    		System.out.print(arr[i] + " ");
    	}
    	
    }
}

