package com.eceshopping.views.components;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class CheckIcon extends Group {
    public CheckIcon(double size) {
        double strokeWidth = size / 10;
        double padding = strokeWidth / 2;

        Line check = new Line(padding, size / 2, size / 2, size - padding);
        check.setStroke(Color.GREEN);
        check.setStrokeWidth(strokeWidth);
        check.setStrokeLineCap(StrokeLineCap.ROUND);
        check.setStrokeLineJoin(StrokeLineJoin.ROUND);

        Line box = new Line(size / 2, size - padding, size - padding, padding);
        box.setStroke(Color.GREEN);
        box.setStrokeWidth(strokeWidth);
        box.setStrokeLineCap(StrokeLineCap.ROUND);
        box.setStrokeLineJoin(StrokeLineJoin.ROUND);

        this.getChildren().addAll(check, box);
    }
}
