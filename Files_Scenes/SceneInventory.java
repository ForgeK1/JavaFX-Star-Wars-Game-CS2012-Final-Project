package Files_Scenes;
import java.nio.file.Paths;
import java.util.ArrayList;

import Files_Characters.CharacterMechanicsAndInteractions;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

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
 				some type.  Along the way there will be traps and 
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
   of class:    A class that will contain all of the pre-filled Scenes
   				for our game. A pre-filled scene is a scene that contains
   				all of the panes and components that make up the scene
   				(ex. Main Menu scene is a pre-filled scene that will display
   				 the menu title, buttons, images, etc.)*/
public class SceneInventory
{
	//1) Data Fields
	
	//An ArrayList to fill all of the scenes we need for the game
	private ArrayList<Scene> sceneInventory = new ArrayList<Scene>();
	
	//A series of class objects
	private MainMenuScene mainMenuScene;
	private LevelSelectorScene levelSelectorScene;
	private BattleGridScene battleGridScene;
	private CharacterMechanicsAndInteractions characterMAIScene;
	
	//2) CONSTRUCTORS
	
	/*A constructor to instantiate our class scene objects, 
	  call their get scene methods from each class to create 
	  our pre-filled scenes, and the returning scene from the
	  getter to our sceneInventory ArrayList object*/
	public SceneInventory(Stage primaryStage) 
	{
		//Instantiating our class scene objects
		this.mainMenuScene = new MainMenuScene(primaryStage, sceneInventory);
		this.levelSelectorScene = new LevelSelectorScene(primaryStage, sceneInventory);
		this.battleGridScene = new BattleGridScene(primaryStage, sceneInventory);
		this.characterMAIScene = new CharacterMechanicsAndInteractions(primaryStage, sceneInventory);
		
		//Main Menu Scene (index 0)
		this.sceneInventory.add(this.mainMenuScene.getMainMenuScreen());
		
		//Level Selector Scene (index 1)
		this.sceneInventory.add(this.levelSelectorScene.getLevelSelectorScreen());
		
		//Battle Grid Scene (index 2)
		this.sceneInventory.add(this.battleGridScene.getBattleGridScreen());
	}
	
	//3) METHODS
	
	/*A method to display our default scene (Main Menu) when the player starts 
	  up the game everytime*/
	public void displayDefaultScene(Stage primaryStage) 
	{		
		primaryStage.setTitle("Rebel Strike! The Final Showdown Against Darth Vader!");
		primaryStage.setScene(sceneInventory.get(0));
		primaryStage.show();
	}
	
	//Getter Methods for class scene objects
	
	public MainMenuScene getMainMenuScene() 
	{
		return this.mainMenuScene;
	}
	
	public LevelSelectorScene getLevelSelectorScene() 
	{
		return this.levelSelectorScene;
	}
	
	public BattleGridScene getBattleGridScene() 
	{
		return this.battleGridScene;
	}
	
	public CharacterMechanicsAndInteractions getCharacterMAIScene() 
	{
		return this.characterMAIScene;
	}
}
