package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ComparisonChain;

public class MobEffect implements Comparable<MobEffect> {

	private static final Logger logger = LogManager.getLogger();

	private final MobEffectType type;
	private int duration;
	private int amplification;
	private boolean splash;
	private boolean ambient;
	private boolean particles;

	public MobEffect(MobEffectType type) {
		this(type, 0, 0);
	}

	public MobEffect(MobEffectType type, int duration) {
		this(type, duration, 0);
	}

	public MobEffect(MobEffectType type, int duration, int amplification) {
		this(type, duration, amplification, false, true);
	}

	public MobEffect(MobEffectType type, int duration, int amplification, boolean ambient, boolean particles) {
		this.type = type;
		this.duration = duration;
		this.amplification = amplification;
		this.ambient = ambient;
		this.particles = particles;
	}

	public MobEffect(MobEffect other) {
		this.type = other.type;
		this.duration = other.duration;
		this.amplification = other.amplification;
		this.ambient = other.ambient;
		this.particles = other.particles;
	}

	public void a(MobEffect other) {
		if (this.type != other.type) {
			logger.warn("This method should only be called for matching effects!");
		}

		if (other.amplification > this.amplification) {
			this.amplification = other.amplification;
			this.duration = other.duration;
		} else if ((other.amplification == this.amplification) && (this.duration < other.duration)) {
			this.duration = other.duration;
		} else if (!other.ambient && this.ambient) {
			this.ambient = other.ambient;
		}

		this.particles = other.particles;
	}

	public MobEffectType getEffectType() {
		return this.type;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getAmplifier() {
		return this.amplification;
	}

	public boolean isAmbient() {
		return this.ambient;
	}

	public boolean isShowParticles() {
		return this.particles;
	}

	public boolean tick(EntityLiving var1) {
		if (this.duration > 0) {
			if (this.type.a(this.duration, this.amplification)) {
				this.b(var1);
			}

			this.decreaseDuration();
		}

		return this.duration > 0;
	}

	private int decreaseDuration() {
		return --this.duration;
	}

	public void b(EntityLiving var1) {
		if (this.duration > 0) {
			this.type.tick(var1, this.amplification);
		}
	}

	public String getName() {
		return this.type.getName();
	}

	@Override
	public String toString() {
		String string = "";
		if (this.amplification > 0) {
			string = this.getName() + " x " + (this.amplification + 1) + ", Duration: " + this.duration;
		} else {
			string = this.getName() + ", Duration: " + this.duration;
		}

		if (this.splash) {
			string = string + ", Splash: true";
		}

		if (!this.particles) {
			string = string + ", Particles: false";
		}

		return string;
	}

	@Override
	public boolean equals(Object otherObj) {
		if (this == otherObj) {
			return true;
		} else if (!(otherObj instanceof MobEffect)) {
			return false;
		} else {
			MobEffect var2 = (MobEffect) otherObj;
			return this.duration != var2.duration ? false : (this.amplification != var2.amplification ? false : (this.splash != var2.splash ? false : (this.ambient != var2.ambient ? false : this.type.equals(var2.type))));
		}
	}

	@Override
	public int hashCode() {
		int var1 = this.type.hashCode();
		var1 = (31 * var1) + this.duration;
		var1 = (31 * var1) + this.amplification;
		var1 = (31 * var1) + (this.splash ? 1 : 0);
		var1 = (31 * var1) + (this.ambient ? 1 : 0);
		return var1;
	}

	public NBTTagCompound a(NBTTagCompound compound) {
		compound.put("Id", (byte) MobEffectType.getId(this.getEffectType()));
		compound.put("Amplifier", (byte) this.getAmplifier());
		compound.put("Duration", this.getDuration());
		compound.put("Ambient", this.isAmbient());
		compound.put("ShowParticles", this.isShowParticles());
		return compound;
	}

	public static MobEffect fromTag(NBTTagCompound compound) {
		byte id = compound.getByte("Id");
		MobEffectType type = MobEffectType.getById(id);
		if (type == null) {
			return null;
		} else {
			byte amplifier = compound.getByte("Amplifier");
			int duration = compound.getInt("Duration");
			boolean ambient = compound.getBoolean("Ambient");
			boolean particles = true;
			if (compound.hasOfType("ShowParticles", 1)) {
				particles = compound.getBoolean("ShowParticles");
			}

			return new MobEffect(type, duration, amplifier, ambient, particles);
		}
	}

	@Override
	public int compareTo(MobEffect other) {
		return ComparisonChain.start().compare(this.getDuration(), other.getDuration()).compare(this.getEffectType().g(), other.getEffectType().g()).result();
	}

}
