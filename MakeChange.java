public class MakeChange 
{
   public static void main (String[] args) 
    {
	    int amount = Integer.parseInt(args[0]);
	    MakeChangeWorker makeChange = new MakeChangeWorker(amount);
	    makeChange.findCombinations(amount, 0, new int[3]);
	
    }

}


