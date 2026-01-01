import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
           list.add(br.readLine());
        }

        for(int i = 0; i < list.get(0).length(); i++) {
            boolean flag = true;
            char ch = list.get(0).charAt(i);
            for(String el : list) {
                if (ch != el.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(ch);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb.toString());
    }
}