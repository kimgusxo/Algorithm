import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int left = 0;
        int right = str.length() - 1;

        int check = 1;

        while(left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                check = 0;
                break;
            }

            left++;
            right--;
        }

        System.out.println(check);
    }
}