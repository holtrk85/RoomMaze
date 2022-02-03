
public class RoomMaze 
{
	public RoomMaze() 
	{
		super();
		
		_defineRooms() ;
		
	}
	
	private void _defineRooms() 
	{
		Location entrance = new Location("Side Entrance") ;
		Location kitchen = new Location("Kitchen") ;
		Location patio = new Location("Patio") ;
		Location hallway = new Location("Hallway") ;
		Location livingRoom = new Location("Living Room") ;
		Location frontPorch = new Location("Front Porch") ;
		Location tomsBedroom = new Location("Tom's Room") ;
		Location alexisRoom = new Location("Alexis' Room") ;
		Location hallCloset1 = new Location("Small Hall Closet") ;
		Location masterBed = new Location("Mom & Dad's Room") ;
		Location hallCloset2 = new Location("Big Hall Closet") ;
		Location hallBath = new Location("Kids Bathroom") ;
		
		entrance.setText( "You are standing at the entrance to the house." ) ;
		entrance.addDoor(kitchen);
		
		kitchen.setText( "You are standing in the kitchen." ) ;
		kitchen.addDoor(entrance);
		kitchen.addDoor(patio);
		kitchen.addDoor(hallway);
		kitchen.addDoor(livingRoom);
		
		patio.setText( "You are standing on patio." ) ;
		patio.addDoor(kitchen);
		
		hallway.setText( "You are standing in the hallway.") ;
		hallway.addDoor( kitchen );
		hallway.addDoor(livingRoom);
		hallway.addDoor(tomsBedroom);
		hallway.addDoor(alexisRoom);
		hallway.addDoor(hallCloset1);
		hallway.addDoor(masterBed);
		hallway.addDoor(hallCloset2);
		hallway.addDoor(hallBath);
		hallway._name = "Test" ;
		
		livingRoom.setText("You are standing in the living room.");
		livingRoom.addDoor(frontPorch);
		
		Location currentLocation = entrance ;
		while( true )
			currentLocation = currentLocation.enterLocation() ;
	}

	public static void main( String[] args )
	{
		new RoomMaze() ;
	}
}
