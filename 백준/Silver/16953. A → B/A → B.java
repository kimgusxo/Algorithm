import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Obj> q = new LinkedList<>();
        q.offer(new Obj(start, 0));

        int cnt = 0;
        int result = 0;
        boolean flag = false;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                if(q.peek() != null) {
                    Obj obj = q.poll();
                    if(obj.x <= end) {
                        q.add(new Obj(obj.x*2 ,cnt+1));
                        q.add(new Obj(obj.x*10+1, cnt+1));
                    }

                    if(obj.x == end) {
                        flag = true;
                        result = obj.depth;
                        break;
                    }
                }
            }

            cnt++;
        }

        if(flag) {
            System.out.println(result+1);
        } else {
            System.out.println(-1);
        }
    }
}

class Obj {
    long x;
    int depth;

    public Obj(long x, int depth) {
        this.x = x;
        this.depth = depth;
    }
}
