import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        long result = 0;
        long num = 1;
        long num2 = 0;
        if(n <= 1){
            System.out.println(1);
        }else {
            for (int i = 1; i < n; i++) {
                result = num + num2;
                num2 = num;
                num = result;
            }
            System.out.println(result);
        }
    }


}
