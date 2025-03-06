import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Absolute> pq = new PriorityQueue<>((o1, o2) -> {
            int compareVal = Integer.compare(o1.val, o2.val);

            if (compareVal != 0) {
                return compareVal;
            }

            return Boolean.compare(o1.sign, o2.sign);
        });

        for(int i = 0; i < T; i++) {
            int val = Integer.parseInt(br.readLine());

            if(val == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    Absolute absolute = pq.poll();
                    if(absolute.sign) {
                        System.out.println(absolute.val);
                    } else {
                        System.out.println(absolute.val*-1);
                    }
                }
            } else if(val > 0) {
                pq.offer(new Absolute(true, val));
            } else {
                pq.offer(new Absolute(false, val*-1));
            }
        }

    }
}

class Absolute {
    boolean sign;
    int val;

    public Absolute(boolean sign, int val) {
        this.sign = sign;
        this.val = val;
    }
}