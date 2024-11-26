package tfar.soosigs.client;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import tfar.soosigs.SoosigEntityForge;

public class SoosigModel extends DefaultedEntityGeoModel<SoosigEntityForge> {

    final ResourceLocation sheared;
    public SoosigModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
        sheared= super.buildFormattedTexturePath(assetSubpath.withPrefix("sheared_"));
    }

    @Override
    public ResourceLocation getTextureResource(SoosigEntityForge animatable) {
        if (animatable.isSheared()) {
            return sheared;
        }
        return super.getTextureResource(animatable);
    }
}
