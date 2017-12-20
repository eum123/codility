package example;

/**
 * 입력한 숫자를 조합해서 최대 시간 구하기
 */
public class MaximumTime {
    public String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8


        int[] d = new int[] {A, B, C, D};
        int h1 = -1;
        int h2 = -1;

        int maxHour = 0;


        for(int i=0 ;i<d.length ;i++) {

            int count = 0;
            int index = i+1;

            while(count < 3) {

                if(index >= 4) {
                    index = 0;
                }

                int hour =  Integer.parseInt(String.valueOf(d[i]) + String.valueOf(d[index]));

                if(hour < 24) {

                    if(maxHour < hour) {
                        maxHour = hour;
                        h1 = i;
                        h2 = index;
                    }
                }


                index++;
                count++;
            }


        }

        if(h1 < 0) {
            return "NOT POSSIBLE";
        }


        int[] m = new int[2];
        int mindex = 0;
        for(int i=0 ;i<d.length ;i++) {
            if(i != h1 && i != h2) {
                m[mindex] = d[i];
                mindex++;
            }
        }


        String maxMinute = "";

        int temp1 = Integer.parseInt(String.valueOf(m[0]) + String.valueOf(m[1]));
        int temp2 = Integer.parseInt(String.valueOf(m[1]) + String.valueOf(m[0]));

        if(temp1 < 60 && temp2 < 60) {
            if(temp1 > temp2 ) {
                maxMinute = String.valueOf(temp1);
            } else {
                maxMinute = String.valueOf(temp2);
            }
        } else if(temp1 < 60 && temp2 >= 60) {
            maxMinute = String.valueOf(temp1);
        } else if(temp1 >= 60 && temp2 < 60) {
            maxMinute = String.valueOf(temp2);
        } else {
            return "NOT POSSIBLE";
        }

        if(maxHour < 10) {
            return "0" + String.valueOf(maxHour) + ":" + maxMinute;
        } else {
            return String.valueOf(maxHour) + ":" + maxMinute;
        }
    }

    public static void main(String[] args) {
        MaximumTime t = new MaximumTime();
        System.out.println(t.solution(1, 2, 3, 4));
        System.out.println(t.solution(1,8,3,2));

        System.out.println(t.solution(3,0,7,0));

        System.out.println(t.solution(9,1,9,7));

        System.out.println(t.solution(3,4,5,6));
    }
}
