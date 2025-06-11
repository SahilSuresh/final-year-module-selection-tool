package view;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Course;
import model.Module;
import model.Name;
import model.StudentProfile;

public class FourthTabModule extends GridPane {

	private TextField txtBlock1;
	private ListView<Module> txtBlock2, txtBlock3;
	private Button btnSave;

	public FourthTabModule() {

		// setup textField

		txtBlock1 = new TextField("Profile will appear here");
		txtBlock1.setPrefSize(800, 150);
		txtBlock1.alignmentProperty().set(Pos.TOP_LEFT);
		;

		txtBlock2 = new ListView<Module>();
		;
		txtBlock2.setPrefSize(400, 300);
		// txtBlock2.alignmentProperty().set(Pos.TOP_LEFT);

		txtBlock3 = new ListView<Module>();
		;
		txtBlock3.setPrefSize(400, 300);
		// txtBlock3.alignmentProperty().set(Pos.TOP_LEFT);

		// creating button

		btnSave = new Button(" Save OverView ");

		VBox box1 = new VBox(txtBlock2);

		VBox box2 = new VBox(txtBlock3);

		HBox container = new HBox();
		container.getChildren().addAll(box1, box2);
		container.setSpacing(20);
		// container.

		HBox box3 = new HBox(btnSave);
		box3.setAlignment(Pos.CENTER);

		VBox container2 = new VBox(txtBlock1, container, box3);
		container.setAlignment(Pos.CENTER);

		container2.setSpacing(30);

		this.setPadding(new Insets(50, 10, 10, 10));
		;
		this.getChildren().add(container2);

		this.setVgrow(container2, Priority.ALWAYS);
		this.setHgrow(container2, Priority.ALWAYS);

		this.setVgrow(container, Priority.ALWAYS);
		this.setHgrow(container, Priority.ALWAYS);

		this.setVgrow(box3, Priority.ALWAYS);
		this.setHgrow(box3, Priority.ALWAYS);

	}

	public void settxtBlock1(Name name, String Pnumber, String email, LocalDate localDate, Course course) {
		txtBlock1.setText("Name: " + name + "\nPnumber " + Pnumber + "\nemail: " + email + "\nDate" + localDate
				+ "\nCourse: " + course);

	}

	public void getSelectedBlock(ListView<Module> n) {
		txtBlock2.getItems().clear();
		txtBlock2.getItems().addAll(n.getItems());		
		
		
	}
	
	public void getReserveBlock(ListView<Module> n) {
		txtBlock3.getItems().clear();
		txtBlock3.getItems().addAll(n.getItems());		
		
	}
	
	

	public String gettxtBlock1() {
		return txtBlock1.getText();
	}
	
	
	// method to attach the create student profile button event handler
	
		public void addSaveOverviewButtonHandler(EventHandler<ActionEvent> handler) {
			btnSave.setOnAction(handler);
		}

}
