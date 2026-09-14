# Blinders & strobes

## Blinders

| Fixture | Registry id | Personality |
|---|---|---|
| Blinder 4x2 | `blinder` | 4-Channel iRGB |
| 2x2 Blinder | `blinder2x2` | 4-Channel iRGB |
| Blinder 1x1 | `blinder1x1` | 5-Channel iRGB + Strobe |
| Blinder (warm) | `blinder_warm` | 1-Channel Mode |
| 2x2 Blinder (Warm) | `blinder2x2warm` | 1-Channel Mode |

**4-Channel iRGB**: 1 Intensity, 2 Red, 3 Green, 4 Blue.

**5-Channel iRGB + Strobe**: channels 1 to 4 as above, 5 Strobe: 0 closed, 1 to 254 strobe slow to fast, 255 open.

**1-Channel Mode**: 1 Intensity, fixed warm colour.

Blinders light their face and throw a warm or coloured light on the ground in front of them.

## Strobe (`strobe`)

Four personalities.

**4-Channel Legacy**: 1 Intensity, 2 Red, 3 Green, 4 Blue. Always open.

**5-Channel Focus**: channels 1 to 4, then 5 Focus: 1 gives a spot of about 3 blocks on the ground, 255 about 20 blocks.

**6-Channel Focus + Strobe**: channels 1 to 5, then 6 Strobe: 0 closed, 1 to 254 strobe slow to fast, 255 open.

**3-Channel Strobe RGB Only**: 1 Red, 2 Green, 3 Blue. Intensity and focus are fixed and the shutter is always open: the fixture fires continuously and you only pick the colour.

## White Strobe (`white_strobe`)

**1-Channel Mode**: 1 Intensity.

## Atomic Strobe (`atomic_strobe`)

A large LED strobe with eight RGB zones and a nine-segment white bar. Single personality **34-Channel Atomic**:

| Ch | Function |
|---|---|
| 1 to 3 | Zone 1 Red, Green, Blue |
| 4 to 6 | Zone 2 R, G, B |
| 7 to 9 | Zone 3 R, G, B |
| 10 to 12 | Zone 4 R, G, B |
| 13 to 15 | Zone 5 R, G, B |
| 16 to 18 | Zone 6 R, G, B |
| 19 to 21 | Zone 7 R, G, B |
| 22 to 24 | Zone 8 R, G, B |
| 25 to 33 | White bar segments 1 to 9 |
| 34 | Focus, 1 to 255 |

The dynamic light takes the brightest emitter as intensity and an intensity-weighted mix of all lit emitters as colour, with the white bar weighted heavier. The fixture stands on a floor plate with a tilting yoke.
