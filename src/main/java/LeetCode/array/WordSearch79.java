package LeetCode.array;

public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        char start=word.charAt(0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(findWord(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean findWord(char[][] board, String word,int i,int j,int len){
        if(len==word.length())return true;
        if(i<0||i>=board.length||j<0||j>=board[i].length)return false;
        boolean flag=false;
        if(board[i][j]==word.charAt(len)){
            board[i][j]+=58;
            flag=findWord(board,word,i+1,j,len+1)||
                 findWord(board,word,i-1,j,len+1)||
                 findWord(board,word,i,j+1,len+1)||
                 findWord(board,word,i,j-1,len+1);
            board[i][j]-=58;
        }
        return flag;
    }
}
