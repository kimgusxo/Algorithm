class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int el : num_list) {
            while(el != 1) {
                if(el % 2 == 0) {
                    el /= 2;
                } else {
                    el = (el-1)/2;
                }
                answer++;
            }
        }
        return answer;
    }
}