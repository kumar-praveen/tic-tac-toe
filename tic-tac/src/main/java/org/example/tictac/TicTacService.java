package org.example.tictac;


import java.util.Scanner;

public class TicTacService {
    private final TicTacBoard board;
    private final User u1;
    private final User u2;
    private GameStatus status;

    public TicTacService(User u1, User u2, int n){
        board = new TicTacBoard(n);
        this.u1 = u1;
        this.u2 = u2;
        status = GameStatus.TO_BEGIN;
    }

    public void start(){
        status = GameStatus.STARTED;
        System.out.println(status);

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter starting player name: ");
        String startingPlayerName = scn.next();
        User currPlayer = startingPlayerName.equals(u1.getName()) ? u1 : u2;
        System.out.println("Enter char to start with ie (X or O)");
        char startChar = scn.next().charAt(0);
        boolean gameStatus = false;
        System.out.println("Enter as per turn ");

        while(board.getTotalPlace() > 0){
            System.out.println(currPlayer+" turn.. ");
            int xPos = scn.nextInt();
            int yPos = scn.nextInt();

            if(xPos >= board.getSize() || yPos >= board.getSize() ||
                    board.getBoard()[xPos][yPos] != '_'){
                System.out.println("Not valid position..");
                continue;
            }
            board.getBoard()[xPos][yPos] = startChar;
            if(board.isWinSituation(xPos,yPos, startChar)){
                gameStatus = true;
                break;
            }

            startChar = startChar == 'X' ? 'O' : 'X';
            currPlayer = currPlayer.equals(u1) ? u2 : u1;
            board.setTotalPlace(board.getTotalPlace() - 1);
            board.printBoard();
        }
        status = GameStatus.END;
        System.out.println(status);
        board.printBoard();
        if(gameStatus){
            System.out.println(currPlayer+" won the game...");
        }else {
            System.out.println("Match Draw....");
        }
        scn.close();
    }

}
