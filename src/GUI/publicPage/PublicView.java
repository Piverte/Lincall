package GUI.publicPage;

import GUI.publicPage.PublicBackground;
import GUI.publicPage.PublicChatView;
import GUI.publicPage.PublicMenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Page blanche transparente de la page de chat publique
 * 
 * @author Noémie
 *
 */
public class PublicView extends AnchorPane {
	
	protected PublicBackground whiteBackground;
	protected PublicMenuBar publicMenuBar;
	protected PublicChatView publicChatView;
	protected VBox communicationsView;
	protected VBox onlineUsersView;
	
	public PublicView() {
		
		this.whiteBackground = new PublicBackground();
		AnchorPane.setLeftAnchor(this.whiteBackground, 40.);
		AnchorPane.setTopAnchor(this.whiteBackground, 40.);
		AnchorPane.setRightAnchor(this.whiteBackground, 40.);
		AnchorPane.setBottomAnchor(this.whiteBackground, 40.);
		
		this.publicMenuBar = new PublicMenuBar();
		AnchorPane.setLeftAnchor(this.publicMenuBar, 0.);
		AnchorPane.setTopAnchor(this.publicMenuBar, 0.);
		AnchorPane.setRightAnchor(this.publicMenuBar, 0.);
		AnchorPane.setBottomAnchor(this.publicMenuBar, 0.);
		
		this.publicChatView = new PublicChatView();
		AnchorPane.setLeftAnchor(this.publicChatView, 55.);
		AnchorPane.setTopAnchor(this.publicChatView, 240.);
		AnchorPane.setRightAnchor(this.publicChatView, -20.);
		AnchorPane.setBottomAnchor(this.publicChatView, 55.);
				
		this.getChildren().addAll(this.whiteBackground, this.publicMenuBar, this.publicChatView);
	}

}
