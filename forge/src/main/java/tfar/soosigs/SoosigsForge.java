package tfar.soosigs;

import net.minecraftforge.fml.common.Mod;

@Mod(Soosigs.MOD_ID)
public class SoosigsForge {
    
    public SoosigsForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Soosigs.LOG.info("Hello Forge world!");
        Soosigs.init();
        
    }
}