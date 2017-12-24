package reader;

/**
 * A zero-indexed array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 */
public class Dominator {

    public int solution(int[] A) {

        int indexOfCandidate = -1;
        int stackCounter = 0, candidate = -1, value = -1, i = 0;

        for (int element : A) {
            if (stackCounter == 0) {
                value = element;
                ++stackCounter;
                indexOfCandidate = i;
            } else {
                if (value == element) {
                    ++stackCounter;
                } else {
                    --stackCounter;
                }
            }
            ++i;
        }

        if (stackCounter > 0) {
            candidate = value;
        } else {
            return -1;
        }

        int countRepetitions = 0;
        for (int element : A) {
            if (element == candidate) {
                ++countRepetitions;

            }
            if (countRepetitions > (A.length / 2)) {
                return indexOfCandidate;
            }
        }
        return -1;

    }
}
