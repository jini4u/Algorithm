package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] onetomil = new int[1000001];
        int original = 1;

        while(original<onetomil.length){
            int generated = original;
            int tmpOri = original;
            while(tmpOri/10 > 0){
                generated += tmpOri%10;
                tmpOri /= 10;
            }
            generated += tmpOri;

            if(generated< onetomil.length){
                if(onetomil[generated] == 0){
                    onetomil[generated] = original;
                } else {
                    onetomil[generated] = Math.min(onetomil[generated],original);
                }
            }
            original++;
        }
        System.out.println(onetomil[N]);
    }
}
