/*
 * Copyright (c) 2000-2013 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;
import jdraw.handles.CenterFigureHandle;
import jdraw.handles.EastFigureHandle;
import jdraw.handles.NorthEastFigureHandle;
import jdraw.handles.NorthFigureHandle;
import jdraw.handles.NorthWestFigureHandle;
import jdraw.handles.SouthEastFigureHandle;
import jdraw.handles.SouthFigureHandle;
import jdraw.handles.SouthWestFigureHandle;
import jdraw.handles.WestFigureHandle;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 * 
 */
public class RectangleFigure extends AbstractRectangularFigure {
	/**
	 * Create a new rectangle of the given dimension.
	 * 
	 * @param x
	 *            the x-coordinate of the upper left corner of the rectangle
	 * @param y
	 *            the y-coordinate of the upper left corner of the rectangle
	 * @param w
	 *            the rectangle�s width
	 * @param h
	 *            the rectangle�s height
	 */
	public RectangleFigure(int x, int y, int w, int h) {
		super(new Rectangle(x, y, w, h));
		//CENTER HANDLE
		handles.add(new CenterFigureHandle(this));
		//CORNER HANDLES
		handles.add(new NorthWestFigureHandle(this));
		handles.add(new NorthEastFigureHandle(this));
		handles.add(new SouthEastFigureHandle(this));
		handles.add(new SouthWestFigureHandle(this));
		//EDGE HANDLES
		handles.add(new NorthFigureHandle(this));
		handles.add(new EastFigureHandle(this));
		handles.add(new SouthFigureHandle(this));
		handles.add(new WestFigureHandle(this));
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * 
	 * @param g
	 *            the graphics context to use for drawing.
	 */
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(Color.BLACK);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
