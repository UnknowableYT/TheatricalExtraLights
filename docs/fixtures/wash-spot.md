# Wash, spot & followspot

## Source Four (`source_four`) and Source Four Warm (`source_four_warm`)

Fixed profile spots.

- **Source Four**: *4-Channel Mode*: 1 Intensity, 2 Red, 3 Green, 4 Blue.
- **Source Four Warm**: *1-Channel Mode*: 1 Intensity, fixed warm white.

## Followspot (`followspot`)

The fixture the [Followspot Console](/guide/followspot) is made for. **7-Channel Mode**:

| Ch | Function | Values |
|---|---|---|
| 1 | Intensity | |
| 2 | Red | |
| 3 | Green | |
| 4 | Blue | |
| 5 | Focus | |
| 6 | Pan | 0 to 255 = −90° to 90° |
| 7 | Tilt | 0 to 255 = −45° to 45° |

Note the narrower pan and tilt range compared with the moving heads; it matches a followspot on a stand.

## LED Fountain (`led_fountain`)

**3-Channel Mode**: 1 Red, 2 Green, 3 Blue. There is no dimmer: intensity is the brightest of the three channels.

## Invisible Light (`invisiblelight`)

A 25-block light source with no visible body, for lighting scenery from an impossible place. **4-Channel Mode**: 1 Intensity, 2 Red, 3 Green, 4 Blue.

## Scrollers

Colour scrollers with a fixed wash beam.

| Fixture | Registry id | Personality |
|---|---|---|
| Big Scroller | `bigscroller` | 4-Channel Mode: Intensity, R, G, B |
| Horizontal Scroller | `horizontalscroller` | 4-Channel Mode |
| Vertical Scroller | `verticalscroller` | 4-Channel Mode |
| Par64 Scroller | `parscroller` | 2-Channel Mode, see below |

**Par64 Scroller, 2-Channel Mode**

| Ch | Function | Values |
|---|---|---|
| 1 | Intensity | |
| 2 | Gel position | 0 to 255 cross-fades through 8 gels: red, green, blue, yellow, magenta, cyan, orange, white |
