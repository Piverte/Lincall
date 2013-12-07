package GUI.publicPage;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import GUI.publicPage.communications.CommunicationsArea;
import GUI.publicPage.users.OnlineUsers;

public class PublicChatView extends GridPane {

	// Corps principal
	protected CommunicationsArea communicationsArea;
	protected OnlineUsers onlineUsers;

	
	/**
	 * Constructeur
	 */
	public PublicChatView() {
	     for (int i = 0; i < 6; i++) {
	         ColumnConstraints column = new ColumnConstraints();
	         column.setPercentWidth(100/6);
	         this.getColumnConstraints().add(column);
	     }
	     
	     for (int j = 0; j < 4; j++) {
	         RowConstraints row = new RowConstraints();
	         row.setPercentHeight(100/4);
	         this.getRowConstraints().add(row);
	     }
		this.communicationsArea = new CommunicationsArea();
		GridPane.setConstraints(this.communicationsArea, 0, 0, 5, 4);
//		AnchorPane.setLeftAnchor(this.communicationsArea, 55.);
//		AnchorPane.setTopAnchor(this.communicationsArea, 240.);
//		AnchorPane.setRightAnchor(this.communicationsArea, 350.);
//		AnchorPane.setBottomAnchor(this.communicationsArea, 55.);
		
		this.onlineUsers = new OnlineUsers();
		GridPane.setConstraints(this.onlineUsers, 5, 0, 1, 4);
//		AnchorPane.setLeftAnchor(this.onlineUsers, 1564.);
//		AnchorPane.setTopAnchor(this.onlineUsers, 240.);
//		AnchorPane.setRightAnchor(this.onlineUsers, 55.);
//		AnchorPane.setBottomAnchor(this.onlineUsers, 55.);
		
		this.getChildren().addAll(this.communicationsArea, this.onlineUsers);
	}
}
