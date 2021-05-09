import java.util.*;


public class tictactoe {
    public static void menu(){
        System.out.println("Welcome player");
        System.out.println("Please type in where you would like to make your move");
    }
    public static void main(String[] args){
        System.out.println("Welcome players to my TicTacToe game, there are nine spots");
        System.out.println("Player 1, please input your name");
        Scanner s1 = new Scanner(System.in);
        String p1 = s1.nextLine();
        System.out.println("Player 2, please input your name");
        Scanner s2 = new Scanner(System.in);
        String p2 = s2.nextLine();
        board b = new board(p1,p2);
        do{
            menu();
            Scanner s = new Scanner(System.in);


        }while(b.getCount() != 9 && !b.checkWin());

    }
}

class player{
    public int [] sum;
    public String name;
    public player next;
    public player(String name){
        next = null;
        sum = new int[5];
        for(int i = 0; i <5; i++){
            sum[i] = 0;
        }
        this.name = name;
    }
    public String toString(){
        return "Player: " + name + " has won!!";
    }
}

class board{
    private int count = 0;
    private int move = 0;
    private player p1;
    private player p2;
    private player[] p = new player[2];
    private String[][] b = new String[3][3];
    private int[][] bi = new int[3][3];

    public board(String p1a, String p2a){
        int k = 0;
        count = 0;
        this.p1 = new player(p1a);
        this.p2 = new player(p2a);
        p[0] = p1;
        p[1] = p2;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = "-";
                bi[i][j] = (i+1) * (j+1) + k;
            }
            k+=3;
        }
    }
    public boolean checkWin(){

    }
    public void printBoard(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(b[i][j]);
                System.out.println(bi[i][j]);
            }
        }
    }
    
    public void setCount(){
        count++;
    }
    public int getCount(){
        return count;
    }

    public void makeMove(){
        boolean valid = true;
        //if move is 0 then its p1 turn
        if(move == 0){
            while(valid) {
                System.out.println("Hello player 1 make your move by picking the number between 1 and 9");
                printBoard();
                Scanner sc1 = new Scanner(System.in);
                int s1 = sc1.nextInt();
                break;
            }
        }
        else{
            while(valid) {
                System.out.println("Hello player 1 make your move by picking the number between 1 and 9");
                printBoard();
                Scanner sc1 = new Scanner(System.in);
                int s1 = sc1.nextInt();
                break;
            }
        }
    }
}