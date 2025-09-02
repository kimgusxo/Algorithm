class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            left.append(String.valueOf(i).repeat(food[i]/2));
        }
        StringBuilder right = new StringBuilder(left);
        
        left.append("0").append(right.reverse());
        
        return left.toString();
    }
}