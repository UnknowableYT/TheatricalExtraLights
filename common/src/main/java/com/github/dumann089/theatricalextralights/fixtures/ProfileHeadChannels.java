package com.github.dumann089.theatricalextralights.fixtures;

import com.github.dumann089.theatricalextralights.util.FramingShutterState;
import com.github.dumann089.theatricalextralights.util.ProfileHeadState;
import dev.imabad.theatrical.api.dmx.DMXPersonality;
import dev.imabad.theatrical.fixtures.SharedSlots;

/**
 * Personnalite « 28ch - Profile 16bit » des lyres a gobos : shutter/strobe, dimmer 16 bit,
 * CMY, roue de couleur, gobo, prisme, frost, zoom, focus, pan/tilt 16 bit, vitesse moteur,
 * puis le module de couteaux. Ordre inspire des lyres profile Martin / Robe.
 */
public final class ProfileHeadChannels {

    public static final int TOTAL_CHANNELS = ProfileHeadState.CHANNELS_BEFORE_SHUTTERS + FramingShutterState.CHANNEL_COUNT;

    public static final DMXPersonality PERSONALITY_28CH = FramingShutterChannels.addFramingSlots(
            new DMXPersonality(TOTAL_CHANNELS, "28ch - Profile 16bit")
                    .addSlot(ExtraLightsSlots.SHUTTER_STROBE)   // 1
                    .addSlot(SharedSlots.INTENSITY)              // 2 dimmer coarse
                    .addSlot(ExtraLightsSlots.DIMMER_FINE)       // 3 dimmer fine
                    .addSlot(ExtraLightsSlots.CYAN)              // 4
                    .addSlot(ExtraLightsSlots.MAGENTA)           // 5
                    .addSlot(ExtraLightsSlots.YELLOW)            // 6
                    .addSlot(ExtraLightsSlots.COLOR_WHEEL)       // 7
                    .addSlot(ExtraLightsSlots.GOBO_WHEEL)        // 8
                    .addSlot(ExtraLightsSlots.GOBO_ROTATION)     // 9
                    .addSlot(ExtraLightsSlots.PRISM)             // 10
                    .addSlot(ExtraLightsSlots.PRISM_ROTATION)    // 11
                    .addSlot(ExtraLightsSlots.FROST)             // 12
                    .addSlot(ExtraLightsSlots.ZOOM)              // 13
                    .addSlot(SharedSlots.FOCUS)                  // 14
                    .addSlot(SharedSlots.PAN)                    // 15
                    .addSlot(ExtraLightsSlots.PAN_FINE)          // 16
                    .addSlot(SharedSlots.TILT)                   // 17
                    .addSlot(ExtraLightsSlots.TILT_FINE)         // 18
                    .addSlot(ExtraLightsSlots.PAN_TILT_SPEED)    // 19
    );

    private ProfileHeadChannels() {
    }
}
