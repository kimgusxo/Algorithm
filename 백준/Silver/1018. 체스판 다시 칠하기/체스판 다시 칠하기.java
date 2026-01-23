import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col =  Integer.parseInt(st.nextToken());
        int row =  Integer.parseInt(st.nextToken());

        String[][] chessboard = new String[col][row];
        for(int i = 0; i < col; i++) {
            chessboard[i] = br.readLine().split("");
        }

        for(int i = 0; i <= col-8; i++) {
            for(int j = 0; j <= row-8; j++) {
                drawing(chessboard, i, j);
            }
        }

        System.out.println(answer);
    }

    private static void drawing(String[][] chessboard, int col, int row) {
        for(int z = 0; z < 2; z++) {
            int result = 0;
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(z%2 == 0) {
                        if(i%2 == 0) {
                            if(j%2 == 0) {
                                if(chessboard[i+col][j+row].equals("W")) {
                                    result++;
                                }
                            } else {
                                if(chessboard[i+col][j+row].equals("B")) {
                                    result++;
                                }
                            }
                        } else {
                            if(j%2 == 0) {
                                if(chessboard[i+col][j+row].equals("B")) {
                                    result++;
                                }
                            } else {
                                if(chessboard[i+col][j+row].equals("W")) {
                                    result++;
                                }
                            }
                        }
                    } else {
                        if(i%2 == 0) {
                            if(j%2 == 0) {
                                if(chessboard[i+col][j+row].equals("B")) {
                                    result++;
                                }
                            } else {
                                if(chessboard[i+col][j+row].equals("W")) {
                                    result++;
                                }
                            }
                        } else {
                            if(j%2 == 0) {
                                if(chessboard[i+col][j+row].equals("W")) {
                                    result++;
                                }
                            } else {
                                if(chessboard[i+col][j+row].equals("B")) {
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
            answer = Math.min(answer, result);
        }
    }
}