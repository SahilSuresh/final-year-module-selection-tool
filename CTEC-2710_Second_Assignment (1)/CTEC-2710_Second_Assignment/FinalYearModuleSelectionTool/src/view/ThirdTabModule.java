package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Module;

public class ThirdTabModule extends GridPane {
	private ListView<Module> txtBlock1, txtBlock2;
	private Button btnAdd, btnRemove, btnConfirm; 
	
	public ThirdTabModule() {
		
		Label txt1 = new Label("Unselected Block 3/4 modules");
		Label txt2 = new Label("Reserved Block 3/4 modules");
		Label btn = new Label ("Reserve one optional module"); 
		
		//setup textField
		
		txtBlock1 = new ListView<Module>();
		txtBlock1.setPrefSize(350, 400);
		
		txtBlock2 = new ListView<Module>();
		txtBlock2.setPrefSize(350, 400);

		
		//initialise create profile button

		btnAdd = new Button(" Add ");
		btnRemove = new Button(" Remove ");
		btnConfirm = new Button(" Confirm ");
		
		
		//add controls and labels to container
		
		VBox box1 = new VBox(txt1, txtBlock1);
		
		VBox box2 = new VBox(txt2, txtBlock2);
		
		HBox container = new HBox(box1, box2);
		container.setAlignment(Pos.CENTER);
		container.setSpacing(20);
		
		HBox box3 = new HBox(btn, btnAdd, btnRemove, btnConfirm);
		box3.setAlignment(Pos.CENTER);
		box3.setSpacing(10);
		
		
		VBox container2 = new VBox(container, box3);
		container2.setSpacing(15);
		container2.setAlignment(Pos.CENTER);
		
		container2.setPadding(new Insets (120, 15, 20, 15));
		
		this.getChildren().add(container2);
		

		this.setVgrow(box3, Priority.ALWAYS);
		this.setHgrow(box3, Priority.ALWAYS);
		
		this.setVgrow(container, Priority.ALWAYS);
		this.setHgrow(container, Priority.ALWAYS);
		
		this.setVgrow(container2, Priority.ALWAYS);
		this.setHgrow(container2, Priority.ALWAYS);
		
	}
	// method to attach the create student profile button event handler
	
	public void addAddButtonHandler(EventHandler<ActionEvent> handler) {
		btnAdd.setOnAction(handler);
	}

	public void addRemoveButtonHandler(EventHandler<ActionEvent> handler) {
		btnRemove.setOnAction(handler);
	}
	
	public void addConfirmButtonHandler(EventHandler<ActionEvent> handler) {
		btnConfirm.setOnAction(handler);
	}
	
	//Methods
	
	public void getUnselectedBlock(ListView<Module> n) {
		txtBlock1.getItems().clear();
		txtBlock1.getItems().addAll(n.getItems());		
		
	}
	
	public void addUnselectedModule() {
		
			txtBlock2.getItems().addAll(txtBlock1.getSelectionModel().getSelectedItem());
			txtBlock1.getItems().removeAll(txtBlock1.getSelectionModel().getSelectedItems());
		
	}
	
	public void removeUnselectedModule() {
		
			txtBlock1.getItems().addAll(txtBlock2.getSelectionModel().getSelectedItem());
			txtBlock2.getItems().removeAll(txtBlock2.getSelectionModel().getSelectedItems());
	
		
	}
	
	public ListView<Module> gettxtBlock1() {
		return txtBlock1;
	}
	
	public ListView<Module> getReserveModule() {
		return txtBlock2;
	}
	
	


	
	

}
