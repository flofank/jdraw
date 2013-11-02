package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

public class EastFigureHandle extends AbstractFigureHandle {

	public EastFigureHandle(Figure owner) {
		super(owner);
	}

	@Override
	public Point getLocation() {
		return new Point((int) owner.getBounds().getMaxX(), (int) owner.getBounds().getCenterY());
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		owner.setBounds(new Point(r.x,r.y), new Point(x, r.y + r.height));		
	}
}
