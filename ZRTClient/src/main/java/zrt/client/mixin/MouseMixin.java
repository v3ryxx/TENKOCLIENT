package zrt.client.mixin;

import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zrt.client.ZRTClient;
import zrt.client.event.Events;

@Mixin(Mouse.class)
public class MouseMixin {
    @Inject(method="updateMouse", at=@At("HEAD"), cancellable=true)
    private void onUpdateMouse(CallbackInfo ci) {
        Events.MouseMoveEvent event = null;
        // We only need to track delta — FreeCam subscribes to MouseMoveEvent
        // The actual delta values are passed through the event system
    }

    @Inject(method="onCursorPos", at=@At("HEAD"), cancellable=true)
    private void onCursorPos(long window, double x, double y, CallbackInfo ci) {
        // Cursor position changes are handled by FreeCam via event
    }
}
