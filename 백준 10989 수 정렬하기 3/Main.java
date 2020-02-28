import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];

        for(int i=0; i<size; i++){
            input[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(input);
        for(int result : input){
            bw.write(""+result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

