package baekjun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main5639 {
	
	   //접근지정자를 지정해주지않으면 기본적으로 default접근지정자로 됨. -> default는 동일 패키지의 모든클래스에서 사용가능
       static class Node{
		
    	Node left;
    	int value;
    	Node right;
		
		static Node head = null;
		
		/*Node(){
			
		}*/
			
		Node(int data) { /****************--> 생성자를 2개 만들어줌 --> 맨처음 입력받는 애를 direct로 넣어주기위해 **********************/
			this.value = data;
		}

		public void insert(int data) {
			if(this.head == null) {
				this.head = new Node(data);
			} else {
				Node currentNode = this.head;
				
				while(true) {
					if(currentNode.value > data) {
						if(currentNode.left == null) {
							currentNode.left = new Node(data);
							break;
						} else {
							currentNode = currentNode.left;
						}
					} else {
						if(currentNode.right == null) {
							currentNode.right = new Node(data);
							break;
						} else {
							currentNode = currentNode.right;
						}
					}
					
				}
				
			}
		}
	}
	
	//후위순회메서드
	static void postorder(Node root) {
				
		if(root == null) { 						/********************************--> root가 null인경우 아예 방지 **********************/
			return;
		}
				
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.value);
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*Node nodeTest = new Node();*/ //--> 
		
		Node.head = new Node(Integer.parseInt(br.readLine()));
		
		String str;
		
		while(true) {
			
			str = br.readLine();
			
			if(str == null || str.equals("")) {
				break;
			}

			int key = Integer.parseInt(str);
			//nodeTest.insert(key);
			Node.head.insert(key);
		}
		
		/*System.out.println(Node.head.left.right.value);*/
		
		
		
		postorder(Node.head);

		
		
	}

}
