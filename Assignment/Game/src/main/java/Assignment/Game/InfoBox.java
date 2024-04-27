package Assignment.Game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class InfoBox extends GameObject {
   //Private Vbox layout to arrange child nodes vertically
	private VBox vbox;
	//TextFlow type variable for handling the layout of rich text elements
    private TextFlow textFlow;
    //Button type variable to accept and close the inof box
    private Button okButton;

    /**
     * 
     * @param game
     * @param windowWidth
     * @param windowHeight
     * @param width
     * @param height
     * 
     * Constructor for the InfoBox class.
     */
    public InfoBox(Game game, double windowWidth, double windowHeight, double width, double height) {
        super(game, windowWidth / 2, windowHeight / 2, width, height, null); // GraphicsContext will be null for InfoBox

        // Initialise VBox for layout
        vbox = new VBox();
        //Allign VBox to centre
        vbox.setAlignment(Pos.CENTER);
        //Set the spacing between children to 20 pixels
        vbox.setSpacing(20);

        //Give the infobox a background colour
        vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        
        //Using textflow to allow rich text so that i can style the infobox text
        textFlow = new TextFlow();
        //preferred width
        textFlow.setPrefWidth(width);
        
        
        
     // Create Text nodes with rich text content
        //Provides game instructions to player
        //Applies styling to the rich text elements
        Text welcomeText = new Text("Welcome to the Power of 2!\n\n");
        welcomeText.setStyle("-fx-font-weight: bold;");
        Text text1 = new Text("Welcome to Alphabetrium our hero.\n\nWe are under attack by the evil numbericons.  They have sent their most powerful soldiers; ");
        Text boldText = new Text("The powers of 2.\n");
        boldText.setStyle("-fx-font-weight: bold;");
        Text text2 = new Text("These evil soldiers can only be beaten by using bullets derived from the ");
        Text boldText2 = new Text("power of two");
        boldText2.setStyle("-fx-font-weight: bold;");
        Text text3 = new Text(" which matches each Numbericon.\n\nTo help you battle them i will teach you how to know which bullet to use to defeat them. Listen carefully:\n\n");
        Text text4 = new Text("Numbericon 1 - This enemy's weakness is the ");
        Text boldText3 = new Text("power of 0.  2^0 = 1.");
        boldText3.setStyle("-fx-font-weight: bold;");
        Text text5 = new Text("  so make sure you press ");
        Text boldText4 = new Text("0");
        boldText4.setStyle("-fx-font-weight: bold;");
        Text text6 = new Text(" on your keypad when you see a Numbericon 1 trooper.\n\nNumbericon 2 - This enemy's weakness is the ");
        Text boldText5 = new Text("power of 1. 2^1 = 2.");
        boldText5.setStyle("-fx-font-weight: bold;");
        Text text7 = new Text("  So make sure you press ");
        Text boldText6 = new Text("1");
        boldText6.setStyle("-fx-font-weight: bold;");
        Text text8 = new Text(" on your keypad when you see a Numbericon 2 trooper.\n\nNumbericon 4 - This enemy's weakness is the ");
        Text boldText7 = new Text("power of 2.  2^2 = 4.");
        boldText7.setStyle("-fx-font-weight: bold;");
        Text text9 = new Text("  So make sure you press ");
        Text boldText8 = new Text("2");
        boldText8.setStyle("-fx-font-weight: bold;");
        Text text10 = new Text(" on your keypad when you see a Numbericon 4 trooper.\n\nNumbericon 8 - This enemy's weakness is the ");
        Text boldText9 = new Text("power 3 of.  2^3 = 8.");
        boldText9.setStyle("-fx-font-weight: bold;");
        Text text11 = new Text("  So make sure you press ");
        Text boldText10 = new Text("3");
        boldText10.setStyle("-fx-font-weight: bold;");
        Text text12 = new Text(" on your keypad when you see a Numbericon 8 trooper.\n\nOnce you are confident with which bullets to use for which enemy press ok to start defending Alphabetrium.\n");

        // Add Text nodes to the TextFlow
        textFlow.getChildren().addAll(welcomeText, text1, boldText, text2, boldText2, text3, text4, boldText3, text5, boldText4, text6, boldText5, text7, boldText6, text8, boldText7, text9, boldText8, text10, boldText9, text11, boldText10, text12);

        
        // Initialise OK button to close the info box
        okButton = new Button("OK");
        okButton.setOnAction(event -> {
            // Close the info box
            hide();
            // Start the game
            game.startGame();
        });

        // Add components to the VBox
        vbox.getChildren().addAll(textFlow, okButton);

        // Set position of VBox
        vbox.setLayoutX(windowWidth / 2 - width / 2);
        vbox.setLayoutY(windowHeight / 2 - height / 2);
    }

    @Override
    public void update() {
        // Display the info box
        game.getRoot().getChildren().add(vbox);
    }

    // Method to hide the info box
    public void hide() {
        game.getRoot().getChildren().remove(vbox);
    }
}
