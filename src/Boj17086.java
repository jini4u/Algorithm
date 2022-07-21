import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17086 {

	static int N,M;
	static int[][] arr;
	static int[][] distArr;
	static int[][] dxdy = new int[][] {
		{-1,-1},{-1,0},{-1,1},
		{0,-1},{0,1},
		{1,-1},{1,0},{1,1}
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		distArr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				distArr[i][j] = Integer.MAX_VALUE;
			}
		} //입력 끝
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		
		int maxDist = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				maxDist = Math.max(maxDist, distArr[i][j]);
			}
		}
		System.out.println(maxDist);
		
	}

	//bfs.... 큐를 만들어서 시작 넣어놓고 하나 디큐, visited == true 해놓고 인접한것들 인큐. 큐 empty일때까지 디큐반복
	public static void bfs(int startI, int startJ) {
//		int[][] visited = new int[N][M]; 이게맞나?
//		<sol>
//		탐색하며 거리 정보를 칸에 저장한다
//		탐색 중 특정 지점에 현재 거리보다 작거나 같은 값이 저장되있다면, 다른 상어가 더 가깝게 있다는 뜻이므로 탐색을 정지한다
//		그래서 visited 필요없음! 어차피 젤 가까운거 찾으니까... 대신 위치를 갖고있는 객체를 하나 만들자
		
		Queue<IJandDistance> que = new LinkedList<>(); //queue는 linkedlist로 만든다!
		que.add(new IJandDistance(startI, startJ, 0));
		distArr[startI][startJ] = 0;
		while(!que.isEmpty()) {
			//근데... 노드처럼 번호 있는거 아니고 다 1인데 뭘로 구분? ㅜㅜ -> 위치 가진 객체로 해결!
			IJandDistance tmp = que.poll();
			int nowI, nowJ, nowDist;
			for(int i=0;i<8;i++) {
				nowI = tmp.i + dxdy[i][0];
				nowJ = tmp.j + dxdy[i][1];
				nowDist = tmp.distance + 1;
				
				if(nowI<0 || nowJ<0 || nowI>=N || nowJ>=M || distArr[nowI][nowJ] <= nowDist) {
					continue;
				}
				distArr[nowI][nowJ] = nowDist;
				que.add(new IJandDistance(nowI, nowJ, nowDist));
			}
			
		}
	}
}

class IJandDistance{
	int i,j,distance;
	public IJandDistance(int i, int j, int distance) {
		this.i = i;
		this.j = j;
		this.distance = distance;
	}
}