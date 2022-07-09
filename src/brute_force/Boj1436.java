package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] titleNumArr = new int[N];
        int num = 665;
        int j = 0;

        while(j < N){
            int[] numPartition = new int[howManyNums(++num)];
            int tmp = num;
            for(int i=0;i<numPartition.length;i++){
                numPartition[i] = tmp % 10;
                tmp /= 10;
            }
            for(int i=0;i<numPartition.length-2;i++){
                if(numPartition[i] == 6 && numPartition[i+1] == 6 && numPartition[i+2] == 6){
                    titleNumArr[j++] = num;
                    break;
                }
            }
        }

        System.out.println(titleNumArr[N-1]);
    }

    public static int howManyNums(int num){
        int numCounter = 1;
        while(num/10 != 0){
            num /= 10;
            numCounter++;
        }
        return numCounter;
    }
}
