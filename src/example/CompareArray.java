package example;

import java.util.Arrays;

public class CompareArray {
    public boolean solution(int[] A) {
        // write your code in Java SE 8

        int count = 0;
        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i])
                count++;
        }

        if (count > 2)
            return false;
        return true;
    }

    public static void main(String[] args) {
        CompareArray t = new CompareArray();
        System.out.println(t.solution(new int[] { 1, 5, 3, 3, 7 }));

        System.out.println(t.solution(new int[] { 1, 3, 5, 3, 4 }));
        System.out.println(t.solution(new int[] { 3, 1, 4, 5, 2 }));

    }
}
