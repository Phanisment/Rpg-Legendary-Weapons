package phanisment.collection.item.mechanic;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.entity.RegisterEntities;

public class HellfireTalonItem extends SwordItem {
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity player) {
		slash(player);
		return super.postHit(stack, target, player);
	}
	
	private void slash(LivingEntity player) {
		World world = player.getWorld();
		Vec3d lookVec = player.getRotationVec(1.0F);
		double playerX = player.getX();
		double playerY = player.getY() + 1.5;
		double playerZ = player.getZ();

		double spawnX = playerX + lookVec.x * 1.5;
		double spawnY = playerY + lookVec.y * 1.5;
		double spawnZ = playerZ + lookVec.z * 1.5;

		FlameSlashEntity slash = new FlameSlashEntity(RegisterEntities.FLAME_SLASH, world);
		slash.refreshPositionAndAngles(spawnX, spawnY, spawnZ, player.getYaw(), player.getPitch());

		world.spawnEntity(slash);
	}
}