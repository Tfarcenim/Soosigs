package tfar.soosigs.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tfar.soosigs.SoosigEntityForge;

public class SoosigFurLayer extends GeoRenderLayer<SoosigEntityForge> {
    public SoosigFurLayer(GeoRenderer<SoosigEntityForge> entityRendererIn) {
        super(entityRendererIn);
    }

    static int[] unpack(int argb) {
        return new int[]{argb >> 24 & 0xff,argb >> 16 & 0xff,argb >> 8 & 0xff,argb & 0xff};
    }

    /**
     * This is the method that is actually called by the render for your render layer to function.<br>
     * This is called <i>after</i> the animatable has been rendered, but before supplementary rendering like nametags.
     */
    @Override
    public void render(PoseStack poseStack, SoosigEntityForge animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (!animatable.isSheared()) {
            int packedColor = animatable.getColor();

            int[] unpacked = unpack(packedColor);

            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType,
                    bufferSource.getBuffer(renderType), partialTick, 0xf00000, OverlayTexture.NO_OVERLAY,
                    (float) unpacked[1] / 0xff, (float) unpacked[2] / 0xff, (float) unpacked[3] / 0xff, (float) unpacked[0] / 0xff);
        }
    }
}
