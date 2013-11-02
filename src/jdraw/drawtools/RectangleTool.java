/*
 * Copyright (c) 2000-2013 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.drawtools;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.figures.RectangleFigure;
import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public class RectangleTool extends AbstractDragDrawTool {

	public RectangleTool(DrawContext context) {
		super(context, "Rectangle");
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(IMAGES + "rectangle.png"));
	}

	@Override
	protected Figure createFigure(Point p) {
		return new RectangleFigure(p.x, p.y, 0, 0);
	}

}
