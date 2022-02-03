
public class Door 
{
	private Location _nextLocation ;
	
	public Door()
	{}
	
	public void setNextLocation( Location nextLocation ) 
	{
		_nextLocation = nextLocation ;
	}
	
	public Location getNextLocation()
	{
		return _nextLocation ;
	}
}
