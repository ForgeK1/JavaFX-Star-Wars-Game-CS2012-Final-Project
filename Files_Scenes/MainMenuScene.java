package Files_Scenes;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
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
   of class:    A class that will display the main menu scene of the 
   				game*/
public class MainMenuScene
{
	//1) DATA FIELDS
	
	//Private Variables to change the scene
	private Stage primaryStage;
	private ArrayList<Scene> sceneInventory;
	
	/*Private variables to be accessed Lambda
	  Expression Events*/
	private Button playButton;
	private ImageView playButtonImageView;
	private Button quitButton;
	private ImageView quitButtonImageView;
	
	//2) CONSTRUCTORS
	
	public MainMenuScene(Stage primaryStage, ArrayList<Scene> sceneInventory) 
	{
		this.primaryStage = primaryStage;
		this.sceneInventory = sceneInventory;
	}
	
	//3) METHODS
	
	/*A method to return the scene that will display our main menu
	  of the game*/
	public Scene getMainMenuScreen() 
	{	
		/*__________________1) Panes_____________________*/
		
		//A default Stack Pane to put on our window
		StackPane mainPane = new StackPane();
		
		/*Issue: Scene color becomes white when adding a button even
		 though the original scene color was already set.
 
 		Solution: When adding a button or any instance of the
 			Control class, the root of the scene by default
 			will apply a CSS style sheet called modena.css 
 			which will have default settings enabled (such as
 			turning the background color white.
 			
 			Therefore, we use the code below to change the
 			background color of the tempPane style sheet to
 			the color we want.*/
		mainPane.setStyle("-fx-background-color: #000749;");
		
		/*__________________2) Components________________*/
		
		/*A series of methods that will add components to our main
		  menu scene*/
		
		addWallpaperBackground(mainPane);
		
		createBackground(mainPane);
		
		createGameTitle(mainPane);
		
		createButtons(mainPane);
		
		/*__________________3) Scene(s)__________________*/
		
		/*Assigns mainPane to mainScene for with a 700x700 blue 
		  background screen*/
		Scene mainScene = new Scene(mainPane, 700, 700, javafx.scene.paint.Color.web("#000749"));
		
		return mainScene;
	}
	
	//A method to add our wallpaper background to our main menu
	public void addWallpaperBackground(StackPane mainPane) 
	{
		ImageView backgroundWallpaper = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Darth_Vader_And-Luke_Main_Menu_Background_GreenxRed.png"));
		
		backgroundWallpaper.setScaleX(0.7);
		backgroundWallpaper.setScaleY(0.7);
		backgroundWallpaper.setTranslateY(40);
		backgroundWallpaper.setOpacity(1);
		
		mainPane.getChildren().add(backgroundWallpaper);
	}
	
	//A method to implment the background images and the blue outline on the main menu screen
	public void createBackground(StackPane mainPane) 
	{
		//IMAGE BORDERS and OUTLINE BORDER FOR ALL IMAGES
		
		/*To utilize an image, we add the image to an Image object,
		  and then add that object to an image view (picture frame for
		  image object) to be able to be added to the tempPane
		  
		  Note: Please refer to the Word Cited txt file to see where I
		  learned to implement images and where I found these images*/
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
	
	//A method that will create the title of my game including my name
	public void createGameTitle(StackPane mainPane) 
	{
		/*Creating a pane to store all of the text for the game title*/
		StackPane groupTextTitlePane = new StackPane();
		
		Text themeTitle = new Text("STAR WARS");
		
		//Configuring theme title text settings
		themeTitle.setScaleX(2.3);
		themeTitle.setScaleY(2.3);
		themeTitle.setTextAlignment(TextAlignment.CENTER);
		themeTitle.setFill(Color.CYAN);
		themeTitle.setStroke(Color.BLACK);
		themeTitle.setStrokeWidth(0.6);
		themeTitle.setTranslateX(0);
		themeTitle.setTranslateY(-216);
		
		/*I learened from tutorialspoint website that I was using 
		  Font.awt instead of javafx.scene.text, which taught me
		  to use Font.font(parameters) to play around with my text
		  
		  Note: Please refer to the Word Cited txt file to see the
		  		website I used*/
		themeTitle.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		
		Text gameTitle = new Text("Rebel Strike! \nThe Final Showdown Against \nDarth Vader! ");
		
		//Configuring game title text settings
		gameTitle.setScaleX(2.9);
		gameTitle.setScaleY(2.9);
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		gameTitle.setFill(Color.CYAN);
		gameTitle.setStroke(Color.BLACK);
		gameTitle.setStrokeWidth(0.6);
		gameTitle.setTranslateX(10);
		gameTitle.setTranslateY(-143);
		gameTitle.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		
		Text gameOwnerTitle = new Text("By Keyvan M. Kani");
		
		//Configuring theme title text settings
		gameOwnerTitle.setScaleX(2.3);
		gameOwnerTitle.setScaleY(2.3);
		gameOwnerTitle.setTextAlignment(TextAlignment.CENTER);
		gameOwnerTitle.setFill(Color.CYAN);
		gameOwnerTitle.setStroke(Color.BLACK);
		gameOwnerTitle.setStrokeWidth(0.6);
		gameOwnerTitle.setTranslateX(0);
		gameOwnerTitle.setTranslateY(-70);
		gameOwnerTitle.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		
		//CREATING THE LINES FOR THE TITLE OF THE GAME
		
		Line gameTitleTopLeftLine = new Line(0, 0, 155, 0);
		
		//Configuring game title top left line settings
		gameTitleTopLeftLine.setStroke(Color.CYAN);
		gameTitleTopLeftLine.setStrokeWidth(3);
		gameTitleTopLeftLine.setTranslateX(-155);
		gameTitleTopLeftLine.setTranslateY(-208);
		
		Line gameTitleTopRightLine = new Line(0, 0, 165, 0);
		
		//Configuring game title top right line settings
		gameTitleTopRightLine.setStroke(Color.CYAN);
		gameTitleTopRightLine.setStrokeWidth(3);
		gameTitleTopRightLine.setTranslateX(153);
		gameTitleTopRightLine.setTranslateY(-208);
		
		Line gameTitleBottomLeftLine = new Line(0, 0, 117.5, 0);
		
		//Configuring game title bottom left line settings
		gameTitleBottomLeftLine.setStroke(Color.CYAN);
		gameTitleBottomLeftLine.setStrokeWidth(3);
		gameTitleBottomLeftLine.setTranslateX(-173);
		gameTitleBottomLeftLine.setTranslateY(-75);
		
		Line gameTitleBottomRightLine = new Line(0, 0, 120, 0);
		
		//Configuring game title bottom right line settings
		gameTitleBottomRightLine.setStroke(Color.CYAN);
		gameTitleBottomRightLine.setStrokeWidth(3);
		gameTitleBottomRightLine.setTranslateX(175);
		gameTitleBottomRightLine.setTranslateY(-77);
		
		groupTextTitlePane.getChildren().addAll(gameTitleTopLeftLine, gameTitleTopRightLine,
									  	   		gameTitleBottomLeftLine, gameTitleBottomRightLine, 
									  	   		themeTitle, gameTitle, gameOwnerTitle);
		
		//Configure the group title pane settings
		groupTextTitlePane.setTranslateY(-35);
		
		mainPane.getChildren().add(groupTextTitlePane);
	}
	
	//A method to create the shapes that surroun the Play and Quit button
	public void createShapeAssets(StackPane mainPane) 
	{
		//Top blue circle surrounding the menu options
		Arc fullTopCircle = new Arc(0, 0, 180, 50, -140, 100);
		
		//Configuring fullTopCircle settings
		fullTopCircle.setType(ArcType.CHORD);
		fullTopCircle.setFill(Color.web("#005886"));
		fullTopCircle.setStroke(Color.CYAN);
		fullTopCircle.setStrokeWidth(3);
		fullTopCircle.setTranslateY(45);
		fullTopCircle.setRotate(180);
		
		//Bottom blue circle surrounding the menu options
		Arc fullBottomCircle = new Arc(0, 0, 180, 50, -140, 100);
		
		//Configuring fullTopCircle settings
		fullBottomCircle.setType(ArcType.CHORD);
		fullBottomCircle.setFill(Color.web("#005886"));
		fullBottomCircle.setStroke(Color.CYAN);
		fullBottomCircle.setStrokeWidth(3);
		fullBottomCircle.setTranslateY(262);
		
		//Creating and configuring settuings of shape pane
		
		mainPane.getChildren().addAll(fullTopCircle, fullBottomCircle);
	}
	
	//Create and configure the functions of the Play and Quit button
	public void createButtons(StackPane mainPane) 
	{
		/*A vertical box pane to stores the main menu buttons*/
		VBox boxForButtons = new VBox(-270);
		
		//Configuring boxForButtons settings
		boxForButtons.setAlignment(Pos.CENTER);
		boxForButtons.setTranslateY(155);
		
		/*Created a Play and Quit button for the player to click on*/
		this.playButton = new Button("");
		this.quitButton = new Button("");
		
		//Set Default images for the Play and Quit Button
		Image playButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/Play_Button_(Not_Highlighted).png");
		this.playButtonImageView = new ImageView(playButtonImage);
		
		Image quitButtonImage = new Image("Images_Main_Menu_And_Level_Selector_Assets/Quit_Button_(Not_Highlighted).png");
		this.quitButtonImageView = new ImageView(quitButtonImage);
		
		//Configuring settings for Play and Quit ImageViews
		this.playButton.setScaleX(0.15);
		this.playButton.setScaleY(0.15);
		this.playButtonImageView.setScaleX(1.60);
		this.playButtonImageView.setScaleY(1.60);
		
		this.quitButton.setScaleX(0.15);
		this.quitButton.setScaleY(0.15);
		this.quitButtonImageView.setScaleX(1.60);
		this.quitButtonImageView.setScaleY(1.60);
		
		//Sets images on Play and Quit Buttons
		this.playButton.setGraphic(playButtonImageView);
		this.quitButton.setGraphic(quitButtonImageView);
		
		//GIVING FUNCTIONALITY TO BUTTONS
		
		/*A series of Lambda Expressions to change how the button looks  
		  when the mouse hovers over, exits the space of, or pressed on
		  the buttons below*/
		
		//-------Play Button Lambda Expressions-------
		this.playButton.setOnMouseEntered(e -> 
		{
			/*Setting new image for the image view that will be the graphic
			  of button*/
			this.playButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Play_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.playButton.setScaleX(0.15);
			this.playButton.setScaleY(0.15);
			this.playButtonImageView.setScaleX(1.60);
			this.playButtonImageView.setScaleY(1.60);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.playButton.setGraphic(playButtonImageView);
		}); 
		
		this.playButton.setOnMouseExited(e -> 
		{
			this.playButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Play_Button_(Not_Highlighted).png"));
			
			this.playButton.setScaleX(0.15);
			this.playButton.setScaleY(0.15);
			this.playButtonImageView.setScaleX(1.60);
			this.playButtonImageView.setScaleY(1.60);
			
			this.playButton.setGraphic(playButtonImageView);
		}); 
		
		this.playButton.setOnMousePressed(e -> 
		{
			this.playButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Play_Button_(Pressed).png"));
			
			this.playButton.setScaleX(0.15);
			this.playButton.setScaleY(0.15);
			this.playButtonImageView.setScaleX(1.60);
			this.playButtonImageView.setScaleY(1.60);
			
			this.playButton.setGraphic(playButtonImageView);
		}); 
		
		/*A Lambda Expression method to change to the level selector scene
		  when the play button pressed is released*/
		this.playButton.setOnMouseReleased(e -> 
		{
			primaryStage.setScene(sceneInventory.get(1));
		}); 		
		
		//-------Quit Button Lambda Expressions-------
		this.quitButton.setOnMouseEntered(e -> 
		{
			/*Setting new image for the image view that will be the graphic
			  of button*/
			this.quitButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Quit_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.quitButton.setScaleX(0.15);
			this.quitButton.setScaleY(0.15);
			this.quitButtonImageView.setScaleX(1.60);
			this.quitButtonImageView.setScaleY(1.60);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.quitButton.setGraphic(quitButtonImageView);
		}); 
		
		this.quitButton.setOnMouseExited(e -> 
		{
			this.quitButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Quit_Button_(Not_Highlighted).png"));
			
			this.quitButton.setScaleX(0.15);
			this.quitButton.setScaleY(0.15);
			this.quitButtonImageView.setScaleX(1.60);
			this.quitButtonImageView.setScaleY(1.60);
			
			this.quitButton.setGraphic(quitButtonImageView);
		}); 
		
		this.quitButton.setOnMousePressed(e -> 
		{
			this.quitButtonImageView = new ImageView (new Image("Images_Main_Menu_And_Level_Selector_Assets/Quit_Button_(Pressed).png"));
			
			this.quitButton.setScaleX(0.15);
			this.quitButton.setScaleY(0.15);
			this.quitButtonImageView.setScaleX(1.60);
			this.quitButtonImageView.setScaleY(1.60);
			
			this.quitButton.setGraphic(quitButtonImageView);
		}); 
		
		/*A Lambda Expression method to change to exit the game
		  when the play button pressed is released*/
		this.quitButton.setOnMouseReleased(e -> 
		{
			System.exit(0);
		}); 	
		
		//Adding buttons to the HBox pane
		boxForButtons.getChildren().addAll(playButton, quitButton);
		
		mainPane.getChildren().add(boxForButtons);
	}
}
