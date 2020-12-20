package util;
import api.geo_location;
import gameClient.util.Point3D;
import gameClient.util.Range;

/**
 * This class represents a 2D Range, composed from two 1D Ranges.
 */
public class Range2D {
	private gameClient.util.Range _y_range;
	private gameClient.util.Range _x_range;
	
	public Range2D(gameClient.util.Range x, gameClient.util.Range y) {
		_x_range = new gameClient.util.Range(x);
		_y_range = new gameClient.util.Range(y);
	}
	public Range2D(Range2D w) {
		_x_range = new gameClient.util.Range(w._x_range);
		_y_range = new Range(w._y_range);
	} 
	public gameClient.util.Point3D getPortion(geo_location p) {
		double x = _x_range.getPortion(p.x());
		double y = _y_range.getPortion(p.y());
		return new gameClient.util.Point3D(x,y,0);
	}
	public gameClient.util.Point3D fromPortion(geo_location p) {
		double x = _x_range.fromPortion(p.x());
		double y = _y_range.fromPortion(p.y());
		return new Point3D(x,y,0);
	}	
}
