package example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * In this task we will investigate interesting patterns that could be observed on a digital clock. Such a clock represents a point in time using the format “HH:MM:SS” where:

 “HH” is the hour of the day (00 through 23), as two decimal digits;
 “MM” is the minute within the hour (00 through 59), as two decimal digits;
 “SS” is the second within the minute (00 through 59), as two decimal digits.
 We say that a point in time is interesting if it uses at most two
 different digits to print. The goal is to count the number of
 interesting points that can be observed on the clock in a given period
 of time.

 Write a function:

 class Solution { public int solution(String S, String T); }

 that, given strings S and T specifying points in time in the format “HH:MM:SS“,
 returns the number of interesting points in time between S and T
 (inclusive). You can assume that S indicates a point in time before T on
 the same day.

 For example, given “15:15:00” and “15:15:12“, your function should return 1, because there is only one interesting point in time between these points (namely “15:15:11“), Given “22:22:21” and “22:22:23“, your function should return 3; interesting points in time are “22:22:21“, “22:22:22“, and “22:22:23“.

 Assume that:

 strings S and T follow the format “HH:MM:SS” strictly;
 string S describes a point in time before T on the same day.
 In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class InterestingPatterns {

    private int solution(String S, String T) {
        int res=0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date1 = sdf.parse(S);
            Date date2 = sdf.parse(T);
            long diff = date2.getTime() - date1.getTime();
            long diffSeconds = diff / 1000 % 60;
            //long diffMinutes = diff / (60 * 1000) % 60;
            //long diffHours = diff / (60 * 60 * 1000) % 24;

            String[] result = new String[Integer.valueOf(((int) diffSeconds) + 2) - 1];
            for (int i = 0; i < result.length; i++) {
                if (i == 0) {
                    result[0] = S;
                } else {
                    Date d1 = sdf.parse(result[0]);
                    Date d = new Date(d1.getTime() + ((i) * 1000));
                    result[i] = sdf.format(d);
                }
            }

            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < result.length; i++) {
                set = new HashSet<Integer>();
                String str = result[i];
                String[] strA = str.split(":");
                for (int j = 0; j < strA.length; j++) {
                    String strD = strA[j];
                    char[] c = strD.toCharArray();
                    char c1 = c[0];
                    char c2 = c[1];
                    if (c1 == c2) {
                        set.add(Integer.valueOf(c1));
                    } else {
                        set.add(Integer.valueOf(c1));
                        set.add(Integer.valueOf(c2));
                    }
                }
                if(set.size() <= 2 ){
                    res++;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        InterestingPatterns t = new InterestingPatterns();
        System.out.println(t.solution("15:15:00", "15:15:12"));
        System.out.println(t.solution("15:15:00", "17:15:12"));
    }
}
