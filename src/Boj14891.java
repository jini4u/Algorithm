import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14891 {
    static int[][] clocks;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        clocks = new int[4][8];
        visited = new int[4];
        for(int i=0;i<4;i++){
            String clockStr = br.readLine();
            for(int j=0;j<8;j++){
                clocks[i][j] = Integer.parseInt(String.valueOf(clockStr.charAt(j)));
            }
        } //[0][] 1번 [1][] 2번 [2][] 3번 [3][] 4번

        int K = Integer.parseInt(br.readLine()); //회전횟수
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            turn(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int j=0;j<4;j++){
                visited[j] = 0;
            }
        }


        int score = 0;
        if(clocks[0][0] == 1){
            score += 1;
        }
        if(clocks[1][0] == 1){
            score += 2;
        }
        if(clocks[2][0] == 1){
            score += 4;
        }
        if(clocks[3][0] == 1){
            score += 8;
        }
        System.out.println(score);
//        int x = 1;
//        for(int i = 0;i<4;i++){
//            System.out.println((x << i));
//        }
    }

    public static void turn(int clockNum, int turnTo){
        if(turnTo == 1){
            visited[clockNum-1] = 1;
            if(clockNum<4 && visited[clockNum] == 0 && clocks[clockNum-1][2] != clocks[clockNum][6]){
                turn(clockNum+1,-1);
            }
            if(clockNum>1 && visited[clockNum-2] == 0 && clocks[clockNum-1][6] != clocks[clockNum-2][2]){
                turn(clockNum-1,-1);
            }
            toClockwise(clockNum);

        } else {
            visited[clockNum-1] = 1;
            if(clockNum<4 && visited[clockNum] == 0 && clocks[clockNum-1][2] != clocks[clockNum][6]){
                turn(clockNum+1,1);
            }
            if(clockNum>1 && visited[clockNum-2] == 0 && clocks[clockNum-1][6] != clocks[clockNum-2][2]){
                turn(clockNum-1,1);
            }
            toCnterClockwise(clockNum);

        }
    }

    public static void toClockwise(int clockNum){ //시계방향
        int i = clockNum-1;
        int tmp = clocks[i][7];
        for(int j=7;j>0;j--){
            clocks[i][j] = clocks[i][j-1];
        }
        clocks[i][0] = tmp;
    }

    public static void toCnterClockwise(int clockNum){ //반시계방향
        int i = clockNum-1;
        int tmp = clocks[i][0];
        for(int j=0;j<7;j++){
            clocks[i][j] = clocks[i][j+1];
        }
        clocks[i][7] = tmp;
    }
}