package jdraw.figures;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.handles.CenterFigureHandle;
import jdraw.handles.NorthEastFigureHandle;
import jdraw.handles.NorthWestFigureHandle;
import jdraw.handles.SouthEastFigureHandle;
import jdraw.handles.SouthWestFigureHandle;


public class Group extends AbstractFigure {
	private List<Figure> figures;
	private Rectangle bounds;
	
	public Group(List<Figure> figures) {
		this.figures = figures;
		bounds = new Rectangle(figures.get(0).getBounds().x,figures.get(0).getBounds().y,0,0);
		for (Figure f : figures) {
			bounds.add(f.getBounds());
		}
		
		handles.add(new CenterFigureHandle(this));
	}
	
	@Override
	public void draw(Graphics g) {
		for (Figure f : figures) {
			f.draw(g);
		}
	}

	@Override
	public void move(int dx, int dy) {
		if (dx != 0 || dy != 0) {
			for (Figure f : figures) {
				f.move(dx, dy);
			}
			bounds.translate(dx, dy);
			notifyListeners();
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return bounds.contains(x,y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}
	
	public List<Figure> getFigures() {
		return figures;
	}
}
