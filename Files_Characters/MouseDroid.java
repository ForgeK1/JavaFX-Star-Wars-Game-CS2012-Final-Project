package Files_Characters;

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
   of class:    A class that will create a Mouse Droid object*/
public class MouseDroid 
{
	//1) DATA FIELDS
	private Label mouseDroidLabel;
	private ImageView characterIconImageView;
	
	//2) CONSTRUCTORS
	
	public MouseDroid() 
	{
		this.mouseDroidLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Mouse_Droid_Game_Icon.png"));
		this.mouseDroidLabel.setGraphic(this.characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
		this.mouseDroidLabel.setId("Mouse Droid");
		
		/*Assigning mission dialogue text when the player detects this character*/
		this.mouseDroidLabel.setEllipsisString("_____Force Sense_____ \nYou hear loud mouse \nnoises getting " +
											   "closer on \nyour location!");
	}
	
	//3) METHODS
	
	/*A method that will create the interaction between the player
	  and the mouse droid. While also moving Vader around*/
	public void playerInteraction() 
	{
		int rowMax = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getCharacterRosterGridInfo().length;
		int columnMax = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getCharacterRosterGridInfo()[0].length;
		
		//Calls Darth Vader movement method to move Vader to an adjacent room
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getDarthVader().darthVaderMovement(rowMax, columnMax);
		
		/*Creating a temp String to send to the mission dialouge to let the player 
		  about the event they encountered*/
		String newMissionDialogueText = "_______EVENT_______ \nThe mischievous mouse \ndroid's " +
										"inadvertent \ntriggering of alarms \ncaught Luke Skywalker's " + 
										"\nattention, unwittingly \nluring Darth Vader ever \ncloser " + 
										"to his vulnerable \nposition";

		String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getTextForMissionDialogueDesc();
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
		
		/*We call this method again to reset the Scroll Pane with our new Text*/
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
	}
	
	//Getters and Setters for private variables
	
	public Label getMouseDroidLabel() {
		return this.mouseDroidLabel;
	}
	
	public void setMouseDroidLabel(Label MouseDroidLabel) {
		this.mouseDroidLabel = MouseDroidLabel;
	}

	public ImageView getCharacterIconImageView() {
		return characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}
}
