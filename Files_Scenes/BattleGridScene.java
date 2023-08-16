package Files_Scenes;
import java.util.ArrayList;

import Files_Characters.LukeSkywalker;
import Files_GUI.StarWarsGameGUI;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
   of class:    A class that can returns a Scene to the SceneInventory
   				class which comprises of a 5x5, or 7x7, or 10x7 Grid the
   				player will play on at the top of the screen and a box
   				at the bottom of the screen displaying text to the player,
   				the amount and the amount of lightsaber swings they have
   				left.*/
public class BattleGridScene 
{
	//1) DATA FIELDS
	
	/*Two private static variables that */
	private StackPane mainPane;
	private GridPane battleGridDisplay;
	
	//Private Variables to add onto or change the scene
	private Stage primaryStage;
	private ArrayList<Scene> sceneInventory;
	
	/*Private variable that will keep track of the amount
	  of lightsaber swings Luke Skywalker has and the image
	  for it*/
	private int numLightsaberSwings;
	private int numLightsaberSwingsUsed;
	private ImageView lightsaberSwingAmountIconImageView;
	Rectangle lightsaberSwingAmountIconBoxOutline;
	
	/*Private variable to be accessed by Lambda 
	  Expressions*/
	private Button debugButton;
	private ImageView debugButtonImageViewer;
	private Button backButton;
	private ImageView backButtonImageView;
	private ScrollPane scrollPaneForMissionDialogueDesc;
	private String textForMissionDialogueDesc;
	
	//2) CONSTRUCTORS
	
	public BattleGridScene(Stage primaryStage, ArrayList<Scene> sceneInventory) 
	{
		this.primaryStage = primaryStage;
		this.sceneInventory = sceneInventory;
		
		//A scroll Pane to scroll through the mission dialogue description
		this.scrollPaneForMissionDialogueDesc = new ScrollPane();
		
		//A default Stack Pane to put on our window
		this.mainPane = new StackPane();
		
		/*Assignes a new Grid object to be dynamically
		  changed without having to add a new grid to
		  the main pane*/
		this.battleGridDisplay = new GridPane(); 
	}
	
	//3) METHODS
	
	public Scene getBattleGridScreen() 
	{
		/*__________________1) Panes_____________________*/
		
		this.mainPane.setStyle("-fx-background-color: #000749;");
		
		/*__________________2) Components________________*/
		
		/*A series of methods that will add components to our
		  battle grid scene*/
		
		addWallpaperBackground();
		
		createBackground();
		
		createBattleGridAndInformationBoxOutline();
		
		createBattleGridDisplay(0);
		
		createLukeSkywalkerIcon();
				
		createDebugButton();
		
		backToMainMenuButton();
		
		createMissionDialogue();
		
		/*__________________3) Scene(s)__________________*/
		
		/*Assigns mainPane to mainScene for with a 700x700 blue 
		  background screen*/
		Scene mainScene = new Scene(this.mainPane, 700, 700, javafx.scene.paint.Color.web("#000749"));
		
		return mainScene;
	}
	
	//A method to add our wallpaper background to our level selector menu
		public void addWallpaperBackground() 
		{
			ImageView backgroundWallpaper = new ImageView (new Image("Images_Battle_Grid_Assets/Jedi_Console_Screen_Wallpaper.png"));
			
			backgroundWallpaper.setScaleX(1.075);
			backgroundWallpaper.setScaleY(1.085);
			backgroundWallpaper.setTranslateY(0);
			backgroundWallpaper.setOpacity(0.8);
			
			this.mainPane.getChildren().add(backgroundWallpaper);
		}
	
	/*A method to implment the background images and the blue outline on 
	  the battle grid screen*/
	public void createBackground() 
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
		
		this.mainPane.getChildren().addAll(leftBorder, rightBorder, 
										   topBorderVersion1Part1, topBorderVersion1Part2, 
										   topBorderVersion2Part1, topBorderVersion2Part2, 
										   topSpecialBorder,
										   bottomBorderVersion1Part1, bottomBorderVersion1Part2,
										   bottomBorderVersion2Part1, bottomBorderVersion2Part2,
										   bottomSpecialBorder, 
										   outlineBorderForImages);
	}
	
	/*Creates the color outline box for the battle grid on top and for the 
	 information box below*/
	public void createBattleGridAndInformationBoxOutline() 
	{		
		/*Creating a temp pane to store the battle grid and information box
		  outline*/
		VBox tempVBPane = new VBox(0);
		
		//Configuring temperory Vertical Box Pane settings
		tempVBPane.setAlignment(Pos.CENTER);
		tempVBPane.setTranslateY(2);
		
		Rectangle battleGridOutline = new Rectangle(0, 0, 450, 310);
		Rectangle informationGridOutline = new Rectangle(0, 0, 450, 126);
		
		//Configuring settings for the outline boxes
		battleGridOutline.setFill(Color.GREEN);
		battleGridOutline.setStroke(Color.CYAN);
		battleGridOutline.setStrokeWidth(2);
		battleGridOutline.setOpacity(0.6);
		
		informationGridOutline.setFill(Color.GREEN);
		informationGridOutline.setStroke(Color.CYAN);
		informationGridOutline.setStrokeWidth(2);
		informationGridOutline.setOpacity(0.6);
		
		/*Adding both outlines to a VBox before adding VBox to our main
		  pane*/
		tempVBPane.getChildren().addAll(battleGridOutline, informationGridOutline);
		
		this.mainPane.getChildren().add(tempVBPane);
	}
	
	/*A static method to generate a 5x5, 7x7, 10x7, or Random Grid of those 
	  three options based on which Battle Grid the player selected in the 
	  level selector screen*/
	public void createBattleGridDisplay(int selectedBattleGridDisplay) 
	{												
		/*For any battleGridDisplay created, either when the game starts or the player 
		  restarts the game with a different or same grid option, we remove all of the labels 
		  that created the previous 5x5 or 7x7 or 10x7 space and replace it with a new 
		  battleGridDisplay at the end of this static method*/
		this.battleGridDisplay.getChildren().remove(0, battleGridDisplay.getChildren().size());
		
		//Variables for the GridPane
		double setScaleX = 0;
		double setScaleY = 0;
		double setTranslateXGridPane = 0;
		double setTranslateYGridPane = 0;
		int columnMax = 0;
		int rowMax = 0;
		double opacityOn = 0;
		
		//Variables for the Labels
		double setPrefSizeXLabel = 0;
		double setPrefSizeYLabel = 0;		
		
		/*Given the GridPane and Label variables created above, we will use a series of
		  if-else statements to modify these variables so that we can dynamically create
		  a new battleGridDisplay*/
		
		//Creates 5x5 Battle Grid
		if(selectedBattleGridDisplay == 1) 
		{											
			//Configuring Grid Pane settings
			setScaleX = 1;
			setScaleY = 1;
			setTranslateXGridPane = 0;
			setTranslateYGridPane = -62;
			columnMax = 5;
			rowMax = 5;
			opacityOn = 1;
			
			//Configuring Label Settings
			setPrefSizeXLabel = 88;
			setPrefSizeYLabel = 60;
			
			//A print statement to check if 5x5 grid was created
//					System.out.println("5x5 grid was created");
		}
		//Creates 7x7 Battle Grid
		else if(selectedBattleGridDisplay == 2) 
		{
			//Configuring Grid Pane settings
			setScaleX = 0.715;
			setScaleY = 0.715;
			setTranslateXGridPane = 0;
			setTranslateYGridPane = -62;
			columnMax = 7;
			rowMax = 7;
			opacityOn = 1;
			
			//Configuring Label Settings
			setPrefSizeXLabel = 88;
			setPrefSizeYLabel = 60;
			
			//A print statement to check if 7x7 grid was created
//					System.out.println("7x7 grid was created");
		}
		//Creates 10x7 Battle Grid
		else if(selectedBattleGridDisplay == 3) 
		{
			//Configuring Grid Pane settings
			setScaleX = 0.657;
			setScaleY = 0.715;
			setTranslateXGridPane = 0;
			setTranslateYGridPane = -62;
			columnMax = 10;
			rowMax = 7;
			opacityOn = 1;
			
			//Configuring Label Settings
			setPrefSizeXLabel = 88;
			setPrefSizeYLabel = 60;
			
			//A print statement to check if 10x7 grid was created
//					System.out.println("10x7 grid was created");
		}
		
		/*Calling a method from the CharacterMechanicsAndInteractions class to
		  create and fill the listOfCharacterInfo 2D array that will have the same 
		  number of rows and columns from the battleGridDisplay*/
//		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
//					   .characterPositionInformation(mainPane, rowMax, columnMax);
		
		/*Configuring Grid Pane settings based on the variables
		  modified*/
			//Sets Grid Pane alighnment
		this.battleGridDisplay.setAlignment(Pos.CENTER); 
			//Sets Grid Pane Size
		this.battleGridDisplay.setScaleX(setScaleX);
		this.battleGridDisplay.setScaleY(setScaleY);
			//Sets Grid Pane location
		this.battleGridDisplay.setTranslateX(setTranslateXGridPane);
		this.battleGridDisplay.setTranslateY(setTranslateYGridPane);
			//Sets Grid Pane padding
		this.battleGridDisplay.setPadding(new Insets(10, 10, 10, 10));
			//Sets HGap and VGap for each cell
		this.battleGridDisplay.setHgap(1);
		this.battleGridDisplay.setVgap(1);		
			//Sets Grid Pane lines to be visible
		this.battleGridDisplay.setGridLinesVisible(true);
			//Sets Grid Pane opacity
		this.battleGridDisplay.setOpacity(opacityOn);
		
		/*A for loop that will add a temporary Label variable to 
		  each space of the battleGridDisplay Pane and create our
		  5x5 or 7x7 or 10x7 space*/
		for(int row = 0; row < rowMax; row++) 
		{
			for(int column = 0; column < columnMax; column++) 
			{
				Label tempLabel = new Label();
				
				tempLabel.setStyle("-fx-font-size:20;" + " " + "-fx-border-color: #FF00FF;");
				tempLabel.setLineSpacing(500);
				tempLabel.setAlignment(Pos.CENTER);
				tempLabel.setPrefSize(setPrefSizeXLabel, setPrefSizeYLabel);
				tempLabel.setOpacity(opacityOn);
				
				GridPane.setConstraints(tempLabel, column, row);
				
				this.battleGridDisplay.getChildren().add(tempLabel);
			}
		}
		
		/*A print statement to check our row and coloumn count is before
		  we apply our new battleGridDisplay to the main pane*/
//				System.out.println("Before: " +
//								   battleGridDisplay.getRowCount() + " " + 
//								   battleGridDisplay.getColumnCount());
		
		/*A for loop to check if there is an already pre-existing 
		  battleGridDisplay added to the main pane so that it can
		  be replaced with the new battleGridDisplay made using the 
		  ".set" method*/		
		for(int i = 0; i < this.mainPane.getChildren().size(); i++) 
		{								
			if(this.mainPane.getChildren().get(i) instanceof GridPane) 
			{								
				//A print statement to track errors
//						System.out.println("----Code runs here.----");
				
				this.mainPane.getChildren().set(i, this.battleGridDisplay);
			}
		}

		/*If there is no pre-existing battleGridDisplay, then we will
		  add our first battleGridDisplay to our mainPane.
		  
		  Note: This if statement is executed when the game starts and
		  		we create our pre-made scenes in the SceneInventory class. 
		  		
		  		Once the player chooses	a battle grid option to play on, 
		  		the if statement in for loop above will always execute 
		  		while the if statement below will never execute again*/
		if(!(this.mainPane.getChildren().contains(this.battleGridDisplay))) 
		{
			//A print statement to track errors
//					System.out.println("Code runs here.");
			
			this.mainPane.getChildren().add(this.battleGridDisplay);
		}	
		
		/*A print statement to check our row and coloumn count is after
		  we apply our new battleGridDisplay to the main pane*/
//				System.out.println("After: " +
//						   		   battleGridDisplay.getRowCount() + " " + 
//						   		   battleGridDisplay.getColumnCount());
	}
	
	//A method to create the Luke Skywalker Icon
	public void createLukeSkywalkerIcon() 
	{
		/*A temp StackPane to stack the Luke Skywalker's Icon image on
		  top of a rectangle object that will act as the icon's outline*/
		StackPane tempPane = new StackPane();
		
		ImageView lukeSkywalkerIconImageViewer = new ImageView(new Image("Images_Battle_Grid_Assets/Luke_Skywalker_Icon.png"));		
		Rectangle lukeSkywalkerIconBoxOutline = new Rectangle(0, 0, 100, 100);
		
		//Configuring icon image and box outline settings
		lukeSkywalkerIconImageViewer.setScaleX(0.1);
		lukeSkywalkerIconImageViewer.setScaleY(0.1);
		
		lukeSkywalkerIconBoxOutline.setFill(null);
		lukeSkywalkerIconBoxOutline.setStroke(Color.MAGENTA);
		lukeSkywalkerIconBoxOutline.setStrokeWidth(2);
		lukeSkywalkerIconBoxOutline.setOpacity(0.6);
		
		//Adding both objects to temporary StackPane
		tempPane.getChildren().addAll(lukeSkywalkerIconBoxOutline, lukeSkywalkerIconImageViewer);
		
		//Configuring temporary StackPane settings
		tempPane.setScaleX(1.255);
		tempPane.setScaleY(1.215);
		tempPane.setTranslateX(0);
		tempPane.setTranslateY(157.9);
		
		this.mainPane.getChildren().addAll(tempPane);
	}
	
	//A method to create the lightsaber swing icon
	public void createLightsaberSwingAmountIcon() 
	{				
		//A print statement to check if this method runs
//				System.out.println("createLightsaberSwingAmountIcon method runs");
		
		/*A while loop and a series of if statements to see how many
		  swings Luke has left*/
		String imageFileToUse = "";
		
		if(this.numLightsaberSwings == 0) 
		{
			imageFileToUse = "Images_Battle_Grid_Assets/Lightsaber_Swing_Icon_(Number_0).png";
		}
		else if(this.numLightsaberSwings == 1) 
		{
			imageFileToUse = "Images_Battle_Grid_Assets/Lightsaber_Swing_Icon_(Number_1).png";
		}
		else if(this.numLightsaberSwings == 2) 
		{
			imageFileToUse = "Images_Battle_Grid_Assets/Lightsaber_Swing_Icon_(Number_2).png";
		}
		else if(this.numLightsaberSwings == 3) 
		{			
			imageFileToUse = "Images_Battle_Grid_Assets/Lightsaber_Swing_Icon_(Number_3).png";
		}
		else if(this.numLightsaberSwings == 4) 
		{			
			imageFileToUse = "Images_Battle_Grid_Assets/Lightsaber_Swing_Icon_(Number_4).png";
		}
		else if(this.numLightsaberSwings == 5) 
		{			
			imageFileToUse = "Images_Battle_Grid_Assets/Lightsaber_Swing_Icon_(Number_5).png";
		}
		
		this.lightsaberSwingAmountIconImageView = new ImageView(new Image(imageFileToUse));		
		this.lightsaberSwingAmountIconBoxOutline = new Rectangle(0, 0, 161, 60.5);
		
		//Configuring icon image and box outline settings
		this.lightsaberSwingAmountIconImageView.setScaleX(0.14);
		this.lightsaberSwingAmountIconImageView.setScaleY(0.14);
		this.lightsaberSwingAmountIconImageView.setTranslateX(-140);
		this.lightsaberSwingAmountIconImageView.setTranslateY(127.5);
		
		this.lightsaberSwingAmountIconBoxOutline.setFill(null);
		this.lightsaberSwingAmountIconBoxOutline.setStroke(Color.MAGENTA);
		this.lightsaberSwingAmountIconBoxOutline.setStrokeWidth(2);
		this.lightsaberSwingAmountIconBoxOutline.setOpacity(0.6);
		this.lightsaberSwingAmountIconBoxOutline.setTranslateX(-143);
		this.lightsaberSwingAmountIconBoxOutline.setTranslateY(127.3);
		
		this.mainPane.getChildren().addAll(this.lightsaberSwingAmountIconImageView, this.lightsaberSwingAmountIconBoxOutline);
	}
	
	//A method to create the debug button that will show all of the enemies, traps, and the main boss
	public void createDebugButton() 
	{
		/*A temp StackPane to stack the Luke Skywalker's Icon image on
		  top of a rectangle object that will act as the icon's outline*/
		StackPane tempPane = new StackPane();
		
		this.debugButton = new Button("");
		this.lightsaberSwingAmountIconImageView = new ImageView(new Image("Images_Battle_Grid_Assets/Debug_Button_(Not_Highlighted).png"));		
		Rectangle lightsaberSwingAmountIconBoxOutline = new Rectangle(0, 0, 127.5, 50);
		
		//Adding image viewer to debug button
		this.debugButton.setGraphic(lightsaberSwingAmountIconImageView);
		
		//Configuring button, icon image, and box outline settings
		this.debugButton.setScaleX(0.05);
		this.debugButton.setScaleY(0.05);
		this.lightsaberSwingAmountIconImageView.setScaleX(2.15);
		this.lightsaberSwingAmountIconImageView.setScaleY(2.15);
		
		lightsaberSwingAmountIconBoxOutline.setFill(null);
		lightsaberSwingAmountIconBoxOutline.setStroke(Color.MAGENTA);
		lightsaberSwingAmountIconBoxOutline.setStrokeWidth(2);
		lightsaberSwingAmountIconBoxOutline.setOpacity(0.6);
		
		/*A series of Lambda Expressions to change how the button looks  
		  when the mouse hovers over, exits the space of, or pressed on
		  the debug button*/
		this.debugButton.setOnMouseEntered(e -> 
		{
			/*Setting new image for the image view that will be the graphic
			  of button*/
			this.debugButtonImageViewer = new ImageView (new Image("Images_Battle_Grid_Assets/Debug_Button_(Highlighted).png"));
			
			//Configuring button and image view settings
			this.debugButton.setScaleX(0.05);
			this.debugButton.setScaleY(0.05);
			this.debugButtonImageViewer.setScaleX(2.15);
			this.debugButtonImageViewer.setScaleY(2.15);
			
			/*Setting graphic of button to the image view we want the 
			  to display*/
			this.debugButton.setGraphic(debugButtonImageViewer);
		}); 
		
		this.debugButton.setOnMouseExited(e -> 
		{
			this.debugButtonImageViewer = new ImageView (new Image("Images_Battle_Grid_Assets/Debug_Button_(Not_Highlighted).png"));
			
			this.debugButton.setScaleX(0.05);
			this.debugButton.setScaleY(0.05);
			this.debugButtonImageViewer.setScaleX(2.15);
			this.debugButtonImageViewer.setScaleY(2.15);
			
			this.debugButton.setGraphic(debugButtonImageViewer);
		}); 
		
		this.debugButton.setOnMousePressed(e -> 
		{
			this.debugButtonImageViewer = new ImageView (new Image("Images_Battle_Grid_Assets/Debug_Button_(Pressed).png"));
			
			this.debugButton.setScaleX(0.05);
			this.debugButton.setScaleY(0.05);
			this.debugButtonImageViewer.setScaleX(2.15);
			this.debugButtonImageViewer.setScaleY(2.15);
			
			this.debugButton.setGraphic(debugButtonImageViewer);
		}); 
		
		/*A Lambda Expression method to change make the enemies, events,
		  Kyber Crystal objects, and main villian appear and dissapear*/
		this.debugButton.setOnMouseReleased(e -> 
		{
			this.debugButtonImageViewer = new ImageView (new Image("Images_Battle_Grid_Assets/Debug_Button_(Not_Highlighted).png"));
			
			this.debugButton.setScaleX(0.05);
			this.debugButton.setScaleY(0.05);
			this.debugButtonImageViewer.setScaleX(2.15);
			this.debugButtonImageViewer.setScaleY(2.15);
			
			this.debugButton.setGraphic(debugButtonImageViewer);
			
			/*A boolean and if-else statement to check if all of our characters
			  except Luke is visible or not visible on our grid*/
			boolean status;
			
			if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
		   		  		      .getCharacterRoster().get(2).getOpacity() == 1) 
			{
				status = true;
			}
			else 
			{
				status = false;
			}
			
			/*An if-else statement and a nested for loop that will turn all of the non-playable 
			  characters, events, and Kyber Crystal objects opacity on or off*/
			if(status == true) 
			{				
				//Print statement to see if icons turn off their opacity
//						System.out.println("\nTrue status code runs here\n");
				
				for(int i = 0; i < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						  						  .getCharacterRoster().size(); i++) 
				{					
					/*An if statement to make sure all character Labels' opacity 
					can be affected except for the Luke Skywalker Label*/
					if(!(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						   		  		.getCharacterRoster().get(i).getId()
						   		  		.equals("Luke Skywalker"))) 
					{
						//Two print statements to check for error
//								System.out.println(
//													StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
//															       .getCharacterRoster().get(i)
//												  );
//					
//								System.out.println(
//													!(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
//											   		  		         .getCharacterRoster().get(i).getId()
//											   		  				 .equals("Luke Skywalker"))
//										  		  );
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
		   		  					   .getCharacterRoster().get(i).setOpacity(0);
					} 
				}
				
				status = false;
			}
			else if(status == false)
			{
				//Print statement to see if icons turn on their opacity
//						System.out.println("\nFalse status code runs here\n");
				
				for(int i = 0; i < StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						  .getCharacterRoster().size(); i++) 
				{
					/*An if statement to make sure all character Labels' opacity 
					can be affected except for the Luke Skywalker Label*/
					if(!(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						   		  		.getCharacterRoster().get(i).getId()
						   		  		.equals("Luke Skywalker"))) 
					{
						//Two print statements to check for error
//								System.out.println(
//													StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
//															       .getCharacterRoster().get(i)
//												  );
//								
//								System.out.println(
//													!(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
//											   		  				 .getCharacterRoster().get(i).getId()
//											   		  				 .equals("Luke Skywalker"))
//										  		  );
						
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
		   		  					   .getCharacterRoster().get(i).setOpacity(1);
					}
				}
				
				status = true;
			}
			
			//-------------Checks Player's Current Row and Column Coordinates-------------
			
			int playRowCoordinate = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerRowCoordinate();
			int playerColumnCoordinate = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerColCoordinate();
			
//			System.out.println("\nPlayer Row Coordinate: " + (playRowCoordinate + 1) +
//							   "\nPlayer Column Coordinate: " + (playerColumnCoordinate + 1) + "\n");
			
			//-------------Requests Focus For Player Movement-------------
			
			//Requests focus from the program for the Luke Label so that player can move again 
			StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						   .getCharacterRosterGridInfo()[playRowCoordinate][playerColumnCoordinate]
						   .requestFocus();			
		}); 		
		
		//Adding both objects to temporary StackPane
		tempPane.getChildren().addAll(lightsaberSwingAmountIconBoxOutline, this.debugButton, this.lightsaberSwingAmountIconImageView);
		
		//Configuring temporary StackPane settings
		tempPane.setScaleX(1.255);
		tempPane.setScaleY(1.215);
		tempPane.setTranslateX(-143);
		tempPane.setTranslateY(189);
		
		this.mainPane.getChildren().addAll(tempPane);
	}
	
	/*A method that will display text to the player in the mission dialogue*/
	public void createMissionDialogue() 
	{		
		/*We reset the Scroll Pane's Mission Dialogue box so that everytime the 
		  player moves and detects another character that prompts the program to
		  display a message, we then grab that new message and attach the old message
		  before creating our new Scroll Pane's Mission Dialogue box
		  Dialogue box we want to create*/
		this.scrollPaneForMissionDialogueDesc.setContent(new TextArea(""));
		
		/*A normal pane to put the scroll box pane in so that the scroll 
		  box pane does not take up the entire screen*/
		Pane standardPaneForScrollBoxPane = new Pane();
		
		//Configuring standard pane for scroll pane settings
		standardPaneForScrollBoxPane.setTranslateX(428);
		standardPaneForScrollBoxPane.setTranslateY(433.5);
		standardPaneForScrollBoxPane.setScaleX(1.04);
		standardPaneForScrollBoxPane.setScaleY(0.9);
		standardPaneForScrollBoxPane.setBlendMode(BlendMode.LIGHTEN);
		
		//Configuring mdDescriptionScrollPane settings
		this.scrollPaneForMissionDialogueDesc.setFocusTraversable(true);
		this.scrollPaneForMissionDialogueDesc.setPrefSize(150, 110);
		this.scrollPaneForMissionDialogueDesc.setMinWidth(0.5);
		
		/*Setting up Mission Dialogue's title, description, and box outline*/
		Text missionDialogueTitle = new Text("Mission Dialogue");
		
		TextArea missionDialogueDesc = new TextArea(this.textForMissionDialogueDesc);
		
		Rectangle lukeSkywalkerIconBoxOutline = new Rectangle(0, 0, 159.5, 121.5);
		
		//Configuring title and description and and box outline settings
		missionDialogueTitle.setFont(Font.font("verdana", FontWeight.BOLD, 15));
		missionDialogueTitle.setFill(Color.CYAN);
		missionDialogueTitle.setTextAlignment(TextAlignment.CENTER);
		missionDialogueTitle.setUnderline(true);
		missionDialogueTitle.setTranslateX(142.5);
		missionDialogueTitle.setTranslateY(107.5);
		
		missionDialogueDesc.setFont(Font.font("verdana", FontWeight.BOLD, 9));
//		missionDialogueDesc.setStyle("-fx-text-fill: "+ "white" + ";");
		missionDialogueDesc.setWrapText(true);
		missionDialogueDesc.setEditable(false);
		
		lukeSkywalkerIconBoxOutline.setTranslateX(143.5);
		lukeSkywalkerIconBoxOutline.setTranslateY(158.5);
		lukeSkywalkerIconBoxOutline.setFill(null);
		lukeSkywalkerIconBoxOutline.setStroke(Color.MAGENTA);
		lukeSkywalkerIconBoxOutline.setStrokeWidth(2);
		lukeSkywalkerIconBoxOutline.setOpacity(0.6);
		
		//Add out description to our Scroll Pane
		this.scrollPaneForMissionDialogueDesc.setContent(missionDialogueDesc);
		
		//Add out scroll pane to our standard pane
		standardPaneForScrollBoxPane.getChildren().add(this.scrollPaneForMissionDialogueDesc);
		
		this.mainPane.getChildren().addAll(missionDialogueTitle, standardPaneForScrollBoxPane, lukeSkywalkerIconBoxOutline);
	}
	
	//A method that creates a back button to go back to the main menu
	public void backToMainMenuButton() 
	{
		//Creating back button and its image view
		this.backButton = new Button("");
		
		Image backButtonImage = new Image("Images_Battle_Grid_Assets/Main_Menu_Button_(Not_Highlighted).png");
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
		
		this.mainPane.getChildren().add(backButton);
		
		this.backButton.setOnMouseEntered(e -> 
		{
			this.backButtonImageView = new ImageView (new Image("Images_Battle_Grid_Assets/Main_Menu_Button_(Highlighted).png"));
			
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
			this.backButtonImageView = new ImageView (new Image("Images_Battle_Grid_Assets/Main_Menu_Button_(Not_Highlighted).png"));
			
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
			this.backButtonImageView = new ImageView (new Image("Images_Battle_Grid_Assets/Main_Menu_Button_(Pressed).png"));
			
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
			StarWarsGameGUI.musicPlayer.stop();
			StarWarsGameGUI.mediaPlayer("src/Music_Themes/Star_Wars_Main_Theme.wav");
			StarWarsGameGUI.musicPlayer.play();
			
			primaryStage.setScene(sceneInventory.get(0));
		}); 
	}
	
	//Getter Methods
	
	public StackPane getBattleGridSceneMainPane() 
	{
		return this.mainPane;
	}
	
	public GridPane getBattleGridDisplay() 
	{
		return this.battleGridDisplay;
	}
	
	public String getTextForMissionDialogueDesc() 
	{
		return this.textForMissionDialogueDesc;
	}
	
	public void setTextForMissionDialogueDesc(String newTextForMissionDialogueDesc) 
	{
		this.textForMissionDialogueDesc = newTextForMissionDialogueDesc;
	}

	public ScrollPane getScrollPaneForMissionDialogueDesc() 
	{
		return this.scrollPaneForMissionDialogueDesc;
	}

	public void setScrollPaneForMissionDialogueDesc(ScrollPane scrollPaneForMissionDialogueDesc) 
	{
		this.scrollPaneForMissionDialogueDesc = scrollPaneForMissionDialogueDesc;
	}

	public int getNumLightsaberSwings() {
		return this.numLightsaberSwings;
	}

	public void setNumLightsaberSwings(int numLightsaberSwings) {
		this.numLightsaberSwings = numLightsaberSwings;
	}

	public int getNumLightsaberSwingsUsed() {
		return numLightsaberSwingsUsed;
	}

	public void setNumLightsaberSwingsUsed(int numLightsaberSwingsUsed) {
		this.numLightsaberSwingsUsed = numLightsaberSwingsUsed;
	}

	public ImageView getLightsaberSwingAmountIconImageView() {
		return this.lightsaberSwingAmountIconImageView;
	}

	public void setLightsaberSwingAmountIconImageView(ImageView lightsaberSwingAmountIconImageView) {
		this.lightsaberSwingAmountIconImageView = lightsaberSwingAmountIconImageView;
	}

	public Rectangle getLightsaberSwingAmountIconBoxOutline() {
		return lightsaberSwingAmountIconBoxOutline;
	}

	public void setLightsaberSwingAmountIconBoxOutline(Rectangle lightsaberSwingAmountIconBoxOutline) {
		this.lightsaberSwingAmountIconBoxOutline = lightsaberSwingAmountIconBoxOutline;
	}
}
