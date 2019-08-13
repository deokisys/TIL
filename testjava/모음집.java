package testjava;

import java.util.HashMap;
import java.util.*;

//유니코드
//32는 공백
//65 90 대문자
//97 122 소문자
public class 모음집 {
	
	/*배열관련*/
	//int[] temp = new int[nums.length]; 배열 선언할때 자주씀
	//Arrays.sort(); 정렬해줌 오름차순밖에 안됨
	//복사
	//int[] a = Arrays.copyOf(list,list.length);
	//위치변환
	//a.indexOf("s");//해당 값의 위치
	
	/*문자열 관련*/
	//String.substring(start,end) //0부터 시작 문자열  start위치 부터 end전까지 문자열 발췌
	//String[] array = str.split("#");
	
	/*형변환*/
	//int to = Integer.parseInt(from);
	//String to = Integer.toString(from);
	/*String -> char[]*/
	//char[] temp = s.toCharArray();
	
	/*진수 변환*/
	//String a2 = Integer.toBinaryString(num);  // 10진수 -> 2진수
	//String a8= Integer.toOctalString(num);    // 10진수 -> 8진수
	//String a16 = Integer.toHexString(num);    // 10진수 -> 16진수
	
	
	
	//StringBuffer sb = new StringBuffer(); - 스트링버퍼라고 있음
	//sb.append(Character.toUpperCase(c)); - append로 쉽게 넣기가능, char대문자 바꾸는함수

	/*리스트*/
	//ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
	
	/*아이터레이터 iterator*/
	//Iterator<String> it = skillTrees.iterator();
	
	
	/* 맵*/
    //HashMap<String,Integer> map = new HashMap<String,Integer>();

    //map.put(completion[i],1);
	//map.get(participant[i])
	//map.remove(key);
	
	/*스택*/
	// Stack<integer> stackX = new Stack<>();
	//stackX.add();
	//stackX.pop();
	//stackX.peek()
	//stack.size()
	
	
	/*큐*/
	//Queue<Integer> q = new PriorityQueue<Integer>();//우선순위 큐
	//q.offer(1);//넣기
	//q.poll();//빼기
	//q.peek();//보기
	
	
	/*최대공약수*/
	public int getGCD(int a,int b){
	      int rem = 1;
	      while(rem>0){
	          rem = a%b;
	          a=b;
	          b=rem;
	      }
	      return a;
	  }
	/*최소공배수*/
	public int getLCM(int a, int b){
        int tmp=0;
        if(a<b){
            tmp=a;
            a=b;
            b=tmp;
        }
        return a*b/getGCD(a,b);
    }
	
		
	/*행렬 곱*/
	public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int a = arr1.length;
        int b = arr2[0].length;
        System.out.println(a);
        System.out.println(b);
        int gob = arr2.length;
        System.out.println(gob);
        answer = new int[a][b];

        int sum = 0;
        for(int i = 0;i<a;i++){
            for(int j=0;j<b;j++){
                //i,j위치 계산
                //arr1행렬 행, arr2행렬 열 가져오기 
                for(int c=0;c<gob;c++){//b 만큼 반복하면됨
                    sum = sum + arr1[i][c]*arr2[c][j];
                }
                //System.out.println(sum);
                answer[i][j]=sum;
                sum = 0;
            }
        }
        
        return answer;
    }

	/* 소수 판별*/
	public int Prim(int n) {
		int ans=1;
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				ans=-1;
				i=n;
			}
		}
		return ans;
				
	}

}
