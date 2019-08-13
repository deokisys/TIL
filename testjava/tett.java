package testjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class tett {
	
	   public static void main(String args[]){ 
		   int[] arr = new int[]{4,3,2,1};
		   int[] answer = {};
		   int sofjiejif=arr.length;
	       List<Integer> ans = new ArrayList<Integer>();
	        
	       int[] temp = arr;
	       
	       Arrays.sort(temp);
	       System.out.println(arr.length);

	       for(int i=0;i<arr.length;i++){
	    	   System.out.println(arr[i]);
	    	   System.out.println(temp[0]);
	           if(arr[i]!=temp[0]){
	        	   System.out.println("add");
	               ans.add(arr[i]);
	           }
	       }
	       System.out.println("---");
	       System.out.println(temp[0]);
	       System.out.println(ans.size());
	       System.out.println("---");
	       answer = new int[ans.size()];
	       int size = 0;
	       for(int ttest:ans){
	           answer[size++]=ttest;
	           System.out.println(ttest);
	       }
	       System.out.println(answer[0]);
	    }
}
