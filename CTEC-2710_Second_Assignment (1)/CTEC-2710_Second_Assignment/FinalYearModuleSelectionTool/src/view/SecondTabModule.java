package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Block;
import model.Course;
import model.Name;
import model.Module;

public class SecondTabModule extends GridPane {

	private ListView<Module> txtBlock1, txtBlock2, txtBlock3, txtBlock4;
	private TextField txtBlock5;
	private Button btnAdd, btnRemove, btnReset, btnSumbit;
	private ObservableList<Module> course;
	private Block block1, block2, block3;

	public SecondTabModule() {

		course = FXCollections.observableArrayList();

		Label selectBlock1 = new Label("Selected Block 1 Modules");
//		selectBlock1.setPadding(new Insets(10, 20, 10, 20));

		Label selectBlock2 = new Label("Selected Block 2 Modules");
//		selectBlock2.setPadding(new Insets(10, 20, 30, 20));

		Label unSelectBlock3 = new Label("UnSelected Block 3/4 Modules");
//		unSelectBlock3.setPadding(new Insets(10, 50, 10, 20));

		Label selectedBlock3 = new Label("Selected Block 3/4 Modules");

		Label btnBlock = new Label("Block3/4");

		Label credit = new Label("Current Credit: ");

		// setup text fields

		txtBlock1 = new ListView<Module>();
		txtBlock1.setPrefSize(400, 190);

		txtBlock2 = new ListView<Module>();
		txtBlock2.setPrefSize(400, 190);

		txtBlock3 = new ListView<Module>();
		txtBlock3.setPrefSize(400, 150);

		txtBlock4 = new ListView<Module>();
		txtBlock4.setPrefSize(400, 150);

		txtBlock5 = new TextField("0");
		txtBlock5.setPrefWidth(50);

		block1 = Block.BLOCK_1;
		block2 = Block.BLOCK_2;
		block3 = Block.BLOCK_3_4;

		// initialise create profile button

		btnAdd = new Button(" Add");
		btnRemove = new Button(" Remove ");
		
		btnReset = new Button(" Reset ");
		btnSumbit = new Button(" Sumbit ");

		// add controls and labels to container

		VBox box1 = new VBox();
		box1.getChildren().addAll(selectBlock1, txtBlock1);

		VBox box2 = new VBox();

		box2.getChildren().addAll(selectBlock2, txtBlock2);

		VBox container1 = new VBox();
		container1.setSpacing(15);
		// container.setMinSize(100, 50);
		container1.getChildren().addAll(box1, box2);

		VBox box3 = new VBox();
		box3.getChildren().addAll(unSelectBlock3, txtBlock3);

		HBox box4 = new HBox();
		box4.setSpacing(10);
		box4.getChildren().addAll(btnBlock, btnAdd, btnRemove);

		VBox box5 = new VBox();
		box5.getChildren().addAll(selectedBlock3, txtBlock4);

		VBox container2 = new VBox();
		container2.setSpacing(20);
		// container.setMinSize(100, 50);
		container2.getChildren().addAll(box3, box4, box5);

		HBox container3 = new HBox();
		container3.setSpacing(10);
		container3.setPadding(new Insets(50, 20, 20, 20));
		container3.getChildren().addAll(container1, container2);
		container3.setAlignment(Pos.CENTER);

		HBox box6 = new HBox();
		box6.setSpacing(10);
		box6.setAlignment(Pos.CENTER);
		box6.getChildren().addAll(credit, txtBlock5);

		HBox box7 = new HBox();
		box7.setSpacing(15);
		box7.setAlignment(Pos.CENTER);
		box7.getChildren().addAll(btnReset, btnSumbit);

		VBox container4 = new VBox();

		container4.setSpacing(15);
		container4.setAlignment(Pos.CENTER);
		container4.setMinWidth(510);
		container4.setMinHeight(300);
		container4.setPadding(new Insets(50, 50, 50, 50));
		container4.getChildren().addAll(container3, box6, box7);

		this.getChildren().addAll(container4);

		this.setVgrow(box4, Priority.ALWAYS);
		this.setHgrow(box4, Priority.ALWAYS);

		this.setVgrow(box7, Priority.ALWAYS);
		this.setHgrow(box7, Priority.ALWAYS);

		this.setVgrow(container1, Priority.ALWAYS);
		this.setHgrow(container1, Priority.ALWAYS);

		this.setVgrow(container2, Priority.ALWAYS);
		this.setHgrow(container2, Priority.ALWAYS);

		this.setVgrow(container3, Priority.ALWAYS);
		this.setHgrow(container3, Priority.ALWAYS);

		this.setVgrow(container4, Priority.ALWAYS);
		this.setHgrow(container4, Priority.ALWAYS);

	}

	// Methods

	public void setModule(Module name) {
		
		txtBlock5.setText("60");
		
		if (name.isMandatory() && name.getRunPlan() == block1) {
			txtBlock1.getItems().add(name);
		} else if (name.isMandatory() && name.getRunPlan() == block2) {
			txtBlock2.getItems().add(name);
		} else if (!name.isMandatory() && name.getRunPlan() == block3) {
			txtBlock3.getItems().add(name);
		} else {
			txtBlock4.getItems().add(name);
		}
	}

	public void addModule(Module name, ListView<Module> course) {

		course.getItems().addAll(name);
	}

	public void RemoveModule(Module name, ListView<Module> course) {

		course.getItems().removeAll(name);
	}
	
	public String getCredit() {
		return txtBlock5.getText();
		
	}
	
	public void addModule() {
		if(txtBlock4.getItems().size() <3) {
			txtBlock4.getItems().addAll(txtBlock3.getSelectionModel().getSelectedItem());
			txtBlock3.getItems().removeAll(txtBlock3.getSelectionModel().getSelectedItem());
			
			
			if(txtBlock5.getText().equals("60")) {
				txtBlock5.setText("90");
			}
			else if (txtBlock5.getText().equals("90")) {
				txtBlock5.setText("120");
			}
		
		}
	}
	
	public void removeModule() {
		txtBlock3.getItems().addAll(txtBlock4.getSelectionModel().getSelectedItem());
		txtBlock4.getItems().removeAll(txtBlock4.getSelectionModel().getSelectedItem());
		
		
		if(txtBlock5.getText().equals("90")) {
			txtBlock5.setText("60");
		}
		else if (txtBlock5.getText().equals("120")) {
			txtBlock5.setText("90");
		}
	}
	
	public void resetModule () {
		txtBlock1.getItems().clear();
		txtBlock2.getItems().clear();
		txtBlock3.getItems().clear();
		txtBlock4.getItems().clear();
		txtBlock5.setText("60");
	}




	public ListView<Module> getUnselectedMethods(){
		return txtBlock3;
	}
	
	public ListView<Module> getSelectedMethods(){
		return txtBlock4;
	}

	
	
	
	

	public ObservableList<Module> getContents() {
		return course;
	}

	// method to attach the create student profile button event handler
	public void addResetButtonHandler(EventHandler<ActionEvent> handler) {
		btnReset.setOnAction(handler);
	}

	public void addSumbitButtonHandler(EventHandler<ActionEvent> handler) {
		btnSumbit.setOnAction(handler);
	}

	public void addAddButtonHandler(EventHandler<ActionEvent> handler) {
		btnAdd.setOnAction(handler);
	}

	public void addRemoveButtonHandler(EventHandler<ActionEvent> handler) {
		btnRemove.setOnAction(handler);
	}

}
