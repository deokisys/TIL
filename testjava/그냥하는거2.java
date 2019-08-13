package testjava;

import java.util.Arrays;
import java.util.*;

public class 그냥하는거2 {
	public static int add_ar(int start, int end, int[] v) {
		int sum = 0;
		for(int i = start;i<end;i++) {
			sum=sum+v[i];
		}
		return sum;
	}
	
	public static void main(String args[]){ 
		int n=4;//구간수
		int[] start= {1,3,4,10};///시작들
		int[] ends= {6,9,5,12};//끝들
		

		
		int answer = 0;
		//한개의 구간을 찾아서 그 구간의 길이의 종합
		
		//전체다 탐색
		//구간들어가면 +1 나오면 -1
		int stack = 0;
		int start_i=0;
		int end_i=0;
		

		//stack이 1이 됬다 = 다음 구간 확인후 answer에 입력 
		for(int i=start[0];i<=ends[ends.length-1];i++) {
			
			if(start_i<start.length) {
				if(start[start_i]==i) {
					stack++;
					start_i++;
				}
			}
			
			if(ends[end_i]==i) {
				end_i++;
				stack = stack -1;
			}
			

			if(stack==1) {
				answer++;
			}
			System.out.println("i"+i+"g"+stack);
			
		}
			
		
		//1 2 3 4 5 6 7 8 9 10 11 12
		//1 1 2 2 1 1 1 0 1 1
		//1  3   5   8   10   12
		//
		
		
		
		System.out.println(answer);
    }
}
