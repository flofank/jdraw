package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

public class WestFigureHandle extends AbstractFigureHandle {

	public WestFigureHandle(Figure owner) {
		super(owner);
	}

	@Override
	public Point getLocation() {
		return new Point((int) owner.getBounds().getMinX(), (int) owner.getBounds().getCenterY());
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		owner.setBounds(new Point(x,r.y), new Point(r.x + r.width, r.y + r.height));		
	}
}
