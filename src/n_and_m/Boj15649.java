package n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {
    static boolean[] visited;
    static int[] nArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //경우의수 nPm

        visited = new boolean[N];
        nArr = new int[M];

        dfs(N,M,0);
    }

    public static void dfs(int N,int M,int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                System.out.print(nArr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                nArr[depth] = i+1;
                dfs(N,M,depth+1);
                visited[i] = false;
            }
        }
    }
}
