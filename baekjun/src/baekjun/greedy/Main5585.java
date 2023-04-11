package baekjun.src.baekjun.greedy;

import java.io.*;
public class Main5585 {

    static int n, cnt;
    static int[] coinType = {500,100,50,10,5,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int money = 1000 - n; //640
        for(int i=0; i<coinType.length; i++){
            if(money < coinType[i]){
                continue;
            }
            int coin = money / coinType[i];
            cnt += coin;
            money -= coin * coinType[i];
        }
        System.out.println(cnt);

    }
}
