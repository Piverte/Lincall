package GUI.publicPage.users;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class User extends HBox {

	protected Circle userStatus;
	protected Label userName;
	
	/**
	 * Constructeur
	 * TODO r�cup�rer l'app principale en param�tre pour r�cup�rer le username � partir
	 * de la m�thode init de Loic
	 */
	public User() {
		this.userStatus = new Circle(5., Color.GREEN);
		this.userName = new Label("Demo");
		
		this.getChildren().addAll(this.userStatus, this.userName);
	}
}
