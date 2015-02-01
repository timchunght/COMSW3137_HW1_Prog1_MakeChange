
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

}
