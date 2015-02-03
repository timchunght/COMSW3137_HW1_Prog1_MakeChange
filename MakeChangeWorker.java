import java.util.ArrayList;
import java.util.Arrays;

public class MakeChangeWorker 
{
	private int amount;
	public MakeChangeWorker(int amount) 
	{
		this.amount = amount;
	}

	//index is used with VALUES, it avoids recursive branching
	public void findCombinations(int amount, int index, int[] coinCounts) 
	{
		int[] VALUES = { 5, 10, 25 };
		//System.out.println("amount:" + amount + " Coin counts: " + Arrays.toString(coinCounts) + " index: " + index);

		//return an empty AL of size 0 if amount is not divisible by 5
		if (amount % 5 != 0)
		{
			System.out.println(amount + " cannot be changed.");
		}
		//if amount is 0, we should have reached a combo, so add array/combo to AL
		else if (amount == 0) 
		{
			printCombo(coinCounts);
			
			
			
		}
		else
		{
		//Start from the given index, 0 is the index for nickel, 1 for dime, and 2 for quarter
			for (int i = index; i < 3; i++) 
			{
				
				if (VALUES[i] <= amount) 
				{
					//prepare a duplicate coinCounts array for recursion
					int[] newCoinCounts = coinCounts.clone();
					
					newCoinCounts[i] = newCoinCounts[i] + 1;
					
					findCombinations(amount - VALUES[i], i, newCoinCounts);
	
				}
			}
		}
		
		
	}
	
	//Takes an int[] of counts as arguments, int[0] is count of nickel, int[1] is count of dime, int[2] is count of quarter
	private void printCombo(int[] combo)
	{
		System.out.print("Change for " + this.amount + " = ");
		for(int i = 0; i < 3; i++)
		{ 
			if(i == 0)
			{
				for(int j = 0; j < combo[i]; j++)
				{
					System.out.print(5 + " ");
				}
				
				
			}
			else if(i == 1)
			{
				for(int j = 0; j < combo[i]; j++)
				{
					System.out.print(10 + " ");
				}
				
				
			}
			else if(i == 2)
			{
				for(int j = 0; j < combo[i]; j++)
				{
					System.out.print(25 + " ");
				}
				
				
			}

		}
		System.out.println();
	}

}
