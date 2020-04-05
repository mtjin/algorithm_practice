class Solution {

    public static int[] answer = {};

    public int[] solution(int brown, int red) {
        if (red == 1) { //red 1은 for 문 못타므로 따로 처리
            answer = new int[]{3, 3};
            return answer;
        }
        for (int i = 1; i <= red / 2; i++) {
            int redSero = 0;
            int redGaro = 0;
            if (i * i == red) { //제곱 (정사각형)
                redSero = i;
                redGaro = i;
                if ((redSero + 2) * (redGaro + 2) - red == brown) {
                    answer = new int[]{redGaro + 2, redSero + 2};
                    break;
                }
            }
            if (red % i == 0) { //직사각형 처리
                redSero = i;
                redGaro = red / i;
                if ((redSero + 2) * (redGaro + 2) - red == brown) {
                    answer = new int[]{redGaro + 2, redSero + 2};
                    break;
                }
            }
        }
        //전체 가로 세로 크기
        return answer;
    }
}