package testjava;

import java.util.Arrays;

public class 수포 {
	public static void main(String args[]){ 
		int[] answers = {5,1};
        int[] answer = {};
        
        int[] su1 = {1,2,3,4,5};
        int[] su2 = {2,1,2,3,2,4,2,5};
        int[] su3 = {3,3,1,1,2,2,4,4,5,5};
        
        int su1a = 0;
        int su2a = 0;
        int su3a = 0;
        
        int j=0;
        for(int i=0;i<answers.length;i++){//answers만큼 반복
            if(j==su1.length){
                j=0;
            }   
            
            if(answers[i]==su1[j]){
                su1a=su1a+1;
            }
            j++;
        }
        j=0;
        for(int i=0;i<answers.length;i++){
            if(j==su2.length){
                j=0;
            } 
            if(answers[i]==su2[j]){
                su2a=su2a+1;
            }
            j++;
        }
        j=0;
        for(int i=0;i<answers.length;i++){
            if(j==su3.length){
                j=0;
            } 
            if(answers[i]==su3[j]){
                su3a=su3a+1;
            }
            j++;
        }
        
        //1
        //2
        //3
        //1,2
        //1,3
        //2,3
        //1,2,3-
        /*
        1=2=3
        
        1>2=3
        1>2>3
        1>3>2
        
        2>1=3
        2>1>3
        2>3>1
        
        3>1=2
        3>1>2 ???
        3>2>1 ????
        
        1=2>3
        1=3>2
        2=3>1
        */
        
        
        if(su1a==su2a){
	        	if(su3a>su1a){
	                answer=new int[]{3};//3>1=2
	            }
	            else if(su2a==su3a){
	                answer=new int[]{1,2,3};//1=2=3
	            }
	            else if(su2a>su3a){
	                answer=new int[]{1,2};//1=2>3
	            }

	        }
	        if(su1a==su3a){
	        	if(su2a>su3a){
	                answer=new int[]{2};//2>1=3
	            }
	            else if(su3a>su2a){
	                answer=new int[]{1,3};//1=3>2
	            }
	            else if(su2a==su3a){
	                answer=new int[]{1,2,3};//1=2=3
	            }
	        }
	        if(su2a==su3a){
	        	if(su1a>su3a){
	                answer=new int[]{1};//1>2=3
	            }
	            else if(su3a>su1a){
	                answer=new int[]{2,3};//2=3>1
	            }
	            else if(su2a==su3a){
	                answer=new int[]{1,2,3};//1=2=3
	            }
	        }
	        
	        else if(su1a>su2a){
	            if(su2a>su3a){
	               answer=new int[]{1}; //1>2>3               
	            }
	            else if(su3a>su2a&&su1a>su3a){//1>3>2
	               answer=new int[]{1};
                    
	            }else if(su3a>su1a){//3>1>2
                    answer=new int[]{3};
                }
	        }
	        else if(su2a>su1a){
	            if(su1a>su3a){
	               answer=new int[]{2}; //2>1>3             
	            }
	            else if(su3a>su1a&&su2a>su3a){//2>3>1
	               answer=new int[]{2};
	            }else if(su3a>su2a){
                    answer=new int[]{3};//3>2>1
                }
	        }
        System.out.println(Arrays.toString(answer));
    }
}
