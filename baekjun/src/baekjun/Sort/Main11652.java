package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//int의 범위는 2,147,483,647 -> 2의 31슨 -1과 같음 -> 아래와 같이 하면 실패.. 애초에 범위내에 들어가지 못함 -> 그래서 Long래퍼클래스에, long타입의 변수로 모두 바꾸어줌
//-21억부터 21억까지를 인덱스로 하는 카운트 배열을 만든다고 한다면,
//이를 카운트를 기준으로해서 정렬한다고 하였을때, 43억log43억이 나오기 때문에,
//시간초과가 나므로,
//입력받은 숫자를 키값으로하는 카운트맵을 만들어 줄것인데,
//중복이 될 수 있으므로, map의 키에 숫자를 담을 것임
//-> 이렇게 되면 최대 10만장의 카드가 모두 서로 다른 숫자라면, 카운트 맵에 값을 담을 때 최대 10만까지의 시간복잡도가 소요될 수있음.
//이떄의 value를 정렬해줘야하는데, value를 list에 담아서(최대 10만의 시간이 소요) + 정렬(10만log10만) 
//-> 총 20만 + 10만log10만 => 180만 정도의 시간복잡도가 소요됨. -> 굳이 list에 value를 담아서 정렬하지 말고 우선순위큐에 넣자. -> 음. 우선순위큐를 내림차순으로 하면서, values()메소드 쓸 수 없나?
public class Main11652 {
	
	//n은 최대 10만이므로 int변수에 써도됨.
	static int n, count;
	static long result;
	static Map<Long,Integer> nums = new HashMap<Long,Integer>();
	//static PriorityQueue<Integer> counting;
	static List<Integer> value; //횟수를 담는 배열
	static List<Long> keys; //키(가지고 있는 숫자)를 담든 배열
	static long min = Long.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			long num = Long.parseLong(br.readLine());
			if(!nums.containsKey(num)) {
				count = 0;
				nums.put(num, count);
			}
			nums.put(num,nums.get(num) + 1);
		}
		
		//맵에 있는 값(횟수)을 담기 위해 values()사용
		value = new ArrayList<Integer>(nums.values());
		Collections.sort(value, Collections.reverseOrder());
		
		//가장 많이 있는 정수를 출력하기 위해
		//counting의 0번째로 접근해서 값을 가져오기 -> 근데 사실, 10개의 숫자가 모두 서로 다른 숫자라면
		//count는 1일텐데, 1을 값으로하는 key를 배열에 담아, 가장 작은 정수를 출력하기 위해 다시 정렬해야하므로, -> 이때 또 10만log10만의 시간복잡도가 소요됨.
		//340만 정도의 시간복잡도가 소요됨.

		for(Long key : nums.keySet()) {
			if(nums.get(key).equals(value.get(0))) {
				result = (long) Math.min(min, key);
				min = result;
			}
		}
		System.out.println(result);
	}

}
