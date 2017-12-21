package sorting;

import java.util.Arrays;

/**
 * Write a function

 class Solution { public int solution(int[] A); }

 that, given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.

 Assume that:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [−1,000,000..1,000,000].
 For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
 the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

 Complexity:

 expected worst-case time complexity is O(N*log(N));
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
public class Distinct {
    public static int solution(int[] A){
        int N = A.length;
        if (N == 0) {
            return 0;
        } else if (N == 1){
            return 1;
        }

        int count = 1;
        Arrays.sort(A);

        for (int i = 0; i < N - 1; i++) {
            if (A[i] != A[i + 1]) {
                count++;
            }
        }

        return count;
    }
}
