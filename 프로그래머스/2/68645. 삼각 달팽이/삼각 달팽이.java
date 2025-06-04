class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int idx = 1;
        int height = 0;
        int width = 0;

        int target = 0;
        if(n%2 == 0) {
            target = (n+1)*(n/2);
        } else {
            target = (n+1)*(n/2)+(n/2+1);
        }

        int[] answer = new int[target];

        int flag = 1;

        while(true) {
            arr[height][width] = idx;
            idx++;

            if(idx > target) break;

            if(flag == 1) {
                height++;
                if(height >= n || arr[height][width] != 0) {
                    flag = 2;
                    height--;
                    width++;
                }
            } else if(flag == 2) {
                width++;
                if(width >= n || arr[height][width] != 0) {
                    flag = 3;
                    width--;
                    width--;
                    height--;
                }
            } else if(flag == 3) {
                height--;
                width--;
                if(arr[height][width] != 0) {
                    flag = 1;
                    height++;
                    width++;
                    height++;
                }
            }
        }

        int idx2 = 0;
        for(int i = 0; i < n; i++) {
            for(int ii = 0; ii < n; ii++) {
                if(arr[i][ii] != 0) {
                    answer[idx2] = arr[i][ii];
                    idx2++;
                }
            }
        }

        return answer;
    }
}