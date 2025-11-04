package game15;

import java.awt.*;
import java.awt.Color;

public class Settings {
    private Color tileColor;
    private Color emptyColor;
    private Color textColor;
    private Color backgroundColor;


    public Settings() {
        tileColor = new Color(153,102,0);
        emptyColor = new Color(153,153,153);
        textColor = new Color(255,204,51);
        backgroundColor = new Color(153,153,153);
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
}
