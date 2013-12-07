package GUI.connectionPage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import GUI.LinCAll;

/**
 * Page blanche transparente de la page de connexion
 * 
 * @author Noémie
 *
 */
public class ConnectionView extends AnchorPane {
	
	protected ConnectionBackground connectionBackground;
	protected ConnectionData connectionData;
	protected VBox dataVBox;
	protected HBox validationHBox;
	
	/**
	 * Constructeur
	 */
	public ConnectionView(LinCAll app) {

		this.connectionBackground = new ConnectionBackground();
		AnchorPane.setLeftAnchor(this.connectionBackground, 160.);
		AnchorPane.setTopAnchor(this.connectionBackground, 40.);
		AnchorPane.setRightAnchor(this.connectionBackground, 160.);
		AnchorPane.setBottomAnchor(this.connectionBackground, 40.);
		
		this.connectionData = new ConnectionData(app);
		this.dataVBox = this.connectionData.createLoginData();
		this.validationHBox = this.connectionData.createValidateInfo();
		
		AnchorPane.setLeftAnchor(this.dataVBox, 240.);
		AnchorPane.setTopAnchor(this.dataVBox, 200.);
		AnchorPane.setRightAnchor(this.dataVBox, 550.);
//		AnchorPane.setBottomAnchor(this.dataVBox, 20.);
		
		AnchorPane.setLeftAnchor(this.validationHBox, 140.);
//		AnchorPane.setTopAnchor(this.validationHBox, 520.);
		AnchorPane.setRightAnchor(this.validationHBox, 140.);
		AnchorPane.setBottomAnchor(this.validationHBox, 130.);
		
		this.getChildren().addAll(this.connectionBackground, this.dataVBox, this.validationHBox);
	}

}
