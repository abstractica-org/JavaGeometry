package org.abstractica.geometry.intf.angle;

import org.abstractica.geometry.intf.interpolate.Interpolator;

public interface AngleDomain
{
	interface Angle
	{
		double asRotations();
		double asDegrees();
		double asRadians();
	}

	Angle zeroAngle();
	Angle rotations(double rotations);
	Angle degrees(double degrees);
	Angle radians(double radians);
	double sin(Angle angle);
	double cos(Angle angle);
	double tan(Angle angle);
	Angle asin(double value);
	Angle acos(double value);
	Angle atan(double value);
	Angle atan2(double y, double x);
	Angle add(Angle a1, Angle a2);
	Angle sub(Angle a1, Angle a2);
	Angle fromTo(Angle from, Angle to);
	Angle mul(Angle a, double factor);
	Angle div(Angle a, double factor);
	Angle neg(Angle a);
	Angle abs(Angle a);
	Angle min(Angle a1, Angle a2);
	Angle max(Angle a1, Angle a2);
	Angle clamp(Angle a, Angle min, Angle max);
	Interpolator<Angle> linearInterpolator();
}
