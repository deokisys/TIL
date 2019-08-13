package testjava;

import java.util.Arrays;

public class k번째수 {
	public static void main(String args[]){ 
		int[] array= {1,5,2,6,3,7,4};
		int[][] commands= {{2,5,3},{4,4,1},{1,7,3}};
		//i,j,k
		int[] temp = {};
        int a = 0;
        int b = 0;
        int c = 0;
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){//i가 commands 하나씩 읽음
            a=commands[i][0];
            b=commands[i][1];
            c=commands[i][2];
            temp = Arrays.copyOfRange(array,a-1,b);
            
            Arrays.sort(temp);
        
            answer[i]=temp[c-1];
            //temp = commands[i];
            //temp = Arrays.copyOf(commands[i],commands[i].length);
            
        }
        //System.out.println(Arrays.toString(answer));
        
        
		
	}
	
}
