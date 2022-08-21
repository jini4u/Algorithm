import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Boj1181 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Word> prique = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			prique.add(new Word(br.readLine()));
		}

		while(!prique.isEmpty()) {
			Word tmp = prique.poll();
			if(!prique.isEmpty()) {
				Word tmp2 = prique.peek();
				while(tmp.word.equals(tmp2.word)) {
					prique.poll();
					if(prique.isEmpty()) {
						break;
					}
					tmp2 = prique.peek();
				}
			} 
			bw.write(tmp.word+"\n");
		}
		
		bw.flush();
	}

}

class Word implements Comparable<Word>{
	String word;
	int length;
	public Word(String word) {
		this.word = word;
		this.length = word.length();
	}
	@Override
	public int compareTo(Word o) {
		if(this.length == o.length) {
			int index = 0;
			while(index < this.length) {
				if(this.word.charAt(index) != o.word.charAt(index)) {
					return this.word.charAt(index)-o.word.charAt(index);
				}
				index++;
			}
			return 0;
		} else {
			return this.length-o.length;
		}
	}

}