package Base25.week8.Calc;

import java.math.BigDecimal;
import java.util.Locale;

import Base25.week8.Calc.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Base25.week8.lesson16.AttribInt;

public class CalcFX extends Application implements CalcKeyMarks, AttribInt,
		Displayable {

	public static final int	fontSize	= 14;
	public static final int	HPADDING	= 10;
	public static final int	VPADDING	= 10;
	public static final int	minBtWidth	= 60;
	public static final int	minBtHeight	= minBtWidth;
	public static final int	sceneWidth	= 800;
	public static final int	sceneHeight	= 550;

	AbstractProcessor		processor	= new TestProcessor();

	private TextField		res			= new TextField();
	private RadioButton		button1		= new RadioButton("degree");
	private RadioButton		button2		= new RadioButton("radian");
	private MenuBar			menuBar		= new MenuBar();
	private GridPane		sceneGrid	= new GridPane();
	private Scene			scene;
	private Button			inversion;
	{
		sceneGrid.setAlignment(Pos.CENTER);
		sceneGrid.setHgap(HPADDING);
		sceneGrid.setVgap(VPADDING);
		sceneGrid.setPadding(new Insets(25, 25, 25, 25)); // margins around the
		// whole

		button1.setUserData(0);
		button2.setUserData(1);
		res.setText("0");
		res.setAlignment(Pos.TOP_RIGHT);
	}

	@Override
	public void setDisplayFieldText(String s) {
		res.setText(s);
	}

	public static void main(String[] args) {
		Locale EngLocale = new Locale("en", "UK");
		Locale.setDefault(EngLocale);

		launch();
	}

	public void inSymv(char c) {
		System.out.println((int) c);
		c = transformChar(c);
		System.out.println((int) c);
		processor.inputChar(c);
		processor.printResult(this);
		processor.setPrevChar(c);

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator JavaFx, v1.0");
		menuBar.prefWidthProperty().bind(stage.widthProperty());
		menuBar.getMenus().addAll(fileMenu(), viewMenu(stage));

		setBtStyle(sceneGrid, fontSize);

		BorderPane root = new BorderPane();

		root.setTop(menuBar);
		root.setCenter(sceneGrid);
		scene = new Scene(root, sceneWidth, sceneHeight);

		stage.setScene(scene);
		stage.show();

	}

	public Menu fileMenu() {

		// File menu - new, save, exit
		Menu menu = new Menu("_File");
		menu.setMnemonicParsing(true);
		MenuItem exitMenuItem = new MenuItem("_Exit");
		exitMenuItem.setMnemonicParsing(true);
		menu.setOnAction(actionEvent -> Platform.exit());

		menu.getItems().addAll(exitMenuItem, new SeparatorMenuItem());
		return menu;
	}

	public Menu viewMenu(Stage stage) {

		// File menu - new, save, exit
		Menu menu = new Menu("_View");
		menu.setMnemonicParsing(true);
		RadioMenuItem commonViewItem = new RadioMenuItem("_Common");
		commonViewItem.setMnemonicParsing(true);
		RadioMenuItem engineerViewItem = new RadioMenuItem("_Engineer");
		engineerViewItem.setMnemonicParsing(true);

		engineerViewItem.setSelected(true);

		ToggleGroup group = new ToggleGroup();
		commonViewItem.setToggleGroup(group);
		engineerViewItem.setToggleGroup(group);

		commonViewItem.setOnAction(actionEvent -> {
			sceneGrid.getChildren().clear();
			setCommonGrid();
			stage.setWidth(sceneWidth / 2);
			res.deselect();
		});

		engineerViewItem.setOnAction(actionEvent -> {
			sceneGrid.getChildren().clear();
			setSciGrid();
			stage.setWidth(sceneWidth);
			res.deselect();
		});

		engineerViewItem.fire();

		menu.getItems().addAll(commonViewItem, engineerViewItem,
				new SeparatorMenuItem());
		return menu;
	}

	public VBox drawSciPad() {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BOTTOM_LEFT);
		grid.setHgap(HPADDING);
		grid.setVgap(VPADDING);
		grid.setPadding(new Insets(0, 0, 0, 0)); // margins around th

		VBox vbox = new VBox(VPADDING);
		setRandBkColor(vbox);

		HBox hbox = new HBox(HPADDING);
		hbox.setPadding(new Insets(VPADDING, HPADDING, VPADDING, HPADDING));
		hbox.setStyle("-fx-border-color: black;");
		setRandBkColor(hbox);
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.setMinSize(minBtWidth, minBtHeight);
		ToggleGroup group = new ToggleGroup();

		group.selectedToggleProperty().addListener(
				new ChangeListener<Toggle>() {
					@Override
					public void changed(ObservableValue<? extends Toggle> ov,
							Toggle old_toggle, Toggle new_toggle) {
						if (group.getSelectedToggle() != null) {
							((TestProcessor) processor).setDegRad(Integer
									.parseInt(group.getSelectedToggle()
											.getUserData().toString()));
						}
					}
				});

		button1.setToggleGroup(group);
		button1.setSelected(true);

		button2.setToggleGroup(group);
		hbox.getChildren().add(button1);
		hbox.getChildren().add(button2);

		setRandBkColor(grid);
		class SciEvent<T> implements EventHandler<ActionEvent> {
			private char	code;

			public SciEvent(int j, int i) {
				this.code = (char) (sciPadStartCode + j * sciPad[0].length + i);
			}

			@Override
			public void handle(ActionEvent event) {
				inSymv(code);
				if (code == sciPadStartCode + 1) {
					inversion.setUserData(~(int) inversion.getUserData());
					// System.out.println(inversion.getUserData().toString());
				}
			}
		}
		for (int j = 0; j < sciPad.length; j++) {
			for (int i = 0; i < sciPad[0].length; i++) {
				Button bt2 = new Button(sciPad[j][i]);
				bt2.setMinSize(minBtWidth, minBtHeight);
				grid.add(bt2, i, j);
				bt2.setOnAction(new SciEvent<ActionEvent>(j, i));
				if (j == 0 && i == 1) {
					inversion = bt2;
					inversion.setUserData(0);
				}

			}
		}

		vbox.getChildren().addAll(hbox, grid);
		return vbox;
	}

	public HBox drawOperPad() {

		HBox hbox2 = new HBox(VPADDING);
		hbox2.setPadding(new Insets(0, 0, 0, 0));
		hbox2.setAlignment(Pos.TOP_LEFT);
		setRandBkColor(hbox2);

		VBox vbox3 = new VBox(VPADDING);
		vbox3.setAlignment(Pos.TOP_LEFT);
		setRandBkColor(vbox3);

		VBox vbox4 = new VBox(VPADDING);
		vbox4.setAlignment(Pos.TOP_LEFT);
		setRandBkColor(vbox4);

		for (String[] element : operPad) {
			Button bt2 = new Button(element[0]);
			bt2.setMinSize(minBtWidth, minBtHeight);
			bt2.setOnAction(new NumEvent<ActionEvent>(bt2.getText()));
			vbox3.getChildren().add(bt2);
		}
		for (int i = 0; i < 3; i++) {
			Button bt2 = new Button(operPad[i][1]);
			bt2.setMinSize(minBtWidth, minBtHeight);
			bt2.setOnAction(new NumEvent<ActionEvent>(bt2.getText()));
			vbox4.getChildren().add(bt2);
		}
		Button bt2 = new Button(operPad[3][1]); // "="
		bt2.setMinSize(minBtWidth, minBtHeight * 2 + VPADDING);
		bt2.setOnAction(new NumEvent<ActionEvent>(bt2.getText()));
		vbox4.getChildren().add(bt2);

		hbox2.getChildren().addAll(vbox3, vbox4);
		return hbox2;
	}

	private void setBtStyle(Region region, int FontSize) {
		region.setStyle("-fx-font-weight: bold; -fx-font-size: " + FontSize
				+ "pt");
	}

	public HBox drawMemPad() {

		HBox hbox = new HBox(VPADDING);
		hbox.setAlignment(Pos.TOP_LEFT);
		setRandBkColor(hbox);
		Button btSave2Mem = null;
		for (int i = 0; i < memPad.length; i++) {
			Button bt2 = new Button(memPad[i]);
			if (i == 0) btSave2Mem = bt2;
			bt2.setMinSize(minBtWidth, minBtHeight);
			bt2.setOnAction(new MemEvent((char) (i + startMemCode), btSave2Mem));
			hbox.getChildren().add(bt2);
		}
		setBtStyle(hbox, fontSize);
		return hbox;
	}

	public VBox drawNumPad() {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(HPADDING);
		grid.setVgap(VPADDING);
		grid.setPadding(new Insets(-VPADDING, 0, 0, 0)); // margins around th

		setRandBkColor(grid);

		for (int i = 3; i < numericPad.length; i++) {
			Button bt2 = new Button(numericPad[i]);
			bt2.setMinSize(minBtWidth, minBtHeight);
			grid.add(bt2, i % 3, (i) / 3);
			bt2.setOnAction(new NumEvent(numericPad[i]));
		}

		HBox hbox5 = new HBox(HPADDING);
		setRandBkColor(hbox5);
		hbox5.setAlignment(Pos.TOP_LEFT);
		for (int i = 0; i < 3; i++) {
			Button bt2 = new Button(numericPad[i]);
			bt2.setMinSize(minBtWidth, minBtHeight);

			hbox5.getChildren().add(bt2);
			bt2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (bt2.getText().equals(numericPad[0])) inSymv((char) 8);
					if (bt2.getText().equals(numericPad[1])) inSymv((char) 20);
					if (bt2.getText().equals(numericPad[2])) inSymv((char) 19);

				}
			});

		}

		HBox hbox4 = new HBox(HPADDING);
		setRandBkColor(hbox4);
		hbox4.setAlignment(Pos.TOP_LEFT);

		Button btZero = new Button(zeroPad[0]);

		btZero.setMinSize(minBtWidth * 2 + HPADDING, minBtHeight);
		btZero.setOnAction(new NumEvent(zeroPad[0]));
		hbox4.getChildren().add(btZero);

		Button btDot = new Button(zeroPad[1]);
		btDot.setMinSize(minBtWidth, minBtHeight);
		btDot.setOnAction(new NumEvent(zeroPad[1]));
		hbox4.getChildren().add(btDot);

		VBox vbox1 = new VBox(VPADDING);
		vbox1.setAlignment(Pos.TOP_LEFT);
		vbox1.setPadding(new Insets(0, 0, 0, 0));
		setRandBkColor(vbox1);
		// vbox1.getChildren().add(hbox5);
		vbox1.getChildren().addAll(hbox5, grid, hbox4);
		return vbox1;

	}

	public void setCommonGrid() {

		VBox vbox7 = new VBox(VPADDING);
		HBox hbox7 = new HBox(HPADDING);
		hbox7.getChildren().addAll(drawNumPad(), drawOperPad());
		res.setEditable(false);

		vbox7.getChildren().addAll(res, drawMemPad(), hbox7);

		sceneGrid.add(vbox7, 0, 0);

	}

	public void setSciGrid() {
		VBox vbox7 = new VBox(VPADDING);
		HBox hbox7 = new HBox(HPADDING);
		hbox7.getChildren().addAll(drawNumPad(), drawOperPad());
		res.setEditable(false);

		HBox hbox8 = new HBox(HPADDING);
		vbox7.getChildren().addAll(drawMemPad(), hbox7);
		hbox8.getChildren().addAll(drawSciPad(), vbox7);
		sceneGrid.add(res, 0, 0);
		sceneGrid.add(hbox8, 0, 1);

	}

	public Scene createScene() {

		// Group sceneGrid = new Group();

		// sceneGrid
		// (top/right/bottom/left)
		VBox vbox7 = new VBox(VPADDING);

		HBox hbox7 = new HBox(HPADDING);
		int k = 1;
		hbox7.getChildren().addAll(drawNumPad(), drawOperPad());
		res.setEditable(false);
		if (k == 1) {
			vbox7.getChildren().addAll(res, drawMemPad(), hbox7);
			sceneGrid.add(vbox7, 0, 0);
		}
		if (k == 2) {
			HBox hbox8 = new HBox(HPADDING);
			vbox7.getChildren().addAll(drawMemPad(), hbox7);
			hbox8.getChildren().addAll(drawSciPad(), vbox7);
			sceneGrid.add(res, 0, 0);
			sceneGrid.add(hbox8, 0, 1);
		}
		return new Scene(new GridPane());

	}

	class NumEvent<T> implements EventHandler {
		private String	name;

		@Override
		public void handle(Event arg0) {
			// res.setText(res.getText() + name);
			inSymv(name.charAt(0));
		}

		public NumEvent(String n) {
			name = n;
		}
	}

	class MemEvent<T> implements EventHandler {
		private char	code;
		private Button	button;

		@Override
		public void handle(Event arg0) {
			// res.setText(res.getText() + name);
			inSymv(code);
			if (code == startMemCode
					&& processor.getMem().compareTo(BigDecimal.ZERO) != 0) {
				button.setStyle("-fx-background-color: #BFBFBF ");
			}

			if (code == 2 + startMemCode) {
				button.setStyle("");
				setBtStyle((Region) button.getParent(), fontSize);
			}

		}

		public MemEvent(char c, Button bt) {
			code = c;
			button = bt;
		}
	}

	public TextField getRes() {
		return res;
	}

	public void setRes(TextField res) {
		this.res = res;
	}
}
