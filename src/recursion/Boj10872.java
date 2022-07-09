package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(recursion(N));
    }

    public static int recursion(int n){
        if(n <= 1){
            return 1;
        }
        return n * recursion(n-1);
    }
}
