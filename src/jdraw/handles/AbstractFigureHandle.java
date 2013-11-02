package jdraw.handles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

public abstract class AbstractFigureHandle implements FigureHandle {
	public static final int HANDLESIZE = 6;
	protected Figure owner;
	protected Point anchor;
	
	public AbstractFigureHandle(Figure owner) {
		this.owner = owner;
	}
	
	@Override
	public Figure getOwner() {
		return owner;
	}
	
	@Override
	public abstract Point getLocation();
	
	@Override
	public void draw(Graphics g) {
		Point p = getLocation();
		g.setColor(Color.WHITE);
		g.fillRect(p.x - HANDLESIZE / 2, p.y  - HANDLESIZE / 2, HANDLESIZE, HANDLESIZE);
		g.setColor(Color.BLACK);
		g.drawRect(p.x - HANDLESIZE / 2, p.y - HANDLESIZE / 2, HANDLESIZE, HANDLESIZE);
	}
	
	@Override
	public abstract Cursor getCursor();
	
	@Override
	public boolean contains(int x, int y) {
		Point p = getLocation();
		return new Rectangle(p.x - HANDLESIZE / 2, p.y - HANDLESIZE / 2, HANDLESIZE, HANDLESIZE).contains(x, y);
	}
	
	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		anchor = new Point(x,y);		
	}
	
	@Override
	public abstract void dragInteraction(int x, int y, MouseEvent e, DrawView v);
	
	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		anchor = null;
	}

}
