package jdraw.drawtools;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.figures.Oval;
import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public class OvalTool extends AbstractDragDrawTool {

	public OvalTool(DrawContext context) {
		super(context, "Oval");
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(IMAGES + "oval.png"));
	}

	@Override
	protected Figure createFigure(Point p) {
		return new Oval(new Rectangle(p, new Dimension(0, 0)));
	}
	

}
