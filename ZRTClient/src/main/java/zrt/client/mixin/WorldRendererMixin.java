package zrt.client.mixin;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zrt.client.ZRTClient;
import zrt.client.event.Events;

@Mixin(net.minecraft.client.gui.hud.InGameHud.class)
public class WorldRendererMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void onRenderHud(net.minecraft.client.gui.DrawContext context, float tickDelta, CallbackInfo ci) {
        ZRTClient.eventBus.post(new Events.Render2DEvent(context.getMatrices(), tickDelta));
    }
}
