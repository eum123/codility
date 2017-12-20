package example;

/**
 * There is a well-known puzzle called Word Search that involves looking for words in a grid of letters.
 The words are given in a list and can appear in the grid horizontally, vertically, or diagonally in any direction.
 In this task, you should implement a solver for word search. You will be given grids and a word to search for,
 and you have to find how many times that word comes out in the grid. Words that are spelled the same backwards and forwards,
 also known as palindromes, will not be given, so you don’t need to worry about words that match in the exact same spot in two different directions.

 Input:

 The first line is the number of test cases T. Each test case will have two numbers N and M, each on their own line given in that order.
 Following that is N lines of M lowercase letters each representing the grid of letters. Lastly, a word W is given that you must look for.

 Output:

 For each test case, output one line of the form “Case C: X” (without the quotes), where C is the case number (starting from 1),
 and X is how many times the word W appeared in the grid.

 Constraints:

 1 ≤ T ≤ 100
 1 ≤ N ≤ 100
 1 ≤ M ≤ 100
 1 ≤ length(W) ≤ 100

 Sample Input:

 3
 3
 4
 catt
 aata
 tatc
 cat
 5
 5
 gogog
 ooooo
 godog
 ooooo
 gogog
 dog
 2
 8
 bananana
 kalibrrr
 nana

 Sample Output:
 Case 1: 4
 Case 2: 8
 Case 3: 4
 */
public class PuzzleString {
    int foundRow;
    int foundColumn;
    String word;
    char[][] wordPuzzle;
    int found = 0;
    int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

    private void puzzleString() throws Exception{
        //readFile("E:\\input.in");
        Object[] input = { 3, 3, 4, "catt", "aata", "tatc", "cat", 5, 5, "gogog", "ooooo", "godog", "ooooo", "gogog", "dog", 2, 8, "bananana", "kalibrrr", "nana" };

        int T = (Integer) input[0];
        int point = 0;
        int row = 0;
        for (int i = 1; i <= T; i++) {
            found = 0;
            point++;
            row = (Integer) input[point];
            point++;
            int col = (Integer) input[point];
            wordPuzzle = new char[row][col];
            for (int j = 0; j < wordPuzzle.length; j++) {
                point++;
                wordPuzzle[j] = input[point].toString().toCharArray();
            }
            point++;
            word = input[point].toString();

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    searchWordPuzzle(wordPuzzle, r, c, word);
                }
            }
            System.out.println("Case "+i+": "+found);
        }
    }
    public static void main(String[] args) throws Exception {
        PuzzleString p = new PuzzleString();
        p.puzzleString();
    }

    void searchWordPuzzle(char grid[][], int row, int col, String word){
        if (grid[row][col] != word.charAt(0))
            return;
        int len = word.length();
        for (int dir = 0; dir < 8; dir++){
            int k, rd = row + x[dir], cd = col + y[dir];
            for (k = 1; k < len; k++){               if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0)
                break;
                if (grid[rd][cd] != word.charAt(k))
                    break;

                rd += x[dir];
                cd += y[dir];
            }
            if (k == len)
                found++;
        }
        return;
    }
}
