import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> arrayList = new ArrayList<Integer>(N);
        for(int i=0 ; i<N ; i++){
            arrayList.add(Integer.valueOf(in.readLine()));
        }

        Collections.sort(arrayList);
        for(int i =0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }


}

