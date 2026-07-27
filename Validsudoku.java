import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // use sets to track seen numbers
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // create unique keys for row, col, and box
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i/3) + "-" + (j/3);

                    // if already present → invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
