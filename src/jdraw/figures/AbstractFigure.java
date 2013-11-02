package jdraw.figures;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

public abstract class AbstractFigure implements Figure {
	private ArrayList<FigureListener> listeners = new ArrayList<FigureListener>();
	protected ArrayList<FigureHandle> handles = new ArrayList<FigureHandle>();
	
	@Override
	public abstract void draw(Graphics g);

	@Override
	public abstract void move(int dx, int dy);

	@Override
	public abstract boolean contains(int x, int y);
	
	@Override
	public abstract void setBounds(Point origin, Point corner);

	@Override
	public abstract Rectangle getBounds();

	@Override
	public List<FigureHandle> getHandles() {
		return handles;
	}

	@Override
	public void addFigureListener(FigureListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		listeners.remove(listener);
	}
	
	protected void notifyListeners() {
		for (FigureListener lis : listeners) {
			lis.figureChanged(new FigureEvent(this));
		}
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
