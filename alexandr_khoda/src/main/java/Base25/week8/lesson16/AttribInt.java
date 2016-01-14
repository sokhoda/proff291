package Base25.week8.lesson16;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public interface AttribInt {

	public default void setRandBkColor(Region obj) {
		String hbox3bkCol = getRandColor();
		BackgroundFill color3 = new BackgroundFill(Color.web(hbox3bkCol),
				CornerRadii.EMPTY, Insets.EMPTY);
		obj.setBackground(new Background(color3));
	}

	public default String getRandColor() {
		int i = (int) (Math.random() * 14 + 1);
		switch (i) {
		case 1:
			return "#00FFFF";
		case 2:
			return "#FF0000";
		case 3:
			return "#e16941";
		case 4:
			return "#00FF00";
		case 5:
			return "#0000FF";
		case 6:
			return "#00d7FF";
		case 7:
			return "#507fff";
		case 8:
			return "#60A4F4";
		case 9:
			return "#9933FF";
		case 10:
			return "#FF00FF";
		case 11:
			return "#E3E3E3";
		case 12:
			return "#ADFF2F";
		case 13:
			return "#7FFFD4";
		case 14:
			return "#00174D";
		case 15:
			return "#014714";
		default:
			return "#DEB887";
		}
	}
}
