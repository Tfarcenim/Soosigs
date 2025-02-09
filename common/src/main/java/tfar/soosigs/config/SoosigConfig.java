package tfar.soosigs.config;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import tfar.soosigs.ModIntegration;

import java.util.HashMap;
import java.util.Map;

public class SoosigConfig {
    public static final Codec<Map<ResourceLocation, ClientEntry>> MAP_CODEC = Codec.unboundedMap(ResourceLocation.CODEC, ClientEntry.CODEC);

    public static final Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;




    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();

        final Pair<Client, ForgeConfigSpec> specPair2 = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair2.getRight();
        CLIENT = specPair2.getLeft();
    }

    public static class Server {


        public Server(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            builder.pop();
        }
    }

    public static class Client {
        public final ConfigHelper.ConfigObject<Map<ResourceLocation, ClientEntry>> COLORS;


        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            COLORS = ConfigHelper.defineObject(builder,"entries",MAP_CODEC,defaults());
            builder.pop();
        }
    }


    public static Map<ResourceLocation, ClientEntry> defaults() {
        Map<ResourceLocation, ClientEntry> map = new HashMap<>();
        map.put(lookup(Items.AMETHYST_SHARD),new ClientEntry(0x8B69CA));
        map.put(lookup(Items.COAL),new ClientEntry(0x111111));
        map.put(lookup(Items.DIAMOND),new ClientEntry(0x00ffff));
        map.put(lookup(Items.EMERALD),new ClientEntry(0x00ff00));
        map.put(lookup(Items.IRON_INGOT),new ClientEntry(0xdddddd));
        map.put(lookup(Items.GOLD_INGOT),new ClientEntry(0xffdd00));
        map.put(lookup(Items.LAPIS_LAZULI),new ClientEntry(0x0000ff));
        map.put(lookup(Items.NETHERITE_SCRAP),new ClientEntry(0x401E00));
        map.put(lookup(Items.QUARTZ),new ClientEntry(0xDAD1C4));
        map.put(lookup(Items.REDSTONE),new ClientEntry(0xdd0000));

        if (ModIntegration.alltheores.loaded) {
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"aluminum_ingot"),new ClientEntry(0xeeeeee));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"lead_ingot"),new ClientEntry(0x8B9CD0));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"nickel_ingot"),new ClientEntry(0xE0D7C0));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"osmium_ingot"),new ClientEntry(0xAFC6CB));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"platinum_ingot"),new ClientEntry(0xEDF3F6));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"silver_ingot"),new ClientEntry(0xE7E7E7));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"tin_ingot"),new ClientEntry(0xDFF1F8));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"uranium_ingot"),new ClientEntry(0xE5EAC0));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"zinc_ingot"),new ClientEntry(0xC7DDDB));
            map.put(new ResourceLocation(ModIntegration.alltheores.name(),"iridium_ingot"),new ClientEntry(0xE5E5E5));
        }

        if (ModIntegration.ad_astra.loaded) {
            map.put(new ResourceLocation(ModIntegration.ad_astra.name(),"desh_ingot"),new ClientEntry(0xD38B4C));
            map.put(new ResourceLocation(ModIntegration.ad_astra.name(),"ostrum_ingot"),new ClientEntry(0x905D63));
            map.put(new ResourceLocation(ModIntegration.ad_astra.name(),"calorite_ingot"),new ClientEntry(0xB63044));
        }

        if (ModIntegration.ae2.loaded) {
            map.put(new ResourceLocation(ModIntegration.ae2.name(),"certus_quartz_crystal"),new ClientEntry(0xB8D8FC));
        }

        if (ModIntegration.draconicevolution.loaded) {
            map.put(new ResourceLocation(ModIntegration.draconicevolution.name(),"draconium_ingot"),new ClientEntry(0xC694F3));
        }

        if (ModIntegration.bigreactors.loaded) {
            map.put(new ResourceLocation(ModIntegration.bigreactors.name(),"magentite_ingot"),new ClientEntry(0xDF79DF));
        }

        if (ModIntegration.mysticalagriculture.loaded) {
            map.put(new ResourceLocation(ModIntegration.mysticalagriculture.name(),"prosperity_shard"),new ClientEntry(0x82A0A0));
        }


        return map;
    }

    public static ResourceLocation lookup(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }

    public static Item lookup(ResourceLocation location) {
        return BuiltInRegistries.ITEM.get(location);
    }


}
