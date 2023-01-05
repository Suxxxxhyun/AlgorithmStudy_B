package baekjun.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main11279 {
	
	static class MaxHeap{
		
		static ArrayList<Integer> heapArray;
		
		MaxHeap(){
			heapArray = new ArrayList<Integer>();
			heapArray.add(null);
		}
		
		public void insert(int data) {
			int inserted_idx, parent_idx;
			
			if(heapArray.size() <= 1) {
				heapArray.add(data);
				return;
			} else {
				heapArray.add(data);
				inserted_idx = heapArray.size() - 1;
				while(this.insertswap(inserted_idx)) {
					parent_idx = inserted_idx / 2;
					Collections.swap(heapArray, inserted_idx, parent_idx);
					inserted_idx = parent_idx;
					if(inserted_idx == 1) {
						return;
					}
				}
			}
		}
		
		public boolean insertswap(Integer inserted_idx) {
			
			int parent_idx = inserted_idx / 2;
			
			if(heapArray.get(parent_idx) < heapArray.get(inserted_idx)) {
				return true;
			} else {
				return false;
			}
		}
		
		public Integer poll() {
			
			Integer polled;
			int rooted_idx = 1;
			int parent_idx;
			
			if(heapArray.size() <= 2) {
				polled = heapArray.remove(rooted_idx);
				return polled;
			} else {
				polled = heapArray.get(rooted_idx);
				heapArray.set(rooted_idx, heapArray.get(heapArray.size() - 1));
				heapArray.remove(heapArray.size()-1);
				
				while(this.pollswap(rooted_idx)) {
					int rooted_left_idx = rooted_idx * 2; 
					int rooted_right_idx = rooted_idx * 2 + 1;
					
					if(rooted_right_idx >= heapArray.size()) {
						Collections.swap(heapArray, rooted_left_idx, rooted_idx);
						rooted_idx = rooted_left_idx;
					} else {
						if(heapArray.get(rooted_left_idx) > heapArray.get(rooted_right_idx)){
							if(heapArray.get(rooted_left_idx) > heapArray.get(rooted_idx)) {
								Collections.swap(heapArray, rooted_left_idx, rooted_idx);
								rooted_idx = rooted_left_idx;
							}
						} else {
							if(heapArray.get(rooted_right_idx) > heapArray.get(rooted_idx)) {
								Collections.swap(heapArray, rooted_right_idx, rooted_idx);
								rooted_idx = rooted_right_idx;
							}
						}
					}
				}
				
				return polled;
			}
		}
		
		public boolean pollswap(int rooted_idx) {
			int rooted_left_idx = rooted_idx * 2; 
			int rooted_right_idx = rooted_idx * 2 + 1;

			if(rooted_left_idx >= heapArray.size()) {
				return false;
			} else if(rooted_right_idx >= heapArray.size()){
				if(heapArray.get(rooted_left_idx) > heapArray.get(rooted_idx)) {
					return true;
				} else {
					return false;
				}
			} else {
				if(heapArray.get(rooted_left_idx) > heapArray.get(rooted_right_idx)) {
					if(heapArray.get(rooted_left_idx) > heapArray.get(rooted_idx)) {
						return true;
					} else {
						return false;
					}
				} else {
					if(heapArray.get(rooted_right_idx) > heapArray.get(rooted_idx)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		MaxHeap heap = new MaxHeap();
		
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a > 0) {
				heap.insert(a);
				System.out.println(heap.heapArray);
			} else {
				if(heap.heapArray.size() <= 1) {
					sb.append(0);
					sb.append("\n");
					System.out.println(heap.heapArray);
					System.out.println(heap.heapArray.size());
				} else {
					sb.append(heap.poll());
					sb.append("\n");
					System.out.println(heap.heapArray);
					System.out.println(heap.heapArray.size());
				}
			}
		}
		
		System.out.println(sb);
		//System.out.println(heap.heapArray);
	}

}
