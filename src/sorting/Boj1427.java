import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj1427 { 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		while(N/10 > 0) {
			priorityQueue.add(N%10);
			N /= 10;
		}
		priorityQueue.add(N);
		while(!priorityQueue.isEmpty()) {
			System.out.print(priorityQueue.poll());
		}
	}
}