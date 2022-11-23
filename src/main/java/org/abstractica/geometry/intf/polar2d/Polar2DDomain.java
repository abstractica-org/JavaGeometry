package org.abstractica.geometry.intf.polar2d;

import org.abstractica.geometry.intf.angle.AngleDomain.Angle;
import org.abstractica.geometry.intf.vector2d.Vector2DDomain.Vector2D;

public interface Polar2DDomain
{
	interface Polar2D
	{
		double r();
		Angle theta();
	}

	Polar2D polar2D(double r, Angle theta);
	Polar2D polar2DfromCartesian(double x, double y);
	Polar2D toPolar2D(Vector2D v);
	Polar2D rotate(Angle a, Polar2D polar2D);
}
