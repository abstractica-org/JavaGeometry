package org.abstractica.geometry.intf.transform2D;

import org.abstractica.geometry.intf.angle.AngleDomain.Angle;
import org.abstractica.geometry.intf.vector2d.Vector2DDomain.Vector2D;

public interface Transform2DDomain
{
	interface Transform2D
	{
	}
	Transform2D identityTransform2D();
	Transform2D translate2D(double x, double y);
	Transform2D rotate2D(Angle angle);
	Transform2D scale2D(double x, double y);
	Transform2D scale2D(double s);
	Transform2D compose(Transform2D parent, Transform2D child);
	Transform2D inverse(Transform2D transform);
	Vector2D transform(Transform2D transform, Vector2D vector);
}
