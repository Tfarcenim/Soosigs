package tfar.soosigs;


import tfar.soosigs.platform.Services;

public enum ModIntegration {
    ad_astra,
    ae2,
    alltheores,
    bigreactors,
    draconicevolution,
    mysticalagriculture,
    ;
    public final boolean loaded;
    ModIntegration() {
        loaded = Services.PLATFORM.isModLoaded(name());
    }
}
