class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for(int[] part : parts) {
            sb.append(my_strings[idx].substring(part[0], part[1]+1));
            idx++;
        }
        
        return sb.toString();
    }
}