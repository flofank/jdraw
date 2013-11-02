package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

public class NorthFigureHandle extends AbstractFigureHandle {

	public NorthFigureHandle(Figure owner) {
		super(owner);
	}

	@Override
	public Point getLocation() {
		return new Point((int) owner.getBounds().getCenterX(), (int) owner.getBounds().getMinY());
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		owner.setBounds(new Point(r.x,y), new Point(r.x + r.width, r.y + r.height));		
	}
}
