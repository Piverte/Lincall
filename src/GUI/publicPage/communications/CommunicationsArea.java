package GUI.publicPage.communications;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * @author Noémie
 *
 */
public class CommunicationsArea extends AnchorPane {
	
	protected ScrollPane publicChatScrollPane;
	protected TextArea publicChatTextArea;
	protected HBox publicMessageZoneHBox;
	protected TextArea writingPublicMessage;
	protected Button sendMessageButton;
	
	/**
	 * Constructeur
	 */
	public CommunicationsArea() {
		
		this.publicChatScrollPane = createChatZone();
		AnchorPane.setLeftAnchor(this.publicChatScrollPane, 0.);
		AnchorPane.setTopAnchor(this.publicChatScrollPane, 0.);
		AnchorPane.setRightAnchor(this.publicChatScrollPane, 0.);
		AnchorPane.setBottomAnchor(this.publicChatScrollPane, 120.);
		
		this.publicMessageZoneHBox = createMessageZone();
		this.publicMessageZoneHBox.setId("Chat_Zone-TextArea");
		AnchorPane.setLeftAnchor(this.publicMessageZoneHBox, 0.);
		AnchorPane.setTopAnchor(this.publicMessageZoneHBox, 584.);
		AnchorPane.setRightAnchor(this.publicMessageZoneHBox, 0.);
		AnchorPane.setBottomAnchor(this.publicMessageZoneHBox, 0.);
		
		this.getChildren().addAll(this.publicChatScrollPane, this.publicMessageZoneHBox);
		
	}
	
	/**
	 * @return
	 */
	public ScrollPane createChatZone() {
		this.publicChatTextArea = new TextArea("Chat is here");
		this.publicChatTextArea.setEditable(false);
		this.publicChatTextArea.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.publicChatScrollPane = new ScrollPane();
		this.publicChatScrollPane.setContent(this.publicChatTextArea);
		this.publicChatScrollPane.setFitToWidth(true);
		this.publicChatScrollPane.vbarPolicyProperty().set(ScrollBarPolicy.ALWAYS);
		this.publicChatScrollPane.hbarPolicyProperty().set(ScrollBarPolicy.NEVER);
		
		return this.publicChatScrollPane;
	}

	/**
	 * @return
	 */
	public HBox createMessageZone() {
		this.publicMessageZoneHBox = new HBox();
		this.writingPublicMessage = new TextArea();
		this.writingPublicMessage.setPromptText("Send a message...");
		this.writingPublicMessage.setEditable(true);
		this.writingPublicMessage.setPrefWidth(1300.);
		this.sendMessageButton = new Button("Send");
		this.sendMessageButton.setId("Send_Message-Button");
		HBox.setMargin(this.sendMessageButton, new Insets(40, 30, 40, 50));
		
		this.publicMessageZoneHBox.getChildren().addAll(this.writingPublicMessage, this.sendMessageButton);
		
		return this.publicMessageZoneHBox;
	}
}
