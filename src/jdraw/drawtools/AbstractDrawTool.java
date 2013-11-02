package jdraw.drawtools;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.Icon;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

public abstract class AbstractDrawTool implements DrawTool {
	protected static final String IMAGES = "/images/";
	protected DrawContext context;
	protected DrawView view;
	protected String name;
	
	public AbstractDrawTool(DrawContext context, String name) {
		this.context = context;
		this.name = name;
		view = context.getView();
	}

	@Override
	public void activate() {
		context.showStatusText(name + " Mode");
	}

	@Override
	public void deactivate() {
		context.showStatusText("");
	}

	@Override
	public abstract void mouseDown(int x, int y, MouseEvent e);

	@Override
	public abstract void mouseDrag(int x, int y, MouseEvent e);

	@Override
	public abstract void mouseUp(int x, int y, MouseEvent e);

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
	}

	@Override
	public abstract Icon getIcon();

	@Override
	public String getName() {
		return name;
	}

}
