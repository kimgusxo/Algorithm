import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '.'){
                sb.append(".");
            } else {
                if(s.startsWith("XXXX", i)) {
                    sb.append("AAAA");
                    i = i+3;
                } else if(s.startsWith("XX", i)) {
                    sb.append("BB");
                    i = i+1;
                } else {
                    flag = true;
                    break;
                }
            }
        }

        if(flag){
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}