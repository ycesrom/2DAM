package com.example.labeledtextfield;

import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.awt.*;

public class ExtendedControl extends TextField {
    private static final StyleablePropertyFactory<ExtendedControl> FACTORY = new StyleablePropertyFactory<>(TextField.getClassCssMetaData());
    private static final Color DEFAULT_MATERIAL_DESIGN_COLOR = Color.web("#009688");
    private static final Color DEFAULT_PROMPT_TEXT_COLOR = Color.web("#757575");
    private static final double STD_FONT_SIZE = 13;
    private static final double SMALL_FONT_SIZE = 10;
    private static final double TOP_OFFSET_Y = 4;
    private static final int ANIMATION_DURATION = 60;
    private static final CssMetaData<ExtendedControl, Color> MATERIAL_DESIGN_COLOR = FACTORY.createColorCssMetaData("-material-design-color", s -> s.materialDesignColor, DEFAULT_MATERIAL_DESIGN_COLOR, false);
    private static final CssMetaData<ExtendedControl, Color> PROMPT_TEXT_COLOR = FACTORY.createColorCssMetaData("-prompt-text-color", s -> s.promptTextColor, DEFAULT_PROMPT_TEXT_COLOR, false);
    private static String userAgentStyleSheet;
    private final StyleableProperty<Color> materialDesignColor;
    private final StyleableProperty<Color> promptTextColor;
    private Text promptText;
    private HBox promptTextBox;
    private DoubleProperty fontSize;
    private Timeline timeline;

    // ******************** Constructors **************************************
    public ExtendedControl() {
        this("");
    }

    public ExtendedControl(final String promptTextBox) {
        super(promptTextBox);

        materialDesignColor = new SimpleStyleableObjectProperty<>(MATERIAL_DESIGN_COLOR, this, "materialDesignColor");
        promptTextColor = new SimpleStyleableObjectProperty<>(PROMPT_TEXT_COLOR, this, "promptTextColor");

        fontSize = new SimpleDoubleProperty(ExtendedControl.this, "fontSize", getFont().getSize());
        timeline = new Timeline();

        initGraphics();
        registerListeners();
    }
}
