package main;

import java.awt.Color;
import javax.swing.Icon;

public class Chart_Item {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Chart_Item(String name, double values, Color color, Icon icon) {
        this.name = name;
        this.values = values;
        this.color = color;
        this.icon = icon;
    }

    public Chart_Item() {
    }

    private String name;
    private double values;
    private Color color;
    private Icon icon;
}
