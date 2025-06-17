import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = br.readLine();

            if(line.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for(char c : line.toCharArray()) {
                switch(c) {
                    case '(':
                        stack.push(c);
                        break;
                    case '[':
                        stack.push(c);
                        break;    
                    case ')':
                        if(stack.isEmpty()) {
                            flag = false;
                        } else {
                            if(stack.peek() == '(') {
                                stack.pop();
                            } else {
                                flag = false;
                            }
                        }
                        break;
                    case ']':
                        if(stack.isEmpty()) {
                            flag = false;
                        } else {
                            if(stack.peek() == '[') {
                                stack.pop();
                            } else {
                                flag = false;
                            }
                        }
                }

                if(!flag) break;
            }

            if(!stack.isEmpty()) {
                flag = false;
            }

            if(flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}