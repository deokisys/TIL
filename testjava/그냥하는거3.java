package testjava;

import java.util.Arrays;

public class 그냥하는거3 {
	public static int add_ar(int start, int end, int[] v) {
		int sum = 0;
		for(int i = start;i<end;i++) {
			sum=sum+v[i];
		}
		return sum;
	}
	
	public static void main(String args[]){ 
		int maxhp=10;//최대체력
		int[] times= {1,5,7,10,11};///물약시간
		int[] effects= {4,-6,-1,4,1};//효과들
		
		int answer = 0;
		//시간 순대로n개의 물약
		//i번째 물약은 ti에 먹게됨, 다음시간부터 effecti만큼 체력이 변화
		//ti 5 , effecti -3 이면 6부터 -3씩 줄어듬
		
		//curhp
		
		//초기는 0부터시작
		//0부터 마지막 시간 까지 0또는 최대인 시간을 구하라
		int time_i = 0;
		int effect_i = 0;
		int curhp = 0;
		
		int effect = 0;
		for(int t=0;t<=times[times.length-1];t++) {//0~11
			
			curhp = curhp+effect;//현재 hp에 효과 적용
			if(curhp<0) {
				curhp=0;
			}
			if(curhp>maxhp) {
				curhp=maxhp;
			}
			
			if(t==times[time_i]) {//물얄마실시간
				effect = effect+effects[effect_i];//중첩
				time_i++;
				effect_i++;
			}else {
				
			}
			
			//최대이거나 0일때 answer +1;
			if(curhp==0) {
				answer++;
			}
			
			if(curhp==maxhp) {
				answer++;
			}
			
			
		}
		
		System.out.println(answer);
    }
}
