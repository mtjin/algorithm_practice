/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.util.StringTokenizer;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        int i, k, m, q, z, index; // 인텔리제이에서 i,j구분안돼서 k씀
        int testNum; // 테스트개수
        int N = 0; // 복권케이스개수
        int M = 0; // 내가 가진 복권 개수
        String bokgwon[]; // 복권당첨번호
        int bokgwonMoney[]; // 당첨금액
        String myBokgwon[]; // 내가가진복권번호
        int moneyResult = 0; // 총 따간 금액
        StringTokenizer str; // 띄어쓰기 입력값받는용도
        Boolean isSame;
        Scanner sc = new Scanner(System.in);

        String line = "";
        testNum = sc.nextInt();

        for (i = 0; i < testNum; i++) { // 테스트 개수만큼 반복
            N = sc.nextInt();
            M = sc.nextInt();

            // 복권관련 생성
            bokgwon = new String[N];
            bokgwonMoney = new int[N];
            myBokgwon = new String[M];

            for (k = 0; k < N; k++) { // 테스트의 복권개수만큼 반복

                bokgwon[k] = sc.next();
                bokgwonMoney[k] = sc.nextInt();

            }
            for (m = 0; m < M; m++) { // 테스트의 내가가진 복권 개수만큼 반복

                myBokgwon[m] = sc.next();
            }

            // 입력끝.... 문제풀이
            for (q = 0; q < N; q++) { // 복권 총 개수만큼 반복
                for (index = 0; index < M; index++) { // 내가 가진 복권 개수만큼 반복
                    isSame = true;
                    for (z = 0; z < myBokgwon[0].length(); z++) { // 복권의 자리수만큼 비교 ( 8자리여서 8로해도됨)
                        if (bokgwon[q].charAt(z) == '*' || (bokgwon[q].charAt(z) == myBokgwon[index].charAt(z))) {

                        } else {
                            isSame = false;
                            break; // 다르면 해당 순서의 복권은 빠져나옴
                        }
                    } // 이 for문을 돌고 isSame으로 복권당첨 유무 확인
                    if (isSame == true) { // 당첨됬으면 돈 더함
                        moneyResult += bokgwonMoney[q];
                    }
                }
            }

            /*
             * writer.write("#" + testNum + " " + moneyResult); writer.newLine();
             */
            System.out.println("#" + (i+1) + " " + moneyResult);
            moneyResult=0;
        }
    }
}
