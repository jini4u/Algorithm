package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //M*N 보드판
        int[][] chessboard = new int[N][M];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                if(line.charAt(j) == 'B'){
                    chessboard[i][j] = 0; //B 0
                } else {
                    chessboard[i][j] = 1; //W 1
                }
            }
        } //체스판입력

        int wholeRecolor = 64;
        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                if(wrongColorIn88(chessboard,j,i) < 32){
                    wholeRecolor = Math.min(wholeRecolor,wrongColorIn88(chessboard,j,i));
                } else {
                    wholeRecolor = Math.min(wholeRecolor,64-wrongColorIn88(chessboard,j,i));
                }
            }
        }

        System.out.println(wholeRecolor);
    }

    public static int wrongColorIn88(int[][] chessboard,int startX,int startY){
        int wrongColorCnt = 0;
        int startColor = chessboard[startY][startX];
        for(int i=startY;i<startY+8;i++){
            for(int j=startX;j<startX+8;j+=2){
                if(chessboard[i][j] != startColor){
                    wrongColorCnt++;
                }
                if(chessboard[i][j+1] == startColor){
                    wrongColorCnt++;
                }
            }

            if(startColor == 0){
                startColor = 1;
            } else {
                startColor = 0;
            }
        }
        return wrongColorCnt;
    }
}
