package tfar.soosigs.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import tfar.soosigs.Soosigs;

public class ModTags {
    public static class  Items {
        public static final TagKey<Item> ALLOWED_RESOURCES = create("allowed_resources");
        private static TagKey<Item> create(String pName) {
            return TagKey.create(Registries.ITEM, Soosigs.id(pName));
        }
    }
}
