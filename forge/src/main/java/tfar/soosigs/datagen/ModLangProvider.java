package tfar.soosigs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModEntities;
import tfar.soosigs.init.ModItems;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, Soosigs.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModEntities.SOOSIG,"Soosig");
        add(ModItems.SOOSIG_EGG,"Soosig Egg");
    }
}
