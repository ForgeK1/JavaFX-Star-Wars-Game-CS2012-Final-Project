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
   of class:    A class that will create a Green Kyber Crystal object*/
public class GreenKyberCrystal 
{
	//1) DATA FIELDS
	private Label greenKyberCrystalLabel;
	private ImageView characterIconImageView;
	
	//Variables to record each Kyber Crystal location
	private int kyberCrystalConstraintX;
	private int kyberCrystalConstraintY;
	
	//2) CONSTRUCTORS
	
	public GreenKyberCrystal() 
	{
		this.greenKyberCrystalLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Green_Kyber_Crystal_Game_Icon.png"));				
		this.greenKyberCrystalLabel.setGraphic(characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
//		this.greenKyberCrystalLabel.setId("Green Kyber Crystal");
		
		/*Assigning mission dialogue text when the player detects this object*/
		this.greenKyberCrystalLabel.setEllipsisString("_____Force Sense_____ \nYou see a faint glow of \ngreen around " +
													  "the corner");
	}
	
	//3) METHODS
	
	/*A method that will give the player an extra lightsaber swing
	  and dissapear from the board so that the player cannot use
	  the Kyber Crystal again*/
	public void playerInteraction() 
	{	
		//A print statement to check the number of lightsaber swings left and used
//				System.out.println("Number of Swings left: " + StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() +
//								   "\nNumber of Swings used: " + StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() + "\n");
		
		//Removes previous Lightsaber Icon
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
		   .getChildren().removeAll
		   (						   				   
				   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				  				  .getLightsaberSwingAmountIconImageView(),
				  				  
				   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
	  							  .getLightsaberSwingAmountIconBoxOutline()
		   );
		
		//Increments the number of lightsaber swings for player
		StarWarsGameGUI.getSceneInventory().getBattleGridScene()
		   			   .setNumLightsaberSwings
		   			   (
		   					StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   			   			   .getNumLightsaberSwings() + 1
		   			   );

		/*A for loop to detect the green kyber crystal the player picked up in the
		grid display to set that object to be null so that the playerMovement method 
		can ignore those objects when checking its surroundings for characters*/
		for(int row = 0; row < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRosterGridInfo().length; row++) 
		{
			for(int column = 0; column < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					  									.getCharacterRosterGridInfo()[row].length; column++) 
			{
				/*If statement checks if the position the player is looking at is empty and
				  if the character there is the green kyber crystal we are looking for*/
				if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								  .getCharacterRosterGridInfo()[row][column]
								  != null &&
						
				   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					  								  .getCharacterRosterGridInfo()[row][column].getId()
					  								  .equals(this.getGreenKyberCrystalLabel().getId())) 
				{
					StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					  			   .getCharacterRosterGridInfo()[row][column] = null;
					
					StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
								   .getChildren().remove(this.getGreenKyberCrystalLabel());
				}
			}
		}
		
		/*Removes its visibility from the board and in the character
		  interaction selection method this green kyber crystal object
		  is removed so that the player can see that they got the item
		  when in debugging mode*/
		this.greenKyberCrystalLabel.setVisible(false);	
		
		//Updates and creates the lightsaber icon based on the changes made
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().createLightsaberSwingAmountIcon();
		
		/*Checks if the status of the current label exists after being removed from the battle grid display
		  main paine*/
//				System.out.println(this.getGreenKyberCrystalLabel().getId() + " exists: " +
//								   StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
//								   				  .getChildren().contains(this.getGreenKyberCrystalLabel()) + "\n");
		
		/*Creating a temp String to send to the mission dialouge to let the player 
		  about the event they encountered*/
		String newMissionDialogueText = "_______EVENT_______ \nLuke Skywalker's eyes \nwidened " +
										"with \ndetermination as he \nsnatched up the radiant " +
										"\ngreen Kyber Crystal on \nthe Death Star, knowing \nits " +
										"potential and \nsafeguarding it for a \nfuture destined " +
										"purpose.";

		String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getTextForMissionDialogueDesc();
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
		
		/*We call this method again to reset the Scroll Pane with our new Text*/
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
	}
	
	//Getters and Setters for private variables
	
	public Label getGreenKyberCrystalLabel() {
		return greenKyberCrystalLabel;
	}
	
	public void setGreenKyberCrystalLabel(Label greenKyberCrystalLabel) {
		this.greenKyberCrystalLabel = greenKyberCrystalLabel;
	}

	public ImageView getCharacterIconImageView() {
		return characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}
}
