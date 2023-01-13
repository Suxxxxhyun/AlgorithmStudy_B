package baekjun.src.baekjun.greedy;

public class Main2720Test {

	public static void main(String[] args) {
		
		double dollar = 124 * 1.00/100;
		System.out.println(dollar);
		
		int c = (int)(1.24 / 0.25);
		System.out.println(c);
		
		double m = 3 * 0.25;
		System.out.println(m);
		
		double s = 1.94 - 1.75;
		System.out.println(s);
		System.out.println(Math.round(s*100)/100.0);
		
		double div1 = (double)3 / (double)5; //0.6
		System.out.println("div1: " + div1);
		
		double div2 = (double)5 / (double)3; //0.6
		System.out.println("div2: " + div2);
		
		System.out.println(Double.compare(div1, div2));
		
		System.out.println("0을 2로 나눈경우");
		System.out.println(0 / 2);
	}

}
