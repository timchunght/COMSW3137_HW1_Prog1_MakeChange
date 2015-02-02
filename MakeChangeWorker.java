import java.util.ArrayList;


public class MakeChangeWorker 
{
	
	
	public MakeChangeWorker()
	{
		
		
	}
	
	/**
	public void test()
	{
		System.out.println(amount);
	}
	**/
	
	public void calcChange(int amount)
	{
		
		if(amount%5 != 0)
		{
			System.out.println(amount + " can't be changed");
		}
		else if(amount/5 == 1)
		{
			System.out.println("5");
			
		}
		else if(amount >= 25)
		{
			amount = amount % 25;
			System.out.println(amount);
			calcChange(amount);
			
		}
		
		
			
	}
	
	public ArrayList<int[]> search(int amount, int[] current, 
            ArrayList<int[]> solutions, int max)
    {
		int[] COINS = {5, 10, 25};
        // Since all the coins are multiples of 5, return an empty array if
        // the amount is not a multiple of 5. This results in an empty array
        // for any inputted amount that is not a multiple of 5.
        if (amount % 5 != 0) return solutions;
        
        // A valid solution has been calculated. Store the current solution.
        if (amount == 0)
        {
            solutions.add(current);
            return solutions;
        }
        
        // Only start from max to reduce the amount of cases to check.
        for (int i = max; i < COINS.length; i++)
        {
            // If the coin being checked is less than the amount, recurse.
            if (COINS[i] <= amount)
            {
                // Clone array and modify accordingly.
                int[] tempCurrent = (int[]) current.clone();
                tempCurrent[i]++;
                solutions = search(amount - COINS[i], 
                        tempCurrent, solutions, i);
            }
        }
        return solutions;
    }
	
	public void printSolutions(ArrayList<int[]> solutions, int amount)
    {
		int[] COINS = {5, 10, 25};
        // If ArrayList is empty, tell user.
        if(solutions.isEmpty())
        {
            System.out.println(amount + " can't be changed.");
            return;
        }
        // Otherwise, print all the solutions.
        for (int[] solution : solutions)
        {
            System.out.print("Change for " + amount + " = ");
            for (int i = 0; i < COINS.length; i++)
            {
                for(int j = 0; j < solution[i]; j++)
                {
                    System.out.print(COINS[i] + " ");
                }
            }
            System.out.println();
        }   
    }

}
