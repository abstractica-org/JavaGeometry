package org.abstractica.geometry.impl.transform2D;

import org.abstractica.geometry.impl.polar2d.Polar2DDomainImpl;
import org.abstractica.geometry.intf.transform2D.Transform2DDomain;
import org.abstractica.geometry.intf.vector2d.Vector2DDomain;

public class Transform2DDomainImpl extends Polar2DDomainImpl implements Transform2DDomain
{
	@Override
	public Transform2D identityTransform2D()
	{
		return new Transform2DImpl();
	}

	@Override
	public Transform2D translate2D(double x, double y)
	{
		return new Transform2DImpl(1.0, 0.0, x, 0.0, 1.0, y);
	}

	@Override
	public Transform2D rotate2D(Angle angle)
	{
		double cos = cos(angle);
		double sin = sin(angle);
		return new Transform2DImpl(cos, -sin, 0.0, sin, cos, 0.0);
	}

	@Override
	public Transform2D scale2D(double x, double y)
	{
		return new Transform2DImpl( x, 0.0, 0.0, 0.0, y, 0.0);
	}

	@Override
	public Transform2D scale2D(double s)
	{
		return new Transform2DImpl( s, 0.0, 0.0, 0.0, s, 0.0);
	}

	@Override
	public Transform2D compose(Transform2D parent, Transform2D child)
	{
		Transform2DImpl a = (Transform2DImpl) parent;
		Transform2DImpl b = (Transform2DImpl) child;
		return new Transform2DImpl(
				a.m00 * b.m00 + a.m01 * b.m10,
				a.m00 * b.m01 + a.m01 * b.m11,
				a.m00 * b.m02 + a.m01 * b.m12 + a.m02,
				a.m10 * b.m00 + a.m11 * b.m10,
				a.m10 * b.m01 + a.m11 * b.m11,
				a.m10 * b.m02 + a.m11 * b.m12 + a.m12);
	}

	@Override
	public Transform2D inverse(Transform2D transform)
	{
		Transform2DImpl a = (Transform2DImpl) transform;
		double det = a.m00 * a.m11 - a.m01 * a.m10;
		return new Transform2DImpl(
				a.m11 / det,
				-a.m01 / det,
				(a.m01 * a.m12 - a.m11 * a.m02) / det,
				-a.m10 / det,
				a.m00 / det,
				(a.m10 * a.m02 - a.m00 * a.m12) / det);
	}

	@Override
	public Vector2DDomain.Vector2D transform(Transform2D transform, Vector2DDomain.Vector2D vector)
	{
		Transform2DImpl a = (Transform2DImpl) transform;
		return vector2D(
				a.m00 * vector.x() + a.m01 * vector.y() + a.m02,
				a.m10 * vector.x() + a.m11 * vector.y() + a.m12);
	}

	private static class Transform2DImpl implements Transform2D
	{
		private final double m00;
		private final double m01;
		private final double m02;
		private final double m10;
		private final double m11;
		private final double m12;

		private Transform2DImpl(double m00, double m01, double m02, double m10, double m11, double m12)
		{
			this.m00 = m00;
			this.m01 = m01;
			this.m02 = m02;
			this.m10 = m10;
			this.m11 = m11;
			this.m12 = m12;
		}

		private Transform2DImpl()
		{
			this(1, 0, 0, 0, 1, 0);
		}

		public double m00()
		{
			return m00;
		}

		public double m01()
		{
			return m01;
		}

		public double m02()
		{
			return m02;
		}

		public double m10()
		{
			return m10;
		}

		public double m11()
		{
			return m11;
		}

		public double m12()
		{
			return m12;
		}
	}
}
