package GUI;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import GUI.connectionPage.ConnectionPage;

/**
 * Application LinC'All 
 * 
 * @author Noémie
 *
 */
public class LinCAll extends Application {

	public static void main(String[] args) {
		Application.launch(LinCAll.class, args);
	}
	
	protected Rectangle2D screenBounds;
	protected Stage primaryStage;
	protected Scene scene;
	protected ConnectionPage connectionPage;
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		this.screenBounds = Screen.getPrimary().getVisualBounds();	
		this.primaryStage = stage;
		this.primaryStage.setTitle("LinC'All");
		this.primaryStage.initStyle(StageStyle.DECORATED);
		this.connectionPage = new ConnectionPage(this);
		
		// Scene
		this.scene = new Scene(this.connectionPage, 1280, 720);
		this.scene.getStylesheets().add("GUI/lincAll.css");
		this.primaryStage.setScene(this.scene);
		this.primaryStage.setResizable(false);
		this.primaryStage.show();	
	}
	
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	/**
	 * Mise à jour des fonctions d'initialisation du Client et du Serveur
	 */
	public void initFunctions() {
		// TODO mettre à jour l'init avec les fichiers de loic
		// par rapport au log4J
	}

	public Rectangle2D getScreenBounds() {
		return screenBounds;
	}

	public void setScreenBounds(Rectangle2D screenBounds) {
		this.screenBounds = screenBounds;	 
	}

	

}
