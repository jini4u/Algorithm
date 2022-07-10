package n_and_m;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15657 {
    static int N,M;
    static int[] arr,ansArr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ansArr = new int[M];

        makeSequence(0,0);
        bw.flush();
    }

    public static void makeSequence(int start,int depth) throws IOException{
        if(depth == M){
            for(int i=0;i<M;i++){
                bw.write(ansArr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start;i<N;i++){
            ansArr[depth] = arr[i];
            makeSequence(start++,depth+1);
        }
    }
}
