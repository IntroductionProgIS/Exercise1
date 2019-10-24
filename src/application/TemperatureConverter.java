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
        	//If a character has been changed (added or deleted)
            if (character.isContentChange()) 
            {
            	//If the TextField is empty
                if (character.getControlNewText().length() == 0) 
                {
                	//We accept the change
                    return character;
                }
                //If the full text in the TextField is - (minus)
                else if(character.getControlNewText().equals("-"))
                {
                	//We accept the change
                	return character;
                }
                //If there is something in the TextField
                else if(character.getControlNewText().length() > 1)
                {
                	//If the last character is 'E' (ten power) and the previous one was not 'E' or '-' (minus)
                	if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == 'E'
                			&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) != 'E'
                			&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) != '-')
                	{
                		//We accept the change
                		return character;
                	}
                	//If the last character is '-' (minus) and the previous one was 'E' (ten power)
                	else if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == '-'
                			&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) == 'E')
                	{
                		//We accept the change
                		return character;
                	}
                }
                //If the case is not mentioned above, we try the following code
                try 
                {
                	//We parse the character to a float
                	Float.parseFloat(character.getControlNewText());
                	
                	//We accept the change
                	return character;
                } 
                //If we got an error while running the code above
                catch (NumberFormatException e) 
                {
                	//We do not accept the change
                }
                //We do not accept the change
                return null;
            }
            
            //If there is nothing new, we do nothing
            return null;
        });
    	
    	/*
    	 * The TextFormatter of the Fahrenheit TextField:
    	 * This TextFormatter accept a new character only if the text remains a number
    	 * (positive or negative). It should also accept the scientific numbers with the format
    	 * xxEx where E means a power of ten.
    	 */
    	textFormatterF = new TextFormatter<>(character -> 
        {
        	//If a character has been changed (added or deleted)
            if (character.isContentChange()) 
            {
            	//If the TextField is empty
                if (character.getControlNewText().length() == 0) 
                {
                	//We accept the change
                    return character;
                }
                //If the full text in the TextField is - (minus)
                else if(character.getControlNewText().equals("-"))
                {
                	//We accept the change
                	return character;
                }
                //If there is something in the TextField
                else if(character.getControlNewText().length() > 1)
                {
                	//If the last character is 'E' (ten power) and the previous one was not 'E' or '-' (minus)
                	if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == 'E'
                			&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) != 'E'
                			&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) != '-')
                	{
                		//We accept the change
                		return character;
                	}
                	//If the last character is '-' (minus) and the previous one was 'E' (ten power)
                	else if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == '-'
                			&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) == 'E')
                	{
                		//We accept the change
                		return character;
                	}
                }
                //If the case is not mentioned above, we try the following code
                try 
                {
                	//We parse the character to a float
                	Float.parseFloat(character.getControlNewText());
                	
                	//We accept the change
                	return character;
                } 
                //If we got an error while running the code above
                catch (NumberFormatException e) 
                {
                	//We do not accept the change
                }
                //We do not accept the change
                return null;
            }
            
            //If there is nothing new, we do nothing
            return null;
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
        		//We get the code of the key pressed and we test if it is "ENTER"
            	if (e.getCode().equals(KeyCode.ENTER)) 
            	{
            		//If the key was "ENTER"
            		
            		//We get the text displays in the Fahrenheit TextField.
                    String value = textFieldF.getText();
                    //We try if there is no error when running the following code
                    try 
                    {
                    	//We create a float from the value in the Fahrenheit TextField
                        float valF = new Float(value);
                        //We calculate the value in Celsius
                        float valC = (valF - 32) / 1.8f;
                        //We display the value in Celsius in the Celsius TextField
                        textFieldC.setText(Float.toString(valC));
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
         * Listener of the "Reset" Button:
         * Reset the value in the two TextFields (when the "Reset" Button is pressed)
         */
        buttonResetListener = new EventHandler<ActionEvent>()
        {
        	@Override
        	public void handle(ActionEvent event) 
        	{
        		//We empty the Fahrenheit TextField
        		textFieldF.setText("");
        		//We empty the Celsius TextField
        		textFieldC.setText("");
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
    	/* CELSIUS */
        
    	//We create the Celsius pane
        VBox paneC = new VBox();       
        //We set a padding so that the elements are correctly placed
        /*
         * Java Doc: 
         * An Insets object is a representation of the borders of a container. It specifies the
         * space that a container must leave at each of its edges. The space can be a border, a
         * blank space, or a title.
         */
        paneC.setPadding(new Insets(10, 10, 10, 10));        
        //We add that pane to our root pane
        root.getChildren().add(paneC);
        
        //We create the label for the Celsius part
        labelC = new Label("Celsius");
        //We correctly place the label
        labelC.setPadding(new Insets(0, 0, 10, 0));
        //We add this Label to the Celsius pane
        paneC.getChildren().add(labelC);
        
        //We create the Textfield for the Celsius part
        textFieldC = new TextField("");
        //We add this TextField to the Celsius pane
        paneC.getChildren().add(textFieldC);   
        
        //We set the action associated to the TextField
        textFieldC.setOnKeyPressed(textFieldCListener);
        //We set the TextFormatter of the TextField
        textFieldC.setTextFormatter(textFormatterC);
        
        /* FAHRENHEIT */
        
        //We create the Fahrenheit pane
        VBox paneF = new VBox();
        //We set a padding so that the elements are correctly placed
        paneF.setPadding(new Insets(10, 10, 10, 10));
        //We add that pane to our root pane
        root.getChildren().add(paneF);
        
        //We create the label for the Fahrenheit part
        labelF = new Label("Fahrenheit");
        //We correctly place the label
        labelF.setPadding(new Insets(0, 0, 10, 0));
        //We add this Label to the Fahrenheit pane
        paneF.getChildren().add(labelF);
        
        //We create the TextField for the Fahrenheit part
        textFieldF = new TextField("");
        //We add this TextField to the Fahrenheit pane
        paneF.getChildren().add(textFieldF);
        
        //We set the action associated to the TextField
        textFieldF.setOnKeyPressed(textFieldFListener);
        //We set the TextFormatter of the TextField
        textFieldF.setTextFormatter(textFormatterF);
        
        /* BUTTONS */
        
        //We create the Buttons pane
        HBox paneButtons = new HBox();
        //We set a padding so that the elements are correctly placed
		paneButtons.setPadding(new Insets(10, 10, 10, 10));
		//We set the space between two elements of the HBox
		paneButtons.setSpacing(10); 
		//We set the alignement of each element in a box of the HBox
		paneButtons.setAlignment(Pos.CENTER_RIGHT);
		//We add the pane for the buttons to the root pane
		root.getChildren().add(paneButtons);
        
        //We create the "Reset" button
        buttonReset = new Button("Reset");
        //We set the width of the "Reset" Button
        buttonReset.setPrefWidth(70);
		//We add the button "Reset" to the buttons pane
        paneButtons.getChildren().add(buttonReset);
        //We set the action associated to the button
        buttonReset.setOnAction(buttonResetListener);
        
        //We create the "Close" button
        buttonClose = new Button("Close");
        //We set the width of the "Close" Button
        buttonClose.setPrefWidth(70);
        //We add the button "Close" to the buttons pane
        paneButtons.getChildren().add(buttonClose);
        //We set the action associated to the button
        buttonClose.setOnAction(buttonCloseListener);   
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