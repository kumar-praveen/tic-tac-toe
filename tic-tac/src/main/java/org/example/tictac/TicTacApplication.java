package org.example.tictac;

public class TicTacApplication {
    public static void main(String[] args) {
        System.out.println("Game started...");
        User u1 = new User(1, "Praveen");
        User u2 = new User(2, "Vinay");

        TicTacService service = new TicTacService(u1,u2,3);
        service.start();
    }
}