import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01000000.GIF", "img2.JPG"});
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase(); // head - number, tail 분리
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            if (head1.compareTo(head2) == 0) { // head 같은문자열인 경우
                String numTail1 = o1.substring(head1.length()); // number,tail 남김
                String numTail2 = o2.substring(head2.length());
                return Integer.parseInt(calNumber(numTail1)) - Integer.parseInt(calNumber(numTail2));
            } else {
                return head1.compareTo(head2);
            }
        });
        return files;
    }

    private static String calNumber(String numTail2) { //최대 5자리인 number 계산
        StringBuilder sb2 = new StringBuilder();
        for (char c : numTail2.toCharArray()) {
            if (Character.isDigit(c) && sb2.length() <= 5) {
                sb2.append(c);
            } else {
                return sb2.toString();
            }
        }
        return sb2.toString();
    }
}