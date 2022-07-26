import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Boj10989 {
	static int N;
	static int[] arrOriginal,arrCounting,arrResult;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arrOriginal = new int[N];
		arrResult = new int[N];
		arrCounting = new int[10001];
		for(int i=0;i<N;i++) {
			arrOriginal[i] = Integer.parseInt(br.readLine());
			arrCounting[arrOriginal[i]]++;
		} //입력겸 갯수배열에 갯수표시

		for(int i=0;i<arrCounting.length-1;i++) {
			arrCounting[i+1] += arrCounting[i];
		} //누적합 해주기
		
		for(int i=N-1;i>=0;i--) {
			int resultIndex = --arrCounting[arrOriginal[i]];
			arrResult[resultIndex] = arrOriginal[i];
		}
		
		for(int data=0;data<N;data++) {
			bw.write(arrResult[data]+"\n");
		}
		bw.flush();
	}
}
