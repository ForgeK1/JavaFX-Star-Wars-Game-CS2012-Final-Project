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
   of class:    A class that will create a Naval Officer object*/
public class NavalOfficer 
{
	//1) DATA FIELDS
	private Label navalOfficerLabel;
	private ImageView characterIconImageView;
	
	//2) CONSTRUCTORS
	
	public NavalOfficer() 
	{
		this.navalOfficerLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Naval_Officer_Game_Icon.png"));
		this.navalOfficerLabel.setGraphic(this.characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
		this.navalOfficerLabel.setId("Naval Officer");
		
		/*Assigning mission dialogue text when the player detects this character*/
		this.navalOfficerLabel.setEllipsisString("_____Force Sense_____ \nAs you peak around \nthe corner, you see " +
												 "\nNaval Officers marching \ntowards your " +
												 "position");
	}
	
	//3) METHODS
	
	/*A method that describes a player interaction with Gable Karius and his naval
	  officers that cause the player to lose one lightsaber swing number per
	  interaction*/
	public void playerInteraction() 
	{
		//A print statement to check if the else statement occurs
//				System.out.println("The lightsaber Icon should be removed and updated now");
	
		/*An if-else statement to make sure that the player has used all of their lightsaber swing
		  ammo or not*/
		if(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() == 5) 
		{
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
						   .playerLoseAllAmmo();
		}
		else 
		{
			/*This nested if statement checks if the player is trying to use a Swing ammo when
			  they are at 0 swings. If not, then the program will create a new lightsaber
			  icon and increase the amount of swings used
			  
			  Note: This will the player from defeating Vader if they are at 0 swings*/
			if(!(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() == 0)) 
			{					
				//A print statement to check if the else statement occurs
//						System.out.println("The lightsaber Icon should be removed and updated now");
				
				/*We need to remove our previous lightsaber icon (Its image view and rectangle box
				  outline) every time we want to display a new number for how swings the player has
				  left*/
				StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
							   .getChildren().removeAll
					   		   (						   				   
					   				   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					   				  				  .getLightsaberSwingAmountIconImageView(),
					   				  				  
		   				  				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
		   				  				  .getLightsaberSwingAmountIconBoxOutline()
							   );
											
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   			   .setNumLightsaberSwings
				   			   (
				   					(StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   			                       .getNumLightsaberSwings() - 1)
				   			   );
				
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   .createLightsaberSwingAmountIcon();
				
				/*Increments the number of lightsaber ammo used to check if player is 
				  trying to use more than the total number of five swings given to 
				  them*/
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   .setNumLightsaberSwingsUsed
							   (
									   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
									   .getNumLightsaberSwingsUsed() + 1									   
							   );
				
				/*Creating a temp String to send to the mission dialouge to let the player 
				  about the event they encountered*/
				String newMissionDialogueText = "_______EVENT_______ \nLuke Skywalker's " +
												"\ncherished Kyber Crystal, \nintegral to his lightsaber, " +
												"\nshatters into countless \nfragments as he is forced \nback " +
												"by Gable Karius and \nhis contingent of Naval \nOfficers.";

				String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
															   .getTextForMissionDialogueDesc();
				
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
				
				/*We call this method again to reset the Scroll Pane with our new Text*/
				StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
			}
			else 
			{						
				/*Creating a temp String to send to the mission dialouge to let the player know
				  that they have used all of their swings and they need to look for more*/
				String newMissionDialogueText = "NOTICE: You cannot \ninteract with these \nNaval Officers " +
												"since \nyou have no more \nlightsaber crystals left.";

				String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
															   .getTextForMissionDialogueDesc();
				
				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
				
				/*We call this method again to reset the Scroll Pane with our new Text*/
				StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
				
				/*A print statement to check if the new text has been set for
				  the mission dialogue*/
//						System.out.println("New text has been sent out");
			}
		}
	}
	
	//Getters and Setters for private variables
	
	public Label getNavalOfficerLabel() {
		return navalOfficerLabel;
	}
	
	public void setNavalOfficerLabel(Label navalOfficerLabel) {
		this.navalOfficerLabel = navalOfficerLabel;
	}

	public ImageView getCharacterIconImageView() {
		return characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}
}
