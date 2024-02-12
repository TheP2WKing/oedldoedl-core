package net.thep2wking.oedldoedlcore.util;

import java.util.Random;

import javax.vecmath.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
@SideOnly(Side.CLIENT)
public class ModCustomParticleRenderer extends Particle {
	public float colorRed;
	public float colorGreen;
	public float colorBlue;
	public Vec3d center;
	public float smokeParticleScale;

	public ModCustomParticleRenderer(World world, double x, double y, double z, Vec3d center, float f, float colorRed,
			float colorGreen, float colorBlue) {
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
		this.center = center;
		this.particleScale *= 0.75F;
		this.particleScale *= f;
		this.smokeParticleScale = this.particleScale;
		this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
		this.particleMaxAge = (int) ((float) this.particleMaxAge * f);
		setRBGColorF(colorRed, colorGreen, colorBlue);
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entity, float partialTicks, float rotationX,
			float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		float f6 = ((float) this.particleAge + partialTicks) / (float) this.particleMaxAge * 32.0F;
		if (f6 < 0.0F) {
			f6 = 0.0F;
		}
		if (f6 > 1.0F) {
			f6 = 1.0F;
		}
		this.particleScale = this.smokeParticleScale * f6;
		super.renderParticle(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired();
		}
		this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
		this.move(this.motionX, this.motionY, this.motionZ);
		this.motionX = (center.x - posX) * 0.1;
		this.motionY = (center.y - posY) * 0.1;
		this.motionZ = (center.z - posZ) * 0.1;
	}

	public static Vector3f randomCircle(double x0, double y0, double z0, Vec3d radius, Random rand) {
		double u = rand.nextDouble();
		double v = rand.nextDouble();
		double theta = 2 * Math.PI * u;
		double phi = Math.acos(2 * v - 1);
		double x = x0 + (radius.x * Math.sin(phi) * Math.cos(theta));
		double y = y0 + (radius.y * Math.sin(phi) * Math.sin(theta));
		double z = z0 + (radius.z * Math.cos(phi));
		return new Vector3f((float) x, (float) y, (float) z);
	}

	// particle color from rgb
	public static void addParticlesFromRGB(World world, BlockPos pos, float red, float green, float blue) {
		Vector3f point = randomCircle(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new Vec3d(2, 2, 2),
				world.rand);
		ModCustomParticleRenderer particle = new ModCustomParticleRenderer(world, point.x, point.y, point.z,
				new Vec3d(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 1.0f), 1.0f, red / 255, green / 255,
				blue / 255);
		Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	}

	// particle color from hex
	public static void addParticleFromHex(World world, BlockPos pos, String hexColor) {
		Vector3f point = randomCircle(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new Vec3d(2, 2, 2),
				world.rand);
		ModCustomParticleRenderer particle = new ModCustomParticleRenderer(world, point.x, point.y, point.z,
				new Vec3d(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 1.0f), 1.0f,
				(float) Integer.valueOf(hexColor.substring(1, 3), 16) / 255,
				(float) Integer.valueOf(hexColor.substring(3, 5), 16) / 255,
				(float) Integer.valueOf(hexColor.substring(5, 7), 16) / 255);
		Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	}
}