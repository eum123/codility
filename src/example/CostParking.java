package example;

import java.text.SimpleDateFormat;

/**
 * 주차 시작 시간과 끝 시간으로 주차 비용 구하기
 */
public class CostParking {
    public int solution(String E, String L) {
        // write your code in Java SE 8

        int HOUR_COST = 3;
        int cost = 5;


        try {
            SimpleDateFormat s = new SimpleDateFormat("HH:mm");

            long duration = (s.parse(L).getTime() - s.parse(E).getTime()) / 60000;

            if(duration / 60 > 3) {

                cost += (duration / 60) * HOUR_COST;
                if ((duration % 60) > 0) {
                    cost += HOUR_COST;
                }
            } else {
                cost += (duration / 60) * 2;
                if ((duration % 60) > 0) {
                    cost += HOUR_COST;
                }
            }

            if(cost < 0) {
                return -1;
            }

            return cost;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        CostParking t = new CostParking();
        // System.out.println(t.solution("10:00", "10:21"));

        System.out.println(t.solution("10:00", "13:21"));
        System.out.println(t.solution("09:42", "11:42"));
        System.out.println(t.solution("19:42", "11:42"));
    }
}
