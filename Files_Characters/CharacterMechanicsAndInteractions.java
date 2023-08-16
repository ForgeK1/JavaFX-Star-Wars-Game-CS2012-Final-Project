package Files_Characters;

import java.util.ArrayList;
import java.util.Random;

import Files_GUI.StarWarsGameGUI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
 				creative as possible. Choose any genre you wish, it 
 				does not have to be a fantasy setting.
				
   Description
   of class:    A class that will handle player and character mechanics
   				such as spawning characters in random locations when game
   				starts, give the ability to the player to move around the 
   				battleGridDisplay, and utilize of the character classes made
   			    (Luke, Vader, Stormtrooper, traps, and Kyber Crystals) to 
   			    define the player interactions with the other characters 
   			    or events or pickable objects.*/
public class CharacterMechanicsAndInteractions 
{
	//1) DATA FIELDS
	
	//Private Variables to add onto or change the scene
	private Stage primaryStage;
	private ArrayList<Scene> sceneInventory;
	
	//A private ArrayList to store all of our characters
	private ArrayList<Label> characterRoster;
	
	/*A private 2D Label array to keep track of every 
	  character info on the battleGridDisplay*/
	private Label[][] characterRosterGridInfo;
	
	//Private Character Objects
	private LukeSkywalker lukeSkywalker;
	private DarthVader darthVader;
	private CloneTrooper501st ct501st;
	private NavalOfficer navalOfficer;
	private MouseDroid mouseDroid;
	private OuterSpaceTrap osTrap;
	private TrashCompactorTrap tcTrap;
	private VentilationShaftTrap vsTrap;
	private GreenKyberCrystal gkCrystal1;
	private GreenKyberCrystal gkCrystal2;
	
	//2) CONSTRUCTORS
	
	public CharacterMechanicsAndInteractions(Stage primaryStage, ArrayList<Scene> sceneInventory) 
	{
		this.primaryStage = primaryStage;
		this.sceneInventory = sceneInventory;
		
		//Instantiating our characterRoster ArrayList
		this.characterRoster = new ArrayList<Label>();
		
		//Assigning our characterRosterGridInfo 2D array an empty array
		this.characterRosterGridInfo = new Label[0][0];
				
		//Assigning the list of character Labels to characterRoster ArrayList 
		this.lukeSkywalker = new LukeSkywalker();
		this.darthVader = new DarthVader();
		this.ct501st = new CloneTrooper501st();
		this.navalOfficer = new NavalOfficer();
		this.mouseDroid = new MouseDroid();
		this.osTrap = new OuterSpaceTrap();
		this.tcTrap = new TrashCompactorTrap();
		this.vsTrap = new VentilationShaftTrap();
		this.gkCrystal1 = new GreenKyberCrystal();
		this.gkCrystal2 = new GreenKyberCrystal();
	}
	
	//3) METHODS
	
	/*A method that will set up all of the characters' mechanics
	  and interactions*/
	public void setUpCharacterMAI(int rowMax, int columnMax) 
	{		
		//A print statement to check if method is executed
//				System.out.println("setUpCharacterMAI method runs");
		
		/*We reset the Character Roster Label ArrayList and Character Roster Grid Info
		  2D array every time the player starts a new game.
		  
		  Note: The player starts a new game because this method when the player chooses
		  		a battleGridDisplay in the level selector menu*/
		this.characterRoster = new ArrayList<Label>();
		this.characterRosterGridInfo = new Label[rowMax][columnMax];
		
		/*A series of methods that will add components to our 
		  character mechanics and interactions scene*/
		
		configureImageViewSettingsAndFillCharacterRoster();
		
		fillCharacterRosterGridInfo(rowMax, columnMax);
		
		randomCharacterBattleGridDisplayPlacement();
		
		playerMovementAndLightsaberAttack(rowMax, columnMax);
		
		detectNearbyCharactersInAdjacentRooms(rowMax, columnMax);
	}
	
	/*A method that will resize and configure the setting of all image 
	  views from all character objects, and then add them to the
	  characterRoster Label ArrayList*/
	public void configureImageViewSettingsAndFillCharacterRoster() 
	{
		//A print statement to check if method is executed
//				System.out.println("fillCharacterRosterGridInfo method runs");
		
		this.lukeSkywalker.getCharacterIconImageView().setFitWidth(50);
		this.lukeSkywalker.getCharacterIconImageView().setFitHeight(50);
		
		this.darthVader.getCharacterIconImageView().setFitWidth(50);
		this.darthVader.getCharacterIconImageView().setFitHeight(50);
		this.darthVader.getDarthVaderLabel().setOpacity(0);
		
		this.ct501st.getCharacterIconImageView().setFitWidth(50);
		this.ct501st.getCharacterIconImageView().setFitHeight(50);
		this.ct501st.getCloneTrooper501stLabel().setOpacity(0);
		
		this.navalOfficer.getCharacterIconImageView().setFitWidth(50);
		this.navalOfficer.getCharacterIconImageView().setFitHeight(50);
		this.navalOfficer.getNavalOfficerLabel().setOpacity(0);
		
		this.mouseDroid.getCharacterIconImageView().setFitWidth(50);
		this.mouseDroid.getCharacterIconImageView().setFitHeight(50);
		this.mouseDroid.getMouseDroidLabel().setOpacity(0);
		
		this.osTrap.getCharacterIconImageView().setFitWidth(50);
		this.osTrap.getCharacterIconImageView().setFitHeight(50);
		this.osTrap.getOuterSpaceTrapLabel().setOpacity(0);
		
		this.tcTrap.getCharacterIconImageView().setFitWidth(50);
		this.tcTrap.getCharacterIconImageView().setFitHeight(50);
		this.tcTrap.getTrashCompactorTrapLabel().setOpacity(0);
		
		this.vsTrap.getCharacterIconImageView().setFitWidth(50);
		this.vsTrap.getCharacterIconImageView().setFitHeight(50);
		this.vsTrap.getVentilationShaftTrapLabel().setOpacity(0);
		
		this.gkCrystal1.getCharacterIconImageView().setFitWidth(50);
		this.gkCrystal1.getCharacterIconImageView().setFitHeight(50);
		this.gkCrystal1.getGreenKyberCrystalLabel().setOpacity(0);
		this.gkCrystal1.getGreenKyberCrystalLabel().setId("Green Kyber Crystal 1");
		
		this.gkCrystal2.getCharacterIconImageView().setFitWidth(50);
		this.gkCrystal2.getCharacterIconImageView().setFitHeight(50);
		this.gkCrystal2.getGreenKyberCrystalLabel().setOpacity(0);
		this.gkCrystal2.getGreenKyberCrystalLabel().setId("Green Kyber Crystal 2");
		
		/*Assigns the newley sized image views to the character roster Label
		  ArrayList*/
		this.characterRoster.add(this.lukeSkywalker.getLukeSkywalkerLabel());
		this.characterRoster.add(this.darthVader.getDarthVaderLabel());
		this.characterRoster.add(this.ct501st.getCloneTrooper501stLabel());
		this.characterRoster.add(this.navalOfficer.getNavalOfficerLabel());
		this.characterRoster.add(this.mouseDroid.getMouseDroidLabel());
		this.characterRoster.add(this.osTrap.getOuterSpaceTrapLabel());
		this.characterRoster.add(this.tcTrap.getTrashCompactorTrapLabel());
		this.characterRoster.add(this.vsTrap.getVentilationShaftTrapLabel());
		this.characterRoster.add(this.gkCrystal1.getGreenKyberCrystalLabel());
		this.characterRoster.add(this.gkCrystal2.getGreenKyberCrystalLabel());
		
		//A for loop that will configure the label settings of each object
		for(int i = 0; i < this.characterRoster.size(); i++) 
		{
			/*The Min, Max, and alignment makes sure the imageviews stay in
			  the middle of the grid slot they are in, regardless of the 
			  grid space (5x5 or 7x7 or 10x7) chosen by the player*/
			this.characterRoster.get(i).setMinSize(10, 10);
			this.characterRoster.get(i).setMaxSize(100, 100);
			this.characterRoster.get(i).setAlignment(Pos.CENTER);
		}
	}
	
	/*A method that will fill the characterRosterGridInfo 2D array with
	  each character Label that will be placed in a random row and column  
	  index of the 2D array*/
	public void fillCharacterRosterGridInfo(int rowMax, int columnMax) 
	{
		Random random = new Random();
		
		for(int i = 0; i < this.characterRoster.size(); i++) 
		{
			boolean continueLoop = true;
			
			//A print statement to check for errors
//					System.out.println("Current i = " + i);
			
			/*A while loop that will to continue to occur until each
			  character Label can be assigned their own row and 
			  column index without occupying the space of or deleting
			  another Character Label*/
			while(continueLoop) 
			{
				int randomRow = random.nextInt(0, rowMax);
				int randomColumn = random.nextInt(0, columnMax);
				
				if(this.characterRosterGridInfo[randomRow][randomColumn] == null) 
				{
					this.characterRosterGridInfo[randomRow][randomColumn] = this.characterRoster.get(i);
				
					continueLoop = false;
				}
				
				//A print statement to check for errors
//						System.out.println("(" + randomRow + ", " + randomColumn + ")");
			}					
		}
	}
	
	/*A method that will use the filled characterRosterGridInfo 2D array to place each character
	  Label on the battleGridDisplay based on the random row and column index position they were 
	  assigned with in the fillCharacterRosterGridInfo method*/
	public void randomCharacterBattleGridDisplayPlacement() 
	{
		//A print statement to check if method is executed
//				System.out.println("randomCharacterPlacement method runs");
		
		for(int row = 0; row < this.characterRosterGridInfo.length; row++) 
		{
			for(int column = 0; column < this.characterRosterGridInfo[row].length; column++) 
			{
				/*This if statement ensures that we don't put a null objects inside of a
				  randomly chosen grid slot of the battleGridDisplay*/
				if(this.characterRosterGridInfo[row][column] != null) 
				{					
					StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   .getBattleGridDisplay()
								   .add(this.characterRosterGridInfo[row][column], column, row);
					
					/*Records the player's position so that they are able to move in the
					  playerMovementAndLightsaberAttack method in this class*/
					if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[row][column]
									  .getId().equals("Luke Skywalker")) 
					{						
						this.lukeSkywalker.setPlayerRowCoordinate(row);
						
						this.lukeSkywalker.setPlayerColCoordinate(column);
					}
					
					/*Records Darth VAder's position so that they are able to move
					  in the darthVaderMovement method of its own class*/
					if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[row][column]
									  .getId().equals("Darth Vader")) 
					{						
						this.darthVader.setDarthVaderRowCoordinate(row);
						
						this.darthVader.setDarthVaderColCoordinate(column);
					}
				}
			}
		}
	}
	
	/*Purpose of this method:
		  1) A method that allows the player to move around the grid using W A S D and 
		     it makes sure to prevent player from going out of the map bounderies.
		  
		  2) A method that will allow the player to attack Darth Vader or any space with their 
	  		 lightsaber
	  
			 Note: If the player attacks an empty space or another character other than Darth
			  	   Darth Vader then nothing will happen to the empty space or that character*/
	public void playerMovementAndLightsaberAttack(int rowMax, int columnMax) 
	{						
		/*This method will request focus on the Luke Skywalker Label the player
		  will be using to move around the grid*/
		this.lukeSkywalker.getLukeSkywalkerLabel().requestFocus();
		
		//-----------------------------------------------------------------------//
		//****************************PLAYER MOVEMENT****************************//
		//-----------------------------------------------------------------------//
		
		/*A lambda expression that will take any key pressed, turn it into a
		  keycode, and use a switch statement to make the player go up, left,
		  down, or right*/
		this.lukeSkywalker.getLukeSkywalkerLabel().setOnKeyPressed(e -> 
		{									
			/*Recording adjacent room positions based on player's location*/
			int playerTopAdjacentRoom = this.lukeSkywalker.getPlayerRowCoordinate() - 1;
			int playerLeftAdjacentRoom = this.lukeSkywalker.getPlayerColCoordinate() - 1;
			int playerBottomAdjacentRoom = this.lukeSkywalker.getPlayerRowCoordinate() + 1;
			int playerRightAdjacentRoom = this.lukeSkywalker.getPlayerColCoordinate() + 1;
			
			KeyCode kc = e.getCode();
			
			switch(kc) 
			{
				case UP: 
					//Print statement to test case W
//							System.out.println("\nYou pressed the W key");
					
					/*This if statement makes sure the the next step the player will
					  will not go out of the top most wall of the map bounderies*/
					if(!(playerTopAdjacentRoom < 0)) 
					{												
						/*This nested if statement will see if there is a character in the position the
						  player wants to go to, if so then the player interacts with character, if not 
						  then the player into that position*/
						if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
										  != null &&
										  
						   !(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										    .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
										    .getId().equals(""))) 
						{
							characterInteractionSelection(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
																		 .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]);
						} 
						else 
						{
							//Removes Luke from original position from battleGridDisplay					
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
							    		   .getChildren().remove(this.lukeSkywalker.getLukeSkywalkerLabel());
				
							/*Adds an empty Label to Luke's original position from battleGridDisplay and 
							  replace Luke label with a null object in the 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .getBattleGridDisplay().add(createEmptyLabel(),
												   					   this.lukeSkywalker.getPlayerColCoordinate(),
												   					   this.lukeSkywalker.getPlayerRowCoordinate());
									
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()] = null;
							
							//Assigns Luke's new position
							this.lukeSkywalker.setPlayerRowCoordinate(this.lukeSkywalker.getPlayerRowCoordinate() - 1);
							
							/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   			   .getBattleGridDisplay()
							   			   .add(this.lukeSkywalker.getLukeSkywalkerLabel(),
							   					this.lukeSkywalker.getPlayerColCoordinate(),
							   					this.lukeSkywalker.getPlayerRowCoordinate());
							
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()]
														= this.lukeSkywalker.getLukeSkywalkerLabel();
							
							//Print statement to test case W
//									System.out.println("Luke has moved up 1\n");
						
							/*Calls method to detect any characters around the player after the player
							  moves*/
							detectNearbyCharactersInAdjacentRooms(rowMax, columnMax);
						}	
					}
					else 
					{
						//Print statement to test case W
//								System.out.println("Luke did not move up 1 because you hit map bounderies!\n");
					}
					
				; break;
					
				case  A:  
					
					//Print statement to test case A
//							System.out.println("\nYou pressed the A key");
					
					/*This if statement makes sure the the next step the player will
					  will not go out of the left most wall of the map bounderies*/
					if(!(playerLeftAdjacentRoom < 0)) 
					{						
						/*This nested if statement will see if there is a character in the position the
						  player wants to go to, if so then the player interacts with character, if not 
						  then the player into that position*/
						if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]
										  != null &&
										  
						   !(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										    .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]
										    .getId().equals(""))) 
						{
							characterInteractionSelection(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
																		 .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]);
						} 
						else 
						{
							//Removes Luke from the battleGridDisplay					
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
							    		   .getChildren().remove(this.lukeSkywalker.getLukeSkywalkerLabel());
				
							/*Adds an empty Label to Luke's original position from battleGridDisplay and 
							  replace Luke label with a null object in the 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .getBattleGridDisplay().add(createEmptyLabel(),
												   					   this.lukeSkywalker.getPlayerColCoordinate(),
												   					   this.lukeSkywalker.getPlayerRowCoordinate());
									
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()] = null;
							
							//Assigns Luke's new position
							this.lukeSkywalker.setPlayerColCoordinate(this.lukeSkywalker.getPlayerColCoordinate() - 1);
							
							/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   			   .getBattleGridDisplay()
							   			   .add(this.lukeSkywalker.getLukeSkywalkerLabel(),
							   					this.lukeSkywalker.getPlayerColCoordinate(),
							   					this.lukeSkywalker.getPlayerRowCoordinate());
							
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()]
														= this.lukeSkywalker.getLukeSkywalkerLabel();
							
							//Print statement to test case A
//								System.out.println("Luke has moved left 1\n");
						
							/*Calls method to detect any characters around the player after the player
							  moves*/
							detectNearbyCharactersInAdjacentRooms(rowMax, columnMax);
						}						
					}
					else 
					{
						//Print statement to test case A
//								System.out.println("Luke did not move left 1 because you hit map bounderies!\n");
					}
					
				; break;
				
				case S: 
					
					//Print statement to test case S
//							System.out.println("\nYou pressed the S key");
					
					/*This if statement makes sure the the next step the player will
					  will not go out of the bottom most wall of the map bounderies*/
					if(!(playerBottomAdjacentRoom > rowMax - 1)) 
					{						
						/*This nested if statement will see if there is a character in the position the
						  player wants to go to, if so then the player interacts with character, if not 
						  then the player into that position*/
						if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
										  != null &&
										  
						   !(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										    .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
										    .getId().equals(""))) 
						{
							characterInteractionSelection(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
																		 .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]);
						} 
						else 
						{
							//Removes Luke from original position from battleGridDisplay					
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
							    		   .getChildren().remove(this.lukeSkywalker.getLukeSkywalkerLabel());
				
							/*Adds an empty Label to Luke's original position from battleGridDisplay and 
							  replace Luke label with a null object in the 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .getBattleGridDisplay().add(createEmptyLabel(),
												   					   this.lukeSkywalker.getPlayerColCoordinate(),
												   					   this.lukeSkywalker.getPlayerRowCoordinate());
									
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()] = null;
							
							//Assigns Luke's new position
							this.lukeSkywalker.setPlayerRowCoordinate(this.lukeSkywalker.getPlayerRowCoordinate() + 1);
							
							/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   			   .getBattleGridDisplay()
							   			   .add(this.lukeSkywalker.getLukeSkywalkerLabel(),
							   					this.lukeSkywalker.getPlayerColCoordinate(),
							   					this.lukeSkywalker.getPlayerRowCoordinate());
							
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()]
														= this.lukeSkywalker.getLukeSkywalkerLabel();
																			
							//Print statement to test case S
//									System.out.println("Luke has moved down 1\n");
						
							/*Calls method to detect any characters around the player after the player
							  moves*/
							detectNearbyCharactersInAdjacentRooms(rowMax, columnMax);
						}
					}
					else 
					{
						//Print statement to test case S
//							System.out.println("Luke did not move down 1 because you hit map bounderies!\n");
					}
								
				; break;
				
				case D: 
				
					//Print statement to test case D
//							System.out.println("\nYou pressed the D key");
					
					/*This if statement makes sure the the next step the player will
					  will not go out of the right most wall of the map bounderies*/
					if(!(playerRightAdjacentRoom > columnMax - 1)) 
					{						
						/*This nested if statement will see if there is a character in the position the
						  player wants to go to, if so then the player interacts with character, if not 
						  then the player into that position*/
						if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]
										  != null &&
										  
						   !(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
										    .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]
										    .getId().equals(""))) 
						{
							characterInteractionSelection(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
																		 .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]);
						}
						else 
						{
							//Removes Luke from original position from battleGridDisplay					
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().getBattleGridDisplay()
							    		   .getChildren().remove(this.lukeSkywalker.getLukeSkywalkerLabel());
				
							/*Adds an empty Label to Luke's original position from battleGridDisplay and 
							  replace Luke label with a null object in the 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .getBattleGridDisplay().add(createEmptyLabel(),
												   					   this.lukeSkywalker.getPlayerColCoordinate(),
												   					   this.lukeSkywalker.getPlayerRowCoordinate());
									
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()] = null;
							
							//Assigns Luke's new position
							this.lukeSkywalker.setPlayerColCoordinate(this.lukeSkywalker.getPlayerColCoordinate() + 1);
							
							/*Adds Luke to a new position in the battleGridDisplay and 2D array info*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
							   			   .getBattleGridDisplay()
							   			   .add(this.lukeSkywalker.getLukeSkywalkerLabel(),
							   					this.lukeSkywalker.getPlayerColCoordinate(),
							   					this.lukeSkywalker.getPlayerRowCoordinate());
							
							this.characterRosterGridInfo[this.lukeSkywalker.getPlayerRowCoordinate()]
														[this.lukeSkywalker.getPlayerColCoordinate()]
														= this.lukeSkywalker.getLukeSkywalkerLabel();
							
							//Print statement to test case D
//								System.out.println("Luke has moved right 1\n");
						
							/*Calls method to detect any characters around the player after the player
							  moves*/
							detectNearbyCharactersInAdjacentRooms(rowMax, columnMax);
						}
					}
					else 
					{
						//Print statement to test case D
//							System.out.println("Luke did not move right 1 because you hit map bounderies!\n");
					}
				
				; break;
				
				default: 
					
					//Requests focus from the program for the Luke Label so that player can move again 
					StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
								   .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()]
										   						[this.lukeSkywalker.getPlayerColCoordinate()]
								   .requestFocus();	
					
			}
			
			//A print statement to let me know what the current and max row and column are for the player
//					System.out.println("\nCurrent Row: " + (this.lukeSkywalker.getPlayerRowCoordinate() + 1) +
//					     	   		   "\nRow Max: " + rowMax +
//					     	   		   "\nCurrent Column: " + (this.lukeSkywalker.getPlayerColCoordinate() + 1) +
//					     	   		   "\nColumn Max: " + columnMax + "\n");
			
			//-----------------------------------------------------------------------//
			//*****************************PLAYER ATTACK*****************************//
			//-----------------------------------------------------------------------//
			
			switch(kc) 
			{
			case I: 				
				//A print statement to check if the key "I" is detected when pressed
//						System.out.println("Key I is being pressed");
				
				/*This if statement makes sure the position the player will attack
				  does not go out of the top most wall of the map bounderies*/
				if(!(this.lukeSkywalker.getPlayerRowCoordinate() - 1 < 0)) 
				{												
					/*This nested if statement checks if the user went above the total number 
					  of lightsaber swings because there is only a total amount of 5 swings the 
					  player can use before they lose the game. 
					  
					  If this is true, then we will play the lose screen where Luke has no more
					  swings left. But if this is false, then we will let the player try to swing
					  again
					  
					  Note: We set the number of lightsaber swings used to 0 everytime we start a new
					        game and to count to 5 it will go from 0 to 4. That is why the if statement
					        checks if number of Lightsaber Swings Used == 4*/
					if(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() == 5) 
					{
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
									   .playerLoseAllAmmo();
					}
					else 
					{
						/*This nested if statement checks if the player is trying to use a Swing ammo when
						  they are at 0 swings. If not, then the program will create a new lightsaber
						  icon and increase the amount of swings used
						  
						  Note: This will the player from defeating Vader if they are at 0 swings*/
						if(!(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() == 0)) 
						{
							/*This nested if statement will see if there is a character in the position the
							  player wants to attack. If so, then the it checks if the character we are looking at
							  is Darth Vader, and if not, then the player's lightsaber swing amount decrements, the
							  number of lightsaber swings used increments, and Vader does not get defeated*/
							if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
											  != null &&
											  
							   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
											  .getId().equals("Darth Vader")) 
							{
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											   .getLukeSkywalker().playerWinInteraction();
							}
							else 
							{						
								//A print statement to check if the else statement occurs
//									System.out.println("The lightsaber Icon should be removed and updated now");
								
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
								   			   .setNumLightsaberSwings
								   			   (
								   					(StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   			                       .getNumLightsaberSwings() - 1)
								   			   );
								
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .createLightsaberSwingAmountIcon();
								
								/*Increments the number of lightsaber ammo used to check if player is 
								  trying to use more than the total number of five swings given to 
								  them*/
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .setNumLightsaberSwingsUsed
											   (
													   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getNumLightsaberSwingsUsed() + 1									   
											   );
							
								/*Since the player missed their lightsaber swing against Vader, then he will move.
								  to an adjacent position*/
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getDarthVader().darthVaderMovement(rowMax, columnMax);
							}
						}
						else 
						{						
							/*Creating a temp String to send to the mission dialouge to let the player know
							  that they have used all of their swings and they need to look for more*/
							String newMissionDialogueText = "NOTICE: You cannot \nswing your lightsaber \nany more " +
															"because you \ndo not have any more \ngreen Kyber Crystals " +
									   				 	    "to \nuse! Try to find some \nmore Kyber Crystals \naround your " +
									   				 	    "area.";

							String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
																		   .getTextForMissionDialogueDesc();
							
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
							
							/*We call this method again to reset the Scroll Pane with our new Text*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
							
							/*A print statement to check if the new text has been set for
							  the mission dialogue*/
//									System.out.println("New text has been sent out");
						}
					}					
				}
				else 
				{
					//Print statement to test case I
//							System.out.println("Luke did not move up 1 because you hit map bounderies!\n");
				}
				
				//A print statement to check the number of lightsaber swings left and used
//						System.out.println("Number of Swings left: " + StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() +
//						   		   		   "\nNumber of Swings used: " + StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() + "\n");
				
			; break;
				
			case  J:  
				
				//Print statement to test case A
//						System.out.println("\nYou pressed the A key");
				
				/*This if statement makes sure the the next step the player will
				  will not go out of the left most wall of the map bounderies*/
				if(!(this.lukeSkywalker.getPlayerColCoordinate() - 1 < 0)) 
				{						
					/*This nested if statement checks if the total number of lightsaber ammo used 
					  is 5 because there is only a total amount of 5 swings the player can use 
					  before they lose the game. 
					  
					  If this is true, then we will play the lose screen where Luke has no more
					  swings left. But if this is false, then we will let the player try to swing
					  again
					  
					  Note: We set the number of lightsaber swings used to 0 everytime we start a new
					        game and to count to 5 it will go from 0 to 4. That is why the if statement
					        checks if number of Lightsaber Swings Used == 4*/
					if(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() == 5) 
					{
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
									   .playerLoseAllAmmo();
					}
					else 
					{
						/*This nested if statement checks if the player is trying to use a Swing ammo when
						  they are at 0 swings. If not, then the program will create a new lightsaber
						  icon and increase the amount of swings used
						  
						  Note: This will the player from defeating Vader if they are at 0 swings*/
						if(!(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() == 0)) 
						{
							/*This nested if statement will see if there is a character in the position the
							  player wants to attack. If so, then the it checks if the character we are looking at
							  is Darth Vader, and if not, then the player's lightsaber swing amount decrements, the
							  number of lightsaber swings used increments, and Vader does not get defeated*/
							if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
									  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]
									  != null &&
									
							   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]
											  .getId().equals("Darth Vader")) 
							{
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											   .getLukeSkywalker().playerWinInteraction();
							}
							else 
							{						
								//A print statement to check if the else statement occurs
//									System.out.println("The lightsaber Icon should be removed and updated now");
								
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
								   			   .setNumLightsaberSwings
								   			   (
								   					(StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   			                       .getNumLightsaberSwings() - 1)
								   			   );
								
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .createLightsaberSwingAmountIcon();
								
								/*Increments the number of lightsaber ammo used to check if player is 
								  trying to use more than the total number of five swings given to 
								  them*/
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .setNumLightsaberSwingsUsed
											   (
													   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getNumLightsaberSwingsUsed() + 1									   
											   );
							
								/*Since the player missed their lightsaber swing against Vader, then he will move.
								  to an adjacent position*/
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getDarthVader().darthVaderMovement(rowMax, columnMax);
							}
						}
						else 
						{
							/*Creating a temp String to send to the mission dialouge to let the player know
							  that they have used all of their swings and they need to look for more*/
							String newMissionDialogueText = "NOTICE: You cannot \nswing your lightsaber \nany more " +
															"because you \ndo not have any more \ngreen Kyber Crystals " +
									   				 	    "to \nuse! Try to find some \nmore Kyber Crystals \naround your " +
									   				 	    "area.";

							String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
																		   .getTextForMissionDialogueDesc();
							
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
							
							/*We call this method again to reset the Scroll Pane with our new Text*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
						}
					}					
				}
				else 
				{
					//Print statement to test case J
//							System.out.println("Luke did not move up 1 because you hit map bounderies!\n");
				}
								
			; break;
			
			case K: 
				
				//Print statement to test case S
//						System.out.println("\nYou pressed the S key");
				
				/*This if statement makes sure the the next step the player will
				  will not go out of the bottom most wall of the map bounderies*/
				if(!(this.lukeSkywalker.getPlayerRowCoordinate() + 1 > rowMax - 1)) 
				{						
					/*This nested if statement checks if the total number of lightsaber ammo used 
					  is 5 because there is only a total amount of 5 swings the player can use 
					  before they lose the game. 
					  
					  If this is true, then we will play the lose screen where Luke has no more
					  swings left. But if this is false, then we will let the player try to swing
					  again
					  
					  Note: We set the number of lightsaber swings used to 0 everytime we start a new
					        game and to count to 5 it will go from 0 to 4. That is why the if statement
					        checks if number of Lightsaber Swings Used == 4*/
					if(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() == 5) 
					{
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
									   .playerLoseAllAmmo();
					}
					else 
					{
						/*This nested if statement checks if the player is trying to use a Swing ammo when
						  they are at 0 swings. If not, then the program will create a new lightsaber
						  icon and increase the amount of swings used
						  
						  Note: This will the player from defeating Vader if they are at 0 swings*/
						if(!(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() == 0)) 
						{
							/*This nested if statement will see if there is a character in the position the
							  player wants to attack. If so, then the it checks if the character we are looking at
							  is Darth Vader, and if not, then the player's lightsaber swing amount decrements
							  and Vader does not get defeated*/
							if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
											  != null &&
											  
							   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
											  .getId().equals("Darth Vader")) 
							{
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											   .getLukeSkywalker().playerWinInteraction();
							}
							else 
							{						
								//A print statement to check if the else statement occurs
//									System.out.println("The lightsaber Icon should be removed and updated now");
								
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
								   			   .setNumLightsaberSwings
								   			   (
								   					(StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   			                       .getNumLightsaberSwings() - 1)
								   			   );
								
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .createLightsaberSwingAmountIcon();
								
								/*Increments the number of lightsaber ammo used to check if player is 
								  trying to use more than the total number of five swings given to 
								  them*/
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .setNumLightsaberSwingsUsed
											   (
													   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getNumLightsaberSwingsUsed() + 1									   
											   );
							
								/*Since the player missed their lightsaber swing against Vader, then he will move.
								  to an adjacent position*/
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getDarthVader().darthVaderMovement(rowMax, columnMax);
							}
						}
						else 
						{
							/*Creating a temp String to send to the mission dialouge to let the player know
							  that they have used all of their swings and they need to look for more*/
							String newMissionDialogueText = "NOTICE: You cannot \nswing your lightsaber \nany more " +
															"because you \ndo not have any more \ngreen Kyber Crystals " +
									   				 	    "to \nuse! Try to find some \nmore Kyber Crystals \naround your " +
									   				 	    "area.";

							String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
																		   .getTextForMissionDialogueDesc();
							
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
							
							/*We call this method again to reset the Scroll Pane with our new Text*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
						}
					}					
				}
				else 
				{
					//Print statement to test case K
//							System.out.println("Luke did not move up 1 because you hit map bounderies!\n");
				}
									
			; break;
			
			case L: 
			
				//Print statement to test case D
//						System.out.println("\nYou pressed the D key");
				
				/*This if statement makes sure the the next step the player will
				  will not go out of the right most wall of the map bounderies*/
				if(!(this.lukeSkywalker.getPlayerColCoordinate() + 1 > columnMax - 1)) 
				{						
					/*This nested if statement checks if the total number of lightsaber ammo used 
					  is 5 because there is only a total amount of 5 swings the player can use 
					  before they lose the game. 
					  
					  If this is true, then we will play the lose screen where Luke has no more
					  swings left. But if this is false, then we will let the player try to swing
					  again
					  
					  Note: We set the number of lightsaber swings used to 0 everytime we start a new
					        game and to count to 5 it will go from 0 to 4. That is why the if statement
					        checks if number of Lightsaber Swings Used == 4*/
					if(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwingsUsed() == 5) 
					{
						StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker()
									   .playerLoseAllAmmo();
					}
					else 
					{
						/*This nested if statement checks if the player is trying to use a Swing ammo when
						  they are at 0 swings. If not, then the program will create a new lightsaber
						  icon and increase the amount of swings used
						  
						  Note: This will the player from defeating Vader if they are at 0 swings*/
						if(!(StarWarsGameGUI.getSceneInventory().getBattleGridScene().getNumLightsaberSwings() == 0)) 
						{
							/*This nested if statement will see if there is a character in the position the
							  player wants to attack. If so, then the it checks if the character we are looking at
							  is Darth Vader, and if not, then the player's lightsaber swing amount decrements
							  and Vader does not get defeated*/
							if(StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]
											  != null &&
											  
							   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]
											  .getId().equals("Darth Vader")) 
							{
								StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											   .getLukeSkywalker().playerWinInteraction();
							}
							else 
							{						
								//A print statement to check if the else statement occurs
//									System.out.println("The lightsaber Icon should be removed and updated now");
								
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
								   			   .setNumLightsaberSwings
								   			   (
								   					(StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   			                       .getNumLightsaberSwings() - 1)
								   			   );
								
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .createLightsaberSwingAmountIcon();
								
								/*Increments the number of lightsaber ammo used to check if player is 
								  trying to use more than the total number of five swings given to 
								  them*/
								StarWarsGameGUI.getSceneInventory().getBattleGridScene()
											   .setNumLightsaberSwingsUsed
											   (
													   StarWarsGameGUI.getSceneInventory().getBattleGridScene()
													   .getNumLightsaberSwingsUsed() + 1									   
											   );
							}
							
							/*Since the player missed their lightsaber swing against Vader, then he will move.
							  to an adjacent position*/
							StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getDarthVader().darthVaderMovement(rowMax, columnMax);
						}
						else 
						{
							/*Creating a temp String to send to the mission dialouge to let the player know
							  that they have used all of their swings and they need to look for more*/
							String newMissionDialogueText = "NOTICE: You cannot \nswing your lightsaber \nany more " +
															"because you \ndo not have any more \ngreen Kyber Crystals " +
									   				 	    "to \nuse! Try to find some \nmore Kyber Crystals \naround your " +
									   				 	    "area.";

							String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
																		   .getTextForMissionDialogueDesc();
							
							StarWarsGameGUI.getSceneInventory().getBattleGridScene()
										   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
							
							/*We call this method again to reset the Scroll Pane with our new Text*/
							StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
						}
					}					
				}
				else 
				{
					//Print statement to test case L
//							System.out.println("Luke did not move up 1 because you hit map bounderies!\n");
				}
								
				; break;
				
				default: ;
			}
		});
	}
	
	/*A method that will detect any characters that are adjacent to the player's
	  location and will call the createMissionDialogue method to pass in a message
	  based on which characters the player senses nearby
	  
	  Note: We check first if the position we trying to access to is out of
	  		out of bounds of the 2D array info (which has the same bounderies as
	  		the battleGridDisplay). If the position we are accessing is out of 
	  		bounds, then we continue to check if the position we are looking at 
	  		contains a character or a null object. Once we identify the character,
	  		we then pass message to the missionDialogue method to display it in
	  		the game*/
	public void detectNearbyCharactersInAdjacentRooms(int rowMax, int columnMax) 
	{
		/*Recording adjacent room positions based on player's location*/
		int playerTopAdjacentRoom = this.lukeSkywalker.getPlayerRowCoordinate() - 1;
		int playerLeftAdjacentRoom = this.lukeSkywalker.getPlayerColCoordinate() - 1;
		int playerBottomAdjacentRoom = this.lukeSkywalker.getPlayerRowCoordinate() + 1;
		int playerRightAdjacentRoom = this.lukeSkywalker.getPlayerColCoordinate() + 1;
		
		
		/*A print statement to see what the grid positions are for the rooms that are
		  adjacent to the player*/
//				System.out.printf("\nplayerTop: %d \nPlayerLeft %d \nPlayerBottom: %d \nPlayerRight: %d \n", 
//								  playerTopAdjacentRoom, playerLeftAdjacentRoom, playerBottomAdjacentRoom, 
//								  playerRightAdjacentRoom);
		
		/*An if statement to check if there is a character above the player and print
		  its mission dialogue text*/
		if(!(playerTopAdjacentRoom < 0) &&
				
		   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						  .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
						  != null) 
		{
			String newMissionDialogueText = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
		  			   .getCharacterRosterGridInfo()[playerTopAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
		  			   .getEllipsisString();

			String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
														   .getTextForMissionDialogueDesc();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to see new text and old text
//					System.out.println(newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to ensure the player can detect character
//					System.out.println("\nCharacter detected in playerTopAdjacentRoom\n");
		}
		
		/*An if statement to check if there is a character to the left of the player and print
		  its mission dialogue text*/
		if(!(playerLeftAdjacentRoom < 0) &&
				
		   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]
						  != null)
		{
			String newMissionDialogueText = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  			   .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerLeftAdjacentRoom]
											  			   .getEllipsisString();
	
			String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   .getTextForMissionDialogueDesc();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to see new text and old text
//					System.out.println(newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to ensure the player can detect character
	//					System.out.println("\nCharacter detected in playerLeftAdjacentRoom\n");
		}
		
		/*An if statement to check if there is a character below the player and print
		  its mission dialogue text*/
		if(!(playerBottomAdjacentRoom > rowMax - 1) &&
				
		   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						  .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
						  != null) 
		{
			String newMissionDialogueText = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
											  			   .getCharacterRosterGridInfo()[playerBottomAdjacentRoom][this.lukeSkywalker.getPlayerColCoordinate()]
											  			   .getEllipsisString();

			String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   .getTextForMissionDialogueDesc();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to see new text and old text
//					System.out.println(newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to ensure the player can detect character
//					System.out.println("\nCharacter detected in playerBottomAdjacentRoom\n");
		}
		
		/*An if statement to check if there is a character to the right of the player and print
		  its mission dialogue text*/
		if(!(playerRightAdjacentRoom > columnMax - 1) &&
				
		   StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
						  .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]
						  != null) 
		{
			String newMissionDialogueText = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
														   .getCharacterRosterGridInfo()[this.lukeSkywalker.getPlayerRowCoordinate()][playerRightAdjacentRoom]
											  			   .getEllipsisString();

			String oldMissionDialogueText = StarWarsGameGUI.getSceneInventory().getBattleGridScene()
								   .getTextForMissionDialogueDesc();
			
			StarWarsGameGUI.getSceneInventory().getBattleGridScene()
						   .setTextForMissionDialogueDesc("\n" + newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to see new text and old text
//					System.out.println(newMissionDialogueText + "\n" + oldMissionDialogueText + "\n");
			
			//A print statement to ensure the player can detect character
//					System.out.println("\nCharacter detected in playerRightAdjacentRoom\n");
		}
		
		/*We call this method again to reset the Scroll Pane's Mission Dialogue box 
		  so that everytime the player moves and detects another character that prompts 
		  the program to display a message, we then grab that new message and attach the 
		  old message before creating our new Scroll Pane's Mission Dialogue box Dialogue
		  box we want to create*/
		StarWarsGameGUI.getSceneInventory().getBattleGridScene().createMissionDialogue();
		
		//-------------Requests Focus For Player Movement-------------
		
		int playRowCoordinate = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerRowCoordinate();
		int playerColumnCoordinate = StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerColCoordinate();
		
		//Requests focus from the program for the Luke Label so that player can move again 
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRosterGridInfo()[playRowCoordinate][playerColumnCoordinate]
					   .requestFocus();
		
		//Requests focus from the program for the Luke Label so that player can move again 
		StarWarsGameGUI.getSceneInventory().getCharacterMAIScene()
					   .getCharacterRosterGridInfo()[StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerRowCoordinate()]
							   						[StarWarsGameGUI.getSceneInventory().getCharacterMAIScene().getLukeSkywalker().getPlayerColCoordinate()]
					   .requestFocus();	
	}

	/*A method that will run if the player tries to go in a space where a character, event, 
	  or Kyber Crystal ammunition is*/
	public void characterInteractionSelection(Label character) 
	{
		if(character.getId().equals("Darth Vader")) 
		{
			this.darthVader.playerLoseInteraction();
		}
		else if(character.getId().equals("501st Clone Trooper")) 
		{
			this.ct501st.playerInteraction();
		}
		else if(character.getId().equals("Naval Officer")) 
		{
			this.navalOfficer.playerInteraction();
		}
		else if(character.getId().equals("Mouse Droid")) 
		{
			this.mouseDroid.playerInteraction();
		}
		else if(character.getId().equals("Outer Space Trap")) 
		{
			this.osTrap.playerInteraction();
		}
		else if(character.getId().equals("Trash Compactor Trap")) 
		{
			this.tcTrap.playerInteraction();
		}
		else if(character.getId().equals("Ventilation Shaft Trap")) 
		{
			this.vsTrap.playerInteraction();
		}
		else if(character.getId().equals("Green Kyber Crystal 1")) 
		{
			//A print statement to check if player interacted with crystal 1
//					System.out.println("Crystal 1 Activated");
			
			this.gkCrystal1.playerInteraction();
			
			//Note: Both gkCrystal1 and gkCrystal2 have the same player interaction method
		}
		else if(character.getId().equals("Green Kyber Crystal 2")) 
		{
			//A print statement to check if player interacted with crystal 2
//					System.out.println("Crystal 2 Activated");
			
			this.gkCrystal2.playerInteraction();
		}
	}
	
	/*Will reset all characters' settings every time the player starts a new game*/
	public void resetCharacters() 
	{
		/*Removes all characters from the roster. We have to account that the 
		  player might have gotten the two Kyber Crystal objects, so we need to
		  remove all objects and re-add them back to account for every character.*/
		this.characterRoster.clear();
		
		//Reverts the both Green Krystal objects from being null
		this.gkCrystal1 = new GreenKyberCrystal();
		this.gkCrystal2 = new GreenKyberCrystal();
		
		//Re-adds all of the characters needed for the game
		configureImageViewSettingsAndFillCharacterRoster();
		
		for(int i = 0; i < this.characterRoster.size(); i++) 
		{
			this.characterRoster.get(i).setBackground(null);
		}
	}
	
	//A method to create an empty label
	public Label createEmptyLabel() 
	{
		Label tempLabel = new Label("");
		
		tempLabel.setTextFill(Color.CYAN);
		tempLabel.setLineSpacing(500);
		tempLabel.setAlignment(Pos.CENTER);
		tempLabel.setPrefSize(88, 60);
		tempLabel.setOpacity(1);
		tempLabel.setId("");
		
		return tempLabel;
	}
	
	//Getter Methods
	
	public ArrayList<Label> getCharacterRoster() 
	{
		return this.characterRoster;
	}

	public Label[][] getCharacterRosterGridInfo() 
	{
		return this.characterRosterGridInfo;
	}

	public LukeSkywalker getLukeSkywalker() {
		return this.lukeSkywalker;
	}

	public DarthVader getDarthVader() {
		return this.darthVader;
	}

	public CloneTrooper501st getCt501st() {
		return this.ct501st;
	}

	public NavalOfficer getNavalOfficer() {
		return this.navalOfficer;
	}

	public MouseDroid getMouseDroid() {
		return this.mouseDroid;
	}

	public OuterSpaceTrap getOsTrap() {
		return this.osTrap;
	}

	public TrashCompactorTrap getTcTrap() {
		return this.tcTrap;
	}

	public VentilationShaftTrap getVsTrap() {
		return this.vsTrap;
	}
}
