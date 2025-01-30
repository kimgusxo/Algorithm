import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(l == r) return;
		
		int mid = (l+r)/2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid+1, r);
		
		int left = l;
		int right = mid+1;
		
		ArrayList<Integer> temp = new ArrayList<>();
		
		while(left <= mid && right <= r) {
			if(arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}
		
		while(left <= mid) {
			temp.add(arr[left]);
			left++;
		}
		
		while(right <= r) {
			temp.add(arr[right]);
			right++;
		}
		
		for(int i = 0; i < temp.size(); i++) {
			arr[l+i] = temp.get(i);
		}
		
	}
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int count = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[count];
    	
    	for(int i = 0; i < count; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	mergeSort(arr, 0, arr.length-1);
    	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	for(int i = 0; i < count; i++) {
    		bw.write(arr[i] + "\n");
    	}
    	
    	bw.flush();
    	bw.close();
    	
    }
}

