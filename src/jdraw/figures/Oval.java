package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.FigureHandle;
import jdraw.handles.EastFigureHandle;
import jdraw.handles.NorthFigureHandle;
import jdraw.handles.SouthFigureHandle;
import jdraw.handles.WestFigureHandle;

public class Oval extends AbstractRectangularFigure {

	public Oval(Rectangle bounds) {
		super(bounds);
		//EDGE HANDLES
		handles.add(new NorthFigureHandle(this));
		handles.add(new EastFigureHandle(this));
		handles.add(new SouthFigureHandle(this));
		handles.add(new WestFigureHandle(this));
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(Color.BLACK);
		g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
