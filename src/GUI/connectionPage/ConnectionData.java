package GUI.connectionPage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Client.Client;
import GUI.LinCAll;
import GUI.publicPage.PublicPage;

/**
 * Données et champs pour la page de connexion
 * 
 * @author Noémie
 *
 */
public class ConnectionData extends VBox {

	protected Client m_client;
	protected LinCAll application;
	protected Label loginLabel;
	protected TextField loginTextField;
	protected Label passwordLabel;
	protected PasswordField passwordField;
	protected Label ipAddressPortLabel;
	protected TextField ipAddressTextField;
	protected TextField portTextField;
	protected Button connectionButton;
	protected Label createAccountLabel;

	/**
	 * Constructeur
	 */
	public ConnectionData(LinCAll app) {
		this.application = app;
	}

	/**
	 * Cr�ation de la VBox pour les donn�es de login
	 * 
	 * @return une vbox
	 */
	public VBox createLoginData() {
		VBox loginDataVBox = new VBox();
		loginDataVBox.setId("Login_Data-VBox");
		// Login
		this.loginLabel = new Label("Login");
		this.loginLabel.setId("Connection-Label");
		this.loginTextField = new TextField();
		this.loginTextField.setId("Login-TextField");
		this.loginTextField.setPromptText("Username");
		this.loginTextField.setPrefSize(100, 35);
		VBox.setMargin(this.loginLabel, new Insets(0, 0, 5, 0));
		VBox.setMargin(this.loginTextField, new Insets(0, 0, 20, 0));
		loginDataVBox.getChildren().addAll(this.loginLabel, this.loginTextField);

		// Password
		this.passwordLabel = new Label("Password");
		this.passwordLabel.setId("Connection-Label");
		this.passwordField = new PasswordField();
		this.passwordField.setId("Password-TextField");
		this.passwordField.setPrefSize(100, 35);
		VBox.setMargin(this.passwordLabel, new Insets(0, 0, 5, 0));
		VBox.setMargin(this.passwordField, new Insets(0, 0, 20, 0));
		loginDataVBox.getChildren().addAll(this.passwordLabel, this.passwordField);

		// @IP and n�port
		this.ipAddressPortLabel = new Label("IP Address and Port");
		this.ipAddressPortLabel.setId("Connection-Label");
		this.ipAddressTextField = new TextField();
		this.ipAddressTextField.setId("IP_Address-TextField");
		this.ipAddressTextField.setPrefSize(500, 35);
		Label doubleDots = new Label(":");
		doubleDots.setId("Double_Dots");
		this.portTextField = new TextField();
		this.portTextField.setId("IP_Port-TextField");
		this.portTextField.setPrefSize(100, 35);
		HBox hBoxAddressPort = new HBox();
		hBoxAddressPort.setAlignment(Pos.CENTER);
		hBoxAddressPort.getChildren().addAll(this.ipAddressTextField, doubleDots, this.portTextField);
		VBox.setMargin(this.ipAddressPortLabel, new Insets(0, 0, 5, 0));
		VBox.setMargin(hBoxAddressPort, new Insets(0, 0, 20, 0));
		loginDataVBox.getChildren().addAll(this.ipAddressPortLabel, hBoxAddressPort);

		return loginDataVBox;
	}

	/**
	 * Création de la HBox avec le bouton de validation des données
	 * (ou création d'un nouveau compte d'utilisateur)
	 * 
	 * @return une hbox
	 */
	public HBox createValidateInfo() {
		// Connection Button
		this.connectionButton = new Button("Connection");
		this.connectionButton.setId("Connection-Button");
		HBox.setMargin(this.connectionButton, new Insets(-5, 0, 0, 0));
		this.connectionButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				m_client = new Client(loginTextField.getText(), passwordField.getText(), ipAddressTextField.getText(), Integer.parseInt(portTextField.getText()));
//				while(!m_client.getM_connection().getM_auth()) {
//					
//				}
				openPublicPage(ConnectionData.this.application.getScreenBounds());
				
			}
		});
		// Create account
		Label orLabel = new Label("or");
		orLabel.setId("Connection-Label-Small");
		this.createAccountLabel = new Label("Create account");
		this.createAccountLabel.setId("Create_Account-Label");
		HBox validateInfoHBox = new HBox();
		validateInfoHBox.setAlignment(Pos.CENTER);
		validateInfoHBox.setId("validate_Info-HBox");
		validateInfoHBox.setAlignment(Pos.BASELINE_CENTER);
		HBox.setMargin(orLabel, new Insets(0, 5, 0, 20));
		validateInfoHBox.getChildren().addAll(this.connectionButton, orLabel, this.createAccountLabel);
		
		return validateInfoHBox;
	}
	
	// variable pour garder en mémoire la position initiale de la stage au début du "drag"
	protected double initX;
	protected double initY;
	protected Stage publicStage;
	protected PublicPage publicPage;
	protected Scene publicScene;
	protected String username = "Demo";
	
	public void openPublicPage(Rectangle2D screenBounds) {
		
		this.publicStage = new Stage();
		this.publicStage.initStyle(StageStyle.DECORATED);
		this.publicStage.setTitle("LinC'All - " + this.username);
		
		this.publicPage = new PublicPage();
		this.publicScene = new Scene(this.publicPage, 1910, 970);
		this.publicScene.getStylesheets().add("GUI/lincAll.css");
		
		this.publicStage.setScene(this.publicScene);
		this.publicStage.setResizable(false);
		
		this.publicStage.setX(screenBounds.getMinX());
		this.publicStage.setY(screenBounds.getMinY());
		this.publicStage.setWidth(screenBounds.getWidth());
		this.publicStage.setHeight(screenBounds.getHeight());
		
		// Disparition de la page de connexion
		this.application.getPrimaryStage().hide();
		this.publicStage.show();
	}

	public String getUsername() {
		return this.username;
	}

	/**
	 * TODO récupérer le username au moment de la connexion
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
