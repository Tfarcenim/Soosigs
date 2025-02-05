package tfar.soosigs.config;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class SoosigConfig {
    public static final Map<Item, ClientEntry> DEFAULTS = defaults();
    public static final Codec<Map<Item, ClientEntry>> MAP_CODEC = Codec.unboundedMap(BuiltInRegistries.ITEM.byNameCodec(), ClientEntry.CODEC);

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
        public final ConfigHelper.ConfigObject<Map<Item, ClientEntry>> COLORS;


        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            COLORS = ConfigHelper.defineObject(builder,"entries",MAP_CODEC,DEFAULTS);
            builder.pop();
        }
    }


    public static Map<Item, ClientEntry> defaults() {
        Map<Item, ClientEntry> map = new HashMap<>();

        map.put(Items.DIAMOND,new ClientEntry(0x00ffff));
        map.put(Items.EMERALD,new ClientEntry(0x00ff00));
        map.put(Items.IRON_INGOT,new ClientEntry(0xeeeeee));
        map.put(Items.GOLD_INGOT,new ClientEntry(0xffdd00));
        map.put(Items.LAPIS_LAZULI,new ClientEntry(0x0000ff));
        map.put(Items.NETHERITE_SCRAP,new ClientEntry(0x401E00));
        map.put(Items.REDSTONE,new ClientEntry(0xff0000));
        return map;
    }


}
