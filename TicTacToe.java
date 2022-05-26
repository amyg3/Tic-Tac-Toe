import java.util.Scanner;
import java.util.ArrayList;

public class TicTacToe 
{
    public static void main(String[] args) 
    {
        char[][] board = new char[3][3];
        for(int r=0; r<board.length; r++)
        {
            for(int c=0; c<board[r].length; c++)
            {
                board[r][c]='-';
            }
        }
        Scanner input = new Scanner(System.in);
        
        System.out.println("Print row and column in the format of r,c with no added space";
        int i=3;
        while(isWon(board)==false && i<12)
        {
            if(i%2==0)
                System.out.println("Player 2 enter row, column: ");
            else 
                System.out.println("Player 1 enter row, column: ");
            String line = input.nextLine();
            String[] tokens = line.split(",");
            int row = Integer.parseInt(tokens[0]);
            int column = Integer.parseInt(tokens[1]);

            if(i%2==0 && board[row-1][column-1]=='-')
            {
                board[row-1][column-1]='O';
            }
            else if(i%2!=0 && board[row-1][column-1]=='-') 
            {
                board[row-1][column-1]='X';
            }
            else if(board[row-1][column-1]!='-')
            {
                System.out.println("Space already filled");
                i--;
            }
            for(int r=0; r<board.length; r++)
            {
                for(int c=0; c<board[r].length; c++)
                {
                System.out.print(board[r][c]+"\t");
                }
                System.out.println();
            }
            i++;
        }
        
        if(isWon(board)==false && i==12)
            System.out.println("Draw");
        else if (isWon(board)==true && i%2==0)
            System.out.println("Player 1 won!");
        else if (isWon(board)==true && i%2!=0)
            System.out.println("Player 2 won!");
    }

    public static boolean isWon(char[][] board)
    {
        if((board[0][0]=='X' && board[0][1]=='X' && board[0][2]=='X') 
        || board[0][0]=='O' && board[0][1]=='O' && board[0][2]=='O')
            return true;
        if((board[1][0]=='X' && board[1][1]=='X' && board[1][2]=='X') 
        || board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O')
            return true;
        if((board[2][0]=='X' && board[2][1]=='X' && board[2][2]=='X') 
        || board[2][0]=='O' && board[2][1]=='O' && board[2][2]=='O')
            return true;
        if((board[0][0]=='X' && board[1][0]=='X' && board[2][0]=='X') 
        || board[0][0]=='O' && board[1][0]=='O' && board[2][0]=='O')
            return true;
        if((board[0][1]=='X' && board[1][1]=='X' && board[2][1]=='X') 
        || board[0][1]=='O' && board[1][1]=='O' && board[2][1]=='O')
            return true;
        if((board[0][2]=='X' && board[1][2]=='X' && board[2][2]=='X') 
        || board[0][2]=='O' && board[1][2]=='O' && board[2][2]=='O')
            return true;
        if((board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X') 
        || board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
            return true;
        if((board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X') 
        || board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
            return true;
        else 
            return false;
    }
}
