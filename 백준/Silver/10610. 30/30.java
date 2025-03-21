import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        ArrayList<Integer> arr = new ArrayList<>();

        int cnt = 0;
        for(char c : N.toCharArray()) {
            if(c != '0') {
                arr.add(Integer.parseInt(String.valueOf(c)));
            } else {
                cnt++;
            }
        }

        ArrayList<Integer> arrAsc = new ArrayList<>(arr);
        Collections.sort(arrAsc);

        ArrayList<Integer> arrDesc = new ArrayList<>(arr);
        Collections.sort(arrDesc, Collections.reverseOrder());

        StringBuilder asc = new StringBuilder();
        StringBuilder desc = new StringBuilder();

        if(cnt > 0) {
            asc.append(arrAsc.get(0));
            for(int i = 0; i < cnt; i++) {
                asc.append(0);
            }
            for(int i = 1; i < arrAsc.size(); i++) {
                asc.append(arrAsc.get(i));
            }

            desc.append(arrDesc.get(0));
            for(int i = 1; i < arrDesc.size(); i++) {
                desc.append(arrDesc.get(i));
            }
            for(int i = 0; i < cnt; i++) {
                desc.append(0);
            }

            BigInteger min = new BigInteger(asc.toString());
            BigInteger max = new BigInteger(desc.toString());
            BigInteger thirty = BigInteger.valueOf(30);
            BigInteger remain = max.mod(thirty);

            if(remain.equals(BigInteger.ZERO)) {
                System.out.println(max);
            } else {
                if(max.compareTo(min) > 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(max.subtract(remain));
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}

