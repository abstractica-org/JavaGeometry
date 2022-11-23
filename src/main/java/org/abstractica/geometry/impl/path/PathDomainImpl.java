package org.abstractica.geometry.impl.path;

import org.abstractica.geometry.intf.path.PathDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PathDomainImpl implements PathDomain
{
	@Override
	public PathBuilder newPathBuilder()
	{
		return new PathBuilderImpl();
	}

	private static class PathBuilderImpl implements PathBuilder
	{
		private final List<Integer> path;

		private PathBuilderImpl()
		{
			path = new ArrayList<>();
		}

		@Override
		public PathBuilder add(int index)
		{
			path.add(index);
			return this;
		}

		@Override
		public Path build()
		{
			return new PathImpl(Collections.unmodifiableList(path));
		}
	}

	private static class PathImpl implements Path
	{
		private final List<Integer> path;

		private PathImpl(List<Integer> path)
		{
			this.path = path;
		}

		@Override
		public int size()
		{
			return path.size();
		}

		@Override
		public int get(int index)
		{
			return path.get(index);
		}

		@Override
		public Iterator<Integer> iterator()
		{
			return path.iterator();
		}
	}
}
