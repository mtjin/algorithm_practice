import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01000000.GIF", "img2.JPG"});
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            if (head1.compareTo(head2) == 0) {
                String numTail1 = o1.substring(head1.length());
                String numTail2 = o2.substring(head2.length());
                StringBuilder sb1 = new StringBuilder();
                for (char c : numTail1.toCharArray()) {
                    if (Character.isDigit(c) && sb1.length() <= 5)
                        sb1.append(c);
                    else
                        break;
                }
                StringBuilder sb2 = new StringBuilder();
                for (char c : numTail2.toCharArray()) {
                    if (Character.isDigit(c) && sb2.length() <= 5)
                        sb2.append(c);
                    else
                        break;
                }
                return Integer.parseInt(sb1.toString()) - Integer.parseInt(sb2.toString());
            } else {
                return head1.compareTo(head2);
            }
        });
        return files;
    }
}