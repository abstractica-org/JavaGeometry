package org.abstractica.geometry.intf.interpolate;

public interface Interpolator<T>
{
	T interpolate(T from, T to, double f);
}
