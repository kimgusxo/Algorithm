import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger nume = BigInteger.valueOf(1);
        BigInteger deno = BigInteger.valueOf(1);
        int i = 0;
        while(i < share) {
            nume = nume.multiply(BigInteger.valueOf(balls-i));
            deno = deno.multiply(BigInteger.valueOf(share-i));
            i++;
        }

        return (nume.divide(deno)).intValue();
    }
}