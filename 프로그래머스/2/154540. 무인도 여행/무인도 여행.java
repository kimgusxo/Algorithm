import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    list.add(dfs(maps, visited, i, j));
                }
            }
        }
        
        if(list.isEmpty()) {
            list.add(-1);
        }

        Collections.sort(list);

        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public static int dfs(String[] maps, boolean[][] visited, int y, int x) {
        Stack<Point> stack = new Stack<>();
        int days = 0;

        stack.push(new Point(y, x));
        visited[y][x] = true;
        days += maps[y].charAt(x) - '0';
        while(!stack.isEmpty()) {
            Point point = stack.pop();
            int py = point.y;
            int px = point.x;
            for(int i = 0; i < 4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];

                if(ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length()) {
                    if(maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                        stack.push(new Point(ny, nx));
                        visited[ny][nx] = true;
                        days += maps[ny].charAt(nx) - '0';
                    }
                }
            }
        }

        return days;
    }
}

class Point {
    int y;
    int x;
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}