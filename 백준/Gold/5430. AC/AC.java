import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String func = br.readLine();
            int size = Integer.parseInt(br.readLine());
            StringBuilder line = new StringBuilder(br.readLine());

            line.deleteCharAt(0);
            line.deleteCharAt(line.length()-1);

            String[] arr = line.toString().split(",");
            Deque<String> deque;
            if(arr[0].equals("")) {
                deque = new ArrayDeque<>();
            } else {
                deque = new ArrayDeque<>(List.of(arr));
            }

            System.out.println(calc(func, deque));
        }
    }

    private static String calc(String func, Deque<String> deque) {
        boolean dir = false;
        for(String f :func.split("")) {
            switch(f) {
                case "R":
                    dir = !dir;
                    break;
                case "D":
                    if(!dir) {
                        if(!deque.isEmpty()) {
                            deque.pollFirst();
                        } else {
                            return "error";
                        }
                    } else {
                        if(!deque.isEmpty()) {
                            deque.pollLast();
                        } else {
                            return "error";
                        }
                    }
                    break;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        if(!dir && !deque.isEmpty()) {
            while(!deque.isEmpty()) {
                result.append(deque.pollFirst()).append(",");
            }
            result.deleteCharAt(result.length()-1);
        } else if(dir && !deque.isEmpty()) {
            while (!deque.isEmpty()) {
                result.append(deque.pollLast()).append(",");
            }
            result.deleteCharAt(result.length()-1);
        }
        result.append("]");

        return result.toString();
    }
}