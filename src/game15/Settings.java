package game15;

import java.awt.*;
import java.awt.Color;

public class Settings {
    private Color tileColor;
    private Color emptyColor;
    private Color textColor;
    private Color backgroundColor;


    public Settings() { // Default Theme
        tileColor = new Color(153,102,0);
        emptyColor = new Color(153,153,153);
        textColor = new Color(255,204,51);
        backgroundColor = new Color(102,51,0);
    }

    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    public Color getEmptyColor() {
        return emptyColor;
    }

    public void setEmptyColor(Color emptyColor) {
        this.emptyColor = emptyColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setDarkTheme() {
        tileColor = new Color(60, 63, 65);
        emptyColor = new Color(25, 25, 25);
        textColor = new Color(220, 220, 220);
        backgroundColor = new Color(30, 30, 30);
    }

    public void setLightTheme() {
        tileColor = new Color(255, 255, 204);
        emptyColor = new Color(255, 255, 153);
        textColor = new Color(255, 204, 51);
        backgroundColor = new Color (255, 204, 0);
    }

    public void setColorfulTheme() {
        tileColor = new Color(51, 153, 255);
        emptyColor = new Color(51, 204, 255);
        textColor = new Color(255, 0, 0);
        backgroundColor = new Color (153, 0, 0);
    }
}
