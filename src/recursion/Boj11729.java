package recursion;

import java.io.*;

public class Boj11729 {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();
        bw.write((int)(Math.pow(2,N)-1)+"\n");
        hanoi(1,2,3,N);
        bw.flush();
        bw.close();
    }

    public static void hanoi(int from,int tmp,int to,int level) throws IOException {
        if(level == 1){
            bw.write(from+" "+to+"\n");
        } else {
            hanoi(from,to,tmp,level-1);
            bw.write(from+" "+to+"\n");
            hanoi(tmp,from,to,level-1);
        }
    }
}
