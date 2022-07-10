package n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18290 {
    static int N, M, K, maxSum;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxSum = Integer.MIN_VALUE;
        makeSum(0,0);
        System.out.println(maxSum);
    }

    public static void makeSum(int selectCnt,int sum){
        if(selectCnt == K){
            maxSum = Math.max(maxSum,sum);
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && !hasTrueNeighbor(i,j)){
                    visited[i][j] = true;
                    makeSum(selectCnt+1,sum+board[i][j]);
                    visited[i][j] = false;
                }

            }
        }
    }

    public static boolean hasTrueNeighbor(int i, int j){
        if(i-1 >= 0){
            if(visited[i-1][j]){
                return true;
            }
        }
        if(i+1 < N){
            if(visited[i+1][j]){
                return true;
            }
        }
        if(j-1 >= 0){
            if(visited[i][j-1]){
                return true;
            }
        }
        if(j+1 < M){
            if(visited[i][j+1]){
                return true;
            }
        }
        return false;
    }
}
