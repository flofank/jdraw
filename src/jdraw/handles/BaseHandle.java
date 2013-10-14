package jdraw.handles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

public abstract class BaseHandle implements FigureHandle {
	public static final int HANDLESIZE = 6;
	protected Figure owner;
	protected Rectangle rectangle; 
	protected Cursor cursor;
	
	public BaseHandle(Figure owner, Point location, Cursor cursor) {
		this.owner = owner;
		this.rectangle = new Rectangle(new Point(location.x - HANDLESIZE / 2, location.y - HANDLESIZE / 2), new Dimension(HANDLESIZE, HANDLESIZE));
		this.cursor = cursor;
	}
	
	@Override
	public Figure getOwner() {
		return owner;
	}

	@Override
	public Point getLocation() {
		return rectangle.getLocation();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		g.setColor(Color.BLACK);
		g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

	@Override
	public Cursor getCursor() {
		return cursor;
	}

	@Override
	public boolean contains(int x, int y) {
		return rectangle.contains(x, y);
	}

	@Override
	public abstract void startInteraction(int x, int y, MouseEvent e, DrawView v);

	@Override
	public abstract void dragInteraction(int x, int y, MouseEvent e, DrawView v);

	@Override
	public abstract void stopInteraction(int x, int y, MouseEvent e, DrawView v);

}
