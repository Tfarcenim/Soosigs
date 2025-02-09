package tfar.soosigs.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import tfar.soosigs.Soosigs;

public class ModTags {
    public static class  Items {
        public static final TagKey<Item> ALLOWED_RESOURCES = mod("allowed_resources");

        public static final TagKey<Item> INGOTS_ALUMINUM = forge("ingots/aluminum");
        public static final TagKey<Item> INGOTS_CALORITE = forge("ingots/calorite");
        public static final TagKey<Item> INGOTS_DESH = forge("ingots/desh");
        public static final TagKey<Item> INGOTS_DRACONIUM = forge("ingots/draconium");
        public static final TagKey<Item> INGOTS_IRIDIUM = forge("ingots/iridium");
        public static final TagKey<Item> INGOTS_LEAD = forge("ingots/lead");
        public static final TagKey<Item> INGOTS_MAGENTITE = forge("ingots/magentite");
        public static final TagKey<Item> INGOTS_NICKEL = forge("ingots/nickel");
        public static final TagKey<Item> INGOTS_OSMIUM = forge("ingots/osmium");
        public static final TagKey<Item> INGOTS_OSTRUM = forge("ingots/ostrum");
        public static final TagKey<Item> INGOTS_PLATINUM = forge("ingots/platinum");
        public static final TagKey<Item> INGOTS_SILVER = forge("ingots/silver");
        public static final TagKey<Item> INGOTS_TIN = forge("ingots/tin");

        public static final TagKey<Item> INGOTS_URANIUM = forge("ingots/uranium");


        private static TagKey<Item> mod(String pName) {
            return TagKey.create(Registries.ITEM, Soosigs.id(pName));
        }

        private static TagKey<Item> forge(String pName) {
            return TagKey.create(Registries.ITEM, new ResourceLocation("forge",pName));
        }
    }
}
