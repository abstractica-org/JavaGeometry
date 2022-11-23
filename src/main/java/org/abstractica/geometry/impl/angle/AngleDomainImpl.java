package org.abstractica.geometry.impl.angle;

import org.abstractica.geometry.impl.path.PathDomainImpl;
import org.abstractica.geometry.intf.angle.AngleDomain;
import org.abstractica.geometry.intf.interpolate.Interpolator;

public class AngleDomainImpl extends PathDomainImpl implements AngleDomain
{
	private static final double fromDegrees = 1.0 / 360.0;
	private static final double fromRadians = 1.0 / (2.0 * Math.PI);
	private final Interpolator<Angle> interpolator;
	private final Angle zeroAngle;
	private final Angle quarterAngle;
	private final Angle halfAngle;
	private final Angle minusQuarterAngle;


	public AngleDomainImpl()
	{
		interpolator = new Interpolator<Angle>()
		{
			@Override
			public Angle interpolate(Angle from, Angle to, double f)
			{
				double delta = to.asRotations() - from.asRotations();
				if(delta <= -0.5 || delta > 0.5)
				{
					delta = delta - Math.floor(delta);
				}
				return rotations(from.asRotations() + delta * f);
			}
		};
		zeroAngle = new AngleImpl(0.0);
		quarterAngle = new AngleImpl(0.25);
		halfAngle = new AngleImpl(0.5);
		minusQuarterAngle = new AngleImpl(-0.25);
	}


	@Override
	public Angle zeroAngle()
	{
		return zeroAngle;
	}

	@Override
	public Angle rotations(double rotations)
	{
		if(rotations < 0.0 || rotations >= 1.0)
		{
			rotations = rotations - Math.floor(rotations);
		}
		if(rotations > 0.5)
		{
			rotations = rotations - 1.0;
		}
		if(Double.compare(rotations, 0.0) == 0)
		{
			return zeroAngle;
		}
		if(Double.compare(rotations, 0.25) == 0)
		{
			return quarterAngle;
		}
		if(Double.compare(rotations, 0.5) == 0)
		{
			return halfAngle;
		}
		if(Double.compare(rotations, -0.25) == 0)
		{
			return minusQuarterAngle;
		}
		return new AngleImpl(rotations);
	}

	@Override
	public Angle degrees(double degrees)
	{
		return rotations(degrees * fromDegrees);
	}

	@Override
	public Angle radians(double radians)
	{
		return rotations(radians * fromRadians);
	}

	@Override
	public double sin(Angle angle)
	{
		return Math.sin(angle.asRadians());
	}

	@Override
	public double cos(Angle angle)
	{
		return Math.cos(angle.asRadians());
	}

	@Override
	public double tan(Angle angle)
	{
		return Math.tan(angle.asRadians());
	}

	@Override
	public Angle asin(double value)
	{
		return radians(Math.asin(value));
	}

	@Override
	public Angle acos(double value)
	{
		return radians(Math.acos(value));
	}

	@Override
	public Angle atan(double value)
	{
		return radians(Math.atan(value));
	}

	@Override
	public Angle atan2(double y, double x)
	{
		return radians(Math.atan2(y, x));
	}

	@Override
	public Angle add(Angle a1, Angle a2)
	{
		return rotations(a1.asRotations() + a2.asRotations());
	}

	@Override
	public Angle sub(Angle a1, Angle a2)
	{
		return rotations(a1.asRotations() - a2.asRotations());
	}

	@Override
	public Angle fromTo(Angle from, Angle to)
	{
		double res = to.asRotations() - from.asRotations();
		if(res <= -0.5 || res > 0.5)
		{
			res = res - Math.floor(res);
		}
		return rotations(res);
	}

	@Override
	public Angle mul(Angle a, double factor)
	{
		return rotations(a.asRotations() * factor);
	}

	@Override
	public Angle div(Angle a, double factor)
	{
		return rotations(a.asRotations() / factor);
	}

	@Override
	public Angle neg(Angle a)
	{
		return rotations(-a.asRotations());
	}

	@Override
	public Angle abs(Angle a)
	{
		return rotations(Math.abs(a.asRotations()));
	}

	@Override
	public Angle min(Angle a1, Angle a2)
	{
		return rotations(Math.min(a1.asRotations(), a2.asRotations()));
	}

	@Override
	public Angle max(Angle a1, Angle a2)
	{
		return rotations(Math.max(a1.asRotations(), a2.asRotations()));
	}

	@Override
	public Angle clamp(Angle a, Angle min, Angle max)
	{
		return rotations(Math.min(Math.max(a.asRotations(), min.asRotations()), max.asRotations()));
	}

	@Override
	public Interpolator<Angle> linearInterpolator()
	{
		return interpolator;
	}

	private static class AngleImpl implements Angle
	{
		private final static double toRadians = 2 * Math.PI;
		private final static double toDegrees = 360.0;
		private final double rotations;

		private AngleImpl(double rotations)
		{
			this.rotations = rotations;

		}

		@Override
		public double asRotations()
		{
			return rotations;
		}

		@Override
		public double asDegrees()
		{
			return toDegrees * rotations;
		}

		@Override
		public double asRadians()
		{
			return toRadians * rotations;
		}
	}
}
