class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];

            int target = query[2];

            for(int i = start; i <= end; i++) {
                if(i % target == 0) {
                    arr[i] += 1;
                }
            }
        }

        return arr;
    }
}