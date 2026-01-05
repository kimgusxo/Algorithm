import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] d = {1,1,2,2,2,8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] N = br.readLine().split(" ");
        for(int i = 0; i < N.length; i++) {
            System.out.print((d[i]-Integer.parseInt(N[i]))+" ");
        }
    }
}