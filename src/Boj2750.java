import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj2750 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //입력

		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j] > arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}
	}

}
