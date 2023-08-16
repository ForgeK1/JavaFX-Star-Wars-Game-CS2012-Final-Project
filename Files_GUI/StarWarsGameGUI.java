package Files_GUI;
import java.nio.file.Paths;
import java.util.Scanner;

import Files_Scenes.SceneInventory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
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
   of class:    The main GUI class that will connect the backend and
   				frontend code in order to run the JavaFX game by
   				creating and utilizing the SceneInventory class in
   				the start method.
*/
public class StarWarsGameGUI extends Application {

	//1) DATA FIELDS
	
	private static SceneInventory sceneInventory;
	public static MediaPlayer musicPlayer;
	
	//2) METHODS
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{		
		//Plays the music for the main menu screen
		mediaPlayer("src/Music_Themes/Star_Wars_Main_Theme.wav");
		StarWarsGameGUI.musicPlayer.play();
		
		//Prevents the window from being resizable
		primaryStage.setResizable(false);
		
		/*Creates an instance of SceneInventory class to pass in the primaryStage
		  so that the SceneInventory class can create the pre-filled scenes*/
		StarWarsGameGUI.sceneInventory = new SceneInventory(primaryStage);
		
		/*Utilize the displayDefaultScene from SceneInventory class to set
		  the default scene when game starts up*/
		StarWarsGameGUI.sceneInventory.displayDefaultScene(primaryStage);
	}
	
	/*The main method to launch the javaFX game*/
	public static void main(String[] args) 
	{				
		Application.launch(args);
	}
	
	/*A music method to play the several themes needed for the different scenes 
	  the player plays through*/
	public static void mediaPlayer(String fileName) 
	{			
		//Relative file path to the star wars theme in the src folder
		String filePathToMusic = fileName;
		
		Media media = new Media(Paths.get(filePathToMusic).toUri().toString());
		
		StarWarsGameGUI.musicPlayer = new MediaPlayer(media);

		StarWarsGameGUI.musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}
	
	//A getter static method to get the SceneInventory object
	public static SceneInventory getSceneInventory() 
	{
		return sceneInventory;
	}
}
