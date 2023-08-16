package Files_Characters;

import java.util.Random;

import Files_GUI.StarWarsGameGUI;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

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
   of class:    A class that will create a Darth Vader object*/
public class DarthVader 
{
	//1) DATA FIELDS
	private Label darthVaderLabel;
	private ImageView characterIconImageView;
	
	/*Private Pane and ImageView Variables to be displayed when 
	  player loses or wins the game against Darth Vader*/
	private Pane darthVaderLoseScreenPane;
	private ImageView darthVaderLoseScreenImageView;
	
	//Private variables to record Darth Vader's position
	private int darthVaderRowCoordinate;
	private int darthVaderColCoordinate;
	
	//2) CONSTRUCTORS
	
	public DarthVader() 
	{
		this.darthVaderLoseScreenPane = new Pane();
		
		this.darthVaderLabel = new Label("");
		characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Darth_Vader_Game_Icon.png"));
		this.darthVaderLabel.setGraphic(this.characterIconImageView);

		/*We set the ID for our Label so that we can access this Label*/
		this.darthVaderLabel.setId("Darth Vader");
		
		/*Assigning mission dialogue text when the player detects this character*/
		this.darthVaderLabel.setEllipsisString("_____Force Sense_____ \nYou feel the force heavy \naround you as *his*" +
											   "\nmechanical breathing  " +
											   "\nechoes louder");
	}
	
	//3) METHODS
	
	/*A method that runs if the player or Darth Vader goes into each other's space
	  and will display a lose screen*/
	public void playerLoseInteraction() 
	{
		/*--------------Vader and other Label Setup--------------*/
		
		//A for loop to display all Character Labels since the player was defeated
		for(int i = 0; i < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRoster().size(); i++) 
		{
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
			  			   .getCharacterRoster().get(i).setOpacity(1);
		}
		
		/*Turns Vader's label background to red to show that the player went into Vader's
		  space*/
		this.darthVaderLabel.setBackground(Background.fill(Color.web("#ab3535")));
		
		/*Requests focus on this character so that the player can't move anymore since
		  the player failed or died in the game*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRoster().get(1)
					   .requestFocus();
		
		/*--------------Lose Screen Image Setup--------------*/
		
		this.darthVaderLoseScreenPane.setTranslateX(-41.5);
		this.darthVaderLoseScreenPane.setTranslateY(399.5);
		
		this.darthVaderLoseScreenImageView = new ImageView(new Image("Images_Battle_Grid_Assets/Darth_Vader_Lose_Screen.png"));
		
		this.darthVaderLoseScreenImageView.setScaleX(0.57);
		this.darthVaderLoseScreenImageView.setScaleY(0.57);
		
		this.darthVaderLoseScreenPane.getChildren().add(this.darthVaderLoseScreenImageView);
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
					   .getChildren().add(this.darthVaderLoseScreenPane);
		
		/*--------------Lose Screen Theme Setup--------------*/
		StarWarsGameGUI.musicPlayer.stop();
		StarWarsGameGUI.mediaPlayer("src/Music_Themes/Darth_Vader_Lose_Screen_Theme2.wav");
		StarWarsGameGUI.musicPlayer.play();
	}
	
	public void darthVaderMovement(int rowMax, int columnMax) 
	{
		Random random = new Random();
		
		/*We will generate a random adjacent position for Vader to move such that 1 = Up,
		  2 = Left, 3 = Down, 4 = Right*/
		int randomMovement = random.nextInt(1, 5);
		
		/*Recording adjacent room positions based on player's location*/
		int darthVaderTopAdjacentRoom = this.darthVaderRowCoordinate - 1;
		int darthVaderLeftAdjacentRoom = this.darthVaderColCoordinate - 1;
		int darthVaderBottomAdjacentRoom = this.darthVaderRowCoordinate + 1;
		int darthVaderRightAdjacentRoom = this.darthVaderColCoordinate + 1;
		
		/*We will then use a switch statement to determine where Darth Vader will move.
		  
		  Note: If Vader tries to go into another character's space (other than Luke) or 
		  the map boundry wall being in the way, then Vader will not move.*/
		switch(randomMovement) 
		{
			case 1: 
				
				/*This if statement checks if the room Vader is trying to go to is the top
				  level of the map bounderies*/
				if(!(this.darthVaderRowCoordinate - 1 < 0)) 
				{
					/*These nested if-else statement checks if Darth Vader will interact with
					  the player or will check if there is another character in the position
					  they are trying to move to*/
					if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[darthVaderTopAdjacentRoom][this.darthVaderColCoordinate]
									  != null &&
							  
					   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[darthVaderTopAdjacentRoom][this.darthVaderColCoordinate]
									  .getId().equals("Luke Skywalker"))
					{
						//Plays the player's lose ending if Vader catches Luke Skywalker
						playerLoseInteraction();
					}
					else if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										   .getCharacterRosterGridInfo()[darthVaderTopAdjacentRoom][this.darthVaderColCoordinate]
										   == null) 
					{
						//Removes Vader from original position from battleGridDisplay					
						StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
						    		   .getChildren().remove(this.darthVaderLabel);
			
						/*Adds an empty Label to Vader's original position from battleGridDisplay and 
						  replaces Vader's Label with a null object in the 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
									   .getBattleGridDisplay().add(StarWarsGameGUI.getSceneInventory()
											   					   .getCharacterMAIScene().createEmptyLabel(),
											   					   this.darthVaderColCoordinate,
											   					   this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
											   						[this.darthVaderColCoordinate] = null;
						
						//Assigns Vader's new position
						this.darthVaderRowCoordinate = (this.darthVaderRowCoordinate - 1);
						
						/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   			   .getBattleGridDisplay()
						   			   .add(this.darthVaderLabel,
						   					this.darthVaderColCoordinate,
						   					this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
																	[this.darthVaderColCoordinate]
																	= this.darthVaderLabel;
						}
					else 
					{
						//A print statement to see if Vader is moving
//								System.out.println("Vader will not move up because there is no " +
//												   "space for him to move.");
					}
				}
				
				; break;
		
			case 2: 
				
				/*This if statement checks if the room Vader is trying to go to is the left most
				  side of the map bounderies*/
				if(!(this.darthVaderColCoordinate - 1 < 0)) 
				{
					/*These nested if-else statement checks if Darth Vader will interact with
					  the player or will check if there is another character in the position
					  they are trying to move to*/
					if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate][darthVaderLeftAdjacentRoom]
									  != null &&
							  
					   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate][darthVaderLeftAdjacentRoom]
									  .getId().equals("Luke Skywalker"))
					{
						//Plays the player's lose ending if Vader catches Luke Skywalker
						playerLoseInteraction();
					}
					else if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate][darthVaderLeftAdjacentRoom]
										   == null) 
					{
						//Removes Vader from original position from battleGridDisplay					
						StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
						    		   .getChildren().remove(this.darthVaderLabel);
			
						/*Adds an empty Label to Vader's original position from battleGridDisplay and 
						  replaces Vader's Label with a null object in the 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
									   .getBattleGridDisplay().add(StarWarsGameGUI.getSceneInventory()
											   					   .getCharacterMAIScene().createEmptyLabel(),
											   					   this.darthVaderColCoordinate,
											   					   this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
											   						[this.darthVaderColCoordinate] = null;
						
						//Assigns Vader's new position
						this.darthVaderColCoordinate = (this.darthVaderColCoordinate - 1);
						
						/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   			   .getBattleGridDisplay()
						   			   .add(this.darthVaderLabel,
						   					this.darthVaderColCoordinate,
						   					this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
																	[this.darthVaderColCoordinate]
																	= this.darthVaderLabel;
						}
					else 
					{
						//A print statement to see if Vader is moving
//								System.out.println("Vader will not move to the left because there is no space " +
//												   "for him to move.");
					}
				}
				
				; break;
		
			case 3: 
				
				/*This if statement checks if the room Vader is trying to go to is the bottom
				  level of the map bounderies*/
				if(!(this.darthVaderRowCoordinate + 1 > rowMax - 1)) 
				{
					/*These nested if-else statement checks if Darth Vader will interact with
					  the player or will check if there is another character in the position
					  they are trying to move to*/
					if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
							  .getCharacterRosterGridInfo()[darthVaderBottomAdjacentRoom][this.darthVaderColCoordinate]
							  != null &&
							  
					   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[darthVaderBottomAdjacentRoom][this.darthVaderColCoordinate]
									  .getId().equals("Luke Skywalker"))
					{
						//Plays the player's lose ending if Vader catches Luke Skywalker
						playerLoseInteraction();
					}
					else if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
							  .getCharacterRosterGridInfo()[darthVaderBottomAdjacentRoom][this.darthVaderColCoordinate]
							  == null) 
					{
						//Removes Vader from original position from battleGridDisplay					
						StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
						    		   .getChildren().remove(this.darthVaderLabel);
			
						/*Adds an empty Label to Vader's original position from battleGridDisplay and 
						  replaces Vader's Label with a null object in the 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
									   .getBattleGridDisplay().add(StarWarsGameGUI.getSceneInventory()
											   					   .getCharacterMAIScene().createEmptyLabel(),
											   					   this.darthVaderColCoordinate,
											   					   this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
											   						[this.darthVaderColCoordinate] = null;
						
						//Assigns Vader's new position
						this.darthVaderRowCoordinate = (this.darthVaderRowCoordinate + 1);
						
						/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   			   .getBattleGridDisplay()
						   			   .add(this.darthVaderLabel,
						   					this.darthVaderColCoordinate,
						   					this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
																	[this.darthVaderColCoordinate]
																	= this.darthVaderLabel;
						}
					else 
					{
						//A print statement to see if Vader is moving
//								System.out.println("Vader will not move down because there is no space " +
//										   		   "for him to move.");
					}
				}
				
				; break;
		
			case 4: 
				
				/*This if statement checks if the room Vader is trying to go to is the left most
				  side of the map bounderies*/
				if(!(this.darthVaderColCoordinate + 1 > columnMax - 1)) 
				{
					/*These nested if-else statement checks if Darth Vader will interact with
					  the player or will check if there is another character in the position
					  they are trying to move to*/
					if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
							  .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate][darthVaderRightAdjacentRoom]
							  != null &&
							  
					   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate][darthVaderRightAdjacentRoom]
									  .getId().equals("Luke Skywalker"))
					{
						//Plays the player's lose ending if Vader catches Luke Skywalker
						playerLoseInteraction();
					}
					else if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
							  .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate][darthVaderRightAdjacentRoom]
							  == null) 
					{
						//Removes Vader from original position from battleGridDisplay					
						StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
						    		   .getChildren().remove(this.darthVaderLabel);
			
						/*Adds an empty Label to Vader's original position from battleGridDisplay and 
						  replaces Vader's Label with a null object in the 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
									   .getBattleGridDisplay().add(StarWarsGameGUI.getSceneInventory()
											   					   .getCharacterMAIScene().createEmptyLabel(),
											   					   this.darthVaderColCoordinate,
											   					   this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
											   						[this.darthVaderColCoordinate] = null;
						
						//Assigns Vader's new position
						this.darthVaderColCoordinate = (this.darthVaderColCoordinate + 1);
						
						/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
						StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   			   .getBattleGridDisplay()
						   			   .add(this.darthVaderLabel,
						   					this.darthVaderColCoordinate,
						   					this.darthVaderRowCoordinate);
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									   .getCharacterRosterGridInfo()[this.darthVaderRowCoordinate]
																	[this.darthVaderColCoordinate]
																	= this.darthVaderLabel;
						}
					else 
					{
						//A print statement to see if Vader is moving
//								System.out.println("Vader will not move to the left because there is no space " +
//												   "for him to move.");
					}
				}
				
				; break;
				
				default: ;
		}
	}
	
	//Getters and Setters for private variables
	
	public Label getDarthVaderLabel() {
		return this.darthVaderLabel;
	}
	
	public void setDarthVaderLabel(Label DarthVaderLabel) {
		this.darthVaderLabel = DarthVaderLabel;
	}

	public ImageView getCharacterIconImageView() {
		return this.characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}

	public Pane getDarthVaderLoseScreenPane() {
		return this.darthVaderLoseScreenPane;
	}

	public void setDarthVaderLoseScreenPane(Pane darthVaderLoseScreenPane) {
		this.darthVaderLoseScreenPane = darthVaderLoseScreenPane;
	}

	public int getDarthVaderRowCoordinate() {
		return darthVaderRowCoordinate;
	}

	public void setDarthVaderRowCoordinate(int darthVaderRowCoordinate) {
		this.darthVaderRowCoordinate = darthVaderRowCoordinate;
	}

	public int getDarthVaderColCoordinate() {
		return darthVaderColCoordinate;
	}

	public void setDarthVaderColCoordinate(int darthVaderColCoordinate) {
		this.darthVaderColCoordinate = darthVaderColCoordinate;
	}
}
