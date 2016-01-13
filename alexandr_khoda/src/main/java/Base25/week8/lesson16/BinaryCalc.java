package Base25.week8.lesson16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BinaryCalc extends Application implements AttribInt {
	private static final int	HBOXSPACING		= 50;
	private static final int	MINLABLEWIDTH	= 300;
	private static final int	CHECKBOXNUM		= 8;

	private TextField			tBinDec			= new TextField();
	private TextField			tBinBin			= new TextField();

	private TextField			tDecBin			= new TextField();
	private TextField			tDecDec			= new TextField();

	private CheckBox[]			chb				= new CheckBox[CHECKBOXNUM];

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Бинарно-десятичный переводчик");
		// stage.getIcons().add(new
		// Image("file:resources/images/notebook2.png"));
		// stage.getIcons().add(new Image("file:resources/images/notepad.png"));
		stage.setScene(createScene());
		stage.show();
	}

	public Scene createScene() {
		tBinBin.setEditable(false);
		tDecDec.setEditable(false);
		GridPane grid = new GridPane();

		grid.setAlignment(Pos.TOP_RIGHT);
		BackgroundFill bkGrColor = new BackgroundFill(Color.YELLOWGREEN,
				CornerRadii.EMPTY, Insets.EMPTY);
		grid.setBackground(new Background(bkGrColor));

		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(20);
		grid.setVgap(10);

		HBox hbox1 = new HBox(HBOXSPACING);
		hbox1.setPadding(new Insets(1, 15, 1, 15));
		hbox1.setStyle("-fx-border:1px solid #ed1c24");
		hbox1.setStyle("-fx-font-weight: bold; -fx-font-size: 16pt");

		BackgroundFill bgMocassin = new BackgroundFill(
				Color.web(getRandColor()), CornerRadii.EMPTY, Insets.EMPTY);
		hbox1.setBackground(new Background(bgMocassin));

		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox1.setMinSize(700, 40);
		tBinBin.setStyle("-fx-text-fill: " + getRandColor());
		Label labBin = new Label("1. Перевод в двоичную");
		String col1 = getRandColor();
		while (Color.web(col1).equals(bgMocassin.getFill())) {
			col1 = getRandColor();
		}

		labBin.setStyle(" -fx-text-fill: " + col1);

		labBin.setMinWidth(MINLABLEWIDTH);
		hbox1.getChildren().add(labBin);

		Button bBin2Dec = new Button("Перевести");
		bBin2Dec.setOnAction(new MyEvent<ActionEvent>(0));

		hbox1.getChildren().add(tBinDec);
		hbox1.getChildren().add(bBin2Dec);
		hbox1.getChildren().add(tBinBin);
		// ------------HBOX2------------------------------------------------------------------
		HBox hbox2 = new HBox(HBOXSPACING);
		hbox2.setPadding(new Insets(1, 15, 1, 15));
		hbox2.setStyle(hbox1.getStyle());
		tDecBin.setStyle("-fx-text-fill: " + getRandColor());

		BackgroundFill color2 = new BackgroundFill(Color.web(getRandColor()),
				CornerRadii.EMPTY, Insets.EMPTY);
		hbox2.setBackground(new Background(color2));
		hbox2.setAlignment(Pos.CENTER_LEFT);
		hbox2.setMinSize(700, 40);
		Label labDec = new Label("2. Перевод в десятичную");

		String col2 = getRandColor();
		while (Color.web(col2).equals(color2.getFill())) {
			col2 = getRandColor();
		}

		labDec.setStyle(" -fx-text-fill: " + col2);
		labDec.setMinWidth(MINLABLEWIDTH);
		hbox2.getChildren().add(labDec);

		Button bDec2Bin = new Button("Перевести");
		bDec2Bin.setOnAction(new MyEvent<ActionEvent>(1));

		hbox2.getChildren().add(tDecBin);
		hbox2.getChildren().add(bDec2Bin);
		hbox2.getChildren().add(tDecDec);
		// ------------HBOX3------------------------------------------------------------------
		HBox hbox3 = new HBox(HBOXSPACING / 10);
		hbox3.setPadding(new Insets(1, 15, 1, 15));
		hbox3.setStyle(hbox1.getStyle());
		tDecBin.setStyle("-fx-text-fill: " + getRandColor());

		String hbox3bkCol = getRandColor();
		BackgroundFill color3 = new BackgroundFill(Color.web(hbox3bkCol),
				CornerRadii.EMPTY, Insets.EMPTY);
		hbox3.setBackground(new Background(color3));

		hbox3.setAlignment(Pos.CENTER_LEFT);
		hbox3.setMinSize(700, 80);

		Label labCheck3 = new Label("3. Соответствие полей одному числу");
		String col3 = getRandColor();
		while (Color.web(col3).equals(color3.getFill())) {
			col3 = getRandColor();
		}

		labCheck3.setStyle(" -fx-text-fill: " + col3);
		labCheck3.setMinWidth(MINLABLEWIDTH);
		labCheck3.setWrapText(true);
		hbox3.getChildren().add(labCheck3);

		for (int i = 0; i < CHECKBOXNUM; i++) {
			chb[i] = new CheckBox("поле" + (CHECKBOXNUM - i - 1));
			chb[i].setStyle("-fx-font-weight: bold; -fx-font-size: 14pt; -fx-text-fill: #D3D3D3");
			chb[i].setMinWidth(100);
			chb[i].setMaxWidth(100);
			chb[i].setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					if (event.getSource() instanceof CheckBox) {
						CheckBox chk = (CheckBox) event.getSource();
						if (chk.isSelected()) {
							chk.setStyle("-fx-font-weight: bold; -fx-font-size: 14pt; -fx-text-fill: blue");
						}
						else {
							chk.setStyle("-fx-font-weight: bold; -fx-font-size: 14pt; -fx-text-fill: #D3D3D3");
						}
					}
				}

			});
			chb[i].setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					String s1 = tDecDec.getText().trim();
					try {
						int val = Integer.parseInt(s1);
						for (int j = 0; j < chb.length; j++) {
							int cond = val & (int) Math.pow(2, j);
							if (cond == 0) {
								chb[chb.length - 1 - j].setSelected(false);
								chb[chb.length - 1 - j]
										.setStyle("-fx-font-weight: bold; -fx-font-size: 14pt; -fx-text-fill: #D3D3D3");
							}
							else {
								chb[chb.length - 1 - j].setSelected(true);
								chb[chb.length - 1 - j]
										.setStyle("-fx-font-weight: bold; -fx-font-size: 14pt; -fx-text-fill: blue");
							}
						}

					}
					catch (Exception e) {

					}
				}
			});

			hbox3.getChildren().add(chb[i]);
		}
		HBox hbox4 = new HBox(HBOXSPACING);
		hbox4.setAlignment(Pos.CENTER_RIGHT);

		hbox4.setMinSize(700, 40);
		hbox4.setPadding(new Insets(1, 0, 1, 0));
		hbox4.setStyle(hbox1.getStyle());

		hbox4.setBackground(grid.getBackground());

		Button bExit = new Button("Exit");
		bExit.setMinWidth(200);
		bExit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}

		});
		hbox4.getChildren().add(bExit);

		bExit.setAlignment(Pos.CENTER);
		grid.add(hbox1, 0, 0);
		grid.add(hbox2, 0, 1);
		grid.add(hbox3, 0, 2);
		grid.add(hbox4, 0, 6);
		return new Scene(grid, 1300, 500);
		// Group g = new Group();
		// for (int i = 0; i < 5; i++) {
		// Rectangle r = new Rectangle();
		// r.setY(i * 20);
		// r.setWidth(300);
		// r.setHeight(10);
		// r.setFill(Color.RED);
		// g.getChildren().add(r);
		// }
		//
		// hbox1.setLayoutX(111);
		// hbox1.setLayoutY(222);
		// bExit.setLayoutX(250);
		// bExit.setLayoutY(120);
		// g.getChildren().addAll(hbox1, bExit);
		// return new Scene(g);

	}

	class MyEvent<T> implements EventHandler {
		// 0 - Bin2Dec, 1 - Dec2Bin;
		private int	mode;

		@Override
		public void handle(Event event) {
			if (mode == 0) { // dec2Bin
				try {
					Integer.parseInt(tBinDec.getText());
				}
				catch (Exception e) {
					(new Alert(AlertType.WARNING, "Невалідне ціле значення: "
							+ tBinDec.getText(), ButtonType.CLOSE)).show();
					return;
				}

				tBinBin.setText(dec2Bin(tBinDec.getText()));
			}
			else if (mode == 1) { // bin2Dec
				String s1 = tDecBin.getText().trim();
				try {
					Long.parseLong(s1);
					for (int i = 0; i < s1.length(); i++) {
						if (s1.charAt(i) != '0' && s1.charAt(i) != '1') throw new Exception();
					}

				}
				catch (Exception e) {
					(new Alert(AlertType.WARNING,
							"Невалідне двійкове значення: " + s1,
							ButtonType.CLOSE)).show();
					return;
				}

				tDecDec.setText(bin2Dec(s1));
			}
			else {

				Alert dlg = new Alert(AlertType.WARNING,
						"Невідомий режим роботи", ButtonType.CLOSE,
						ButtonType.OK);
				dlg.setTitle("Невідомий режим роботи");
				dlg.setOnShowing(evt -> System.out.println(evt));
				// dlg.getDialogPane().setContentText(
				// "I'm glad I didn't need to use this...");
				dlg.show();
			}
		}

		public MyEvent(int mode) {
			this.mode = mode;
			// System.out.prin22tln("constructor " + mode);
		}

	}

	public static String bin2Dec(String binVal) {
		if (binVal.length() == 0) return "";

		binVal = binVal.trim();
		int ext = binVal.length() - 1;
		long res = 0;

		for (int j = 0; j < binVal.length(); j++) {
			if (binVal.charAt(j) == '1') res += Math.pow(2, ext - j);
		}

		return Long.toString(res);
	}

	public static String dec2Bin(String decVal) {

		if (decVal.length() == 0) return "";
		int val = Integer.parseInt(decVal);
		if (val == 0) return "0";
		if (val == 1) return "1";

		String s = "";
		int quotient = val / 2;
		// System.out.println();
		s += val % 2;
		while (quotient >= 2) {
			s += quotient % 2;
			quotient = quotient / 2;
		}
		s += quotient;

		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			s1 += Character.toString(s.charAt(i));
		}
		return s1;

	}
}
