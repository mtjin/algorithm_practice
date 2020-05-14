import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{	"123", "456", "789"});
    }

    static String[] phone_book;
    static HashMap<String, Integer> map;
    public boolean solution(String[] phone_book) {
        Solution.phone_book = phone_book;
        map = new HashMap();

        //접두사 초기화
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], map.getOrDefault(phone_book[i], 0) + 1);
        }

        for (int i = 0; i < phone_book.length; i++) { //전화번호부 전번 하나씩 불러옴
            for (int j = 0; j < phone_book[i].length(); j++) { //전화번호 한자리씩 읽어서 비교
                String num = phone_book[i].substring(0, j + 1);
                if (checkPrefix(num, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    //접두사인 경우인지 체크
    public boolean checkPrefix(String num, int index) {
        for (int i = 0; i < phone_book.length; i++) {
            //자신의 접두사를 제외한 나머지 번호들의 접두사와 비교해서 해당되는게 있으면 true 반환
            if (map.getOrDefault(num, 0) >= 1 && !phone_book[index].equals(num)) {
                return true;
            }
        }
        return false;
    }
}