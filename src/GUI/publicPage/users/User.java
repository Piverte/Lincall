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
	 * TODO récupérer l'app principale en paramètre pour récupérer le username à partir
	 * de la méthode init de Loic
	 */
	public User() {
		this.userStatus = new Circle(5., Color.GREEN);
		this.userName = new Label("Demo");
		
		this.getChildren().addAll(this.userStatus, this.userName);
	}
}
