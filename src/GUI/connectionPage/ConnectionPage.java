package GUI.connectionPage;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import GUI.LinCAll;

/**
 * Page de connexion à l'application LinC'All
 * 
 * @author Noémie
 *
 */
public class ConnectionPage extends AnchorPane {

	protected ConnectionView connectionView;
	protected ImageView logo;
	protected VBox logoVBox;
	protected ImageView computerMan;

	protected double screenWidth;
	protected double screenHeight;
	
	/**
	 * Constructeur
	 */
	public ConnectionPage(LinCAll app) {
		this.setId("Background");
			
		this.connectionView = new ConnectionView(app);
		AnchorPane.setLeftAnchor(this.connectionView, 0.);
		AnchorPane.setTopAnchor(this.connectionView, 0.);
		AnchorPane.setRightAnchor(this.connectionView, 0.);
		AnchorPane.setBottomAnchor(this.connectionView, 0.);

		// Logo LinC'All
		this.logo = new ImageView();
		this.logo.setId("Logo");
		this.logoVBox = new VBox();
		this.logoVBox.setAlignment(Pos.CENTER);
		this.logoVBox.getChildren().add(this.logo);
		AnchorPane.setLeftAnchor(this.logoVBox, 160.);
		AnchorPane.setTopAnchor(this.logoVBox, 60.);
		AnchorPane.setRightAnchor(this.logoVBox, 160.);
		
		// Bonhomme avec un PC
		this.computerMan = new ImageView();
		this.computerMan.setId("Computer_Man-Picture");
		AnchorPane.setRightAnchor(this.computerMan, 165.);
		AnchorPane.setBottomAnchor(this.computerMan, 45.);
		
		this.getChildren().addAll(this.connectionView, this.logoVBox, this.computerMan);
		
	}
	
}
