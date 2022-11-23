package org.abstractica.geometry.impl.polar2d;

import org.abstractica.geometry.impl.vector2d.Vector2DDomainImpl;
import org.abstractica.geometry.intf.polar2d.Polar2DDomain;

public class Polar2DDomainImpl extends Vector2DDomainImpl implements Polar2DDomain
{
	@Override
	public Polar2D polar2D(double r, Angle theta)
	{
		return new Polar2DImpl(r, theta);
	}

	@Override
	public Polar2D polar2DfromCartesian(double x, double y)
	{
		return polar2D(Math.sqrt(x * x + y * y), radians(Math.atan2(y, x)));
	}

	@Override
	public Polar2D toPolar2D(Vector2D v)
	{
		return polar2DfromCartesian(v.x(), v.y());
	}

	@Override
	public Polar2D rotate(Angle a, Polar2D polar2D)
	{
		return polar2D(polar2D.r(), add(a, polar2D.theta()));
	}

	@Override
	public Vector2D vector2DfromPolar(double r, Angle theta)
	{
		return vector2D(cos(theta) * r, sin(theta) * r);
	}

	private static class Polar2DImpl implements Polar2D
	{
		private final double r;
		private final Angle theta;

		public Polar2DImpl(double r, Angle theta)
		{
			this.r = r;
			this.theta = theta;
		}

		@Override
		public double r()
		{
			return r;
		}

		@Override
		public Angle theta()
		{
			return theta;
		}
	}
}
