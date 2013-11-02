package jdraw.figures;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

public abstract class AbstractRectangularFigure extends AbstractFigure {
	protected Rectangle bounds;
	
	
	public AbstractRectangularFigure(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	@Override
	public abstract void draw(Graphics g);

	@Override
	public void move(int dx, int dy) {
		if (dx != 0 || dy != 0) {
			bounds.translate(dx, dy);
			notifyListeners();
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return bounds.contains(x, y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		bounds = new Rectangle(origin, new Dimension(corner.x - origin.x, corner.y - origin.y));
		notifyListeners();
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
