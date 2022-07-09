package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st1.nextToken()); //카드N장
        int M = Integer.parseInt(st1.nextToken()); //합이M이하,최대한가깝도록

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        int[] cards = new int[N];
        for(int i=0;st2.hasMoreTokens();i++){
            cards[i] = Integer.parseInt(st2.nextToken());
        } //카드들 배열에 저장, 크기순아님
        int simSum = 0;
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    if(cards[i]+cards[j]+cards[k]<=M){
                        simSum = Math.max(simSum,cards[i]+cards[j]+cards[k]);
                    }
                }
            }
        }
        System.out.println(simSum);
    }
}
