import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2108 {
	static int N;
	static int[] arr, arrResult, arrCount;
	//arrCount�� ���� �� ���� -4000~4000. -4000->0, 0->4000, 4000->8000
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arrResult = new int[N];
		arrCount = new int[8002];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arrCount[arr[i]+4000]++;	
		} //�Է� �� ī��Ʈ
		
		int modeIndex = 0; 
		int modeCnt = 0;
		for(int i=1;i<arrCount.length;i++) { //i-0�� ��� 0���ε����� �ֺ󰪿� ���Եɰ�� modeCnt�� �ٷ� 1�̵Ǳ� ������ i=1����...
			if(arrCount[modeIndex] < arrCount[i]) {
				modeIndex = i;
				modeCnt = 0;
			} else if(arrCount[modeIndex] == arrCount[i] && modeCnt == 0) {
					modeIndex = i;
					modeCnt++;
			}
		} //�ֺ� ã��
		
		for(int i=0;i<arrCount.length-1;i++) {
			arrCount[i+1] += arrCount[i];
		} //������
				
		for(int i=N-1;i>=0;i--) {
			int index = --arrCount[arr[i]+4000];
			arrResult[index] = arr[i];
		} //����迭
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += arrResult[i];
		}
		double avg = (double)sum/N; //���
		if(avg>-0.5 && avg<0) {
			System.out.println("0");
		} else {
			System.out.printf("%.0f\n",avg);
		} //�ݿø�, -0 ������ ���� ����.
	
		int mid = (N+1)/2;
		System.out.println(arrResult[mid-1]); //�߾Ӱ�
		
		System.out.println(modeIndex-4000); //�ֺ�
		
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
