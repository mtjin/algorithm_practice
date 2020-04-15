class Solution {
    public static void main(String[] args) {
        String str = "aaaaa";
        String[] a = str.split("a");
        for (int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public int solution(String s) {
        int answer = 1000; // 최대치로 초기화
        int index = 0; // 문자열의 인덱스(포인터) 역할
        String result = "";

        //문자열 1의 길이인 경우 (한가지 케이스 예외처리)
        if (s.length() == 1) {
            return 1;
        }

        // 한개부터 최대 나눌 수 있는 개수(s.lengt/2) 만큼 반복
        for (int i = 1; i <= (s.length() / 2); i++) {
            index = 0;
            result = "";
            while (true) {
                String standard = ""; // 자르는 기준 문자열
                if (index + i > s.length()) { //index가 최대길이 오버한 경우 최대길이로 조정
                    standard = s.substring(index);
                } else {
                    standard = s.substring(index, index + i);
                }
                String remainStr = s.substring(index); // 압축 안된 문자열
                String[] splitArr = remainStr.split(standard); // 압축 안된 문자열을 기준 문자열로 split
                int compressCount = 0; // 압축 카운트
                while (true) {
                    if (splitArr.length == 0) { // standard 로 끝문자열까지 압축 할 수 있는 경우, 즉 마지막까지 standard 로 압축가능
                        compressCount = remainStr.length() / standard.length(); //
                        break;
                    }
                    if (splitArr[compressCount].equals("")) { // standard 로 압축가능한 개수 +1
                        compressCount++;
                    } else { // standard 로 압축 불가
                        break;
                    }
                }
                index += standard.length() * compressCount; // 다음 불러올 문자열 index 증가
                if (compressCount == 1) { // 압축 하나인 경우
                    result += standard;
                } else { // 두개 이상인 경우 앞에 압축개수 붙여줌
                    result += "" + compressCount + standard;
                }
                if (index >= s.length()) { // 문자열 끝까지 압축실행 했을 경우
                    if (answer >= result.length()) { // 지금까지 최솟값 보다 이번 압축결과가 더 작으면 교체
                        answer = result.length();
                    }
                    break;
                }
            }
        }
        return answer;
    }
}