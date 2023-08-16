package Files_Characters;

import Files_GUI.StarWarsGameGUI;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

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
   of class:    A class that will create a Luke Skywalker object*/
public class LukeSkywalker 
{
	//1) DATA FIELDS
	private Label lukeSkywalkerLabel;
	private ImageView characterIconImageView;
	
	//Variables to record player's position
	private int playerRowCoordinate;
	private int playerColCoordinate;
	
	/*Private Pane and ImageView Variables to be displayed when 
	  player wins the game against Darth Vader*/
	private Pane lukeSkywalkerWinScreenPane;
	private ImageView lukeSkywalkerWinScreenImageView;
	
	/*Private Pane and ImageView Variables to be displayed when 
	  player uses all of the lightsaber swings they have*/
	private Pane lightsaberSwingAmountLoseScreenPane;
	private ImageView lightsaberSwingAmountLoseScreenImageView;
	
	//2) CONSTRUCTORS
	
	public LukeSkywalker() 
	{
		this.lukeSkywalkerWinScreenPane = new Pane();
		
		this.lightsaberSwingAmountLoseScreenPane = new Pane();
		
		this.lukeSkywalkerLabel = new Label("");
		this.characterIconImageView = new ImageView (new Image("Images_Character_Game_Icons/Luke_Skywalker_Game_Icon.png"));				
		this.lukeSkywalkerLabel.setGraphic(characterIconImageView);
		
		/*We set the ID for our Label so that we can access this Label*/
		this.lukeSkywalkerLabel.setId("Luke Skywalker");
	}
	
	//3) METHODS
	
	/*A method that runs if Luke defeats Darth Vader by swinging his
	  lightsaber at him*/
	public void playerWinInteraction() 
	{
		/*--------------Luke and other Label Setup--------------*/
		
		//A for loop to display all Character Labels since the player won
		for(int i = 0; i < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRoster().size(); i++) 
		{
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
			  			   .getCharacterRoster().get(i).setOpacity(1);
		}
		
		/*Turns Vader's label background to green to show that the player defeated
		  Vader*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getDarthVader()
					   .getDarthVaderLabel().setBackground(Background.fill(Color.GREEN));
		
		/*Requests focus on this character so that the player can't move anymore since
		  the player won the game*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRoster().get(1)
					   .requestFocus();
		
		/*--------------Win Screen Image Setup--------------*/
		
		this.lukeSkywalkerWinScreenPane.setTranslateX(-41.5);
		this.lukeSkywalkerWinScreenPane.setTranslateY(399.5);
		
		this.lukeSkywalkerWinScreenImageView = new ImageView(new Image("Images_Battle_Grid_Assets/Luke_Skywalker_Win_Screen.png"));
		
		this.lukeSkywalkerWinScreenImageView.setScaleX(0.57);
		this.lukeSkywalkerWinScreenImageView.setScaleY(0.57);
		
		this.lukeSkywalkerWinScreenPane.getChildren().add(this.lukeSkywalkerWinScreenImageView);
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
					   .getChildren().add(this.lukeSkywalkerWinScreenPane);
		
		/*--------------Win Screen Theme Setup--------------*/
		StarWarsGameGUI.musicPlayer.stop();
		StarWarsGameGUI.mediaPlayer("src/Music_Themes/Luke_Skywalker_Win_Screen_Theme.mp3");
		StarWarsGameGUI.musicPlayer.play();
	}
	
	/*A method that will run if the player uses all of their lightsaber swings (including the
	  ones they can pick up)*/
	public void playerLoseAllAmmo() 
	{
		/*--------------Luke and other Label Setup--------------*/
		
		//A for loop to display all Character Labels since the player won
		for(int i = 0; i < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRoster().size(); i++) 
		{
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
			  			   .getCharacterRoster().get(i).setOpacity(1);
		}
		
		/*Turn's Luke's label to red because Luke has used all of the ammo that is
		  accessable to defeat Darth Vader*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
					   .getLukeSkywalkerLabel().setBackground(Background.fill(Color.web("#ab3535")));
		
		/*Requests focus on Darth Vader so that the player can't move anymore since
		  the player lost the game*/
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRoster().get(1)
					   .requestFocus();
		
		/*--------------Lose Screen Image Setup--------------*/
		
		this.lightsaberSwingAmountLoseScreenPane.setTranslateX(-41.5);
		this.lightsaberSwingAmountLoseScreenPane.setTranslateY(399.5);
		
		this.lightsaberSwingAmountLoseScreenImageView = new ImageView(new Image("Images_Battle_Grid_Assets/Lightsaber_Swing_Amount_Lose_Screen.png"));
		
		this.lightsaberSwingAmountLoseScreenImageView.setScaleX(0.57);
		this.lightsaberSwingAmountLoseScreenImageView.setScaleY(0.57);
		
		this.lightsaberSwingAmountLoseScreenPane.getChildren().add(this.lightsaberSwingAmountLoseScreenImageView);
		
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
					   .getChildren().add(this.lightsaberSwingAmountLoseScreenPane);
		
		/*--------------Lose Screen Theme Setup--------------*/
		StarWarsGameGUI.musicPlayer.stop();
		StarWarsGameGUI.mediaPlayer("src/Music_Themes/Lightsaber_Swing_Amount_Lose_Screen_Theme.mp3");
		StarWarsGameGUI.musicPlayer.play();
	}
	
	//Getters and Setters for private variables
	
	public Label getLukeSkywalkerLabel() {
		return lukeSkywalkerLabel;
	}
	
	public void setLukeSkywalkerLabel(Label lukeSkywalkerLabel) {
		this.lukeSkywalkerLabel = lukeSkywalkerLabel;
	}

	public ImageView getCharacterIconImageView() {
		return characterIconImageView;
	}	

	public void setCharacterIconImageView(ImageView characterIconImageView) {
		this.characterIconImageView = characterIconImageView;
	}

	public int getPlayerRowCoordinate() {
		return this.playerRowCoordinate;
	}
	
	public void setPlayerRowCoordinate(int playerRowCoordinate) {
		this.playerRowCoordinate = playerRowCoordinate;
	}

	public int getPlayerColCoordinate() {
		return this.playerColCoordinate;
	}
	
	public void setPlayerColCoordinate(int playerColCoordinate) {
		this.playerColCoordinate = playerColCoordinate;
	}

	public Pane getLukeSkywalkerWinScreenPane() {
		return lukeSkywalkerWinScreenPane;
	}

	public void setLukeSkywalkerWinScreenPane(Pane lukeSkywalkerWinScreenPane) {
		this.lukeSkywalkerWinScreenPane = lukeSkywalkerWinScreenPane;
	}

	public Pane getLightsaberSwingAmountLoseScreenPane() {
		return lightsaberSwingAmountLoseScreenPane;
	}

	public void setLightsaberSwingAmountLoseScreenPane(Pane lightsaberSwingAmountLoseScreenPane) {
		this.lightsaberSwingAmountLoseScreenPane = lightsaberSwingAmountLoseScreenPane;
	}
}
