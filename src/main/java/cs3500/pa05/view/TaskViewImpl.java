package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 * Represents a simple task creation GUI view.
 */
public class TaskViewImpl implements View {

  private final FXMLLoader loader;

  /**
   * Initializes a controller
   *
   * @param controller to initialize
   */
  public TaskViewImpl(Controller controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Task.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Shows a warning if invalid input is received for a day
   */
  public void showWarning() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Alert");
    alert.setHeaderText("Warning");
    alert.setContentText("Invalid input for day");
    alert.showAndWait();
  }

  /**
   * Loads a scene for task creation in GUI layout.
   *
   * @return the layout
   */
  @Override
  public Scene load() throws IllegalStateException {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
