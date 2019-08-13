package testjava;

import java.util.HashMap;
import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;


public class 테스트 {
	public static void main(String args[]){ 
		String s ="PPoooyYY";
		boolean answer=true;
		 s.toLowerCase();
		 long efes = 6;
		 
		 BigInteger temp = BigInteger.valueOf((long)efes);
		 BigInteger temp2;
	     int answer2 = -1;
	     
	     int n = 17;
	     String answert = "";
	      //6:17
	      
	      //수를 표현하는데 1,2,4만 사용 - >일단 계산하기 쉽게 4는 3으로 대체
	      
	      /*
	      5인경우
	      5%3 =   2
	      5/3 = 1
	      1%3 =   1
	      ->12
	      6인경우
	      6%3 =   0 - >4
	      6/3 = 2 -> 1
	      1%3 =   1
	      ->14
	      */
	      int num = 3;
	      int rem = 0;
	      int div = 1;
	      System.out.println("n:"+n);
	      while(n>0){
	          rem = n%3;
	          System.out.println(" n%3:"+ n%3);
	          if(rem==0){
	              rem=4;
	              n = n/3 - 1;
	          }else{
	             n=n/3; 
	          }
	          answert=Integer.toString(rem)+answert;
	      }
	     System.out.println(answert);
	     
	     
	     
	     
	      //500번을 반복해도 1이 안되면 -1
	      for(int i = 1;i<=500;i++){
	    	  temp2 = temp.mod(BigInteger.valueOf(2));
	    	  if(temp2.equals(BigInteger.valueOf(0))){

	              temp = temp.divide(BigInteger.valueOf(2));
	          }else{
	        	  //System.out.println("2");
	              temp = temp.multiply(BigInteger.valueOf(3));
	              temp = temp.add(BigInteger.valueOf(1));
	          }
	          //확인\
	          if(temp.equals(1)){
	              answer2=i;
	              i=501;
	          }
	      }
	        //true가 나와야 하는데
	        //안나오는경우가 있나?
	}

}
