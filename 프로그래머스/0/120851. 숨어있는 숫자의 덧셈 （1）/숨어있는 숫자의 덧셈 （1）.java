class Solution {
    public int solution(String my_string) {
        return my_string.replaceAll("[a-zA-z]", "").chars().map(Character::getNumericValue).sum();
    }
}