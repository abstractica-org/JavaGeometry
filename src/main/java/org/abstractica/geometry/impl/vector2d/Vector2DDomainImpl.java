package org.abstractica.geometry.impl.vector2d;

import org.abstractica.geometry.impl.angle.AngleDomainImpl;
import org.abstractica.geometry.intf.polar2d.Polar2DDomain.Polar2D;
import org.abstractica.geometry.intf.vector2d.Vector2DDomain;

public class Vector2DDomainImpl extends AngleDomainImpl implements Vector2DDomain
{
	private static final Vector2D zeroVector = new Vector2DImpl(0.0, 0.0);
	private static final Vector2D unitX = new Vector2DImpl(1.0, 0.0);
	private static final Vector2D unitY = new Vector2DImpl(0.0, 1.0);
	private static final Vector2D minusUnitX = new Vector2DImpl(-1.0, 0.0);
	private static final Vector2D minusUnitY = new Vector2DImpl(0.0, -1.0);

	@Override
	public Vector2D vector2D(double x, double y)
	{
		if(Double.compare(x, 0.0) == 0 && Double.compare(y, 0.0) == 0)
		{
			return zeroVector;
		}
		if(Double.compare(x, 1.0) == 0 && Double.compare(y, 0.0) == 0)
		{
			return unitX;
		}
		if(Double.compare(x, 0.0) == 0 && Double.compare(y, 1.0) == 0)
		{
			return unitY;
		}
		if(Double.compare(x, -1.0) == 0 && Double.compare(y, 0.0) == 0)
		{
			return minusUnitX;
		}
		if(Double.compare(x, 0.0) == 0 && Double.compare(y, -1.0) == 0)
		{
			return minusUnitY;
		}
		return new Vector2DImpl(x, y);
	}

	@Override
	public Vector2D vector2DfromPolar(double r, Angle theta)
	{
		return vector2D(cos(theta) * r, sin(theta) * r);
	}

	@Override
	public Vector2D toVector2D(Polar2D polar)
	{
		return vector2DfromPolar(polar.r(), polar.theta());
	}

	@Override
	public Vector2D add(Vector2D a, Vector2D b)
	{
		return new Vector2DImpl(a.x() + b.x(), a.y() + b.y());
	}

	@Override
	public Vector2D sub(Vector2D a, Vector2D b)
	{
		return new Vector2DImpl(a.x() - b.x(), a.y() - b.y());
	}

	@Override
	public Vector2D mul(Vector2D a, double f)
	{
		return new Vector2DImpl(a.x() * f, a.y() * f);
	}

	@Override
	public Vector2D div(Vector2D a, double f)
	{
		return new Vector2DImpl(a.x() / f, a.y() / f);
	}

	@Override
	public Vector2D inverse(Vector2D a)
	{
		return new Vector2DImpl(-a.x(), -a.y());
	}

	@Override
	public Vector2D fromTo(Vector2D from, Vector2D to)
	{
		return new Vector2DImpl(to.x() - from.x(), to.y() - from.y());
	}

	@Override
	public double dot(Vector2D a, Vector2D b)
	{
		return a.x() * b.x() + a.y() * b.y();
	}

	@Override
	public double sqrLength(Vector2D a)
	{
		return a.x() * a.x() + a.y() * a.y();
	}

	@Override
	public double length(Vector2D a)
	{
		return Math.sqrt(sqrLength(a));
	}

	@Override
	public Angle angle(Vector2D a)
	{
		return atan2(a.y(), a.x());
	}

	@Override
	public Angle angle(Vector2D from, Vector2D to)
	{
		return sub(angle(to), angle(from));
	}

	@Override
	public Vector2D normalize(Vector2D a)
	{
		double l = length(a);
		return new Vector2DImpl(a.x() / l, a.y() / l);
	}

	@Override
	public Vector2D zeroVector2D()
	{
		return zeroVector;
	}

	private static class Vector2DImpl implements Vector2D
	{
		private final double x;
		private final double y;

		public Vector2DImpl(double x, double y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public double x()
		{
			return x;
		}

		@Override
		public double y()
		{
			return y;
		}
	}
}
