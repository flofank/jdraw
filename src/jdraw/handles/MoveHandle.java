package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

public class MoveHandle extends BaseHandle {
	private int origDiffX, origDiffY, cornDiffX, cornDiffY;

	public MoveHandle(Figure owner, Point location) {
		super(owner, location, new Cursor(Cursor.MOVE_CURSOR));
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
}
