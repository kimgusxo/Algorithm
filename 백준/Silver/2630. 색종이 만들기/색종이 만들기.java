import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        concuer(arr, 0, arr.length-1, 0, arr.length-1);

        System.out.println(count1);
        System.out.println(count2);
    }

    public static boolean judge(int[][] arr, int xStart, int xEnd, int yStart, int yEnd, int num) {
        for(int i = xStart; i <= xEnd; i++) {
            for(int j = yStart; j <= yEnd; j++) {
                if(arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void concuer(int[][] arr, int xStart, int xEnd, int yStart, int yEnd) {
        int xMid = (xStart+xEnd)/2;
        int yMid = (yStart+yEnd)/2;

        int num = arr[xStart][yStart];

        if(num == 0) {
            if(!judge(arr, xStart, xEnd, yStart, yEnd, num)) {
                concuer(arr, xStart, xMid, yStart, yMid);
                concuer(arr, xStart, xMid, yMid+1, yEnd);
                concuer(arr, xMid+1, xEnd, yStart, yMid);
                concuer(arr, xMid+1, xEnd, yMid+1, yEnd);
            } else {
                count1++;
            }
        } else {
            if(!judge(arr, xStart, xEnd, yStart, yEnd, num)) {
                concuer(arr, xStart, xMid, yStart, yMid);
                concuer(arr, xStart, xMid, yMid+1, yEnd);
                concuer(arr, xMid+1, xEnd, yStart, yMid);
                concuer(arr, xMid+1, xEnd, yMid+1, yEnd);
            } else {
                count2++;
            }
        }
    }
}


