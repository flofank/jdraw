package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

public class SouthEastFigureHandle extends AbstractFigureHandle {

	public SouthEastFigureHandle(Figure owner) {
		super(owner);
	}

	@Override
	public Point getLocation() {
		return new Point(owner.getBounds().getLocation().x + owner.getBounds().width, owner.getBounds().getLocation().y + owner.getBounds().height);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		owner.setBounds(new Point(r.x,r.y), new Point(x, y));		
	}
}
