import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2108 {
	static int N;
	static int[] arr, arrResult, arrCount;
	//arrCount에 들어가는 수 범위 -4000~4000. -4000->0, 0->4000, 4000->8000
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arrResult = new int[N];
		arrCount = new int[8002];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arrCount[arr[i]+4000]++;	
		} //입력 겸 카운트
		
		int modeIndex = 0; 
		int modeCnt = 0;
		for(int i=1;i<arrCount.length;i++) { //i-0일 경우 0번인덱스가 최빈값에 포함될경우 modeCnt가 바로 1이되기 때문에 i=1부터...
			if(arrCount[modeIndex] < arrCount[i]) {
				modeIndex = i;
				modeCnt = 0;
			} else if(arrCount[modeIndex] == arrCount[i] && modeCnt == 0) {
					modeIndex = i;
					modeCnt++;
			}
		} //최빈값 찾기
		
		for(int i=0;i<arrCount.length-1;i++) {
			arrCount[i+1] += arrCount[i];
		} //누적합
				
		for(int i=N-1;i>=0;i--) {
			int index = --arrCount[arr[i]+4000];
			arrResult[index] = arr[i];
		} //결과배열
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += arrResult[i];
		}
		double avg = (double)sum/N; //평균
		if(avg>-0.5 && avg<0) {
			System.out.println("0");
		} else {
			System.out.printf("%.0f\n",avg);
		} //반올림, -0 나오는 문제 수정.
	
		int mid = (N+1)/2;
		System.out.println(arrResult[mid-1]); //중앙값
		
		System.out.println(modeIndex-4000); //최빈값
		
		int from = arrResult[0];
		int to = arrResult[N-1];
		System.out.println(to - from);
		
//		
//		for(int i=0;i<N;i++) {
//			System.out.println(arrResult[i]);
//		}
//		System.out.println();
//		
	}

}
