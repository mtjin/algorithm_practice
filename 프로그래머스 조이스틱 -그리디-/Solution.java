class Solution {

    private static StringBuilder name2;
    private static StringBuilder AAAAA = new StringBuilder(); //다 탐색했나 비교용 다 A가 되었으면 끝난거임
    private static int answer = 0;

    public int solution(String name) {
        name2 = new StringBuilder(name);
        for (int i = 0; i < name.length(); i++) {
            AAAAA.append('A');
        }
        int totalMoveCount = name.length() - 1;
        int start = 0;

        //많이 움직여도 문자열 길이 -1 만큼이므로 그만큼 반복
        while (totalMoveCount > 0) {
            // 완료시 break (해결된 인덱스는 A로 바꿔주는데 A는 안움직여도 되는 인덱스를 의미하게했다.)
            if (AAAAA.toString().equals(name2.toString())) {
                break;
            }
            // 첫번쨰 인덱스만 따로 처리
            if (totalMoveCount == name.length() - 1 && name2.toString().charAt(0) != 'A') {
                answer += moveUpDown(name2.charAt(0));
                name2.setCharAt(0, 'A');
            }
            // 왼쪽 오른쪽으로 어디로 이동할지 결정
            Index index = checkIndex(start);
            // 좌우 이동 카운트 +
            answer += index.moveCount;
            // 해당 인덱스 상하 이동 계산해서 카운트 +
            answer += moveUpDown(name2.charAt(index.currentIndex));
            // 현재 인덱스 세팅
            start = index.currentIndex;
            // 해결한 인덱스는 A로 바꿔줌
            name2.setCharAt(index.currentIndex, 'A');
            totalMoveCount--;
        }
        System.out.println(answer);
        return answer;
    }

    //'A' 가 아닌 인덱스 도착하는데 왼쪽으로 가는거와 오른쪽으로 가는것 중 최소인거의 인덱스와 총 이동거리 반환
    public static Index checkIndex(int start) {
        int tmpStart = start;
        int rightMoveCount = 0;
        int rightIndex = 0;
        int leftMoveCount = 0;
        int leftIndex = 0;
        //오른쪽으로 이동한 경우
        for (int i = 0; i < name2.length(); i++) {
            start++;
            rightMoveCount++;
            if (start > name2.length() - 1) {
                start = 0;
            }
            if (name2.charAt(start) != 'A') {
                rightIndex = start;
                break;
            }
        }
        //왼쪽으로 이동한 경우
        start = tmpStart;
        for (int i = 0; i < name2.length(); i++) {
            start--;
            leftMoveCount++;
            if (start < 0) {
                start = name2.length() - 1;
            }
            if (name2.charAt(start) != 'A') {
                leftIndex = start;
                break;
            }
        }
        // 왼쪽 오른쪽 이동 중 최소를 반환
        if (rightMoveCount <= leftMoveCount) {
            return new Index(rightMoveCount, rightIndex);
        } else {
            return new Index(leftMoveCount, leftIndex);
        }
    }

    // 위아래로 움직이는 최솟값 반환
    private static int moveUpDown(char dest) {
        int distance = Math.abs('A' - dest);
        int zDistance = Math.abs('Z' - dest) + 1;
        int minDistance = Math.min(distance, zDistance);
        return minDistance;
    }

    static class Index {
        int moveCount; // 조이스틱 움직인 횟수
        int currentIndex; // 현재 인덱스

        Index(int moveCount, int currentIndex) {
            this.moveCount = moveCount;
            this.currentIndex = currentIndex;
        }
    }
}