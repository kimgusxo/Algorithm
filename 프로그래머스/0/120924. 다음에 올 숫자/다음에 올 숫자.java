class Solution {
    public int solution(int[] common) {
        int el1 = common[1]-common[0];
        int el2 = common[2]-common[1];
        if(el1 == el2) {
            return common[common.length-1]+el1;
        } else {
            int multy = el2/el1;
            return common[common.length-1] * multy;
        }
    }
}