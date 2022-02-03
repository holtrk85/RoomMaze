import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Location 
{
	public String _name ;
	private String _text = "" ;
	private List<Door> _doorList = new ArrayList<>() ;
	
	public Location()
	{
	}
	
	public Location( String name )
	{
		_name = name ;
	}
	
	public void setName( String name )
	{
		_name = name ;
	}
	
	public String getName()
	{
		return _name ;
	}
	
	public void setText( String text )
	{
		_text = text ;
	}
	
	public boolean containsDoorTo( Location location )
	{
		boolean returnValue = false  ;
		
		for( Door door : _doorList )
		{
			if( door.getNextLocation().equals( location ) )
			{
				returnValue = true ;
			}
		}
		
		return returnValue ;
	}
	
	public void addDoor( Location nextLocation )
	{
		Door door = new Door() ;
		door.setNextLocation(nextLocation);
		
		if( containsDoorTo( nextLocation ) == false )
		{
			System.err.println( "Adding door to " + _name ) ;
	    	_doorList.add( door ) ;
			nextLocation.addDoor(this);

		}
	}
	
	public Location enterLocation()
	{
		String msg = "Location: " + _name + "\n\n" ;
		msg += _text + "\n\n" ;
		msg += "You see " + _doorList.size() + " doors.\n" ;
		msg += "\n" ;
		msg += "Please select a door number you want to step through.\n" ;
		for( int i = 0 ; i < _doorList.size() ; i++ )
		{
			Door door = _doorList.get(i) ;
			int doorNum = i + 1 ;
			msg += "  " + doorNum + ". Door to " + door.getNextLocation().getName() + "\n" ;
		}
		msg += "\n" ;
		
		// Display a message asking the user to select a door.
		String reply = JOptionPane.showInputDialog(msg) ;
		
		int replyInt = Integer.parseInt(reply) ;
		int doorNumber = replyInt - 1 ;
		
		Location nextLocation = null ;
		
		if( doorNumber < 0 || doorNumber >= _doorList.size() )
		{
			// If the door number is out of range, then put up a message and reenter this room.
			JOptionPane.showMessageDialog(null, 
					                      "Invalid door number. Door number = 1-" + _doorList.size(), 
					                      "BAD DOOR", 
					                      JOptionPane.ERROR_MESSAGE );
			nextLocation = this ;
		}
		else
		{
			// Good door number so set the next location.
			nextLocation = _doorList.get( doorNumber ).getNextLocation() ;
		}
		
		return nextLocation ;
	}
}
