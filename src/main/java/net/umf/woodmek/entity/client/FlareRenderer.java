package net.umf.woodmek.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.umf.woodmek.entity.custom.FlareEntity;

public class FlareRenderer extends EntityRenderer<FlareEntity> {

    public FlareRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(FlareEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        // Simple renderer - just render particles, no actual model needed
        // The entity itself is invisible, particles do all the visual work
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(FlareEntity entity) {
        // Return the particle texture atlas since we're using particles
        return TextureAtlas.LOCATION_PARTICLES;
    }
}
