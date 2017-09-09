class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkCols(board) && checkRows(board) && checkSubGrids(board);
    }

    public boolean checkRows(char[][] board) {
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (board[i][j] != '.' && !seen.contains(board[i][j])) {
                    seen.add(board[i][j]);
                } else {
                    return false;
                }
            }
            seen = new HashSet<>();
        }
        return true;
    }

    public boolean checkCols(char[][] board) {
        HashSet<Character> seen = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (board[i][j] != '.' && !seen.contains(board[i][j])) {
                    seen.add(board[i][j]);
                } else {
                    return false;
                }
            }
            seen = new HashSet<>();
        }
        return true;
    }

    public boolean checkSubGrids(char[][] board) {
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int x = j; x < j + 3; x++) {
                        if (board[k][x] == '.') {
                            continue;
                        } else if (board[k][x] != '.' && !seen.contains(board[k][x])) {
                            seen.add(board[k][x]);
                        } else {
                            return false;
                        }
                    }
                }
                seen = new HashSet<>();
            }
        }
        return true;
    }
}