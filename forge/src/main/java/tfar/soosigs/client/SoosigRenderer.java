package tfar.soosigs.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tfar.soosigs.SoosigEntityForge;

public class SoosigRenderer extends GeoEntityRenderer<SoosigEntityForge> {


    public SoosigRenderer(EntityRendererProvider.Context renderManager, GeoModel<SoosigEntityForge> model) {
        super(renderManager, model);
    }

}
