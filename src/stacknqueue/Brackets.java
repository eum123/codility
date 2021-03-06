package stacknqueue;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested
 if any of the following conditions is true:
 - S is empty;
 - S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 - S has the form "VW" where V and W are properly nested strings.

 For example, the string "{[()()]}" is properly nested but "([)()]" is not.

 Write a function:
 class Solution { public int solution(String S); }
 that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

 For example, given S = "{[()()]}", the function should return 1
 and given S = "([)()]", the function should return 0, as explained above.

 Assume that:
 - N is an integer within the range [0..200,000];
 - string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

 Complexity:
 - expected worst-case time complexity is O(N);
 - expected worst-case space complexity is O(N) (not counting the storage required for input arguments).


 */
public class Brackets {
    public int solution(String S) {
        int result = 1;
        int N = S.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return 0;
                }
                if (c == ']') {
                    if (stack.pop() != '[') {
                        return 0;
                    }
                } else if (c == '}') {
                    if (stack.pop() != '{') {
                        return 0;
                    }
                } else if (c == ')') {
                    if (stack.pop() != '(') {
                        return 0;
                    }
                }
            }
            System.out.println(stack);
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return result;
    }
}
