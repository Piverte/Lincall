package GUI.publicPage;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Page de chat public
 * 
 * @author Noémie
 *
 */
public class PublicPage extends AnchorPane {

	protected PublicView publicView;
	protected ImageView logo;
	protected VBox logoVBox;

	/**
	 * Constructeur
	 */
	public PublicPage() {
		this.setId("Background");
		
		this.publicView = new PublicView();
		AnchorPane.setLeftAnchor(this.publicView, 0.);
		AnchorPane.setTopAnchor(this.publicView, 0.);
		AnchorPane.setRightAnchor(this.publicView, 0.);
		AnchorPane.setBottomAnchor(this.publicView, 0.);

		this.logo = new ImageView();
		this.logo.setId("Logo");
		this.logoVBox = new VBox();
		this.logoVBox.setAlignment(Pos.CENTER_LEFT);
		this.logoVBox.getChildren().add(this.logo);
		AnchorPane.setLeftAnchor(this.logoVBox, 60.);
		AnchorPane.setTopAnchor(this.logoVBox, 60.);
				
		this.getChildren().addAll(this.publicView, this.logoVBox);	
	}
}
