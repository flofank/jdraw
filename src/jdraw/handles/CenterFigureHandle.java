package jdraw.handles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

public class CenterFigureHandle extends AbstractFigureHandle {
	private int origDiffX, origDiffY, cornDiffX, cornDiffY;

	public CenterFigureHandle(Figure owner) {
		super(owner);
	}

	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle ownerBounds = owner.getBounds();
		origDiffX = x - ownerBounds.getLocation().x;
		origDiffY = y - ownerBounds.getLocation().y;
		cornDiffX = x - (ownerBounds.getLocation().x + ownerBounds.width);
		cornDiffY = y - (ownerBounds.getLocation().y + ownerBounds.height);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		owner.setBounds(new Point(x - origDiffX, y - origDiffY), new Point(x - cornDiffX, y - cornDiffY));
	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
	}

	@Override
	public Point getLocation() {
		return new Point((int) owner.getBounds().getCenterX(), (int) owner.getBounds().getCenterY());
	}
	
	@Override 
	public void draw(Graphics g) {
		Point p = getLocation();
		g.setColor(Color.BLACK);
		g.drawLine(p.x -2, p.y, p.x + 2, p.y);
		g.drawLine(p.x, p.y - 2, p.x, p.y + 2);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
	}
}
