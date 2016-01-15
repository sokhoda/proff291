package Base25.week8.lesson16;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GroupExample extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group g = new Group();
		for (int i = 0; i < 5; i++) {
			Rectangle r = new Rectangle();
			r.setY(i * 20);
			r.setWidth(100);
			r.setHeight(10);
			r.setFill(Color.RED);
			g.getChildren().add(r);
		}

		stage.setScene(new Scene(g));
		stage.show();

	}
}
