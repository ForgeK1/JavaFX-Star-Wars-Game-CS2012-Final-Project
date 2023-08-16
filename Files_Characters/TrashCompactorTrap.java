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
   of class:    A class that will create a Trash Compactor object*/
public class TrashCompactorTrap
{
	//1) DATA FIELDS
	private Label trashCompactorTrapLabel;
	private ImageView characterIconImageView;
	
	/*Private Pane and ImageView Variables to be displayed when 
	  player loses in the game*/
	private Pane trashCompactorLoseScreenPane;
	private ImageView trashCompactorLosenScreenImageView;
	
	//2) CONSTRUCTORS
	
	public TrashCompactorTrap() 
	{
		this.trashCompactorLoseScreenPane = new Pane();
		
		this.trashCompactorTrapLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Death_Star_Trash_Compactor_Game_Icon.jpg"));
		this.trashCompactorTrapLabel.setGraphic(characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
		this.trashCompactorTrapLabel.setId("Trash Compactor Trap");
		
		/*Assigning mission dialogue text when the player detects this character*/
		this.trashCompactorTrapLabel.setEllipsisString("_____Force Sense_____ \nYou smell a heap load \nof stinking garbage and " +
													   "\ntrash nearby");
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
		
		/*Turns Trash Compactor label background to red to show that the player has been
		  defeated when they went into outer space*/
		this.trashCompactorTrapLabel.setBackground(Background.fill(Color.web("#ab3535")));
		
		/*Requests focus on this character so that the player can't move anymore since
		  the player failed or died in the game*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRoster().get(5)
					   .requestFocus();
		
		/*--------------Lose Screen Image Setup--------------*/
		
		this.trashCompactorLoseScreenPane.setTranslateX(-41.80);
		this.trashCompactorLoseScreenPane.setTranslateY(399.2);
		
		this.trashCompactorLosenScreenImageView = new ImageView(new Image("Images_Battle_Grid_Assets/Trash_Compactor_Lose_Screen.png"));
		
		this.trashCompactorLosenScreenImageView.setScaleX(0.571);
		this.trashCompactorLosenScreenImageView.setScaleY(0.575);
		
		this.trashCompactorLoseScreenPane.getChildren().add(this.trashCompactorLosenScreenImageView);
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
					   .getChildren().add(this.trashCompactorLoseScreenPane);
		
		/*--------------Lose Screen Theme Setup--------------*/
		StarWarsGameGUI.musicPlayer.stop();
		StarWarsGameGUI.mediaPlayer("src/Music_Themes/Trash_Compactor_Lose_Screen_Theme.mp3");
		StarWarsGameGUI.musicPlayer.play();
	}
	
	//Getters and Setters for private variables
	
	public Label getTrashCompactorTrapLabel() {
		return this.trashCompactorTrapLabel;
	}
	
	public void setTrashCompactorTrapLabel(Label trashCompactorTrapLabel) {
		this.trashCompactorTrapLabel = trashCompactorTrapLabel;
	}

	public ImageView getCharacterIconImageView() {
		return this.characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}

	public Pane getTrashCompactorLoseScreenPane() {
		return this.trashCompactorLoseScreenPane;
	}

	public void setTrashCompactorLoseScreenPane(Pane trashCompactorLoseScreenPane) {
		this.trashCompactorLoseScreenPane = trashCompactorLoseScreenPane;
	}	
}
