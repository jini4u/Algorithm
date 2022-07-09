package n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
    static int N;
    static int M;
    static boolean visited[];
    static int nArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nArr = new int[M];

        recursion(0,0);
    }

    public static void recursion(int n,int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                System.out.print(nArr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=n;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                nArr[depth] = i+1;
                recursion(i+1,depth+1);
                visited[i] = false;
            }
        }
    }
}
