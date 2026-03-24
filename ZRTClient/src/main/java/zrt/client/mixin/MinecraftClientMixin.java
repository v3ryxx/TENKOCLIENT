package zrt.client.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zrt.client.ZRTClient;
import zrt.client.event.Events;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method="tick", at=@At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ZRTClient.eventBus.post(new Events.TickEvent());
    }
}
