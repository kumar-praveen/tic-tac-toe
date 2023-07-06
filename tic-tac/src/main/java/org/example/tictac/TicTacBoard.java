package org.example.tictac;

import lombok.Data;

@Data
public class TicTacBoard {
    private int size;
    private int totalPlace;
    private char[][] board;
    public TicTacBoard(int size){
        this.size = size;
        board = new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = '_';
            }
        }
        totalPlace = size*size;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public boolean isWinSituation(int xPos, int yPos, char startChar) {
        boolean won = true;
        for(int j=0; j<size; j++){
            if (board[xPos][j] != startChar) {
                won = false;
                break;
            }
        }
        if(won) return true;

        won = true;
        for(int i=0; i<size; i++){
            if (board[i][yPos] != startChar) {
                won = false;
                break;
            }
        }
        if(won) return true;

        won = true;
        for(int i=0;i<size;i++){
            if(board[i][i] != startChar){
                won = false;
                break;
            }
        }
        if(won) return true;

        won = true;
        for(int i=0;i<size;i++){
            if(board[i][size-1-i] != startChar){
                won = false;
                break;
            }
        }

        return won;
    }
}
