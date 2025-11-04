package game15;

import java.awt.Color;

public class Settings {
    private Color tileColor;
    private Color emptyColor;
    private Color textColor;

    public Color getTileColor() {
        return tileColor;
    }

    public Color getEmptyColor() {
        return emptyColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setDarkTheme() {
        tileColor = new Color(60, 63, 65);
        emptyColor = new Color(25, 25, 25);
        textColor = new Color(220, 220, 220);
    }

    public void setLightTheme() {
        tileColor = new Color(119, 183, 246);
        emptyColor = new Color(243, 239, 239);
        textColor = new Color(255, 255, 255);
    }

    public void setColorfulTheme() {
        tileColor = new Color(255, 102, 178);
        emptyColor = new Color(102, 204, 255);
        textColor = new Color(0, 51, 102);
    }
}
