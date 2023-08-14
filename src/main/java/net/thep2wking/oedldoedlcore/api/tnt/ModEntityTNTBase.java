package net.thep2wking.oedldoedlcore.api.tnt;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

/**
 * @author TheP2WKing
 */
public class ModEntityTNTBase extends EntityTNTPrimed {
	public static final DataParameter<Integer> FUSE = EntityDataManager.<Integer>createKey(ModEntityTNTBase.class,
			DataSerializers.VARINT);
	public int fuse = 80;
	public EntityLivingBase ignitor;
	public float explosionStrength = 4.0f;
	public boolean spawnFire = false;
	public boolean blockDamage = true;

	/**
	 * @author TheP2WKing
	 * @param world             {@link World}
	 * @param x                 double
	 * @param y                 double
	 * @param z                 double
	 * @param igniter           {@link EntityLivingBase}
	 * @param fuse              int
	 * @param explosionStrength float
	 * @param spawnFire         boolean
	 * @param blockDamage       boolean
	 */
	public ModEntityTNTBase(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world);
		this.fuse = fuse;
		this.explosionStrength = explosionStrength;
		this.spawnFire = spawnFire;
		this.blockDamage = blockDamage;
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * (Math.PI * 2D));
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.setFuse(this.fuse);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.ignitor = igniter;
	}

	/**
	 * @author TheP2WKing
	 * @param world   {@link World}
	 * @param x       double
	 * @param y       double
	 * @param z       double
	 * @param igniter {@link EntityLivingBase}
	 */
	public ModEntityTNTBase(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world);
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * (Math.PI * 2D));
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.setFuse(this.fuse);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.ignitor = igniter;
	}

	/**
	 * @author TheP2WKing
	 * @param world {@link World}
	 */
	public ModEntityTNTBase(World world) {
		super(world);
		this.preventEntitySpawning = true;
		this.isImmuneToFire = true;
		this.setSize(0.98F, 0.98F);
	}

	@Override
	public void entityInit() {
		this.dataManager.register(FUSE, Integer.valueOf(this.fuse));
	}

	@Override
	public boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (!this.hasNoGravity()) {
			this.motionY -= 0.03999999910593033D;
		}
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}
		--this.fuse;
		if (this.fuse <= 0) {
			this.setDead();
			if (!this.world.isRemote) {
				this.explode();
			}
		} else {
			this.handleWaterMovement();
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D,
					0.0D);
		}
	}

	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setShort("Fuse", (short) this.getFuse());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.setFuse(compound.getShort("Fuse"));
	}

	@Override
	public EntityLivingBase getTntPlacedBy() {
		return this.ignitor;
	}

	@Override
	public float getEyeHeight() {
		return 0.0F;
	}

	@Override
	public void setFuse(int fuseIn) {
		this.dataManager.set(FUSE, Integer.valueOf(fuseIn));
		this.fuse = fuseIn;
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		if (FUSE.equals(key)) {
			this.fuse = this.getFuseDataManager();
		}
	}

	@Override
	public int getFuseDataManager() {
		return ((Integer) this.dataManager.get(FUSE)).intValue();
	}

	@Override
	public int getFuse() {
		return this.fuse;
	}

	public float getExplosionStrength() {
		return this.explosionStrength;
	}

	public boolean doesSpawnFire() {
		return this.spawnFire;
	}

	public boolean doesBlockDamage() {
		return this.blockDamage;
	}
}