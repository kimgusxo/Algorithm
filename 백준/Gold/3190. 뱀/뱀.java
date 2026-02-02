import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dirPoint = 0;
    static String[] dir = {"R", "D", "L", "U"};
    static int t = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        Deque<Position> length = new ArrayDeque<>();
        length.push(new Position(0, 0));

        int K =  Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = -1;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> commands = new HashMap<>();
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time =  Integer.parseInt(st.nextToken());
            String com = st.nextToken();
            commands.put(time, com);
        }

        run(map, commands, length);

        System.out.println(t);
    }

    private static void run(int[][] map, Map<Integer, String> commands, Deque<Position> length) {
        int x = 0;
        int y = 0;

        while(true) {
            switch(dir[dirPoint]) {
                case "R":
                    y++;
                    t++;

                    if(y >= map.length || check(length, new Position(x,y))) return;
                    if(map[x][y] == -1) {
                        length.addFirst(new Position(x, y));
                        map[x][y] = 0;
                    } else {
                        length.addFirst(new Position(x, y));
                        length.pollLast();
                    }

                    break;
                case "L":
                    y--;
                    t++;

                    if(y < 0 || check(length, new Position(x,y))) return;
                    if(map[x][y] == -1) {
                        length.addFirst(new Position(x, y));
                        map[x][y] = 0;
                    } else {
                        length.addFirst(new Position(x, y));
                        length.pollLast();
                    }
                    break;
                case "U":
                    x--;
                    t++;

                    if(x < 0 || check(length, new Position(x,y))) return;
                    if(map[x][y] == -1) {
                        length.addFirst(new Position(x, y));
                        map[x][y] = 0;
                    } else {
                        length.addFirst(new Position(x, y));
                        length.pollLast();
                    }
                    break;
                case "D":
                    x++;
                    t++;

                    if(x >= map.length || check(length, new Position(x,y))) return;
                    if(map[x][y] == -1) {
                        length.addFirst(new Position(x, y));
                        map[x][y] = 0;
                    } else {
                        length.addFirst(new Position(x, y));
                        length.pollLast();
                    }
                    break;
            }

            if(commands.containsKey(t)) {
                changeDirection(commands, t);
            }
        }
    }

    private static void changeDirection(Map<Integer, String> commands, int t) {
        if(commands.get(t).equals("D")) {
            if(dirPoint == 3) {
                dirPoint = 0;
            } else {
                dirPoint++;
            }
        } else {
            if(dirPoint == 0) {
                dirPoint = 3;
            } else {
                dirPoint--;
            }
        }
    }

    private static boolean check(Deque<Position> length, Position pos) {
        for(Position p : length) {
            if(p.x == pos.x && p.y == pos.y) {
                return true;
            }
        }
        return false;
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}