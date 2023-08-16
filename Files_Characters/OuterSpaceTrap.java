package Files_Characters;

import Files_GUI.StarWarsGameGUI;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
   of class:    A class that will create a Outer Space Trap object*/
public class OuterSpaceTrap
{
	//1) DATA FIELDS
	private Label outerSpaceTrapLabel;
	private ImageView characterIconImageView;
	
	/*Private Pane and ImageView Variables to be displayed when 
	  player loses in the game*/
	private Pane outerSpaceLoseScreenPane;
	private ImageView outerSpaceLosenScreenImageView;
	
	//2) CONSTRUCTORS
	
	public OuterSpaceTrap() 
	{
		this.outerSpaceLoseScreenPane = new Pane();
		
		this.outerSpaceTrapLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Outer_Space_Death_Star_Game_Icon.png"));
		this.outerSpaceTrapLabel.setGraphic(characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
		this.outerSpaceTrapLabel.setId("Outer Space Trap");
		
		/*Assigning mission dialogue text when the player detects this character*/
		this.outerSpaceTrapLabel.setEllipsisString("_____Force Sense_____ \nYou see a room with a \nwarning sign saying: " +
												   "\n\"OUTER SPACE SHUTTLE\"");
	}
	
	//3) METHODS
	
	//A method that runs if Luke interacts with this character
	public void playerInteraction() 
	{
		/*--------------Outerspace and other Label Setup--------------*/
		
		//A for loop to display all Character Labels since the player was defeated
		for(int i = 0; i < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRoster().size(); i++) 
		{
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
			  			   .getCharacterRoster().get(i).setOpacity(1);
		}
		
		/*Turns Outer Space label background to red to show that the player has been
		  defeated when they went into outer space*/
		this.outerSpaceTrapLabel.setBackground(Background.fill(Color.web("#ab3535")));
		
		/*Requests focus on this character so that the player can't move anymore since
		  the player failed or died in the game*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRoster().get(5)
					   .requestFocus();
		
		/*--------------Lose Screen Image Setup--------------*/
		
		this.outerSpaceLoseScreenPane.setTranslateX(-41.80);
		this.outerSpaceLoseScreenPane.setTranslateY(399.2);
		
		this.outerSpaceLosenScreenImageView = new ImageView(new Image("Images_Battle_Grid_Assets/Outer_Space_Lose_Screen.png"));
		
		this.outerSpaceLosenScreenImageView.setScaleX(0.571);
		this.outerSpaceLosenScreenImageView.setScaleY(0.575);
		
		this.outerSpaceLoseScreenPane.getChildren().add(this.outerSpaceLosenScreenImageView);
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
					   .getChildren().add(this.outerSpaceLoseScreenPane);
		
		/*--------------Lose Screen Theme Setup--------------*/
		StarWarsGameGUI.musicPlayer.stop();
		StarWarsGameGUI.mediaPlayer("src/Music_Themes/Outer_Space_Lose_Screen_Theme.mp3");
		StarWarsGameGUI.musicPlayer.play();
	}
	
	//Getters and Setters for private variables
	
	public Label getOuterSpaceTrapLabel() {
		return outerSpaceTrapLabel;
	}
	
	public void setOuterSpaceTrapLabel(Label outerSpaceTrapLabel) {
		this.outerSpaceTrapLabel = outerSpaceTrapLabel;
	}

	public ImageView getCharacterIconImageView() {
		return this.characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}

	public Pane getOuterSpaceLoseScreenPane() {
		return this.outerSpaceLoseScreenPane;
	}

	public void setOuterSpaceLoseScreenPane(Pane outerSpaceLoseScreenPane) {
		this.outerSpaceLoseScreenPane = outerSpaceLoseScreenPane;
	}
}
