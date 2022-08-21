import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21608 {
    static int N;
    static int[][] classroom;
    static int[][] favoArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classroom = new int[N][N]; //N*N교실
        favoArr = new int[N*N][4]; //[학생번호][좋아하는친구번호]
        for(int cases=0;cases<N*N;cases++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stuNum = Integer.parseInt(st.nextToken());
            for(int j=0;j<4;j++){
                favoArr[stuNum-1][j] = Integer.parseInt(st.nextToken());
            }

            int maxFriendsI = 0;
            int maxFriendsJ = 0;
            int maxBlank = Integer.MIN_VALUE;
            boolean isFirstblank = true;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(classroom[i][j] == 0){
                        if(isFirstblank){
                            maxFriendsI = i;
                            maxFriendsJ = j;
                            isFirstblank = false;
                        }
                        int blank = 0;
                        if(i-1>=0 && classroom[i-1][j]==0){
                            blank++;
                        }
                        if(j-1>=0 && classroom[i][j-1]==0){
                            blank++;
                        }
                        if(i+1<N && classroom[i+1][j]==0){
                            blank++;
                        }
                        if(j+1<N && classroom[i][j+1]==0){
                            blank++;
                        }

                        if(favoFriends(stuNum,i,j)>favoFriends(stuNum,maxFriendsI,maxFriendsJ)){
                            maxFriendsI = i;
                            maxFriendsJ = j;
                            maxBlank = blank;
                        } else if(favoFriends(stuNum,i,j)==favoFriends(stuNum,maxFriendsI,maxFriendsJ) && blank>maxBlank){
                            maxFriendsI = i;
                            maxFriendsJ = j;
                            maxBlank = blank;
                        }
                    }
                }
            }
            classroom[maxFriendsI][maxFriendsJ] = stuNum;

        } //입력

        int score = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(favoFriends(classroom[i][j],i,j) > 0){
                    score += Math.pow(10,favoFriends(classroom[i][j],i,j)-1);
                }
            }
        }
        System.out.println(score);
    }

    //해당칸 앞뒤양옆에 좋아하는 친구가 몇명인지
    static int favoFriends(int stuNum,int i,int j){
        int result = 0;
        int[] dj = {0,1,0,-1};
        int[] di = {1,0,-1,0};
        int[] favos = favoArr[stuNum-1];

        for(int d=0;d<4;d++){
            int tmpI = i+di[d];
            int tmpJ = j+dj[d];
            if(tmpI<0 || tmpJ<0 || tmpI>=N || tmpJ>=N){
                continue;
            } else {
                int cnt = 0;
                while(cnt < 4){
                    if(classroom[tmpI][tmpJ] == favos[cnt++]){
                        result++;
                    }
                }
            }
        }
        return result;
    } //메소드끝
} //클래스끝
