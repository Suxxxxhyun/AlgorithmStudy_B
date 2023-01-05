package baekjun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main5639 {
	
	   //���������ڸ� ���������������� �⺻������ default���������ڷ� ��. -> default�� ���� ��Ű���� ���Ŭ�������� ��밡��
       static class Node{
		
    	Node left;
    	int value;
    	Node right;
		
		static Node head = null;
		
		/*Node(){
			
		}*/
			
		Node(int data) { /****************--> �����ڸ� 2�� ������� --> ��ó�� �Է¹޴� �ָ� direct�� �־��ֱ����� **********************/
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
	
	//������ȸ�޼���
	static void postorder(Node root) {
				
		if(root == null) { 						/********************************--> root�� null�ΰ�� �ƿ� ���� **********************/
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
