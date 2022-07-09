package recursion;

import java.io.*;

public class Boj2447 {
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N]; //N*N 보드 생성

        recursion(0,0,N);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 0){
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    public static void recursion(int row,int col,int size){

        if(size == 3){
            for(int i=row;i<row+size;i++){
                for(int j=col;j<col+size;j++){
                    if(i == row+1 && j == col+1){
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                }
            }
        } else {
            size /= 3;
            for (int y = 0;y<3;y++){
                for (int x = 0;x<3;x++){
                    if (y == 1 && x == 1)
                        continue;
                    recursion(row + y*size,col + x*size,size);
                } // this is 최선!
            }
//            recursion(row,col,size);
//            recursion(row,col+size,size);
//            recursion(row,col+size2,size);
//            recursion(row+size,col,size);
//            recursion(row+size,col+size2,size);
//            recursion(row+size2,col,size);
//            recursion(row+size2,col+size,size);
//            recursion(row+size2,col+size2,size); //이게 최선..?
        }
    }
}
