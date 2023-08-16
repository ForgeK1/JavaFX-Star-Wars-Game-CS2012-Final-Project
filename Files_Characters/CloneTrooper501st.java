package Files_Characters;

import java.util.Random;

import Files_GUI.StarWarsGameGUI;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * Name:        Keyvan Mahmoodzadeh Kani
 * CIN:         401528761
 * Course:      INTRO TO PROGRAMMING II 
 * Section:     CS 2012-01
 * Description: For this assignment you will be implementing a game.  
 				In this game you control a character armed with a 
 				mystical weapon that can only be used a limited 
 				number of times.  The player traverses through a 
 				series of caves to hunt down a mythical creature of 
 				some type. Along the way there will be traps and 
 				enemies to deal with and magical ammo to find.  
 				What follows is a general description of the elements
 				I would like you to implement.  It is up to you to 
 				come up with a backstory for your game as well as 
 				the types of enemies you want to implement.  
 				Be creative, make this your own game. My examples 
 				are purely examples and you may not use my examples. 
 				You choose your own monsters and hazards as long as 
 				you have the requirements I want, feel free to be as 
 				creative as possible.  Choose any genre you wish, it 
 				does not have to be a fantasy setting.
				
   Description
   of class:    A class that will create a 501st Clone Trooper object*/
public class CloneTrooper501st 
{
	//1) DATA FIELDS
	private Label cloneTrooper501stLabel;
	private ImageView characterIconImageView;
	
	//2) CONSTRUCTORS
	
	public CloneTrooper501st() 
	{
		this.cloneTrooper501stLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Clone_Trooper_501st_Game_Icon.png"));
		this.cloneTrooper501stLabel.setGraphic(this.characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
		this.cloneTrooper501stLabel.setId("501st Clone Trooper");
		
		/*Assigning mission dialogue text when the player detects this character*/
		this.cloneTrooper501stLabel.setEllipsisString("_____Force Sense_____ \nYou hear 501st clone \ntroopers walking nearby");
	}
	
	//3) METHODS
	
	/*This method will randomly place Luke on the map after his interaction
	  with the 501st clones*/
	public void playerInteraction() 
	{
		Random random = new Random();
		
		int randomRowPlacement = 0;
		int randomColPlacement = 0;
		
		int rowMax = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getCharacterRosterGridInfo().length;
		int columnMax = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getCharacterRosterGridInfo()[0].length;
		
		boolean continueLoop = true;
		
		while(continueLoop) 
		{
			randomRowPlacement = random.nextInt(0, rowMax);
			randomColPlacement = random.nextInt(0, columnMax);
			
			/*An if statement that checks if the position the player is being sent is null (empty)
			  so that the player does not accidently occupy another character's space*/
			if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								.getCharacterRosterGridInfo()[randomRowPlacement][randomColPlacement]
								== null) 
			{
				//Removes Luke from original position from battleGridDisplay					
				StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
				    		   .getChildren().remove
				    		   (
				    				   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
													  .getLukeSkywalker().getLukeSkywalkerLabel()
				    		   );
	
				/*Adds an empty Label to Luke's original position from battleGridDisplay and 
				  replaces Luke label with a null object in the 2D array info*/
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   .getBattleGridDisplay().add(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   									  .createEmptyLabel(),
						   								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						   												  .getLukeSkywalker().getPlayerColCoordinate(),
			   											   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
			   											   				  .getLukeSkywalker().getPlayerRowCoordinate());
				
				StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
							   .getCharacterRosterGridInfo()[StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerRowCoordinate()]
														    [StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerColCoordinate()] 
												   		    = null;
				
				//Assigns Luke's new position
				StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
							   .setPlayerRowCoordinate(randomRowPlacement);
				
				StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
							   .setPlayerColCoordinate(randomColPlacement);
				
				/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   			   .getBattleGridDisplay()
				   			   .add(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getLukeSkywalkerLabel(),
				   					StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerColCoordinate(),
				   					StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerRowCoordinate());
				
				StarWarsGameGUI.getSceneInventory()
							   .getCharacterMAIScene()
							   .getCharacterRosterGridInfo()
							   [StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerRowCoordinate()]
							   [StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerColCoordinate()]
							   = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getLukeSkywalkerLabel();
			
				continueLoop = false;
			}
		}
		
		/*Creating a temp String to send to the mission dialouge to let the player 
		  about the event they encountered*/
		String newMissionDialogueText = "_______EVENT_______ \n501st Stormtroopers \nhave spotted Luke  " +
										"\nSkywalker! Due to their \nlarge size in numbers \nLuke had to " +
										"make a \nrun for it!";

		String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getTextForMissionDialogueDesc();
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
		
		/*We call this method again to reset the Scroll Pane with our new Text*/
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
	}
	
	//Getters and Setters for private variables
	
	public Label getCloneTrooper501stLabel() {
		return cloneTrooper501stLabel;
	}
	
	public void setCloneTrooper501stLabel(Label cloneTrooper501stLabel) {
		this.cloneTrooper501stLabel = cloneTrooper501stLabel;
	}

	public ImageView getCharacterIconImageView() {
		return this.characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}
}
