package controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import model.Block;
import model.Course;
import model.Module;
import model.Name;
import model.StudentProfile;
import view.FinalYearOptionsRootPane;
import view.FourthTabModule;
import view.SecondTabModule;
import view.ThirdTabModule;
import view.CreateStudentProfilePane;
import view.FinalYearOptionsMenuBar; 

public class FinalYearOptionsController implements Comparable<Module>, Serializable {

	//fields to be used throughout class
	private FinalYearOptionsRootPane view;
	private StudentProfile model;
	
	private CreateStudentProfilePane cspp;
	private SecondTabModule stm;
	private ThirdTabModule ttm;
	private FourthTabModule ftm;
	private FinalYearOptionsMenuBar mstmb;

	public FinalYearOptionsController(FinalYearOptionsRootPane view, StudentProfile model) {
		//initialise view and model fields
		this.view = view;
		this.model = model;
		
		//initialise view subcontainer fields
		cspp = view.getCreateStudentProfilePane();
		mstmb = view.getModuleSelectionToolMenuBar();
        stm =  view.getSecondTabModule();
        ttm = view.getThirdTabModule();
        ftm = view.getFourthTabModule();
        
		//add courses to combobox in create student profile pane using the buildModulesAndCourses helper method below
		cspp.addCourseDataToComboBox(buildModulesAndCourses());

		//attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	
	//helper method - used to attach event handlers
	private void attachEventHandlers() {
		//attach an event handler to the create student profile pane
		cspp.addCreateStudentProfileHandler(new CreateStudentProfileHandler());
		
		stm.addAddButtonHandler(e -> stm.addModule());
		stm.addRemoveButtonHandler(e -> stm.removeModule());
		stm.addResetButtonHandler( new SelectTabResetButton());
		stm.addSumbitButtonHandler(new SelectTabSumbitButton());
		
		
		ttm.addAddButtonHandler(e -> ttm.addUnselectedModule());
		ttm.addRemoveButtonHandler(e -> ttm.removeUnselectedModule());
		ttm.addConfirmButtonHandler(new ReserveConformButton());
		
		ftm.addSaveOverviewButtonHandler(new SaveOverviewButton());
		
		
		
		//attach an event handler to the menu bar that closes the application
		mstmb.addExitHandler(e -> System.exit(0));
		mstmb.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Final Year Module Selection MVC app v1.0"));
		//mstmb.addLoadHandler(new LoadMenuHandler());
		mstmb.addSaveHandler(new SaveMenuHandler());
		mstmb.addLoadHandler(new LoadMenuHandler());
	}
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		
		alert.showAndWait();
	}
	
	private class LoadMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studentProfile.dat"));) {

				model = (StudentProfile) ois.readObject();	

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Profile loaded from: studentProfile.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

			//refresh the view with the names loaded back into the model
			cspp.setSelectedStudentCourse(model.getStudentCourse());
			cspp.setStudentPnumber(model.getStudentPnumber());
			cspp.setStudentName(model.getStudentName());
			cspp.setStudentEmail(model.getStudentEmail());
			cspp.setStudentDate(model.getSubmissionDate());
		}
	}
	
	private class SaveMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentProfile.dat"));) {

				oos.writeObject(model);
				oos.flush();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Student Profile Save Successfully", "Profile is saved to: " + " studentProfile.dat");
			}
			catch (IOException ioExcep){
				ioExcep.printStackTrace();
				System.out.println("Error saving");
			}
		}
	}



	//event handler (currently empty), which can be used for creating a profile
	private class CreateStudentProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			model.setStudentCourse(cspp.getSelectedCourse());
			model.setStudentPnumber(cspp.getStudentPnumber());
			model.setStudentName(cspp.getStudentName());
			model.setStudentEmail(cspp.getStudentEmail());
			model.setSubmissionDate(cspp.getStudentDate());
			
			model.getStudentCourse().getAllModulesOnCourse();
			
			for(Module i: model.getStudentCourse().getAllModulesOnCourse()) {
				System.out.println(i);
				stm.setModule(i);
				view.changeTab(1);
			}
				
		}
	}
	
	private class SelectTabSumbitButton implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			view.changeTab(2);
			ttm.getUnselectedBlock(stm.getUnselectedMethods());
			
			
			
		
					
				
		}
	}
	
	private class ReserveConformButton implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			view.changeTab(3);
			
			ftm.settxtBlock1(model.getStudentName(), model.getStudentPnumber(), model.getStudentEmail(), model.getSubmissionDate(), model.getStudentCourse());
			ftm.getSelectedBlock(stm.getSelectedMethods());
			ftm.getReserveBlock(ttm.getReserveModule());
			
		}
	}
	
	
	
	
	private class SelectTabResetButton implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			stm.resetModule();
			model.setStudentCourse(cspp.getSelectedCourse());
			model.setStudentPnumber(cspp.getStudentPnumber());
			model.setStudentName(cspp.getStudentName());
			model.setStudentEmail(cspp.getStudentEmail());
			model.setSubmissionDate(cspp.getStudentDate());
			
			model.getStudentCourse().getAllModulesOnCourse();
			
			for(Module i: model.getStudentCourse().getAllModulesOnCourse()) {
				System.out.println(i);
				stm.setModule(i);
			}
				
		}
	}
	
	private class SaveOverviewButton implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			
			FileChooser chooser = new FileChooser();
			File file = chooser.showSaveDialog(null);
			
			//save the data model
			try (PrintWriter writer = new PrintWriter(file)) {

				writer.write(ftm.gettxtBlock1() + "\n");
//				writer.write(ftm.getSelectedBlock);
				
				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Overview Save", "Save Successful");
			}
			catch (IOException ioExcep){
				//ioExcep.printStackTrace();
				System.out.println("Error saving");
			}
		}
	}
	
	


	//helper method - builds modules and course data and returns courses within an array
	private Course[] buildModulesAndCourses() {
		Module ctec3701 = new Module("CTEC3701", "Software Development: Methods & Standards", 30, true, Block.BLOCK_1);

		Module ctec3702 = new Module("CTEC3702", "Big Data and Machine Learning", 30, true, Block.BLOCK_2);
		Module ctec3703 = new Module("CTEC3703", "Mobile App Development and Big Data", 30, true, Block.BLOCK_2);

		Module ctec3451 = new Module("CTEC3451", "Development Project", 30, true, Block.BLOCK_3_4);

		Module ctec3704 = new Module("CTEC3704", "Functional Programming", 30, false, Block.BLOCK_3_4);
		Module ctec3705 = new Module("CTEC3705", "Advanced Web Development", 30, false, Block.BLOCK_3_4);

		Module imat3711 = new Module("IMAT3711", "Privacy and Data Protection", 30, false, Block.BLOCK_3_4);
		Module imat3722 = new Module("IMAT3722", "Fuzzy Logic and Inference Systems", 30, false, Block.BLOCK_3_4);

		Module ctec3706 = new Module("CTEC3706", "Embedded Systems and IoT", 30, false, Block.BLOCK_3_4);


		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec3701);
		compSci.addModule(ctec3702);
		compSci.addModule(ctec3451);
		compSci.addModule(ctec3704);
		compSci.addModule(ctec3705);
		compSci.addModule(imat3711);
		compSci.addModule(imat3722);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec3701);
		softEng.addModule(ctec3703);
		softEng.addModule(ctec3451);
		softEng.addModule(ctec3704);
		softEng.addModule(ctec3705);
		softEng.addModule(ctec3706);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}


	@Override
	public int compareTo(Module o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
