package testjava;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class 연습장 {
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
		String[] numbers = input.split("[+*/-]");//숫자 자르기
		
		ArrayList<Integer> output = new ArrayList<Integer>();//결과 계산
		ArrayList<Character> oper_al = new ArrayList<Character>();//덧셈뺄셈 저장
		for(int i=0;i<numbers.length;i++) {
			output.add(Integer.parseInt(numbers[i]));//숫자 자른거 AL에 넣기
			System.out.println(numbers[i]);
			
		}
		
		int oper_count = 0;
		int left = 0;
		int right = 0;
		//사칙연산 저장하면서 곱셈 먼저 저장
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'||input.charAt(i)=='/') {
				oper_al.add(input.charAt(i));
				System.out.println(input.charAt(i));
				if(input.charAt(i)=='*'||input.charAt(i)=='/') {
					if(input.charAt(i)=='*') {
						left=output.remove(oper_count);
						right=output.remove(oper_count);
						output.add(oper_count,left*right);	
					}else {
						left=output.remove(oper_count);
						right=output.remove(oper_count);
						output.add(oper_count,left/right);	
					}
					
				}
				
				oper_count++;
			}
		}
		
		//덧셈 나눗셈 시작
		while(output.size()>1) {
			if(oper_al.remove(0)=='+') {
				left=output.remove(0);
				right=output.remove(0);
				output.add(0,left+right);	
			}else {
				left=output.remove(0);
				right=output.remove(0);
				output.add(0,left-right);	
			}
		}
		
		
		
		System.out.println(output.get(0));
		
	}
}
