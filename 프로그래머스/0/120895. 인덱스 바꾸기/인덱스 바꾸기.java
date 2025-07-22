class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] arr = my_string.split("");
        String s1 = arr[num1];
        String s2 = arr[num2];
        
        arr[num1] = s2;
        arr[num2] = s1;
        
        return String.join("", arr);
    }
}