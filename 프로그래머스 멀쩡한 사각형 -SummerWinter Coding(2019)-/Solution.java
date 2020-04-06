class Solution {
    //대각선이 지나는 단위정사각형'에 대한 문제 중 직사각형의 각 변을 m,n이라고 할때 공식은 m+n-(m과n의 최대공약수)입니다.
    public long solution(long w, long h) {
        long answer = 1;
        long GCD = 1;
        if (w > h) {
            GCD = gcd(w, h);
        } else {
            GCD = gcd(h, w);
        }
        long passSquare = w + h - GCD;
        answer = w * h - passSquare;
        return answer;
    }

    public static long gcd(long big, long small) {
        if (big % small == 0) {
            return small;
        }
        return gcd(small, big % small);
    }
}