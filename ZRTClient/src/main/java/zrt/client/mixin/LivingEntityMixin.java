package zrt.client.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zrt.client.ZRTClient;
import zrt.client.event.Events;

@Mixin(net.minecraft.client.network.ClientPlayerInteractionManager.class)
public class LivingEntityMixin {

    @Inject(method = "attackEntity", at = @At("HEAD"))
    private void onAttack(net.minecraft.entity.player.PlayerEntity player,
                          net.minecraft.entity.Entity target, CallbackInfo ci) {
        ZRTClient.eventBus.post(new Events.AttackEvent());
    }
}
