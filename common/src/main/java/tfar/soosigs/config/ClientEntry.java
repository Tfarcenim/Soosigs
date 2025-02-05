package tfar.soosigs.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ClientEntry(int color) {

    public static final ClientEntry BLANK = new ClientEntry(0xffffffff);

    public static final Codec<ClientEntry> CODEC = RecordCodecBuilder.create(soosigEntryInstance ->
            soosigEntryInstance.group(Codec.INT.fieldOf("color").forGetter(ClientEntry::color))
                    .apply(soosigEntryInstance, ClientEntry::new));

}
