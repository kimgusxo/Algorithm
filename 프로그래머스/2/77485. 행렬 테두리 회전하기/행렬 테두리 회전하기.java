import java.util.*;

class Solution {
    
     static List<Integer> answer = new ArrayList<>();

    public int[] solution(int rows, int columns, int[][] queries) {

        int el = 1;
        int[][] array = new int[rows][columns];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                array[i][j] = el;
                el++;
            }
        }


        for(int[] query : queries) {
            int min = Integer.MAX_VALUE;

            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;


            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(Integer.MAX_VALUE);
            for (int j = y1; j < y2; j++) {
                queue.offer(array[x1][j]);
                array[x1][j] = queue.poll();
                min = Math.min(min, array[x1][j]);
            }
            for (int j = x1; j < x2; j++) {
                queue.offer(array[j][y2]);
                array[j][y2] = queue.poll();
                min = Math.min(min, array[j][y2]);
            }
            for (int j = y2; j > y1; j--) {
                queue.offer(array[x2][j]);
                array[x2][j] = queue.poll();
                min = Math.min(min, array[x2][j]);
            }
            for (int j = x2; j > x1; j--) {
                queue.offer(array[j][y1]);
                array[j][y1] = queue.poll();
                min = Math.min(min, array[j][y1]);
            }

            array[x1][y1] = queue.poll();
            min = Math.min(min, array[x1][y1]);

            answer.add(min);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}