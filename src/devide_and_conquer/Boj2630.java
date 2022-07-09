package devide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2630 {
    static int[][] wholePaper; //변수선언
    static int whiteCnt;
    static int blueCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N은2^1~2^7
        wholePaper = new int[N][N]; //메모리할당
        whiteCnt = 0; //흰색 0
        blueCnt = 0; //파란색 1

        for(int i=0;i<N;i++){
            String[] strLineArr = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                wholePaper[i][j] = Integer.parseInt(strLineArr[j]);
            }
        } //색종이색입력

        quaterDevide(0,0,N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    public static boolean isSameColor(int row,int col,int size){ //정사각형모양확인
        int firstColor = wholePaper[row][col];

        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(wholePaper[i][j] != firstColor){
                    return false; //하나라도 다르면 false..
                }
            }
        }
        return true; //다른거 없으면 true
    }

    public static void quaterDevide(int row,int col,int size){

        if(isSameColor(row,col,size)){ //색이 다 같으면 숫자세기
            if(wholePaper[row][col] == 0){
                whiteCnt++;
            } else {
                blueCnt++;
            }
        } else { //색이 다르면 .. 사분할하고 반복...
            size /= 2;
            quaterDevide(row,col,size);
            quaterDevide(row+size,col,size);
            quaterDevide(row,col+size,size);
            quaterDevide(row+size,col+size,size);
        }
    }

}
