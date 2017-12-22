package stacknqueue;

import java.util.Stack;

/**
 * You are given two non-empty zero-indexed arrays A and B consisting of N integers.
 * <p>
 * Arrays A and B represent N voracious fish in a river,
 * <p>
 * ordered downstream along the flow of the river.
 * <p>
 * <p>
 * <p>
 * The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q,
 * <p>
 * then fish P is initially upstream of fish Q. Initially, each fish has a unique position.
 * <p>
 * <p>
 * <p>
 * Fish number P is represented by A[P] and B[P].
 * <p>
 * Array A contains the sizes of the fish. All its elements are unique.
 * <p>
 * Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
 * <p>
 * - 0 represents a fish flowing upstream,
 * <p>
 * - 1 represents a fish flowing downstream.
 * <p>
 * <p>
 * <p>
 * If two fish move in opposite directions and there are no other (living) fish between them,
 * <p>
 * they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one.
 * <p>
 * More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0,
 * <p>
 * and there are no living fish between them. After they meet:
 * <p>
 * - If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 * <p>
 * - If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
 * <p>
 * We assume that all the fish are flowing at the same speed.
 * <p>
 * That is, fish moving in the same direction never meet.
 * <p>
 * The goal is to calculate the number of fish that will stay alive.
 * <p>
 * <p>
 * <p>
 * For example, consider arrays A and B such that:
 * <p>
 * - A[0] = 4    B[0] = 0
 * <p>
 * - A[1] = 3    B[1] = 1
 * <p>
 * - A[2] = 2    B[2] = 0
 * <p>
 * - A[3] = 1    B[3] = 0
 * <p>
 * - A[4] = 5    B[4] = 0
 * <p>
 * Initially all the fish are alive and all except fish number 1 are moving upstream.
 * <p>
 * Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too.
 * <p>
 * Finally, it meets fish number 4 and is eaten by it. The remaining two fish,
 * <p>
 * number 0 and 4, never meet and therefore stay alive.
 * <p>
 * <p>
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty zero-indexed arrays A and B consisting of N integers,
 * <p>
 * returns the number of fish that will stay alive.
 * <p>
 * <p>
 * <p>
 * For example, given the arrays shown above, the function should return 2, as explained above.
 * <p>
 * <p>
 * <p>
 * Assume that:
 * <p>
 * - N is an integer within the range [1..100,000];
 * <p>
 * - each element of array A is an integer within the range [0..1,000,000,000];
 * <p>
 * - each element of array B is an integer that can have one of the following values: 0, 1;
 * <p>
 * - the elements of A are all distinct.
 * <p>
 * Complexity:
 * <p>
 * - expected worst-case time complexity is O(N);
 * <p>
 * - expected worst-case space complexity is O(N), beyond input storage
 * <p>
 * (not counting the storage required for input arguments).
 * <p>
 * <p>
 * <p>
 * Elements of input arrays can be modified.
 */
public class Fish {
    public static int solution(int[] A, int[] B) {
        int N = A.length;
        int alive = N;
        Stack<Integer> downFishStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (B[i] == 0) {    // up
                if (!downFishStack.empty()) {
                    while (!downFishStack.empty()) {
                        alive--;
                        if (downFishStack.peek() > A[i]) {
                            break;
                        } else {
                            downFishStack.pop();
                        }
                    }
                }
            } else {    // down
                downFishStack.push(A[i]);
            }
        }
        return alive;
    }

}
