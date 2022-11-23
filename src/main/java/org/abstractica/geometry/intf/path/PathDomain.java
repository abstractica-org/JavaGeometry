package org.abstractica.geometry.intf.path;

public interface PathDomain
{
	interface Path extends Iterable<Integer>
	{
		int size ();
		int get(int index);
	}

	interface PathBuilder
	{
		PathBuilder add(int index);
		Path build();
	}

	PathBuilder newPathBuilder();
}
