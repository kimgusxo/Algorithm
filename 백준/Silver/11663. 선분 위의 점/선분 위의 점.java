import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());

        ArrayList<Integer> points = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            points.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(points);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            int lower = binarySearch1(points, start);
            int upper = binarySearch2(points, end);

            System.out.println(upper-lower);
        }
    }

    private static int binarySearch1(ArrayList<Integer> points, int target) {
        int lower = 0;
        int upper = points.size() - 1;

        while(upper >= lower) {
            int mid = lower + (upper - lower) / 2;
            if(points.get(mid) < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return lower;
    }

    private static int binarySearch2(ArrayList<Integer> points, int target) {
        int lower = 0;
        int upper = points.size() - 1;

        while(upper >= lower) {
            int mid = lower + (upper - lower) / 2;
            if(points.get(mid) <= target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return lower;
    }
}


