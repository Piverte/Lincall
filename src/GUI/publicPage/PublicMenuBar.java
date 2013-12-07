package GUI.publicPage;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author Noémie
 *
 */
public class PublicMenuBar extends AnchorPane {

	protected HBox menuBar;
	// Barre de menu
	protected Menu fileMenu;
	protected MenuItem statusItem;
	protected MenuItem exitItem;
	protected Menu infoMenu;
	protected MenuItem helpItem;
	protected MenuItem aboutItem;
	protected Button logOutButton;
	
	/**
	 * Constructeur
	 */
	public PublicMenuBar() {
		this.menuBar = this.createMenu();
		AnchorPane.setLeftAnchor(this.menuBar, 40.);
		AnchorPane.setTopAnchor(this.menuBar, 200.);
		AnchorPane.setRightAnchor(this.menuBar, 40.);
		this.getChildren().add(this.menuBar);
	}
	
	public HBox createMenu() {
		HBox toolBar = new HBox();
		toolBar.setId("Menu_Bar-HBox");
		MenuBar linCAllBar = new MenuBar();
		linCAllBar.setId("MenuBar");
		
		// Menu "File"
		this.fileMenu = new Menu("File");		
		this.statusItem = new MenuItem("Status");		
		this.exitItem = new MenuItem("Quit");
		this.fileMenu.getItems().addAll(this.statusItem, this.exitItem);
		
		// Menu "?"
		this.infoMenu = new Menu("?");
		this.helpItem = new MenuItem("Help");
		this.aboutItem = new MenuItem("About LinCAll");
		this.infoMenu.getItems().addAll(this.helpItem, this.aboutItem);
		
		linCAllBar.getMenus().addAll(this.fileMenu, this.infoMenu);
		
		// Button LogOut
		this.logOutButton = new Button("Log Out");
		this.logOutButton.setId("Log_Out-Button");
		HBox.setMargin(this.logOutButton, new Insets(4, 0, 0, 0));
		
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		toolBar.getChildren().addAll(linCAllBar, spacer, this.logOutButton);
				
		return toolBar;
	}

	public Button getLogOutButton() {
		return logOutButton;
	}

	
}