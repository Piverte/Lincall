package GUI.publicPage.users;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * @author Noémie
 *
 */
public class OnlineUsers extends AnchorPane {
	
	protected HBox onlineBar;
	protected ScrollPane onlineUsersScrollPane;
	protected ArrayList<User> onlineUserList;
	
	/**
	 * Constructeur
	 */
	public OnlineUsers() {
		
		this.onlineUserList = new ArrayList<>();
		
		this.onlineBar = createOnlineBar();
		AnchorPane.setLeftAnchor(this.onlineBar, 0.);
		AnchorPane.setTopAnchor(this.onlineBar, 0.);
		AnchorPane.setRightAnchor(this.onlineBar, 0.);
		AnchorPane.setBottomAnchor(this.onlineBar, 30.);
		
		this.onlineUsersScrollPane = createUserScrollPane();
		AnchorPane.setLeftAnchor(this.onlineUsersScrollPane, 0.);
		AnchorPane.setTopAnchor(this.onlineUsersScrollPane, 30.);
		AnchorPane.setRightAnchor(this.onlineUsersScrollPane, 0.);
		AnchorPane.setBottomAnchor(this.onlineUsersScrollPane, 0.);
		
		this.getChildren().addAll(this.onlineBar, this.onlineUsersScrollPane);
	}

	
	/**
	 * @return
	 */
	public HBox createOnlineBar() {
		HBox hbox = new HBox();
		hbox.setId("Online_Bar");
		
		Label onlineLabel = new Label("Online users");
		onlineLabel.setId("On_Line-Label");
		
		hbox.getChildren().add(onlineLabel);
		
		return hbox;
	}
	
	/**
	 * @return
	 */
	public ScrollPane createUserScrollPane() {
		ScrollPane pane = new ScrollPane();
		pane.vbarPolicyProperty().set(ScrollBarPolicy.ALWAYS);
		
		// Ajout des utilisateur en ligne
		for (User user : this.onlineUserList) {
			pane.setContent(user);
		}
		
		return pane;
	}
}
