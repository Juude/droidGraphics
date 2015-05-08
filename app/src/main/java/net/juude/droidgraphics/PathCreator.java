package net.juude.droidgraphics;

import android.graphics.Path;

/**
 * Created by juude on 15-4-1.
 */
public class PathCreator {
    private static PathCreator sInstance;

    private PathCreator() {

    }

    public static PathCreator getInstance() {
        synchronized (PathCreator.class) {
            if(sInstance == null) {
                sInstance = new PathCreator();
            }
            return sInstance;
        }
    }

    public Path createRoundPath(float x , float y, float radius) {
        Path path = new Path();
        path.moveTo(x, y);
        path.addCircle(radius, radius, radius, Path.Direction.CCW);
        return path;
    }
}
