class Solution {
public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] map = new int[n/w+1][w];

        int x = 0;
        int y = 0;

        int el = map.length*map[0].length;
        boolean flag = (n/w)%2 == 0 ? false : true;
        for(int i = 0; i < map.length; i++) {
            if (flag) {
                for (int j = 0; j < map[0].length; j++) {
                    if (el == num) {
                        x = i;
                        y = j;
                    }

                    map[i][j] = el;
                    el--;
                }
                flag = false;
            } else {
                for (int j = map[0].length - 1; j >= 0; j--) {
                    if (el == num) {
                        x = i;
                        y = j;
                    }
                    map[i][j] = el;
                    el--;
                }
                flag = true;
            }
        }

        for(int i = x; i >= 0; i--) {
            if(map[i][y] <= n) {
                answer++;
            }
        }

        return answer;
    }
}