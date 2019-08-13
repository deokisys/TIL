package testjava;

import java.util.Arrays;

public class 그냥하는거 {
	public static int add_ar(int start, int end, int[] v) {
		int sum = 0;
		for(int i = start;i<end;i++) {
			sum=sum+v[i];
		}
		return sum;
	}
	
	public static void main(String args[]){ 
		int n=7;
		int[] v= {3,2,3,4,-1,-2,-3};
		int answer = 0;
		int lownum= 0 ;
		for(int i =0;i<n;i++) {
			if(i==0) {
				lownum = add_ar(i,n,v)-lownum;
				if(lownum<0) {
					lownum=-lownum;
				}
				answer = 0;
			}else {
				if((add_ar(0,i,v)-add_ar(i,n,v))<0) {
					if(lownum>-(add_ar(0,i,v)-add_ar(i,n,v))){
						answer = i;
						lownum = -(add_ar(0,i,v)-add_ar(i,n,v));
					}
				}else {
					if(lownum>(add_ar(0,i,v)-add_ar(i,n,v))){
						answer = i;
						lownum = add_ar(0,i,v)-add_ar(i,n,v);
					}
				}
				
			}
		}
		System.out.println(answer);
    }
}
