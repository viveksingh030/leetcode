class SolveSudoku {
    char[][] boards;
    boolean found=false;
    public void solveSudoku(char[][] board) {
        this.boards=board;
        solveSudoku(0,0);
    }

    public void solveSudoku(int i, int j) {
        if (i == boards.length) {
            found=true;
            return;
        }
        int ni = 0;
        int nj = 0;
        if (j == boards[0].length) {
            ni = i + 1;
            j = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (boards[i][j] != '.') {
            solveSudoku(ni, nj);
        } else {
            for (char pos = 49; pos <= 57; pos++) {
                if (isValid(i, j, pos)) {
                    boards[i][j] = pos;
                    solveSudoku(ni, nj);
                    if(!found) {
                        boards[i][j] = '.';
                    }
                }
            }
        }
    }

    boolean isValid(int row, int col, int pos) {
        for (int j = 0; j < boards[0].length; j++) {
            if (boards[row][j] == pos) {
                return false;
            }
        }
        for (int j = 0; j < boards.length; j++) {
            if (boards[j][col] == pos) {
                return false;
            }
        }
        int smi = (row / 3) * 3;
        int smj = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boards[smi + i][smj + j] == pos) {
                    return false;
                }
            }
        }
        return true;
    }
}