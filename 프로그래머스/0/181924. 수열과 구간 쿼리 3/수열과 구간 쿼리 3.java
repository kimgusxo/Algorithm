class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            int pre = query[0];
            int post = query[1];

            int temp = arr[pre];
            arr[pre] = arr[post];
            arr[post] = temp;
        }
        return arr;
    }

}