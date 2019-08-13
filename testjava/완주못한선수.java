package testjava;

import java.util.HashMap;

public class 완주못한선수 {
	public static void main(String args[]){ 
	 		String[] participant = {"a","a","b","b","c"};
	 		String[] completion= {"a","c","b","b"};
	 		
	 		
	        String answer = "";
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        
	        for(int i=0;i<completion.length;i++){
	            if(map.get(completion[i])!=null){//있는경우
	                map.put(completion[i],map.get(completion[i])+1);//1 추가
	            }
	            else{
	                map.put(completion[i],1);
	            }
	        }
	        for(int i=0;i<participant.length;i++){
	            if(map.get(participant[i])==null){//없는경우
	                answer=participant[i];
	            }
	            else if(map.get(participant[i])==0){//0인경우
	                answer=participant[i];
	            }
	            else{//1개 이상인경우 중복인 사람 들어오면
	                map.put(participant[i],map.get(participant[i])-1);
	            }
	            //map.remove(participant[i]);
	            //동명이인이 둘다 들어온 경우가 있을거다?
	            //p = (a,a,b,b,c), c = (a,c,b,b)-> 삭제 시 문제가 된다.
	            
	            //삭제시 테스트1빼고  실패
	            //삭제 안하면 테스트 2,5실패
	        }
	        System.out.println("ans---");
	        System.out.println(answer);
	    }
}
