package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //사람수 N
        int[][] weightHeight = new int[N][2]; //0 몸무게 1 키
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            weightHeight[i][0] = Integer.parseInt(st.nextToken());
            weightHeight[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[N];
        for(int i=0;i<N;i++){
            int nowRank = 1;
            for(int j=0;j<N;j++){
                if(weightHeight[i][0] < weightHeight[j][0] && weightHeight[i][1] < weightHeight[j][1]){
                    nowRank++;
                }
            }
            rank[i] = nowRank;
        }

        for(int i=0;i<N;i++){
            System.out.print(rank[i]+" ");
        }
    }
}


//        for(int i=0;i<N;i++){
//        for(int j=0;j<2;j++){
//        System.out.print(weightHeight[i][j]+" ");
//        }
//        System.out.println();
//        }