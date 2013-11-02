package jdraw.drawtools;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.Icon;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public abstract class AbstractDragDrawTool extends AbstractDrawTool{
	protected Figure f;
	protected Point anchor;
	
	
	public AbstractDragDrawTool(DrawContext context, String name) {
		super(context, name);
	}

	@Override
	public void mouseDown(int x, int y, MouseEvent e) {
		if (f != null) {
			throw new IllegalStateException();
		}
		anchor = new Point(x,y);
		f = createFigure(anchor);
		view.getModel().addFigure(f);
	}

	@Override
	public void mouseDrag(int x, int y, MouseEvent e) {
		f.setBounds(anchor, new Point(x,y));
		Rectangle r = f.getBounds();
		context.showStatusText("w: " + r.width + ", h: " + r.height);
	}

	@Override
	public void mouseUp(int x, int y, MouseEvent e) {
		f.setBounds(anchor, new Point(x,y));
		f = null;
		anchor = null;
		context.showStatusText(name + " Mode");
	}

	@Override
	public abstract Icon getIcon();
	
	protected abstract Figure createFigure(Point p);

}
