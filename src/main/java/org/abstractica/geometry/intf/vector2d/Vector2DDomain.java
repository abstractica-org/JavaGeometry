package org.abstractica.geometry.intf.vector2d;

import org.abstractica.geometry.intf.angle.AngleDomain.Angle;
import org.abstractica.geometry.intf.polar2d.Polar2DDomain.Polar2D;

public interface Vector2DDomain
{
	interface Vector2D
	{
		double x();
		double y();
	}
	Vector2D zeroVector2D();
	Vector2D vector2D(double x, double y);
	Vector2D vector2DfromPolar(double r, Angle theta);
	Vector2D toVector2D(Polar2D polar);
	Vector2D add(Vector2D a, Vector2D b);
	Vector2D sub(Vector2D a, Vector2D b);
	Vector2D mul(Vector2D a, double b);
	Vector2D div(Vector2D a, double b);
	Vector2D inverse(Vector2D a);
	Vector2D fromTo(Vector2D from, Vector2D to);
	double dot(Vector2D a, Vector2D b);
	double sqrLength(Vector2D a);
	double length(Vector2D a);
	Angle angle(Vector2D a);
	Angle angle(Vector2D from, Vector2D to);
	Vector2D normalize(Vector2D a);
}
