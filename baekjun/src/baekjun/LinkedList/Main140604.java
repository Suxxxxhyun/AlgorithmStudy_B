package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;


/***************************** µ¦ »ç¿ë ************************************************/
public class Main140604 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Character> arraydeque1 = new ArrayDeque<>();
		Deque<Character> arraydeque2 = new ArrayDeque<>();
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			arraydeque1.offer(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				case "L" :
					if(!arraydeque1.isEmpty()) {
						arraydeque2.offerFirst(arraydeque1.pollLast());
					}
					break;
				case "D" :
					if(!arraydeque2.isEmpty()) {
						arraydeque1.offerLast(arraydeque2.pollFirst());
					}
					break;
				case "B" :
					if(!arraydeque1.isEmpty()) {
						arraydeque1.pollLast();
					}
					break;
				case "P" :
					arraydeque1.offerLast(st.nextToken().charAt(0));
					break;
				default :
					break;
			}
		}
		
		Iterator<Character> iter1 = arraydeque1.iterator();
		Iterator<Character> iter2 = arraydeque2.iterator();
		
		br.close();
		
		while(iter1.hasNext()) {
			bw.write(iter1.next());
		}
		
		while(iter2.hasNext()) {
			bw.write(iter2.next());
		}
		
		bw.flush();
		bw.close();
		
	}

}
