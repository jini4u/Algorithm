import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Position> priQue = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			priQue.add(new Position(x,y));
		}
		
		while(!priQue.isEmpty()) {
			Position tmp = priQue.poll();
			bw.write(tmp.x+" "+tmp.y+"\n");
		}
		
		/*
		 * for(int data:priQue) �̿��ؼ� �ϸ� �迭�ƴϰ� ��Ʈ�� ������ ���ĵ� ���·� �ȳ��´�..
		 */
		bw.flush();
	}
}

class Position implements Comparable<Position>{
	int x,y;
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Position o) {
		if(this.x == o.x ){ //x��ǥ�� ������
			if(this.y > o.y) { //y��ǥ ��
				return 1;
			} else if(this.y < o.y) {
				return -1;
			}
		}
		if(this.x > o.x) { //x��ǥ ��
			return 1;
		}
		if(this.x < o.x) {
			return -1;
		} 
		
		return 0;
	}
}