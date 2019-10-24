package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureConverter extends Application 
{
	//Attributes
	private Button buttonReset ;
	private Button buttonClose;
	private Label labelC ;
	private Label labelF ;
	private TextField textFieldC ;
	private TextField textFieldF ;
	private EventHandler<KeyEvent> textFieldCListener;
	private EventHandler<KeyEvent> textFieldFListener;
	private EventHandler<ActionEvent> buttonResetListener;
	private EventHandler<ActionEvent> buttonCloseListener;
	private TextFormatter<Object> textFormatterC;
	private TextFormatter<Object> textFormatterF;
	
	@Override
	public void start(Stage stage) throws Exception
	{
		/*
		 * The application represents a JavaFX application.
		 * The stage is the high level container of the application.
		 * The scene is the element that contains the visual components
		 */
    	
    		//We define a root pane which will contains all the other elements
		FlowPane root = new FlowPane();
        
		//We create a scene that contains root as a root pane
		Scene scene = new Scene(root); 
		
		//We set the height of the stage
		stage.setHeight(155);
		stage.setMaxHeight(225);
		stage.setMinHeight(155);
		//We set the width of the stage
		stage.setWidth(351);
		stage.setMaxWidth(351);
		stage.setMinWidth(180);        
		
		//We initialize the TextFormatters of the TextField components
		initTextFormatters();
		
		//We initialize the listeners of our UI components
		initListener();
		
		//We initialize the User Interface (UI) of the application
		initGUI(root);
		
		//We give a title to our stage
		stage.setTitle("Temperature Converter");
		
		//We display the scene we just created in the stage
		stage.setScene(scene);
		
		//We display the stage
		stage.show();
	}
	
	public void initTextFormatters()
	{
		/*
		* The TextFormatter of the Celsius TextField:
		* This TextFormatter accept a new character only if the text remains a number
		* (positive or negative). It should also accept the scientific numbers with the format
		* xxEx where E means a power of ten.
		*/
		textFormatterC = new TextFormatter<>(character -> 
		{
			/*
			 * TODO: 8.(Going furhter) Associate a TextFormatter to textFieldF to ensure a 
			 * valid character input (e.g., 23, 23.345, -21, 3E -02).
			 */	
			 
			 return character;
		});

		/*
		* The TextFormatter of the Fahrenheit TextField:
		* This TextFormatter accept a new character only if the text remains a number
		* (positive or negative). It should also accept the scientific numbers with the format
		* xxEx where E means a power of ten.
		*/
		textFormatterF = new TextFormatter<>(character -> 
		{
			/*
			 * TODO: 8.(Going furhter) Associate a TextFormatter to textFieldF to ensure a 
			 * valid character input (e.g., 23, 23.345, -21, 3E -02).
			 */	
			 
			 return character;
		});
	}

	/**
	 * Initialize the Listeners of the UI elements
	 */
	public void initListener()
	{
		/*
		 * Listener of the Celsius TextField: 
		 * Convert the value of the Celsius TextField from Celsius to Fahrenheit when the "ENTER"
		 * key is hit on the keyboard (while focusing the Celsius TextField)
		 */
		textFieldCListener = new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				//We get the code of the key pressed and we test if it is "ENTER"
				if (e.getCode().equals(KeyCode.ENTER)) 
				{
					//If the key was "ENTER"
    				
					//We get the text displays in the Celsius TextField.
					String value = textFieldC.getText();
					
					//We try if there is no error when running the following code
					try 
					{
						//We create a float from the value in the Celsius TextField
						float valC = new Float(value);
						//We calculate the value in Fahrenheit
						float valF = valC * 1.8f + 32;
						//We display the value in Fahrenheit in the Fahrenheit TextField
						textFieldF.setText(Float.toString(valF));
					}
					//If we got an error after running the code above
					catch (Exception exp) 
					{
						//We empty the Fahrenheit TextField
						textFieldF.setText("");
						//We empty the Celsius TextField
						textFieldC.setText("");
					}
				}
			}
		};

		/*
		 * Listener of the Fahrenheit TextField:
		 * Convert the value of the Fahrenheit TextField from Fahrenheit to Celsius when the "ENTER"
		 * key is hit on the keyboard (while focusing the Fahrenheit TextField)
		 */
		textFieldFListener = new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e) 
			{
				/*
				 * TODO: 5. Fill in the textFieldFListener in order to do the conversion from
				 * Fahrenheit to Celsius. Associate it with the text box of the Fahrenheit value.
				 */	
			}     		
		};

		/*
		 * Listener of the "Reset" Button:
		 * Reset the value in the two TextFields (when the "Reset" Button is pressed)
		 */
		buttonResetListener = new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) 
			{
				/*
				 * TODO: 7. Fill in the buttonResetListener in order to empty both text boxes.
				 * Associate it to the "Reset" button.
				 */	
			}
		};

		/*
		 * Listener of the "Close" Button:
		 * Close the application (when the "Close" Button is pressed)
		 */
		buttonCloseListener = new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//We quit the application
				Platform.exit();
			}
		};
	}

	/**
	 * Initialize the UI elements
	 * @param root The root pane that will contain all the other elements
	 */
	public void initGUI(Pane root)
	{
		/*
		 * TODO: 2. Complete the function initGUI() by using the class FlowPane and
		 * layout panes of your choice.  
		 */
		
		/*
		 * TODO: 3. Make sure the widgets are aligned and that their location remains
		 * consistent while resizing the window.
		 */
		
		/*
		 * TODO: 4. The textFieldCListener reads a floating value in the Celsius text box
		 * when the user press "enter", converts it from Celsius to Fahrenheit, and writes
		 * the result in the Fahrenheit text box. Associate this event handler to the text
		 * box of the Celsius value.
		 */
		
		/*
		 * TODO: 6. The buttonCloseListener closes the window. Associate it to the "Close" button.
		 */
	}

	/**
	 * The main function should never be changed
	 * @param args The arguments given when you launch the application in command line
	 */
	public static void main(String[] args) 
	{
		//We launch the application
		launch(args);
	}
}
