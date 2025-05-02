import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Flavor> flavors = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Flavor flavor = new Flavor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            flavors.add(flavor);
        }

        int bits = 1 << N;
        for(int mask = 1; mask < bits; mask++) {
            int sours = 1;
            int bitters = 0;
            for(int i = 0; i < N; i++) {
                if((mask & (1 << i)) != 0) {
                    sours *= flavors.get(i).sour;
                    bitters += flavors.get(i).bitter;
                }
            }

            int total = sours - bitters;
            if(Math.abs(total) < min) {
                min = Math.abs(total);
            }
        }

        System.out.println(min);

    }
}

class Flavor {
    int sour;
    int bitter;

    public Flavor(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }
}