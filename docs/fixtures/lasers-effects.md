# Lasers & effects

## Laser (`laser`)

A pattern laser with three colour groups and a client-side persistence trail. Single personality **19-Channel Mode**. Usage and the emergency stop are described in [Lasers & emergency stop](/guide/lasers).

| Ch | Function | Values |
|---|---|---|
| 1 | Intensity | 0 off to 255 |
| 2 | Colour 1 Red | |
| 3 | Colour 1 Green | |
| 4 | Colour 1 Blue | |
| 5 | Colour 2 Red | |
| 6 | Colour 2 Green | |
| 7 | Colour 2 Blue | |
| 8 | Colour 3 Red | |
| 9 | Colour 3 Green | |
| 10 | Colour 3 Blue | |
| 11 | Pattern | See table below |
| 12 | Size | 0 to 255 |
| 13 | Amplitude | 0 to 255 |
| 14 | Speed | 0 to 255; below about 5 % the animation is frozen |
| 15 | Rotation | 0 to 255 = 0° to 360° static rotation |
| 16 | Pan | 0 to 255 = −80° to 80° |
| 17 | Tilt | 0 to 255 = 45° to −45°, centred on 127 |
| 18 | Focus | 0 to 255 |
| 19 | Persistence | 0 to 255, length of the trail |

The pattern is drawn with a gradient from colour 1 through colour 2 to colour 3. Colour groups left at 0 fall back to the previous group.

### Patterns (channel 11)

| Values | Pattern |
|---|---|
| 0 to 17 | Single beam |
| 18 to 35 | Line |
| 36 to 53 | Circle |
| 54 to 71 | Square |
| 72 to 89 | Wave |
| 90 to 107 | Tunnel |
| 108 to 125 | Star |
| 126 to 143 | Cross |
| 144 to 161 | Triangle |
| 162 to 179 | Spiral |
| 180 to 197 | Parallel lines |
| 198 to 215 | Double circle |
| 216 to 233 | Burst |
| 234 to 255 | Scatter |

### Emergency stop

The laser screen has an **EMERGENCY STOP** control. Engaged, the output is blocked whatever the DMX, the state is saved with the world and shown to every player, and the button becomes **Re-arm laser output**.

### Related config

`laserBeamLength` and `laserPassThroughBlocks` in the [config file](/guide/config-file).

## Laser Mirror (`laser_mirror`)

Reflects laser beams. **5-Channel Mode**: 1 Intensity, 2 Red, 3 Green, 4 Blue, 5 Focus. It emits no light of its own.
