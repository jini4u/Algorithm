import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj2751 {
	static int[] arr, sortedArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sortedArr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //ют╥б
		br.close();
		
		mergeSort(0,N-1);
		
		for(int i=0;i<N;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int start,int end) {
		int mid = (start+end)/2;
		if(start<end) {
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);
		}
	}

	public static void merge(int left,int mid,int right) {
		int i1 = left;
		int i2 = left;
		int j = mid +1;
		while(i1<=mid && j<=right) {
			if(arr[i1] <= arr[j]) {
				sortedArr[i2++] = arr[i1++];
			} else {
				sortedArr[i2++] = arr[j++];
			}
		}
		
		if(i1>mid) {
			for(int n=j;n<=right;n++) {
				sortedArr[i2++] = arr[n];
			}
		} else {
			for(int n=i1;n<=mid;n++) {
				sortedArr[i2++] = arr[n];
			}
		}
		
		for(int n=left;n<=right;n++) {
			arr[n] = sortedArr[n];
		}
	}
}
