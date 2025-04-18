import java.io.*;

public class Main {

    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while(((input = br.readLine()) != null) && (input.length()>0)) {
            result = new StringBuilder();
            int n = Integer.parseInt(input);
            int length = (int) Math.pow(3, n);

            StringBuilder sb = new StringBuilder();


            for(int i = 0; i < length; i++) {
                sb.append("-");
            }

            conquer(sb, sb.length());

            System.out.println(result);
        }

    }

    public static void conquer(StringBuilder sb, int length) {
        int left = length/3;
        int right = length/3*2;

        if(left == right) {
            result.append(sb.toString());
            return;
        }

        StringBuilder leftPart = new StringBuilder(sb.substring(0, left));
        StringBuilder rightPart = new StringBuilder(sb.substring(right, length));

        conquer(leftPart, leftPart.length());

        for (int i = left; i < right; i++) {
            result.append(' ');
        }

        conquer(rightPart, rightPart.length());
    }
}


