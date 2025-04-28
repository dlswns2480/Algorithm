class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int ocnt = 0;
        int xcnt = 0;
        int winCnt = 0;
        String whoWin = "";
        int oWin = 0;
        int xWin = 0;
        String[][] boards = new String[board.length][board.length];
        
        
        for(int i = 0; i < board.length; i++) {
            boards[i] = board[i].split("");
            String start = boards[i][0];
            if(start.equals("O")) {
                whoWin = "O";
            } else {whoWin = "X";}
            boolean flag = true;
            for(int j = 1; j < boards[i].length; j++) {
                if(boards[i][j].equals(".")) flag = false;
                if(!boards[i][j].equals(start)) {
                    flag = false;
                }
            }
            if(flag && whoWin.equals("O")) oWin++;
            else if(flag && whoWin.equals("X")) xWin++;
        }
        
        for(int i = 0; i < boards.length; i++) {
            for(int j = 0; j < boards.length; j++) {
                if(boards[i][j].equals("O")) ocnt++;
                else if(boards[i][j].equals("X")) xcnt++;
            }
        }
        
        for(int i = 0; i < boards.length; i++) {
            String start = boards[0][i];
            if(start.equals("O")) {
                whoWin = "O";
            } else {whoWin = "X";}
            boolean flag = true;
            for(int j = 1; j < boards.length; j++) {
                if(boards[j][i].equals(".")) flag = false;
                if(!boards[j][i].equals(start)) {
                    flag = false;
                }
            }
            if(flag && whoWin.equals("O")) oWin++;
            else if(flag && whoWin.equals("X")) xWin++;
        }
        
        String start = boards[0][0];
        if(start.equals("O")) whoWin = "O";
        else whoWin = "X";
        boolean flag = true;
        for(int i = 1; i < 3; i++) {
            if(boards[i][i].equals(".")) flag = false;
                if(!boards[i][i].equals(start)) {
                    flag = false;
                }
        }
        if(flag && whoWin.equals("O")) oWin++;
        else if(flag && whoWin.equals("X")) xWin++;
        
        start = boards[0][2];
        if(!start.equals(".") && boards[1][1].equals(start) && boards[2][0].equals(start)) {
            if(start.equals("O")) oWin++;
            else if(start.equals("X")) xWin++;
        }
        
        
        
        winCnt = oWin + xWin;
        
        if(oWin >= 1 && xWin >= 1) {
            answer = 0;
        }
        
        if(xcnt > ocnt) {
            // System.out.print("here");
            answer = 0;
        }
        if(ocnt - xcnt >= 2) {
            // System.out.print("here2");
            answer = 0;
        }
        // if(winCnt >= 2) {
        //     System.out.print("here3");
        //     answer = 0;
        // }
        
        if(winCnt == 1 && oWin == 1) {
            if(ocnt != xcnt + 1) answer = 0;
        }
        if(winCnt == 1 && xWin == 1) {
            if(xcnt != ocnt) {
                answer = 0;
            }
        }
        
        return answer;
    }
}