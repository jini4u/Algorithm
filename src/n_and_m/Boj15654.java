package n_and_m;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654 {
    static int N,M;
    static int[] arr;
    static BufferedWriter bw;
    static int[] ansArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ansArr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recursion(0);
        bw.flush();
    }

    public static void recursion(int depth) throws IOException{
        if(depth == M){
            for(int i=0;i<M;i++){
                bw.write(ansArr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                ansArr[depth] = arr[i];
                recursion(depth+1);
                visited[i] = false;
            }
        }
    }
}
