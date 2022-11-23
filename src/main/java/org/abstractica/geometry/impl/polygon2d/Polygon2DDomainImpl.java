package org.abstractica.geometry.impl.polygon2d;

import org.abstractica.geometry.impl.transform2D.Transform2DDomainImpl;
import org.abstractica.geometry.intf.polygon2D.Polygon2DDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polygon2DDomainImpl extends Transform2DDomainImpl implements Polygon2DDomain
{

	@Override
	public Polygon2D polygon2D(List<Vector2D> vertices)
	{
		List<Vector2D> verticesCopy = new ArrayList<>(vertices);
		List<Path> paths = new ArrayList<>(1);
		PathBuilder pathBuilder = newPathBuilder();
		for(int i = 0; i < vertices.size(); i++)
		{
			pathBuilder.add(i);
		}
		paths.add(pathBuilder.build());
		return new Polygon2DImpl(Collections.unmodifiableList(verticesCopy),
									Collections.unmodifiableList(paths));
	}

	@Override
	public Polygon2D polygon2D(List<Vector2D> vertices, List<Path> paths)
	{
		List<Vector2D> verticesCopy = new ArrayList<>(vertices);
		List<Path> pathsCopy = new ArrayList<>(paths);
		return new Polygon2DImpl(Collections.unmodifiableList(verticesCopy),
									Collections.unmodifiableList(pathsCopy));
	}

	private static class Polygon2DImpl implements Polygon2D
	{
		private final List<Vector2D> vertices;
		private final List<Path> paths;

		private Polygon2DImpl(List<Vector2D> vertices, List<Path> paths)
		{
			this.vertices = vertices;
			this.paths = paths;
		}

		@Override
		public List<Vector2D> vertices()
		{
			return vertices;
		}

		@Override
		public List<Path> paths()
		{
			return paths;
		}
	}
}
