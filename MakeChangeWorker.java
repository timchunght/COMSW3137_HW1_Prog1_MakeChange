import java.util.ArrayList;

public class MakeChangeWorker {

	public MakeChangeWorker() 
	{

	}


	public ArrayList<int[]> findCombinations(int amount, int[] coinCounts,
			ArrayList<int[]> combinations, int index) 
	{
		int[] VALUES = { 5, 10, 25 };

		if (amount % 5 != 0)
		{
			return combinations;
		}

		
		if (amount == 0) 
		{
			combinations.add(coinCounts);
			
		}

		
		for (int i = index; i < VALUES.length; i++) 
		{
			
			if (VALUES[i] <= amount) 
			{
				
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
		
		if (combinations.size() == 0) 
		{
			System.out.println(amount + " can't be changed.");
			
		}
		
		for (int s = 0; s < combinations.size(); s++) 
		{
			System.out.print("Change for " + amount + " = ");
			for (int i = 0; i < VALUES.length; i++) 
			{
				for (int j = 0; j < combinations.get(s)[i]; j++) 
				{
					System.out.print(VALUES[i] + " ");
				}
			}
			System.out.println();
		}
	}

}
