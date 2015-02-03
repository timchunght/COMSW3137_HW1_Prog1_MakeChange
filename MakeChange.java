import java.util.ArrayList;


public class MakeChange 
{
   public static void main (String[] args) 
    {
       
	
	    int amount = Integer.parseInt(args[0]);
	  
	    

	    MakeChangeWorker makeChange = new MakeChangeWorker();
	    makeChange.printCombinations(makeChange.findCombinations(amount, new int[3], new ArrayList<int[]>(), 0), amount);
	
    }

}


