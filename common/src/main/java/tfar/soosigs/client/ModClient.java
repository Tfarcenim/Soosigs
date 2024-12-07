package tfar.soosigs.client;

import net.minecraft.client.gui.screens.MenuScreens;
import tfar.soosigs.init.ModMenuTypes;

public class ModClient {

    public static void setup() {
        MenuScreens.register(ModMenuTypes.GENE_INJECTOR,GeneInjectorScreen::new);
    }

}
