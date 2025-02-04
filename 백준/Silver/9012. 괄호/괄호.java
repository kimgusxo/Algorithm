import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++) {
            String str = br.readLine();

            boolean flag = true;
            int[] arr = new int[2];

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    arr[0]++;
                } else {
                    arr[1]++;
                }

                if(arr[0] < arr[1]) {
                    flag = false;
                }
            }

            if(arr[0] != arr[1]) {
                flag = false;
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
