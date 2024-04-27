package Assignment.Game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InfoBox extends GameObject {
    private VBox vbox;
    private Label infoLabel;
    private Button okButton;

    public InfoBox(Game game, double x, double y, double width, double height) {
        super(game, x, y, width, height, null); // GraphicsContext will be null for InfoBox

        // Initialise VBox for layout
        vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        //Give the infobox a background colour
        vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        
        // Initialise label to display information
        infoLabel = new Label("Welcome to the Power of 2!\n\nWelcome to Alphabetrium our hero.\n\nWe are under attack by the evil numbericons.  They have sent their most powerful soldiers; The powers of 2.\n\nThese evil soldiers can only be beaten by using bullets derived from the power of two which matches each Numbericon."
        		+ "\n\nTo help you battle them i will teach you how to know which bullet to use to defeat them. Listen carefully:\n\n"
        		+ "Numbericon 1 - This enemies weakness is the power of 0.  2^0 = 1.  so make sure you press 0 on your keypad when you see a Numbericon 1 trooper.\n\n\n"
        		+ "Numbericon 2 - This enemies weakness is the power of 1. 2^1 = 2.  So make sure you press 1 on your keypad when you see a Numbericon 2 trooper. \n\n\n"
        		+ "Numbericon 4 - This enemies weakness is the power of 2.  2^2 = 4.  So make sure you press 2 on your keypad when you see a Numbericon 4 trooper. \n\n\n"
        		+ "Numbericon 8 - This enemeies weakness is the power 3 of.  2^3 = 8.  So make sure you press 3 on your keypad when you see a Numbericon 8 trooper. \n\n"
        		+ "Once you are confident with which bullets to use for which enemy press ok to start defending Alphabetrium. ");

        //Centre and align the contents of the infolabel
        infoLabel.setAlignment(Pos.CENTER);
        
        
        // Initialise OK button to close the info box
        okButton = new Button("OK");
        okButton.setOnAction(event -> {
            // Close the info box
            hide();
            // Start the game
            game.startGame();
        });

        // Add components to the VBox
        vbox.getChildren().addAll(infoLabel, okButton);

        // Set position of VBox
        vbox.setLayoutX(x - width / 2);
        vbox.setLayoutY(y - height / 2);
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
