package Base25.week8.lesson16;

import java.util.Optional;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import org.controlsfx.dialog.LoginDialog;

public class TableViewExample extends Application {
	/* w ww. j a v a 2s . c om */
	TableView<Person>						table	= new TableView<Person>();
	final HBox								hb		= new HBox();
	private final ObservableList<Person>	data	= FXCollections
			.observableArrayList(new Person(
					"A", "B"));

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setWidth(450);
		stage.setHeight(550);
		table.setEditable(true);

		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(100);
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		TableColumn emailCol = new TableColumn("Email");

		TableColumn PEmailCol = new TableColumn("Personal");
		PEmailCol.setMinWidth(100);
		PEmailCol.setCellValueFactory(new PropertyValueFactory<>("personal"));

		TableColumn WEmailCol = new TableColumn("Work");
		WEmailCol.setMinWidth(100);
		WEmailCol.setCellValueFactory(new PropertyValueFactory<>("work"));

		emailCol.getColumns().addAll(PEmailCol, WEmailCol);

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
		emailCol.setVisible(true);
		// table.in
		table.setItems(data);

		final Button closeButton = new Button("Close");
		closeButton.setOnAction((ActionEvent e) -> {
			// data.add(new Person("Z", "X"));
				System.exit(0);
			});

		final Button addButton = new Button("Add");
		addButton.setOnAction((ActionEvent e) -> {
			// data.add(new Person("Z", "X"));
				Dialog<Person> dialog = new Dialog<Person>();
				dialog.setTitle("Додати особу в таблицю:");

				// Set the button types.
				ButtonType OkButtonType = new ButtonType("OK",
						ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes()
						.addAll(OkButtonType, ButtonType.CANCEL);

				GridPane grid = new GridPane();
				grid.setHgap(10);
				grid.setVgap(10);
				HBox hBox1 = new HBox(10);
				// hBox1.setPadding(new Insets(2, right, bottom, left));
				TextField name = new TextField();
				Label Lname = new Label("ім'я:");
				Lname.setMinWidth(70);
				Lname.setFont(Font.font(14));
				hBox1.getChildren().addAll(Lname, name);

				HBox hBox2 = new HBox(10);
				TextField sname = new TextField();
				Label LSname = new Label("прізвище:");
				LSname.setMinWidth(Lname.getMinWidth());
				LSname.setFont(Lname.getFont());
				hBox2.getChildren().addAll(LSname, sname);

				grid.add(hBox1, 0, 0);
				grid.add(hBox2, 0, 1);
				// dialog.getDialogPane().setContentText("������ ��� �����:");
				dialog.getDialogPane().setContent(grid);
				// dialog.getDialogPane().setContent(
				// new HBox(new Button("Close"), new Button("ok")));

				dialog.setResultConverter(dialogButton1 -> {
					Person person = new Person(name.getText(), sname.getText());
					if (dialogButton1 == OkButtonType) {
						return person;
					}
					else return null;
				});

				Optional<Person> res = dialog.showAndWait();

				res.ifPresent(person -> {
					data.add(person);
				});

			});
		final Button Hyperlink9 = new Button("LoginDialog");
		Hyperlink9.setOnAction(e -> {
			Pair<String, String> pair1 = new Pair<>("", "");
			Callback<Pair<String, String>, Void> auth = null;
			LoginDialog ld = new LoginDialog((new Pair<>("name1", "name2")),
					auth);
			Optional<Pair<String, String>> res = ld.showAndWait();

			res.ifPresent(person -> {
				System.out.println(ld.getResult().getKey() + ", "
						+ ld.getResult().getValue());
			});
		});

		final Button Hyperlink8 = new Button("TextField");
		Hyperlink8.setOnAction(e -> {
			TextInputDialog dlg = new TextInputDialog("");
			dlg.setTitle("Name Check");
			dlg.getDialogPane().setContentText("What is your name?");

			Optional<String> res = dlg.showAndWait();

			res.ifPresent(text -> {
				System.out.println(text);
			});
		});
		// final Button Hyperlink9 = new Button("Initial Value Set");
		// Hyperlink9.setOnAction(e -> {
		// TextInputDialog dlg = new TextInputDialog("Jonathan");
		// dlg.setTitle("Name Guess");
		// String optionalMasthead = "Name Guess";
		// dlg.getDialogPane().setContentText("Pick a name?");
		// configureSampleDialog(dlg, optionalMasthead);
		// showDialog(dlg);
		// });

		hb.getChildren().addAll(addButton, closeButton, Hyperlink8, Hyperlink9);
		hb.setSpacing(3);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table, hb);

		((Group) scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);
		stage.show();
	}

	public static class Person {

		private final SimpleStringProperty	firstName;

		private final SimpleStringProperty	lastName;

		private Person(String fName, String lName) {
			this.firstName = new SimpleStringProperty(fName);
			this.lastName = new SimpleStringProperty(lName);
		}

		public String getFirstName() {
			return firstName.get();
		}

		public void setFirstName(String fName) {
			firstName.set(fName);
		}

		public String getLastName() {
			return lastName.get();
		}

		public void setLastName(String fName) {
			lastName.set(fName);
		}
	}
}
