import java.util.*;
import org.w2mind.net.*;

public class SeanMind implements Mind 
{	 	 
	
	public void newrun()  throws RunError 
	{
	}

	public void endrun()  throws RunError
	{
	}
	
	/* The following is a list of scenario's that should generate a move from Peg A to Peg C
	   If the scenario occurs, return true */
	private static boolean move_Left_to_Right(String left, String middle, String right)
	{
		if(middle.equals("empty") && right.equals("empty") || left.equals("345") && middle.equals("12") && right.equals("empty")
			|| left.equals("145") && middle.equals("empty") && right.equals("23") || left.equals("125") && middle.equals("34") && right.equals("empty")
			|| left.equals("5") && middle.equals("1234") && right.equals("empty") || left.equals("1") && middle.equals("34") && right.equals("25")
			|| left.equals("123") && middle.equals("empty") && right.equals("45") || left.equals("3") && middle.equals("12") && right.equals("45")
			|| left.equals("1") && middle.equals("empty") && right.equals("2345"))
				return true;
		else return false;
	}
	
	/* The following is a list of scenario's that should generate a move from Peg A to Peg B
	   If the scenario occurs, return true */
	private static boolean move_Left_to_Middle(String left, String middle, String right)
	{
	
		if(left.equals("2345") && middle.equals("empty") && right.equals("1") || left.equals("45") && middle.equals("empty") && right.equals("123")
			|| left.equals("25") && middle.equals("34") && right.equals("1") || left.equals("23") && middle.equals("empty") && right.equals("145"))
				return true;
		else return false;
	}
	
	/* The following is a list of scenario's that should generate a move from Peg C to Peg A
	   If the scenario occurs, return true */
	private static boolean move_Right_to_Left(String left, String middle, String right)
	{
		if(left.equals("5") && middle.equals("14") && right.equals("23") || left.equals("3") && middle.equals("14") && right.equals("25"))
				return true;
		else return false;
	}
	
	/* The following is a list of scenario's that should generate a move from Peg C to Peg B
	   If the scenario occurs, return true */
	private static boolean move_Right_to_Middle(String left, String middle, String right)
	{
		if(left.equals("345") && middle.equals("2") && right.equals("1") || left.equals("5") && middle.equals("4") && right.equals("123")
			|| left.equals("125") && middle.equals("4") && right.equals("3") || left.equals("5") && middle.equals("234") && right.equals("1")
			|| left.equals("3") && middle.equals("4") && right.equals("125") || left.equals("3") && middle.equals("2") && right.equals("145"))
				return true;
		else return false;
	}
	
	/* The following is a list of scenario's that should generate a move from Peg B to Peg A
	   If the scenario occurs, return true */
	private static boolean move_Middle_to_Left(String left, String middle, String right)
	{
		if(left.equals("45") && middle.equals("12") && right.equals("3") || left.equals("25") && middle.equals("14") && right.equals("3")
			|| left.equals("empty") && middle.equals("1234") && right.equals("5") || left.equals("empty") && middle.equals("34") && right.equals("125")
			|| left.equals("23") && middle.equals("14") && right.equals("5") || left.equals("empty") && middle.equals("12") && right.equals("345"))
				return true;
		else return false;
	}
	
	/* The following is a list of scenario's that should generate a move from Peg B to Peg C
	   If the scenario occurs, return true */
	private static boolean move_Middle_to_Right(String left, String middle, String right)
	{
		if(left.equals("145") && middle.equals("2") && right.equals("3") || left.equals("1") && middle.equals("234") && right.equals("5")
			|| left.equals("123") && middle.equals("4") && right.equals("5") || left.equals("1") && middle.equals("2") && right.equals("345"))
				return true;
		else return false;
	}
	
	public Action getaction ( State state )
	{ 
		String s = state.toString();	 
		String[] x = s.split(",");			   

		/* Peg A */
		String left = x[0];
		
		/* Peg B */
		String middle = x[1];
		
		/* Peg C */
		String right = x[2];
		
		int i = 0;

		/* Checking through all possible scenarios that could arise within the run 
		   If one scenario occurs, act upon on it with the correct Action */
		if (move_Left_to_Right(left, middle, right) == true)
			i = HanoiTower.TAKE_LEFT_MOVE_RIGHT;
			
		else if(move_Left_to_Middle(left, middle, right) == true)
			i = HanoiTower.TAKE_LEFT_MOVE_MIDDLE;
			
		else if(move_Right_to_Left(left, middle, right) == true)
			i = HanoiTower.TAKE_RIGHT_MOVE_LEFT;

		else if(move_Right_to_Middle(left, middle, right) == true)
			i = HanoiTower.TAKE_RIGHT_MOVE_MIDDLE;
			
		else if(move_Middle_to_Left(left, middle, right) == true)
			i = HanoiTower.TAKE_MIDDLE_MOVE_LEFT;
			
		else if(move_Middle_to_Right(left, middle, right) == true)
			i = HanoiTower.TAKE_MIDDLE_MOVE_RIGHT;	
		
		
		String a = String.format ( "%d", i );

		/* If Mind has not completed its run, recursively create a new Action */
		return new Action ( a );		 
	}
}