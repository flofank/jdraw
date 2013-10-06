package jdraw.ff;

import java.util.ArrayList;
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
    private List<Figure> figures = new ArrayList<Figure>();
    private List<DrawModelListener> listeners = new ArrayList<DrawModelListener>();
    /** The draw command handler. Initialized here with a dummy implementation. */
    // TODO initialize with your implementation from the undo/redo-assignment.
    private DrawCommandHandler handler = new EmptyDrawCommandHandler();

    /**
     * Retrieve the draw command handler in use.
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
        }
        notifyListeners(f, DrawModelEvent.Type.FIGURE_ADDED);
    }

    @Override
    public void removeFigure(Figure f) {
        if (f != null) {
            figures.remove(f);        
            f.removeFigureListener(this);
        }
        notifyListeners(f, DrawModelEvent.Type.FIGURE_REMOVED);
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
        if (listener != null) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeModelChangeListener(DrawModelListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    @Override
    public void setFigureIndex(Figure f, int index) throws IllegalArgumentException, IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void figureChanged(FigureEvent e) {
        // TODO Auto-generated method stub
        
    }

    private void notifyListeners(Figure f, DrawModelEvent.Type t) {
        for (DrawModelListener lis : listeners) {
            lis.modelChanged(new DrawModelEvent(this, f, t));
        }
    }
    
}
