import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(char c : word.toCharArray()) {
            sb.append(c);
            if(sb.charAt(sb.length()-1) == boom.charAt(boom.length()-1) && sb.length() >= boom.length()) {
                if(sb.substring(sb.length()-boom.length()).equals(boom)) {
                    sb.delete(sb.length()-boom.length(), sb.length());
                }
            }
        }

        if(sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("FRULA");
        }

    }
}