package jdraw.drawtools;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.figures.LineFigure;
import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public class LineTool extends AbstractDragDrawTool {

	public LineTool(DrawContext context) {
		super(context, "Line");
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(IMAGES + "line.png"));
	}

	@Override
	protected Figure createFigure(Point p) {
		return new LineFigure(new Rectangle(p, new Dimension(0,0)));
	}
	
}
