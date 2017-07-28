package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.LeavePage;
import pageclasses.TrainingCoursesPage;

public class TrainingCoursesSteps extends DriverFactory {
	
	@When("^I am on the Training courses page$")
	public void i_am_on_a_new_leave_page() throws Throwable {
        new TrainingCoursesPage(driver).Navigate_training_courses_page();
    }
	
	@When("^I select Training action Requested Courses")
	public void i_select_Training_action_requested_courses() throws Throwable {
		new TrainingCoursesPage(driver).selectTrainingActionRequestedCourses();
	}

	@When("^I click on Add button$")
	public void i_click_on_Add_button() throws Throwable {
		new TrainingCoursesPage(driver).add_button();	
	}

	@When("^I click on Search button$")
	public void i_click_on_Search_button() throws Throwable {
		new TrainingCoursesPage(driver).searchButton();	
	}

	@When("^I select the program from result")
	public void i_select_the_program_from_result() throws Throwable {
		new TrainingCoursesPage(driver).selectProgram();
	}

	@When("I select Reason General Interest")
	public void i_select_Reason() throws Throwable {
		new TrainingCoursesPage(driver).selectGeneralInterest();
	}

	@When("^I click on Apply button$")
	public void i_click_on_Apply_button() throws Throwable {
		new TrainingCoursesPage(driver).apply();
	}

	@When("^I click on Submit button$")
	public void i_click_on_Submit_button() throws Throwable {
		new TrainingCoursesPage(driver).submit();
	}
	
	@Then("^I should see the success message is displayed if there is no overlap$") 
	public void I_should_see_the_success_message_is_displayed_if_no_overlap() throws Throwable {
		new TrainingCoursesPage(driver).successOrOverlap();
	}
	
	@Then("^I should see the program$") 
	public void I_should_see_the_program() throws Throwable {
		new TrainingCoursesPage(driver).seeTheProgramm();
	}
}