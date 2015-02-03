import java.util.ArrayList;

public class MakeChangeWorker 
{

	public MakeChangeWorker() 
	{

	}


	public ArrayList<int[]> findCombinations(int amount, int[] coinCounts,
			ArrayList<int[]> combinations, int index) 
	{
		int[] VALUES = { 5, 10, 25 };
		
		//return the an empty AL of size 0 if amount is not divisible by 5
		if (amount % 5 != 0)
		{
			return combinations;
		}

		//if amount is 0, we should have reached a combo, so add array/combo to AL
		if (amount == 0) 
		{
			combinations.add(coinCounts);
			
		}

		//Start from the given index, 0 is the index for nickel, 1 for dime, and 2 for quarter
		for (int i = index; i < VALUES.length; i++) 
		{
			
			if (VALUES[i] <= amount) 
			{
				//prepare a duplicate coinCounts array for recursion
				int[] newCoinCounts = (int[]) coinCounts.clone();
				newCoinCounts[i]++;

				combinations = findCombinations(amount - VALUES[i], newCoinCounts, combinations, i);

			}
		}
		
		return combinations;
	}

	public void printCombinations(ArrayList<int[]> combinations, int amount) 
	{
		int[] VALUES = { 5, 10, 25 };
		
		ArrayList<String> output = new ArrayList<String>();
		if (combinations.size() == 0) 
		{
			System.out.println(amount + " can't be changed.");
			
		}
		
		for (int s = 0; s < combinations.size(); s++) 
		{
			String header = "Change for " + amount + " = ";
			for (int i = 0; i < VALUES.length; i++) 
			{
				for (int j = 0; j < combinations.get(s)[i]; j++) 
				{
					header+=(VALUES[i] + " ");
				}
			}
			output.add(header);
		}
		
		for( String s : output)
		{
			System.out.println(s);
		}
	}

}
