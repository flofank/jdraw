package jdraw.ff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdraw.framework.DrawCommandHandler;
import jdraw.framework.DrawModel;
import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelListener;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;
import jdraw.std.EmptyDrawCommandHandler;

public class FFDrawModel implements DrawModel, FigureListener {
	private List<Figure> figures = new LinkedList<Figure>();
	private List<DrawModelListener> listeners = new LinkedList<DrawModelListener>();
	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation from the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * 
	 * @return the draw command handler.
	 */
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void addFigure(Figure f) {
		if (f != null) {
			figures.add(f);
			f.addFigureListener(this);
			notifyListeners(f, DrawModelEvent.Type.FIGURE_ADDED);
		}
	}

	@Override
	public void removeFigure(Figure f) {
		if (f != null) {
			figures.remove(f);
			f.removeFigureListener(this);
			notifyListeners(f, DrawModelEvent.Type.FIGURE_REMOVED);
		}
	}

	@Override
	public void removeAllFigures() {
		figures.clear();
		// TODO: notify notifyListeners(, DrawModelEvent.Type.FIGURE_REMOVED);
	}

	@Override
	public Iterable<Figure> getFigures() {
		return figures;
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		if (listener != null && !listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		if (listener != null) {
			listeners.remove(listener);
		}
	}

	private void notifyListeners(Figure f, DrawModelEvent.Type t) {
		for (DrawModelListener lis : listeners) {
			lis.modelChanged(new DrawModelEvent(this, f, t));
		}
	}

	@Override
	public void setFigureIndex(Figure f, int index)
			throws IllegalArgumentException, IndexOutOfBoundsException {
		int pos = figures.indexOf(f);
		if (pos < 0) {
			throw new IllegalArgumentException(
					"Figure f not contained in model");
		}
		if (pos != index) {
			figures.remove(f);
			figures.add(index, f);
			notifyListeners(f, DrawModelEvent.Type.DRAWING_CHANGED);
		}
	}

	@Override
	public void figureChanged(FigureEvent e) {
		notifyListeners(e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED);
	}

}
