package jdraw.ff;

import java.awt.Point;

import jdraw.framework.PointConstrainer;

public class GridConstrainer implements PointConstrainer {
	private int step;
	
	public GridConstrainer(int step) {
		this.step = Math.max(1, step);
	}
	
	@Override
	public Point constrainPoint(Point p) {
		return new Point((p.x / step) * step, (p.y / step) * step);
	}

	@Override
	public int getStepX(boolean right) {
		return step;
	}

	@Override
	public int getStepY(boolean down) {
		return step;
	}

	@Override
	public void activate() {
	}

	@Override
	public void deactivate() {
	}

	@Override
	public void mouseDown() {
	}

	@Override
	public void mouseUp() {
	}
}
