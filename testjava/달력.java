package testjava;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class 달력 {
	public static void main(String args[]){ 
		int[] arr = {5,9,7,10};
		int divisor = 5;
		 int[] answer = {};
	      List<Integer> list = new ArrayList<Integer>();
	      //arr중 divisor로 나누어떨어지는(%)값을 오름차순으로 정렬
	      
	      
	      for(int i=0;i<arr.length;i++){
	          if(arr[i]%divisor==0){//나누어 떨어짐
	              list.add(arr[i]);
	          }
	      }
	      
	      int ss=0;
	      if(list.size()==0){
	          answer = new int[list.size()+1];
	      }
	      else{
	          answer = new int[list.size()];
	          for(int ttest:list){
	              answer[ss++]=ttest;
	          }
	          Arrays.sort(answer);
	      }
	}
}
