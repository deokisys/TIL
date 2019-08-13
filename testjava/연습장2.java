package testjava;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class 연습장2 {
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		//String input = scanner.nextLine();
		
		/*
		 * 1. *또는 /부터 계산
		 * 2. +-계산
		 * 
		 * String 에 char[]로 변환하여 계산 진행
		 * 2번의 반복문을 통해 곱셈,나눗셈 +  덧셈, 뺄셈을 진행
		 * 
		 * */
		String input = "1+2-5+1+5*10";
		
		/* 0 1 2 3 4 5
		 * 1 2 5 1 5 10
		 * + - + + *
		 * 
		 * 
		 * */
		
		String[] numbers = input.split("[+*/-]");
		
		ArrayList<Integer> num_al = new ArrayList<Integer>();
		ArrayList<Character> oper_al = new ArrayList<Character>();
		
		for(int index = 0; index<numbers.length;index++) {
			num_al.add(Integer.parseInt(numbers[index]));
		}
		
		//
		int oper_count=0;
		int left = 0;
		int right = 0;
		for(int index=0;index<input.length();index++) {
			if(input.charAt(index)=='*'||input.charAt(index)=='/') {
				if(input.charAt(index)=='*') {
					left=num_al.remove(oper_count);
					right=num_al.remove(oper_count);
					num_al.add(left*right);
				}else {
					left=num_al.remove(oper_count);
					right=num_al.remove(oper_count);
					num_al.add(left/right);
				}
			}else if(input.charAt(index)=='+'||input.charAt(index)=='-') {
				oper_al.add(input.charAt(index));
				oper_count++;
			}else {
				
			}
		}
		
	}
}
