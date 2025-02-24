import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if(line == null || line.isEmpty()){
                break;
            }
            arr.add(Integer.parseInt(line));
        }

        recursive(arr, Integer.MAX_VALUE);
    }

    public static void recursive(ArrayList<Integer> arr, int bound) {
        if (arr.isEmpty() || arr.get(0) > bound) {
            return;
        }

        int root = arr.remove(0);

        recursive(arr, root);
        recursive(arr, bound);

        System.out.println(root);
    }
}
