package jdraw.figures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.FigureHandle;
import jdraw.handles.CenterFigureHandle;
import jdraw.handles.NorthEastFigureHandle;
import jdraw.handles.NorthWestFigureHandle;
import jdraw.handles.SouthEastFigureHandle;
import jdraw.handles.SouthWestFigureHandle;

public class LineFigure extends AbstractRectangularFigure {

	public LineFigure(Rectangle bounds) {
		super(bounds);
		handles.add(new CenterFigureHandle(this));
		handles.add(new NorthWestFigureHandle(this));
		handles.add(new SouthEastFigureHandle(this));
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(bounds.x, bounds.y, bounds.x + bounds.width, bounds.y + bounds.height);
	}

	@Override
	public boolean contains(int x, int y) {
		return bounds.contains(x, y) && false; //TODO: fix
	}
}
