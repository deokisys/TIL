package testjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수찾기 {
	   public static void main(String args[]){ 
		   int[] arr = new int[]{4,3,2,1};
		   int n =10;
		   int answer = 0;
		      int thisnum = 0;
		      
		      int k = 2;
		        int flag = 0;
		      for(thisnum=2;thisnum<n+1;thisnum++){//2부터 n까지 확인
		         // for(k=2;k<thisnum+1;k++){//나눌꺼 n은 2부터 현재 확인하는 숫자 까지 나누기시작
		         //     if(thisnum%k==0){//만약 나누어 떨어질때
		          //        if(thisnum==k){//자기 자신일때만
		          //            answer++;//소수라고 센다
		          //        }
		          //        k=n+1;//나누어 떨어지면 바로 반복문에서 제외
		          //    }
		          //}
		          
		          //현재 확인하는 수의 제곱근이하 까지 나눈다 
		          double thissqrt = Math.sqrt(thisnum);
		          
		          for(k=2;k<(int)thissqrt+1;k++){
		              if(thisnum%k==0){//만약 나누어 떨어질때
		                  flag=1;
		                  k=n+1;//나누어 떨어지면 바로 반복문에서 제외
		              }
		          }
		          if(flag==0){
		              answer++;
		          }
		          else{
		              flag=0;
		          }
		      }
		      

		    System.out.println(answer);
	    }
}
