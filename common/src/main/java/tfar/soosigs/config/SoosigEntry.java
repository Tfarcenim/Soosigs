package tfar.soosigs.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record SoosigEntry(int color) {

    public static final Codec<SoosigEntry> CODEC = RecordCodecBuilder.create(soosigEntryInstance ->
            soosigEntryInstance.group(Codec.INT.fieldOf("color").forGetter(SoosigEntry::color))
                    .apply(soosigEntryInstance,SoosigEntry::new));

}
