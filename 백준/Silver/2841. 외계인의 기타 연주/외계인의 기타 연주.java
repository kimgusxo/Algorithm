import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int count = 0;
	
	public static void setStack(Stack<Integer> stack, int melodyFlat) {
		if(stack.peek() < melodyFlat) {
			stack.push(melodyFlat);
			count++;
		} else if(stack.peek() > melodyFlat) {
			while(stack.peek() > melodyFlat) {
				stack.pop();
				count++;
			}
			if(stack.peek() != melodyFlat) {
				stack.push(melodyFlat);
				count++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int flat = sc.nextInt();
		
		Stack<Integer> oneFlatStack = new Stack<>();
		oneFlatStack.push(0);
		
		Stack<Integer> twoFlatStack = new Stack<>();
		twoFlatStack.push(0);
		
		Stack<Integer> threeFlatStack = new Stack<>();
		threeFlatStack.push(0);
		
		Stack<Integer> fourFlatStack = new Stack<>();
		fourFlatStack.push(0);
		
		Stack<Integer> fiveFlatStack = new Stack<>();
		fiveFlatStack.push(0);
		
		Stack<Integer> sixFlatStack = new Stack<>();
		sixFlatStack.push(0);
		
		for(int i = 0; i < num; i++) {
			int melody = sc.nextInt();
			int melodyFlat = sc.nextInt();
			
			if(melody == 1) {
				setStack(oneFlatStack, melodyFlat);
			} else if(melody == 2) {
				setStack(twoFlatStack, melodyFlat);
			} else if(melody == 3) {
				setStack(threeFlatStack, melodyFlat);
			} else if(melody == 4) {
				setStack(fourFlatStack, melodyFlat);
			} else if(melody == 5) {
				setStack(fiveFlatStack, melodyFlat);
			} else if(melody == 6) {
				setStack(sixFlatStack, melodyFlat);
			}
		}
		
		System.out.println(count);
		
	}
}