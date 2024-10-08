package phanisment.collection.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class FlameSlashEntity extends AnimalEntity {
	private int lifeTime = 6;
	private int tickCounter = 0;

	public FlameSlashEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();
		
		if (!this.getWorld().isClient) {
			if (lifeTime-- <= 0) {
				this.discard();
			} else {
				tickCounter++;
			}
		}
	}

	public int getTickCounter() {
		return this.tickCounter;
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@Override
	public void pushAway(Entity entity) {
	}

	@Override
	public void pushAwayFrom(Entity entity) {
	}

	@Override
	public FlameSlashEntity createChild(ServerWorld world, PassiveEntity mate) {
		return null;
	}

	@Override
	public boolean isInvulnerableTo(DamageSource damageSource) {
		return true;
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
	}
}
