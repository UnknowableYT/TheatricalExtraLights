package com.github.dumann089.theatricalextralights.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;

/**
 * Etat de la personnalite « Profile 16 bit » des lyres a gobos : canaux d'une vraie lyre
 * profile (shutter/strobe, dimmer 16 bit, CMY, roue de couleur, prisme, frost, pan/tilt
 * 16 bit avec vitesse moteur). Les couteaux restent dans {@link FramingShutterState}.
 *
 * <pre>
 *  1  Shutter / strobe    0-19 ferme, 20-49 ouvert, 50-149 strobe lent→rapide,
 *                         150-179 ouvert, 180-229 pulse lent→rapide, 230-239 ouvert, 240-255 aleatoire
 *  2  Dimmer (coarse)     3  Dimmer (fine)
 *  4  Cyan   5  Magenta   6  Yellow
 *  7  Roue de couleur     0-9 ouvert, 10-99 neuf couleurs (10 pas chacune), 100-127 ouvert,
 *                         128-191 rotation continue CW lent→rapide, 192-255 CCW rapide→lent
 *  8  Roue de gobos       9  Rotation du gobo
 * 10  Prisme              0-127 hors faisceau, 128-255 prisme 3 facettes
 * 11  Rotation du prisme  0-127 position indexee, 128-191 CW lent→rapide, 192-255 CCW lent→rapide
 * 12  Frost               0 aucun … 255 plein
 * 13  Zoom               14  Focus
 * 15  Pan (coarse)       16  Pan (fine)   17  Tilt (coarse)   18  Tilt (fine)
 * 19  Vitesse pan/tilt    0-2 tracking (instantane), 3-255 rapide→lent
 * 20-28 Couteaux (voir FramingShutterState)
 * </pre>
 */
public final class ProfileHeadState {

    public static final int CHANNELS_BEFORE_SHUTTERS = 19;

    // Roue de couleur : 9 couleurs (index 1-9), 0 = ouvert
    public static final int[] WHEEL_COLORS = {
            0xFFFFFF, // 0 ouvert
            0xFF2A18, // 1 rouge
            0xFF7A00, // 2 orange
            0xFFDC2C, // 3 jaune
            0x2CC848, // 4 vert
            0x50B4FF, // 5 bleu clair
            0x1E3CFF, // 6 bleu
            0xE628C8, // 7 magenta
            0xFFBE78, // 8 CTO
            0x6E28DC  // 9 congo
    };
    public static final String[] WHEEL_NAMES = {
            "Open", "Red", "Orange", "Yellow", "Green", "Light blue", "Blue", "Magenta", "CTO", "Congo"
    };

    /** Vitesse moteur max (tracking) et min, en degres par seconde. */
    private static final float MOTOR_FAST_DEG_S = 720f;
    private static final float MOTOR_SLOW_DEG_S = 25f;

    private boolean active;

    // Valeurs DMX brutes
    private int shutter = 32;       // ouvert par defaut
    private int dimmer16;
    private int cyan, magenta, yellow;
    private int colorWheel;
    private int prism;
    private int prismRotation;
    private int frost;
    private int pan16 = 32768;
    private int tilt16 = 32768 + 5825; // ~ tilt 0°
    private int speed;

    // Cibles / moteur (client)
    private float targetPan;
    private float targetTilt;
    private float motorPan;
    private float motorTilt;
    private float prevMotorPan;
    private float prevMotorTilt;
    private boolean motorInit;

    // Animations client
    private float prismAngle;
    private float prevPrismAngle;
    private float wheelPhase;
    private float prevWheelPhase;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ── DMX ──────────────────────────────────────────────────────────────────

    /** Lit les 19 premiers canaux. Retourne true si une valeur a change. */
    public boolean consume(byte[] v) {
        int h = hashState();
        shutter = u(v[0]);
        dimmer16 = (u(v[1]) << 8) | u(v[2]);
        cyan = u(v[3]);
        magenta = u(v[4]);
        yellow = u(v[5]);
        colorWheel = u(v[6]);
        prism = u(v[9]);
        prismRotation = u(v[10]);
        frost = u(v[11]);
        pan16 = (u(v[14]) << 8) | u(v[15]);
        tilt16 = (u(v[16]) << 8) | u(v[17]);
        speed = u(v[18]);
        targetPan = pan16 / 65535f * 360f - 180f;
        targetTilt = tilt16 / 65535f * 270f - 225f;
        active = true;
        return h != hashState();
    }

    private int hashState() {
        int h = shutter;
        h = 31 * h + dimmer16;
        h = 31 * h + cyan;
        h = 31 * h + magenta;
        h = 31 * h + yellow;
        h = 31 * h + colorWheel;
        h = 31 * h + prism;
        h = 31 * h + prismRotation;
        h = 31 * h + frost;
        h = 31 * h + pan16;
        h = 31 * h + tilt16;
        h = 31 * h + speed;
        return h;
    }

    private static int u(byte b) {
        return Byte.toUnsignedInt(b);
    }

    // ── Decodage ─────────────────────────────────────────────────────────────

    /** Intensite 0-255 issue du dimmer 16 bit. */
    public int intensity8() {
        return Math.round(dimmer16 / 257f);
    }

    public int getFocusRaw(byte[] v) {
        return u(v[13]);
    }

    public int getZoomRaw(byte[] v) {
        return u(v[12]);
    }

    public int getGoboRaw(byte[] v) {
        return u(v[7]);
    }

    public int getGoboSpinRaw(byte[] v) {
        return u(v[8]);
    }

    public int getPanInt() {
        return Math.round(targetPan);
    }

    public int getTiltInt() {
        return Math.round(targetTilt);
    }

    public float getTargetPan() { return targetPan; }
    public float getTargetTilt() { return targetTilt; }
    public int getShutter() { return shutter; }
    public int getCyan() { return cyan; }
    public int getMagenta() { return magenta; }
    public int getYellow() { return yellow; }
    public int getColorWheel() { return colorWheel; }
    public int getPrism() { return prism; }
    public int getPrismRotation() { return prismRotation; }
    public int getFrost() { return frost; }
    public int getSpeed() { return speed; }

    /** Couleur statique (CMY x roue) a ecrire dans les champs RGB du block entity. */
    public int staticColour() {
        int base = cmyColour();
        int slot = wheelSlot(colorWheel);
        if (slot >= 0) {
            return multiply(base, WHEEL_COLORS[slot]);
        }
        return base; // rotation continue : la couleur animee est calculee cote client
    }

    private int cmyColour() {
        int r = 255 - cyan;
        int g = 255 - magenta;
        int b = 255 - yellow;
        return (r << 16) | (g << 8) | b;
    }

    /** Index de couleur fixe pour une valeur DMX de roue, -1 si rotation continue. */
    public static int wheelSlot(int dmx) {
        if (dmx < 10) return 0;
        if (dmx < 100) return 1 + (dmx - 10) / 10;
        if (dmx < 128) return 0;
        return -1;
    }

    public boolean isWheelRotating() {
        return wheelSlot(colorWheel) < 0;
    }

    /** Couleur vue par le client : CMY x roue, roue animee si elle tourne. */
    public int colour(float partialTicks) {
        int base = cmyColour();
        int slot = wheelSlot(colorWheel);
        if (slot >= 0) {
            return multiply(base, WHEEL_COLORS[slot]);
        }
        float phase = prevWheelPhase + (wheelPhase - prevWheelPhase) * partialTicks;
        int n = WHEEL_COLORS.length - 1; // sans "ouvert"
        float pos = ((phase % n) + n) % n;
        int i0 = 1 + (int) Math.floor(pos);
        int i1 = 1 + ((int) Math.floor(pos) + 1) % n;
        float t = pos - (float) Math.floor(pos);
        return multiply(base, mix(WHEEL_COLORS[i0], WHEEL_COLORS[i1], t));
    }

    public boolean hasPrism() {
        return prism >= 128;
    }

    /** Angle du prisme en degres (indexe ou anime). */
    public float prismAngle(float partialTicks) {
        if (prismRotation < 128) {
            return prismRotation / 127f * 360f;
        }
        return prevPrismAngle + (prismAngle - prevPrismAngle) * partialTicks;
    }

    // ── Shutter / strobe ─────────────────────────────────────────────────────

    /** Facteur 0-1 applique au dimmer selon le canal shutter. */
    public float shutterFactor(long gameTime, float partialTicks) {
        int s = shutter;
        if (s < 20) return 0f;
        if (s < 50) return 1f;
        double t = (gameTime + partialTicks) / 20.0; // secondes
        if (s < 150) {
            double hz = Mth.lerp((s - 50) / 99f, 1.0, 12.0);
            return ((t * hz) % 1.0) < 0.5 ? 1f : 0f;
        }
        if (s < 180) return 1f;
        if (s < 230) {
            double hz = Mth.lerp((s - 180) / 49f, 0.5, 6.0);
            double p = (t * hz) % 1.0;
            return (float) (p < 0.5 ? p * 2.0 : 2.0 - p * 2.0); // rampe montante puis descendante
        }
        if (s < 240) return 1f;
        // aleatoire : etat tire au sort toutes les ~60 ms
        long cell = (long) Math.floor(t * 16.0);
        long hash = cell * 0x9E3779B97F4A7C15L;
        hash ^= (hash >>> 29);
        return ((hash >>> 7) & 3) == 0 ? 0f : 1f;
    }

    // ── Moteur pan/tilt et animations (client) ───────────────────────────────

    public void tickClient() {
        prevMotorPan = motorPan;
        prevMotorTilt = motorTilt;
        prevPrismAngle = prismAngle;
        prevWheelPhase = wheelPhase;

        if (!motorInit) {
            motorPan = targetPan;
            motorTilt = targetTilt;
            prevMotorPan = motorPan;
            prevMotorTilt = motorTilt;
            motorInit = true;
        } else if (speed <= 2) {
            motorPan = targetPan;
            motorTilt = targetTilt;
        } else {
            float degPerSec = Mth.lerp((speed - 3) / 252f, MOTOR_FAST_DEG_S, MOTOR_SLOW_DEG_S);
            float maxStep = degPerSec / 20f;
            motorPan = approach(motorPan, targetPan, maxStep);
            motorTilt = approach(motorTilt, targetTilt, maxStep);
        }

        if (prismRotation >= 128) {
            boolean cw = prismRotation < 192;
            float norm = cw ? (prismRotation - 128) / 63f : (prismRotation - 192) / 63f;
            float degPerTick = Mth.lerp(norm, 0.5f, 12f) * (cw ? 1f : -1f);
            prismAngle = (prismAngle + degPerTick) % 360f;
            if (prismAngle < 0) prismAngle += 360f;
        }

        if (isWheelRotating()) {
            boolean cw = colorWheel < 192;
            float norm = cw ? (colorWheel - 128) / 63f : 1f - (colorWheel - 192) / 63f;
            float slotsPerTick = Mth.lerp(norm, 0.01f, 0.25f) * (cw ? 1f : -1f);
            wheelPhase += slotsPerTick;
        }
    }

    /** Approche avec plafond de vitesse et amorti : rapide au depart, doux a l'arrivee. */
    private static float approach(float current, float target, float maxStep) {
        float delta = target - current;
        if (Math.abs(delta) < 0.001f) {
            return target;
        }
        float eased = delta * 0.45f;
        if (Math.abs(eased) < 0.05f) {
            eased = Math.copySign(Math.min(0.05f, Math.abs(delta)), delta);
        }
        float step = Mth.clamp(eased, -maxStep, maxStep);
        return current + step;
    }

    public float partialPan(float partialTicks) {
        return prevMotorPan + (motorPan - prevMotorPan) * partialTicks;
    }

    public float partialTilt(float partialTicks) {
        return prevMotorTilt + (motorTilt - prevMotorTilt) * partialTicks;
    }

    public boolean isMoving() {
        return Math.abs(motorPan - targetPan) > 0.01f || Math.abs(motorTilt - targetTilt) > 0.01f;
    }

    // ── NBT ──────────────────────────────────────────────────────────────────

    public void write(CompoundTag tag) {
        CompoundTag t = new CompoundTag();
        t.putBoolean("active", active);
        t.putInt("shutter", shutter);
        t.putInt("dimmer16", dimmer16);
        t.putInt("cyan", cyan);
        t.putInt("magenta", magenta);
        t.putInt("yellow", yellow);
        t.putInt("wheel", colorWheel);
        t.putInt("prism", prism);
        t.putInt("prismRot", prismRotation);
        t.putInt("frost", frost);
        t.putInt("pan16", pan16);
        t.putInt("tilt16", tilt16);
        t.putInt("speed", speed);
        tag.put("profileHead", t);
    }

    public void read(CompoundTag tag) {
        if (!tag.contains("profileHead")) {
            active = false;
            return;
        }
        CompoundTag t = tag.getCompound("profileHead");
        active = t.getBoolean("active");
        shutter = t.getInt("shutter");
        dimmer16 = t.getInt("dimmer16");
        cyan = t.getInt("cyan");
        magenta = t.getInt("magenta");
        yellow = t.getInt("yellow");
        colorWheel = t.getInt("wheel");
        prism = t.getInt("prism");
        prismRotation = t.getInt("prismRot");
        frost = t.getInt("frost");
        pan16 = t.getInt("pan16");
        tilt16 = t.getInt("tilt16");
        speed = t.getInt("speed");
        targetPan = pan16 / 65535f * 360f - 180f;
        targetTilt = tilt16 / 65535f * 270f - 225f;
    }

    // ── Couleurs ─────────────────────────────────────────────────────────────

    private static int multiply(int a, int b) {
        int r = ((a >> 16) & 0xFF) * ((b >> 16) & 0xFF) / 255;
        int g = ((a >> 8) & 0xFF) * ((b >> 8) & 0xFF) / 255;
        int bl = (a & 0xFF) * (b & 0xFF) / 255;
        return (r << 16) | (g << 8) | bl;
    }

    private static int mix(int a, int b, float t) {
        int r = Math.round(((a >> 16) & 0xFF) + (((b >> 16) & 0xFF) - ((a >> 16) & 0xFF)) * t);
        int g = Math.round(((a >> 8) & 0xFF) + (((b >> 8) & 0xFF) - ((a >> 8) & 0xFF)) * t);
        int bl = Math.round((a & 0xFF) + ((b & 0xFF) - (a & 0xFF)) * t);
        return (r << 16) | (g << 8) | bl;
    }
}
