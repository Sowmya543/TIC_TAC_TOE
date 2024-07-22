import java.util.*;

public class Game 
{

	static char[] board;
	static char player = 'X';

	static void gameboard()
    	{
        	System.out.println("|-----|-----|-----|");
        	System.out.println("|  "+board[0]+"  |  "+board[1]+"  |  "+board[2]+"  |");
        	System.out.println("|-----------------|");
        	System.out.println("|  "+board[3]+"  |  "+board[4]+"  |  "+board[5]+"  |");
        	System.out.println("|-----------------|");
        	System.out.println("|  "+board[6]+"  |  "+board[7]+"  |  "+board[8]+"  |");
        	System.out.println("|-----|-----|-----|");
    	}

	static void play()
	{
		Scanner sc=new Scanner(System.in);
		int place;
		while(true)
		{
			System.out.println(player+"'s turn, Enter your move: ");
			place=sc.nextInt();
			if(place>0 && place<10 && (board[place-1]!='X' || board[place-1]!='O'))
			{
				board[place-1]=player;
				break;
			}
			else
				System.out.println("Invalid move.");
		}
	}

	static void turn()
	{
		player=(player=='X')?'O':'X';
	}

	static boolean winner()
    	{
        	String check=null;
        	for(int i=0;i<8;i++)
        	{
            		switch(i)
            		{
                	case 0:
                    		check=board[0]+""+board[1]+""+board[2];
                    		break;
                	case 1:
                    		check=board[3]+""+board[4]+""+board[5];
                    		break;
                	case 2:
                    		check=board[6]+""+board[7]+""+board[8];
                    		break;
                	case 3:
                    		check=board[0]+""+board[3]+""+board[6];
                    		break;
                	case 4:
                    		check=board[1]+""+board[4]+""+board[7];
                    		break;
                	case 5:
                    		check=board[2]+""+board[5]+""+board[8];
                    		break;
                	case 6:
                    		check=board[0]+""+board[4]+""+board[8];
                    		break;
                	case 7:
                    		check=board[2]+""+board[4]+""+board[6];
                    		break;
            		}
        	}
        	if(check.equals("XXX") || check.equals("OOO"))
			return true;
		else
			return false;
    	}

	static boolean draw() 
	{
        	for (int i = 0; i < 9; i++) 
		{
                	if (board[i]!='X' && board[i]!='O')
                    		return false;
        	}
        	return true;
    	}

	static void mainaccess()
	{
		board = new char[9];

		for (int a = 0; a < 9; a++)
			board[a] = Character.forDigit((a+1),10);
		System.out.println("Welcome to TIC-TAC-TOE game(3x3 board)");
		gameboard();
		System.out.println("Let's Start-->");
		while (true) 
		{
            		play();
            		gameboard();
            		if (winner()) 
			{
                		System.out.println("Player " + player + " wins!");
                		break;
            		}
            		if (draw()) 
			{
                		System.out.println("The game is a draw!");
                		break;
            		}
            		turn();
        	}
	}

	public static void main(String[] args)
	{	
		while(true)
		{
			mainaccess();
			Scanner sc=new Scanner(System.in);
			System.out.println("1 - Replay the game");
			System.out.println("2 - Exit");
			int choice=sc.nextInt();
			if(choice==1)
				mainaccess();
			else
				System.out.println("Exiting...");
				return;
    		}
	}

}
