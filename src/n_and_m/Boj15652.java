package n_and_m;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15652 {
    static int N,M;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        recursion(0,0);
        bw.flush();
    }

    public static void recursion(int depth,int start) throws IOException{
        if(depth == M){
            for(int i=0;i<M;i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start;i<N;i++){
            arr[depth] = i+1;
            recursion(depth+1,i);
        }
    }
}
