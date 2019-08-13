package testjava;

import java.util.Arrays;

public class 체육복빌리기 {
	public static void main(String args[]){ 

		
		int n =3;
		int[] lost = {1,2};
		int[] reserve = {2,3};
	
	
	//번호는 체격순
    //자기번호 +1-1 사람에게만 빌릴수 있음
    //전체학생n, 도단당한애들 lost, 여벌 가져온 사람들 reserve,
    //체육을 들을수있는 최대값
    
int answer = 0;
        
        int[] student = new int[n];
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        int k=0;
        int r_leng=reserve.length;
        
        answer=n-lost.length;//최소 들을수 있는 학생 수
        
        for(int i=0;i<r_leng;i++){//여벌을 가진 학생 배열만들기
           student[reserve[i]-1]=1;
        }

        System.out.println(Arrays.toString(student));
        
        //잃어버린 학생 위치로 이동
        //여벌을 가진 학생 찾기
        //자기꺼 잃어버리고 자기 여분가진 사람
        for(int i=0;i<lost.length;i++){
            if(student[lost[i]-1]==1){//lost내의 배열의 위치, 여벌 가짐
                student[lost[i]-1]=0;
                answer++;   
                System.out.println("gg");
            }
        }
        
        System.out.println(Arrays.toString(student));
        for(int i=0;i<lost.length;i++){
            if(lost[i]==1){//맨 앞인 경우
                //자기여분 확인
                if(student[0]==1){
                    student[0]=0;
                    answer++;
                    System.out.println("a");
                }
                //뒤를 확인
                else if(student[1]==1){
                    student[1]=0;
                    answer++;
                    System.out.println("b");
                }
                
            }else if(lost[i]==n){//맨 뒤인 경우
                //자기여분 확인
                if(student[n-1]==1){
                    student[n-1]=0;
                    answer++;
                    System.out.println("c");
                }
                //앞을 확인
                else if(student[n-2]==1){
                    student[n-2]=0;
                    answer++;
                    System.out.println("d");
                }
            }
            else if(student[lost[i]-2]==1){//앞사람 확인
                student[lost[i]-2]=0;
                answer++;
                System.out.println("e");
            }
            else if(student[lost[i]-1]==1){//자기 여분 확인
                student[lost[i]-1]=0;
                answer++;
                System.out.println("f");
            }
           else if(student[lost[i]]==1){//뒷사람 확인
                student[lost[i]]=0;
                answer++;
                System.out.println("kk");
            }else {//여분이 없을때
            	System.out.println("---");
            }
        }
    
    System.out.println("답 : "+answer);
	}
}
