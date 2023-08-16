package Files_Scenes;
import java.util.ArrayList;
import java.util.Random;

import Files_GUI.StarWarsGameGUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
   of class:    A class that will display the level selector menu of
   				our game*/
public class LevelSelectorScene 
{
	//1) DATA FIELDS
	
	//Private Variables to add onto or change the scene
	private Stage primaryStage;
	private ArrayList<Scene> sceneInventory;
	
	/*Private variables to be accessed Lambda
	  Expression Events*/
	private Button fivexFiveGridButton;
	private ImageView fivexFiveGridButtonImageView;
	private Button sevenxSevenGridButton;
	private ImageView sevenxSevenGridButtonImageView;
	private Button sevenxTenGridButton;
	private ImageView sevenxTenGridButtonImageView;
	private Button randomGridButton;
	private ImageView randomGridButtonImageView;
	private Button backButton;
	private ImageView backButtonImageView;
	
	/*A private ArrayList that contains several songs
	  to play for any grid game the player chooses*/
	private ArrayList<String> listOfSongs;
		
	//2) CONSTRUCTORS
	
	public LevelSelectorScene(Stage primaryStage, ArrayList<Scene> sceneInventory) 
	{
		this.primaryStage = primaryStage;
		this.sceneInventory = sceneInventory;
		
		this.listOfSongs = new ArrayList<String>();
	}
	
	//3) METHODS
	
	public Scene getLevelSelectorScreen() 
	{
		/*__________________1) Panes_____________________*/
		
		//A default Stack Pane to put on our window
		StackPane mainPane = new StackPane();
		
		mainPane.setStyle("-fx-background-color: #000749;");
		
		/*__________________2) Components________________*/
		
		/*A series of methods that will add components to our level
		  selector scene*/
		
		addWallpaperBackground(mainPane);
		
		createBackground(mainPane);
		
		createStoryTitleAndDescription(mainPane);
		
		createGridBattleTitleAndHollowBox(mainPane);
		
		fillListOfSong();
		
		createGridBattleButtons(mainPane);

		backToMainMenuButton(mainPane);
		
		/*__________________3) Scene(s)__________________*/
		
		/*Assigns mainPane to mainScene for with a 700x700 blue 
		  background screen*/
		Scene mainScene = new Scene(mainPane, 700, 700, javafx.scene.paint.Color.web("#000749"));
		
		return mainScene;
	}
	
	//A method to add our wallpaper background to our level selector menu
	public void addWallpaperBackground(StackPane mainPane) 
	{
		ImageView backgroundWallpaper = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Darth_Vader_And_Luke_Level_Selector_Background.jpg"));
		
		backgroundWallpaper.setScaleX(0.5);
		backgroundWallpaper.setScaleY(0.5);
		backgroundWallpaper.setTranslateY(40);
		backgroundWallpaper.setOpacity(0.8);
		
		mainPane.getChildren().add(backgroundWallpaper);
	}
	
	/*A method to implment the background images and the blue outline on 
	the level selector screen*/
	public void createBackground(StackPane mainPane) 
	{
		//IMAGE BORDERS and OUTLINE BORDER FOR ALL IMAGES
		
		ImageView leftBorder = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Left_Border.png"));
		
		//Configuring left border image view settings
		leftBorder.setScaleX(1);
		leftBorder.setScaleY(1);
		leftBorder.setTranslateX(-389);
		
		ImageView rightBorder = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Right_Border.png"));
		
		//Configuring right border image view settings
		rightBorder.setScaleX(1);
		rightBorder.setScaleY(1);
		rightBorder.setTranslateX(390);
		
		//Top and Bottom Image Borders
		
		ImageView topBorderVersion1Part1 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Light_Bulb_Border.jpg"));
		
		topBorderVersion1Part1.setScaleX(0.8);
		topBorderVersion1Part1.setScaleY(1);
		topBorderVersion1Part1.setTranslateX(-360);
		topBorderVersion1Part1.setTranslateY(-316);
		
		ImageView topBorderVersion1Part2 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Light_Bulb_Border.jpg"));
		
		topBorderVersion1Part2.setScaleX(0.8);
		topBorderVersion1Part2.setScaleY(1);
		topBorderVersion1Part2.setTranslateX(360);
		topBorderVersion1Part2.setTranslateY(-316);
		
		ImageView topBorderVersion2Part1 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Top_Border.jpg"));
		
		topBorderVersion2Part1.setScaleX(1);
		topBorderVersion2Part1.setScaleY(1);
		topBorderVersion2Part1.setTranslateX(-167);
		topBorderVersion2Part1.setTranslateY(-316);
		
		ImageView topBorderVersion2Part2 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Top_Border.jpg"));
		
		topBorderVersion2Part2.setScaleX(1);
		topBorderVersion2Part2.setScaleY(1);
		topBorderVersion2Part2.setTranslateX(167);
		topBorderVersion2Part2.setTranslateY(-316);
		
		//Special Border for the Top Section of the Screen
		ImageView topSpecialBorder = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Top_Special_Border.jpg"));
		
		topSpecialBorder.setScaleX(1.39);
		topSpecialBorder.setScaleY(1.39);
		topSpecialBorder.setTranslateX(0);
		topSpecialBorder.setTranslateY(-315);
		
		ImageView bottomBorderVersion1Part1 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Light_Bulb_Border.jpg"));
		
		bottomBorderVersion1Part1.setScaleX(0.8);
		bottomBorderVersion1Part1.setScaleY(1);
		bottomBorderVersion1Part1.setTranslateX(-360);
		bottomBorderVersion1Part1.setTranslateY(316);
		
		ImageView bottomBorderVersion1Part2 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Light_Bulb_Border.jpg"));
		
		bottomBorderVersion1Part2.setScaleX(0.8);
		bottomBorderVersion1Part2.setScaleY(1);
		bottomBorderVersion1Part2.setTranslateX(360);
		bottomBorderVersion1Part2.setTranslateY(316);
		
		ImageView bottomBorderVersion2Part1 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Bottom_Border.jpg"));
		
		bottomBorderVersion2Part1.setScaleX(1);
		bottomBorderVersion2Part1.setScaleY(1);
		bottomBorderVersion2Part1.setTranslateX(-167);
		bottomBorderVersion2Part1.setTranslateY(316);
		
		ImageView bottomBorderVersion2Part2 = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Bottom_Border.jpg"));
		
		bottomBorderVersion2Part2.setScaleX(1);
		bottomBorderVersion2Part2.setScaleY(1);
		bottomBorderVersion2Part2.setTranslateX(167);
		bottomBorderVersion2Part2.setTranslateY(316);
		
		//Special Border for the Bottom Section of the Screen
		ImageView bottomSpecialBorder = new ImageView(new Image("Images_Main_Menu_And_Level_Selector_Assets/Bottom_Special_Border.jpg"));
		
		bottomSpecialBorder.setScaleX(1.39);
		bottomSpecialBorder.setScaleY(1.39);
		bottomSpecialBorder.setTranslateX(0);
		bottomSpecialBorder.setTranslateY(351);
		
		/*A rectangle outline border to surround all of the images
		  
		  Rectangle Paramters: setX, setY, setWidth, setHeight, 
		  setArcWidth, setArcHeight*/
		Rectangle outlineBorderForImages = new Rectangle(0, 0, 553.5, 563);
		
		//Configuring settings for outlineBorderForImages
		outlineBorderForImages.setFill(null);
		outlineBorderForImages.setStroke(Color.CYAN);
		outlineBorderForImages.setStrokeWidth(3);
		
		mainPane.getChildren().addAll(leftBorder, rightBorder, 
									  topBorderVersion1Part1, topBorderVersion1Part2, 
									  topBorderVersion2Part1, topBorderVersion2Part2, 
									  topSpecialBorder,
									  bottomBorderVersion1Part1, bottomBorderVersion1Part2,
									  bottomBorderVersion2Part1, bottomBorderVersion2Part2,
									  bottomSpecialBorder, 
									  outlineBorderForImages);
	}
	
	/*A method to create the story box that will tell the player
	  lore of the game*/
	public void createStoryTitleAndDescription(StackPane mainPane) 
	{
		//SETTING UP BORDERPANE
		
		BorderPane storyBorderPane = new BorderPane();
		
		//Configuring settings for the storyBox Border Pane
		storyBorderPane.setMaxSize(500, 200);
		storyBorderPane.setTranslateY(-130);
		
		//SETTING UP STORY TITLE
		
		Text storyTitleText = new Text("MISSION");
		
		//Configuring story title text settings
		storyTitleText.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		storyTitleText.setFill(Color.CYAN);
		storyTitleText.setStroke(Color.BLACK);
		storyTitleText.setStrokeWidth(0.6);
		storyTitleText.setScaleX(4.5);
		storyTitleText.setScaleY(4.5);
		storyTitleText.setTranslateY(-19.5);
		
		/*From Java Code Junkie's YouTube Tutorial video, I learned that Border Pane has
		  a default alightnment for Top, Left, Center, Right, and Bottom of the screen. But
		  because I didn't like those alighnment settings I learned to change it through
		  the setAlighnment method below.
		  
	      Note: Please refer to Number 7 from the Word Cited txt file to see the website
	      		I used*/
		BorderPane.setAlignment(storyTitleText, Pos.CENTER);
		
		//Sets Story title at the top of the border pane
		storyBorderPane.setTop(storyTitleText);
		
		//SETTING UP DESCRIPTION BOX FOR THE BORDER PANE
		
		StackPane storyBoxStackPane = new StackPane();
		Rectangle storyBoxDescription = new Rectangle(500, 200);
		Text storyTextDescription = new Text
				("Luke Skywalker embarks on a perilous mission to infiltrate "
			   + "\nthe Death Star and confront Darth Vader in a final battle to "
			   + "\nsave the galaxy from the Empire's reign of terror. He must "
			   + "\nnavigate the station's treacherous corridors and evade  "
			   + "\nstormtroopers and deadly traps before facing his father in "
			   + "\nan epic lightsaber duel. The fate of the galaxy rests on Luke's "
			   + "\nshoulders as he confronts the Dark Lord of the Sith.");
		
		//Configuring story box description and story text description settings
		storyBoxDescription.setFill(Color.web("#000749"));
		storyBoxDescription.setStroke(Color.CYAN);
		storyBoxDescription.setOpacity(0.5);
		
		storyTextDescription.setFont(Font.font("verdana", FontWeight.BOLD, 13));
		storyTextDescription.setFill(Color.CYAN);
		storyTextDescription.setStroke(Color.BLACK);
		storyTextDescription.setStrokeWidth(0.5);
		storyTextDescription.setScaleX(1.05);
		storyTextDescription.setScaleY(1.05);
		storyTextDescription.setTextAlignment(TextAlignment.CENTER);
		storyTextDescription.setLineSpacing(8);
		
		/*Sets both the box and its description in a stackpane before attachig it to
		  the center of the border pane*/
		storyBoxStackPane.getChildren().addAll(storyBoxDescription, storyTextDescription);
		
		storyBorderPane.setCenter(storyBoxStackPane);
		
		mainPane.getChildren().add(storyBorderPane);
	}
	
	public void createGridBattleTitleAndHollowBox(StackPane mainPane) 
	{
		//SETTING UP BORDERPANE
		
		BorderPane gridBorderPane = new BorderPane();
		
		//Configuring settings for the storyBox Border Pane
		gridBorderPane.setMaxSize(500, 200);
		gridBorderPane.setTranslateY(150);
		
		//SETTING UP STORY TITLE
		
		Text gridTitleText = new Text("SELECT BATTLE GRID");
		
		//Configuring story title text settings
		gridTitleText.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		gridTitleText.setFill(Color.CYAN);
		gridTitleText.setStroke(Color.BLACK);
		gridTitleText.setStrokeWidth(0.6);
		gridTitleText.setScaleX(3.7);
		gridTitleText.setScaleY(3.7);
		gridTitleText.setTranslateY(-15.5);
		BorderPane.setAlignment(gridTitleText, Pos.CENTER);
		
		//Sets Story title at the top of the border pane
		gridBorderPane.setTop(gridTitleText);
		
		//SETTING UP HOLLOW BOX
				
		Rectangle gridHollowBox = new Rectangle(500, 200);
		
		//Configuring grid hollow box settings
		gridHollowBox.setFill(Color.web("#000749"));
		gridHollowBox.setStroke(Color.CYAN);
		gridHollowBox.setOpacity(0.5);
		
		/*Attaches the hollow box to the center of the Border Pane*/
		gridBorderPane.setCenter(gridHollowBox);
		
		mainPane.getChildren().addAll(gridBorderPane);
	}
	
	/*A method to create and apply functionality of the 5x5, 7x7, 
	  7x10, and Random buttons*/
	public void createGridBattleButtons(StackPane mainPane) 
	{								
		//5 x 5 Grid Button
		this.fivexFiveGridButton = new Button("");
		
		Image fivexFiveGridButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/FivexFive_Grid_Button_(Not_Highlighted).png");
		this.fivexFiveGridButtonImageView = new ImageView(fivexFiveGridButtonImage);
		
		this.fivexFiveGridButton.setTranslateX(-120);
		this.fivexFiveGridButton.setTranslateY(115);
		this.fivexFiveGridButton.setScaleX(0.13);
		this.fivexFiveGridButton.setScaleY(0.13);
		
		this.fivexFiveGridButtonImageView.setScaleX(1.60);
		this.fivexFiveGridButtonImageView.setScaleY(1.60);	
		
		this.fivexFiveGridButton.setGraphic(fivexFiveGridButtonImageView);
		
		//7 x 7 Grid Button
		this.sevenxSevenGridButton = new Button("");
		
		Image sevenxSevenGridButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxSeven_Grid_Button_(Not_Highlighted).png");
		this.sevenxSevenGridButtonImageView = new ImageView(sevenxSevenGridButtonImage);
		
		this.sevenxSevenGridButton.setTranslateX(120);
		this.sevenxSevenGridButton.setTranslateY(115);
		this.sevenxSevenGridButton.setScaleX(0.13);
		this.sevenxSevenGridButton.setScaleY(0.13);
		
		this.sevenxSevenGridButtonImageView.setScaleX(1.60);
		this.sevenxSevenGridButtonImageView.setScaleY(1.60);
		
		this.sevenxSevenGridButton.setGraphic(sevenxSevenGridButtonImageView);
		
		//7 x 10 Grid Button
		this.sevenxTenGridButton = new Button("");
		
		Image sevenxTenGridButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxTen_Grid_Button_(Not_Highlighted).png");
		this.sevenxTenGridButtonImageView = new ImageView(sevenxTenGridButtonImage);
		
		this.sevenxTenGridButton.setTranslateX(-120);
		this.sevenxTenGridButton.setTranslateY(205);
		this.sevenxTenGridButton.setScaleX(0.13);
		this.sevenxTenGridButton.setScaleY(0.13);
		
		this.sevenxTenGridButtonImageView.setScaleX(1.60);
		this.sevenxTenGridButtonImageView.setScaleY(1.60);	
		
		this.sevenxTenGridButton.setGraphic(sevenxTenGridButtonImageView);	
		
		//Random Grid Selector Button
		this.randomGridButton = new Button("");
		
		Image randomGridButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/Random_Grid_Button_(Not_Highlighted).png");
		this.randomGridButtonImageView = new ImageView(randomGridButtonImage);
		
		this.randomGridButton.setTranslateX(120);
		this.randomGridButton.setTranslateY(205);
		this.randomGridButton.setScaleX(0.13);
		this.randomGridButton.setScaleY(0.13);
		
		this.randomGridButtonImageView.setScaleX(1.60);
		this.randomGridButtonImageView.setScaleY(1.60);	
		
		this.randomGridButton.setGraphic(randomGridButtonImageView);	
		
		//GIVING FUNCTIONALITY TO BUTTONS
		
		/*A series of Lambda Expressions to change how the button looks  
		  when the mouse hovers over, exits the space of, or pressed on
		  the play button*/	
		
		//-------FivexFive Grid Button Lambda Expressions-------
		this.fivexFiveGridButton.setOnMouseEntered(e -> 
		{
			/*Setting new image for the image view that will be the graphic
			  of button*/
			this.fivexFiveGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/FivexFive_Grid_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.fivexFiveGridButton.setScaleX(0.13);
			this.fivexFiveGridButton.setScaleY(0.13);
			this.fivexFiveGridButtonImageView.setScaleX(1.60);
			this.fivexFiveGridButtonImageView.setScaleY(1.60);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.fivexFiveGridButton.setGraphic(fivexFiveGridButtonImageView);
		}); 
		
		this.fivexFiveGridButton.setOnMouseExited(e -> 
		{
			this.fivexFiveGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/FivexFive_Grid_Button_(Not_Highlighted).png"));
			
			this.fivexFiveGridButton.setScaleX(0.13);
			this.fivexFiveGridButton.setScaleY(0.13);
			this.fivexFiveGridButtonImageView.setScaleX(1.60);
			this.fivexFiveGridButtonImageView.setScaleY(1.60);	
			
			this.fivexFiveGridButton.setGraphic(fivexFiveGridButtonImageView);
		}); 
		
		this.fivexFiveGridButton.setOnMousePressed(e -> 
		{
			this.fivexFiveGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/FivexFive_Grid_Button_(Pressed).png"));
			
			this.fivexFiveGridButton.setScaleX(0.13);
			this.fivexFiveGridButton.setScaleY(0.13);
			this.fivexFiveGridButtonImageView.setScaleX(1.60);
			this.fivexFiveGridButtonImageView.setScaleY(1.60);	
			
			this.fivexFiveGridButton.setGraphic(fivexFiveGridButtonImageView);
		}); 
		
		/*A Lambda Expression method to change to the level selector scene
		  when the button pressed is released*/
		this.fivexFiveGridButton.setOnMouseReleased(e -> 
		{
			Random random = new Random();
			
			/*A random number to generate to choose which song would be played
			  for every time the player starts a new game*/
			StarWarsGameGUI.musicPlayer.stop();
			StarWarsGameGUI.mediaPlayer("src/Music_Battle_Grid_Themes/" + this.listOfSongs.get(random.nextInt(0, 5)));
			StarWarsGameGUI.musicPlayer.play();
			
			//Will reset character settings back to normal for everytime the player starts a new game
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().resetCharacters();
			
			/*We call a method from the BattleGridScene class to change the battleGridDisplay 
			  to the one the player chose (Ex. 5x5 battleGridDisplay)*/
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createBattleGridDisplay(1);
			
			/*We call a method from the CharacterMAI class to setup our characters and player on the 
			  battleGridDisplay chosen right before this method*/
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().setUpCharacterMAI(5, 5);
			
			/*Will reset the Mission Dialogue Text Box everytime player starts a new game*/
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().setTextForMissionDialogueDesc("");
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
			
			//Will reset Lose Screen Themes for Characters player can be defeated or win by
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
						   (
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getDarthVader().getDarthVaderLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getOsTrap().getOuterSpaceLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getTcTrap().getTrashCompactorLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getVsTrap().getVentilationShaftLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLukeSkywalkerWinScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLightsaberSwingAmountLoseScreenPane()
						   );
			
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
						   .setNumLightsaberSwings(3);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createLightsaberSwingAmountIcon();
			
			/*We need to reset the total amount of lightsaber swings the player used to 0
			  so that they have a total amount of 5 swings they can use per game(3 swings 
			  given to them initialy and 2 Kyber Crystals ammo around the map)*/
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
			   			   .setNumLightsaberSwingsUsed(0);
			
			primaryStage.setScene(sceneInventory.get(2));
		}); 		
		
		//-------SevenxSeven Grid Button Lambda Expressions-------
		this.sevenxSevenGridButton.setOnMouseEntered(e -> 
		{
			this.sevenxSevenGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxSeven_Grid_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.sevenxSevenGridButton.setScaleX(0.13);
			this.sevenxSevenGridButton.setScaleY(0.13);
			this.sevenxSevenGridButtonImageView.setScaleX(1.60);
			this.sevenxSevenGridButtonImageView.setScaleY(1.60);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.sevenxSevenGridButton.setGraphic(sevenxSevenGridButtonImageView);
		}); 
		
		this.sevenxSevenGridButton.setOnMouseExited(e -> 
		{
			this.sevenxSevenGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxSeven_Grid_Button_(Not_Highlighted).png"));
			
			this.sevenxSevenGridButton.setScaleX(0.13);
			this.sevenxSevenGridButton.setScaleY(0.13);
			this.sevenxSevenGridButtonImageView.setScaleX(1.60);
			this.sevenxSevenGridButtonImageView.setScaleY(1.60);	
			
			this.sevenxSevenGridButton.setGraphic(sevenxSevenGridButtonImageView);
		}); 
		
		this.sevenxSevenGridButton.setOnMousePressed(e -> 
		{
			this.sevenxSevenGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxSeven_Grid_Button_(Pressed).png"));
			
			this.sevenxSevenGridButton.setScaleX(0.13);
			this.sevenxSevenGridButton.setScaleY(0.13);
			this.sevenxSevenGridButtonImageView.setScaleX(1.60);
			this.sevenxSevenGridButtonImageView.setScaleY(1.60);	
			
			this.sevenxSevenGridButton.setGraphic(sevenxSevenGridButtonImageView);
		}); 
		
		this.sevenxSevenGridButton.setOnMouseReleased(e -> 
		{
			Random random = new Random();
			
			StarWarsGameGUI.musicPlayer.stop();
			StarWarsGameGUI.mediaPlayer("src/Music_Battle_Grid_Themes/" + this.listOfSongs.get(random.nextInt(0, 5)));
			StarWarsGameGUI.musicPlayer.play();

			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().resetCharacters();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createBattleGridDisplay(2);
			
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().setUpCharacterMAI(7, 7);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().setTextForMissionDialogueDesc("");
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
						   (
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getDarthVader().getDarthVaderLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getOsTrap().getOuterSpaceLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getTcTrap().getTrashCompactorLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getVsTrap().getVentilationShaftLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLukeSkywalkerWinScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLightsaberSwingAmountLoseScreenPane()
						   );

			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
				   		   (						   				   
				   				   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   				  				  .getLightsaberSwingAmountIconImageView(),
				   				  				  
					  				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					  				  			   .getLightsaberSwingAmountIconBoxOutline()
						   );
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setNumLightsaberSwings(3);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createLightsaberSwingAmountIcon();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setNumLightsaberSwingsUsed(0);
			
			primaryStage.setScene(sceneInventory.get(2));
		}); 	
		
		//-------SevenxTen Grid Button Lambda Expressions-------
		this.sevenxTenGridButton.setOnMouseEntered(e -> 
		{
			this.sevenxTenGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxTen_Grid_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.sevenxTenGridButton.setScaleX(0.13);
			this.sevenxTenGridButton.setScaleY(0.13);
			this.sevenxTenGridButtonImageView.setScaleX(1.60);
			this.sevenxTenGridButtonImageView.setScaleY(1.60);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.sevenxTenGridButton.setGraphic(sevenxTenGridButtonImageView);
		}); 
		
		this.sevenxTenGridButton.setOnMouseExited(e -> 
		{
			this.sevenxTenGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxTen_Grid_Button_(Not_Highlighted).png"));
			
			this.sevenxTenGridButton.setScaleX(0.13);
			this.sevenxTenGridButton.setScaleY(0.13);
			this.sevenxTenGridButtonImageView.setScaleX(1.60);
			this.sevenxTenGridButtonImageView.setScaleY(1.60);	
			
			this.sevenxTenGridButton.setGraphic(sevenxTenGridButtonImageView);
		}); 
		
		this.sevenxTenGridButton.setOnMousePressed(e -> 
		{
			this.sevenxTenGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/SevenxTen_Grid_Button_(Pressed).png"));
			
			this.sevenxTenGridButton.setScaleX(0.13);
			this.sevenxTenGridButton.setScaleY(0.13);
			this.sevenxTenGridButtonImageView.setScaleX(1.60);
			this.sevenxTenGridButtonImageView.setScaleY(1.60);	
			
			this.sevenxTenGridButton.setGraphic(sevenxTenGridButtonImageView);
		}); 
		
		this.sevenxTenGridButton.setOnMouseReleased(e -> 
		{
			Random random = new Random();
			
			StarWarsGameGUI.musicPlayer.stop();
			StarWarsGameGUI.mediaPlayer("src/Music_Battle_Grid_Themes/" + this.listOfSongs.get(random.nextInt(0, 5)));
			StarWarsGameGUI.musicPlayer.play();
			
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().resetCharacters();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createBattleGridDisplay(3);
			
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().setUpCharacterMAI(7, 10);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().setTextForMissionDialogueDesc("");
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
						   (
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getDarthVader().getDarthVaderLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getOsTrap().getOuterSpaceLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getTcTrap().getTrashCompactorLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getVsTrap().getVentilationShaftLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLukeSkywalkerWinScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLightsaberSwingAmountLoseScreenPane()
						   );
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
				   		   (						   				   
				   				   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   				  				  .getLightsaberSwingAmountIconImageView(),
				   				  				  
					  				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					  				  			   .getLightsaberSwingAmountIconBoxOutline()
						   );
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setNumLightsaberSwings(3);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createLightsaberSwingAmountIcon();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setNumLightsaberSwingsUsed(0);
			
			primaryStage.setScene(sceneInventory.get(2));
		}); 
		
		//-------Random Grid Button Lambda Expressions-------
		this.randomGridButton.setOnMouseEntered(e -> 
		{
			this.randomGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Random_Grid_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.randomGridButton.setScaleX(0.13);
			this.randomGridButton.setScaleY(0.13);
			this.randomGridButtonImageView.setScaleX(1.60);
			this.randomGridButtonImageView.setScaleY(1.60);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.randomGridButton.setGraphic(randomGridButtonImageView);
		}); 
		
		this.randomGridButton.setOnMouseExited(e -> 
		{
			this.randomGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Random_Grid_Button_(Not_Highlighted).png"));
			
			this.randomGridButton.setScaleX(0.13);
			this.randomGridButton.setScaleY(0.13);
			this.randomGridButtonImageView.setScaleX(1.60);
			this.randomGridButtonImageView.setScaleY(1.60);	
			
			this.randomGridButton.setGraphic(randomGridButtonImageView);
		}); 
		
		this.randomGridButton.setOnMousePressed(e -> 
		{
			this.randomGridButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Random_Grid_Button_(Pressed).png"));
			
			this.randomGridButton.setScaleX(0.13);
			this.randomGridButton.setScaleY(0.13);
			this.randomGridButtonImageView.setScaleX(1.60);
			this.randomGridButtonImageView.setScaleY(1.60);	
			
			this.randomGridButton.setGraphic(randomGridButtonImageView);
		}); 
		
		this.randomGridButton.setOnMouseReleased(e -> 
		{
			Random random = new Random();
			
			int randomGridDisplay = random.nextInt(1, 4);
			
			int randomGridDisplayRowMax = 0;
			int randomGridDisplayColumnMax = 0;
			
			if(randomGridDisplay == 1) 
			{
				randomGridDisplayRowMax = 5;
				randomGridDisplayColumnMax = 5;
			}
			else if(randomGridDisplay == 2) 
			{
				randomGridDisplayRowMax = 7;
				randomGridDisplayColumnMax = 7;
			}
			else 
			{
				randomGridDisplayRowMax = 7;
				randomGridDisplayColumnMax = 10;
			}
			
			StarWarsGameGUI.musicPlayer.stop();
			StarWarsGameGUI.mediaPlayer("src/Music_Battle_Grid_Themes/" + this.listOfSongs.get(random.nextInt(0, 5)));
			StarWarsGameGUI.musicPlayer.play();
			
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().resetCharacters();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createBattleGridDisplay(randomGridDisplay);
			
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().setUpCharacterMAI(randomGridDisplayRowMax, randomGridDisplayColumnMax);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().setTextForMissionDialogueDesc("");
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
						   (
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getDarthVader().getDarthVaderLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getOsTrap().getOuterSpaceLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getTcTrap().getTrashCompactorLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getVsTrap().getVentilationShaftLoseScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLukeSkywalkerWinScreenPane(),
								   				  
								   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   				  .getLukeSkywalker().getLightsaberSwingAmountLoseScreenPane()
						   );
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridSceneMainPane()
						   .getChildren().removeAll
				   		   (						   				   
				   				   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
				   				  				  .getLightsaberSwingAmountIconImageView(),
				   				  				  
					  				StarWarsGameGUI.getSceneInventory().getBattleGridScene()
					  							   .getLightsaberSwingAmountIconBoxOutline()
						   );
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setNumLightsaberSwings(3);
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene().createLightsaberSwingAmountIcon();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setNumLightsaberSwingsUsed(-100);
			
			primaryStage.setScene(sceneInventory.get(2));
		}); 
		
		mainPane.getChildren().addAll(this.fivexFiveGridButton, this.sevenxSevenGridButton,
									  this.sevenxTenGridButton, this.randomGridButton);
	}
	
	/*A method to fill our ArrayList of songs with battle grid themes*/
	public void fillListOfSong() 
	{
		this.listOfSongs.add("Battle_Grid_Gameplay_Music.mp3");
		this.listOfSongs.add("Star Wars - Anakin Skywalker Suite (Theme)  Ultimate Edition.mp3");
		this.listOfSongs.add("Star Wars - Darth Maul Complete Music Theme  Remastered.mp3");
		this.listOfSongs.add("Star Wars - Millennium Falcon Suite (Theme).mp3");
		this.listOfSongs.add("Star Wars - Republic Clone Army March Complete Music Theme  Remastered.mp3");
	}
	
	//A method that creates a back button to go back to the main menu
	public void backToMainMenuButton(StackPane mainPane) 
	{
		//Creating back button and its image view
		this.backButton = new Button("");
		
		Image backButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/Back_Button_(Not_Highlighted).png");
		this.backButtonImageView = new ImageView(backButtonImage);
		
		//Configuring button settings
		this.backButton.setScaleX(0.21);
		this.backButton.setScaleY(0.21);
		this.backButtonImageView.setScaleX(2.75);
		this.backButtonImageView.setScaleY(2.5);	
		this.backButton.setTranslateX(-166.5);
		this.backButton.setTranslateY(-305);
		
		//Setting image on button
		this.backButton.setGraphic(backButtonImageView);
		
		mainPane.getChildren().add(backButton);
		
		this.backButton.setOnMouseEntered(e -> 
		{
			this.backButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Back_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.backButton.setScaleX(0.21);
			this.backButton.setScaleY(0.21);
			this.backButtonImageView.setScaleX(2.75);
			this.backButtonImageView.setScaleY(2.5);	
			this.backButton.setTranslateX(-166.5);
			this.backButton.setTranslateY(-305);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.backButton.setGraphic(backButtonImageView);
		}); 
		
		this.backButton.setOnMouseExited(e -> 
		{
			this.backButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Back_Button_(Not_Highlighted).png"));
			
			this.backButton.setScaleX(0.21);
			this.backButton.setScaleY(0.21);
			this.backButtonImageView.setScaleX(2.75);
			this.backButtonImageView.setScaleY(2.5);	
			this.backButton.setTranslateX(-166.5);
			this.backButton.setTranslateY(-305);
			
			this.backButton.setGraphic(backButtonImageView);
		}); 
		
		this.backButton.setOnMousePressed(e -> 
		{
			this.backButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Back_Button_(Pressed).png"));
			
			this.backButton.setScaleX(0.21);
			this.backButton.setScaleY(0.21);
			this.backButtonImageView.setScaleX(2.75);
			this.backButtonImageView.setScaleY(2.5);	
			this.backButton.setTranslateX(-166.5);
			this.backButton.setTranslateY(-305);	
			
			this.backButton.setGraphic(backButtonImageView);
		}); 
		
		this.backButton.setOnMouseReleased(e -> 
		{			
			primaryStage.setScene(sceneInventory.get(0));
		}); 
	}
}
