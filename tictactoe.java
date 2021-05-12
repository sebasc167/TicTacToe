import java.util.*;


public class tictactoe {
    public static void menu(){
        System.out.println("Welcome player");
        //System.out.println("Please type in where you would like to make your move");
    }
    public static void main(String[] args){
        int k = 0;
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
            b.printBoard();
            b.printNumyBoard();
            Scanner s = new Scanner(System.in);
            b.printName(k);
            int n = s.nextInt();
            if(!b.checkMove(n))
                continue;
            b.makeMove(n);
            if(k==0)
                k++;
            else
                k--;
            b.setk(k);
        }while(b.getCount()!= 9 && b.checkWin()!= 1 && b.checkWin() != 2);


    }
}

class player{
    public int [] sum;
    public String name;
    public player(String name){
        this.name = name;
    }
    public String toString(){
        return "Player: " + name ;
    }
}

class board {
    private int count = 0;
    private int k = 0;
    private int move = 0;
    private player p1;
    private player p2;
    private player[] p = new player[2];
    private String[][] b = new String[3][3];
    private int[][] bn = new int[3][3];
    HashMap<Integer, Integer[]> ho = new HashMap<>();

    public board(String p1a, String p2a) {
        int k = 0;
        count = 0;
        this.p1 = new player(p1a);
        this.p2 = new player(p2a);
        p[0] = p1;
        p[1] = p2;
        ho.put(1, new Integer[]{0, 0});
        ho.put(2, new Integer[]{0, 1});
        ho.put(3, new Integer[]{0, 2});
        ho.put(4, new Integer[]{1, 0});
        ho.put(5, new Integer[]{1, 1});
        ho.put(6, new Integer[]{1, 2});
        ho.put(7, new Integer[]{2, 0});
        ho.put(8, new Integer[]{2, 1});
        ho.put(9, new Integer[]{2, 2});
        fillBoard();
    }

    public void setk(int s){
        this.k = s;
    }

    public void fillBoard() {
        //fills board in O^2 time
        for (int k = 0; k < 3; k++) {
            for (int n = 0; n <= 2; n++) {
                b[k][n] = "-";
                bn[k][n] = 3 * k + n + 1;
            }
        }
    }

    public void printBoard() {
        System.out.println(" -------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + b[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println(" -------------");
        System.out.println();
    }

    public void printNumyBoard() {
        System.out.println(" -------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + bn[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println(" -------------");
    }

    public void setCount() {
        count++;
    }

    public int getCount() {
        if(count == 9)
            System.out.println("There seems to be a tie");
        return count;
    }

    public boolean checkMove(int s) {
        if (s > 9 || s < 1) {
            System.out.println("The number you entered is out of bounds");
            return false;
        }
        int[] coor = new int[2];
        Integer[] c = ho.get(s);
        for (int i = 0; i < 2; i++) {
            coor[i] = c[i];
        }
        if (b[coor[0]][coor[1]] == "X" || b[coor[0]][coor[1]] == "O") {
            System.out.println("The number with the slot you have selected is already full, try again");
            return false;
        } else {
            return true;
        }

    }

    public void makeMove(int s) {
        int[] coor = new int[2];
        Integer[] c = ho.get(s);
        for (int i = 0; i < 2; i++) {
            coor[i] = c[i];
        }
        b[coor[0]][coor[1]] = (k == 0) ? "X" : "O";
        k++;
        System.out.println("Thank you for making a move!\n");
        setCount();
    }

    public void printName(int s){
        if(s==0){
            System.out.println(p1 + " , it is your turn, please pick a number between 1 and 9, see the map below");
        }
        else
            System.out.println(p2 + " , it is your turn, please pick a number between 1 and 9, see the map below");
    }

    public int checkWin(){
        // 3 if tie, 1 if p1, 2 if p2
        for(int i = 0; i < 3; i++){
            int xcount1 = 0, ocount1 = 0;
            for(int j = 0; j < 3; j++){
                if(b[i][j] == "X")
                    xcount1++;
                else if(b[i][j] == "O")
                    ocount1++;
            }
            if(xcount1 == 3){
                System.out.println("You have won: " + p1.name);
                return 1;
            }
            else if(ocount1 == 3){
                System.out.println("You have won: " + p2.name);
                return 2;
            }
        }
        for(int i = 0; i < 3; i++){
            int xcount1 = 0, ocount1 = 0;
            for(int j = 0; j < 3; j++){
                if(b[j][i] == "X")
                    xcount1++;
                else if(b[j][i] == "O")
                    ocount1++;
            }
            if(xcount1 == 3){
                System.out.println("You have won: " + p1.name);
                return 1;
            }
            else if(ocount1 == 3)
            {
                System.out.println("You have won: " + p2.name);
                return 2;
            }

        }
        if(b[0][0].equals(b[1][1]) && b[1][1].equals(b[2][2]) && b[2][2].equals("X")){
            System.out.println("You have won: " + p2.name);
            return 2;
        }
        else if(b[0][0].equals(b[1][1]) && b[1][1].equals(b[2][2]) && b[2][2].equals("O")){
            System.out.println("You have won: " + p2.name);
            return 2;
        }
        return 3;
    }
}
