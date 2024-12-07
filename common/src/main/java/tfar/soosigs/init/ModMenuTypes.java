package tfar.soosigs.init;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import tfar.soosigs.menu.GeneInjectorMenu;

public class ModMenuTypes {

    public static final MenuType<GeneInjectorMenu> GENE_INJECTOR = new MenuType<>(GeneInjectorMenu::new, FeatureFlags.VANILLA_SET);

}
