import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int MAX = 1299709;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int range = (int) Math.sqrt(MAX)+1;
        int[] arr = new int[MAX+1];

        arr[0] = 0;
        arr[1] = 0;

        for(int i = 2; i <= MAX; i++) {
            arr[i] = i;
        }

        for(int i = 2; i <= range; i++) {
            if(arr[i] != 0) {
                for(int j = 2; j <= MAX/i; j++) {
                    arr[i*j] = 0;
                }
            }
        }

        ArrayList<Integer> decimals = new ArrayList<>();

        for(int el : arr) {
            if(el != 0) {
                decimals.add(el);
            }
        }

        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());

            int start = 0;
            int end = decimals.size() - 1;

            boolean flag = false;

            while(start <= end) {
                int mid = (start+end)/2;
                if(decimals.get(mid) < target) {
                    start = mid + 1;
                } else if(decimals.get(mid) > target) {
                    end = mid - 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                System.out.println(0);
            } else {
                System.out.println(decimals.get(start)-decimals.get(end));
            }
        }

    }
}



