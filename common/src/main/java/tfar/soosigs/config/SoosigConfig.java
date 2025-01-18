package tfar.soosigs.config;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoosigConfig {

    public static final Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final Codec<Map<Item,SoosigEntry>> MAP_CODEC = Codec.unboundedMap(BuiltInRegistries.ITEM.byNameCodec(),SoosigEntry.CODEC);



    static {
        final Pair<Server, ForgeConfigSpec> specPair2 = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = specPair2.getRight();
        SERVER = specPair2.getLeft();
    }
    public static final List<String> defaults = Lists.newArrayList(
            "minecraft:emerald|100");

    public static class Server {
        public final ConfigHelper.ConfigObject<Map<Item,SoosigEntry>> COLORS;


        public Server(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            COLORS = ConfigHelper.defineObject(builder,"entries",MAP_CODEC,defaults());
            builder.pop();
        }
    }

    public static final Map<Item,SoosigEntry> DEFAULTS = defaults();

    public static Map<Item,SoosigEntry> defaults() {
        Map<Item,SoosigEntry> map = new HashMap<>();
        map.put(Items.REDSTONE,new SoosigEntry(0xffff0000));
        return map;
    }


}
