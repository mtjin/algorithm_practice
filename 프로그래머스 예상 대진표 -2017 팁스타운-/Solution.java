    class Solution {

        //게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B
        public int solution(int n, int a, int b) {
            int answer = 1;
            int aNum = a;
            int bNum = b;
            while (true) {
                // 12냐 23이냐 차이 구분
                if (aNum < bNum) {
                    if (Math.abs(aNum - bNum) == 1 && ((aNum / 2 + 1) == bNum / 2)) {
                        break;
                    }
                } else {
                    if (Math.abs(aNum - bNum) == 1 && ((bNum / 2 + 1) == aNum / 2)) {
                        break;
                    }
                }
                //승리 후 재배치
                if (aNum % 2 == 0) { //짝수
                    aNum = aNum / 2;
                } else { //홀수
                    aNum = aNum / 2 + 1;
                }
                if (bNum % 2 == 0) { //짝수
                    bNum = bNum / 2;
                } else { //홀수
                    bNum = bNum / 2 + 1;
                }
                answer++;
            }

            return answer;
        }
    }