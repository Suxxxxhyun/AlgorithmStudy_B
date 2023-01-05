package baekjun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//head없이 쓴경우 , postorder는 재귀함수를 이용 , insert메서드는 currentNode변수 생성

public class Node563903 {
	
	static class Node2{
		
		Node2 left;
		int value;
		Node2 right;
		
		Node2(int data){
			this.left = null;
			this.right = null;
			this.value = data;
		}
		
		public void insert(int data) {
			
			Node2 currentNode = this;
			
			while(currentNode != null) {
				if(currentNode.value > data) {
					if(currentNode.left == null) {
						currentNode.left = new Node2(data);
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if(currentNode.right == null) {
						currentNode.right = new Node2(data);
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}
		
		public void postorder(Node2 root) {
			
			if(root == null) {
				return;
			}
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.value);
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		Node2 node = new Node2(Integer.parseInt(br.readLine()));
		
		while( (str = br.readLine()) != null ) {
			
			if((str == null) || str.equals("")) {
				break;
			}
			node.insert(Integer.parseInt(str));
		}
		
		node.postorder(node);
		

	}

}
