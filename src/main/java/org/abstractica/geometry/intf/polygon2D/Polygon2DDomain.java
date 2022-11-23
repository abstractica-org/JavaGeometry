package org.abstractica.geometry.intf.polygon2D;

import org.abstractica.geometry.intf.path.PathDomain.Path;
import org.abstractica.geometry.intf.vector2d.Vector2DDomain.Vector2D;

import java.util.List;

public interface Polygon2DDomain
{
	interface Polygon2D
	{
		List<Vector2D> vertices();
		List<Path> paths();
	}

	Polygon2D polygon2D(List<Vector2D> vertices);
	Polygon2D polygon2D(List<Vector2D> vertices, List<Path> paths);
}
