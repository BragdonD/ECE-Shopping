package com.eceshopping.views.components;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/*
 * LoadingCircle class is a utility class for creating a loading circle.
 * This class is used in the LoginView class.
 */
public class LoadingCircle extends Pane {
    public static final double DEFAULT_DIAMETER = 40;

    private final Arc backgroundArc; 
    private final Arc spinnerArc;
    private final RotateTransition rotateTransition; 
    
    private double diameter;
    private double strokeWidth;
    private double radius;

    public LoadingCircle(double diameter) {
        this.diameter = diameter;
        this.strokeWidth = diameter / 10;
        this.radius = diameter / 2 - strokeWidth / 2;

        backgroundArc = new Arc();
        spinnerArc = new Arc();

        // Set up the background arc
        backgroundArc.setCenterX(radius + strokeWidth / 2);
        backgroundArc.setCenterY(radius + strokeWidth / 2);
        backgroundArc.setRadiusX(radius);
        backgroundArc.setRadiusY(radius);
        backgroundArc.setStartAngle(90);
        backgroundArc.setLength(360);
        backgroundArc.setType(ArcType.OPEN);
        backgroundArc.setFill(null);
        backgroundArc.setStroke(Color.rgb(255, 255, 255, 0.2));
        backgroundArc.setStrokeWidth(strokeWidth);
        getChildren().add(backgroundArc);

        // Set up the spinner arc
        spinnerArc.setCenterX(radius + strokeWidth / 2);
        spinnerArc.setCenterY(radius + strokeWidth / 2);
        spinnerArc.setRadiusX(radius);
        spinnerArc.setRadiusY(radius);
        spinnerArc.setStartAngle(0);
        spinnerArc.setLength(270);
        spinnerArc.setType(ArcType.OPEN);
        spinnerArc.setFill(null);
        spinnerArc.setStroke(Color.WHITE);
        spinnerArc.setStrokeWidth(strokeWidth);
        getChildren().add(spinnerArc);

        rotateTransition = new RotateTransition(Duration.seconds(1), spinnerArc);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Z_AXIS);

        setPrefSize(diameter, diameter);
        setMaxSize(diameter, diameter);
        setMinSize(diameter, diameter);

        layout();
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        this.strokeWidth = diameter / 10;
        this.radius = diameter / 2 - strokeWidth / 2;

        backgroundArc.setCenterX(radius + strokeWidth / 2);
        backgroundArc.setCenterY(radius + strokeWidth / 2);
        backgroundArc.setRadiusX(radius);
        backgroundArc.setRadiusY(radius);
        backgroundArc.setStrokeWidth(strokeWidth);

        spinnerArc.setCenterX(radius + strokeWidth / 2);
        spinnerArc.setCenterY(radius + strokeWidth / 2);
        spinnerArc.setRadiusX(radius);
        spinnerArc.setRadiusY(radius);
        spinnerArc.setStrokeWidth(strokeWidth);
    }

    public void start() {
        this.rotateTransition.play();
    }

    public void stop() {
        this.rotateTransition.stop();
    }

    public double getDiameter() {
        return this.diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        this.requestLayout();
    }

    public Arc getArc() {
        return this.spinnerArc;
    }
}