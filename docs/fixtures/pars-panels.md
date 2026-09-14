# PARs & LED panels

## Single-colour PARs (1 channel)

All of these use **1-Channel Mode**: channel 1 is intensity, the colour is fixed by the block.

| Family | Colours | Registry ids |
|---|---|---|
| Par 1000 | white, red, blue, green, magenta, amber, orange, purple, light blue | `par1000`, `par1000_red`, `par1000_blue`, `par1000_green`, `par1000_magenta`, `par1000_amber`, `par1000_orange`, `par1000_purple`, `par1000_lightblue`, `par1000_white` |
| Par56 | red, green, blue, orange, magenta, light blue, purple, white, warm, yellow | `par56_red` … `par56_yellow` |
| x8 Par64 bar | red, green, blue, magenta, light blue, yellow, white, purple, warm, orange | `x8par_red` … `x8par_orange` |
| 2x2 Par64 block | red, green, blue, magenta, light blue, purple, orange, yellow, warm, white | `a2x2par64_red` … `a2x2par64_white` |

The Par56 family projects a soft wash texture; it is not DMX-controllable.

## Colour-preset arrays

| Fixture | Registry id |
|---|---|
| 2x2 Par64 (Color Preset) | `a1x1par64` |
| 2x8 Par64 (Color Preset) | `a2x8par64` |
| 6x3 Par64 Vertical (Color Preset) | `a6x3par64_vertical` |

Ten personalities each: nine **1-channel** colour presets (Red, Green, Blue, Yellow, Orange, Purple, Magenta, Lightblue, White: channel 1 intensity) and **iRGB**, 4 channels: 1 Intensity, 2 Red, 3 Green, 4 Blue.

## RGB panels and bars (4 channels)

**4-Channel Mode**: 1 Intensity, 2 Red, 3 Green, 4 Blue.

| Fixture | Registry id |
|---|---|
| LED Par | `par_led` |
| LED Panel 2 | `led_panel_2` |
| Big Panel 3x3 | `big_panel` |
| Big Panel 3x2 | `big_panel2` |
| RGB Bar | `rgb_bar` |
| Vertical RGB Bar | `vertical_bar` |
| Mini RGB Bar | `mini_bar` |
| Truss 3x3 Lights | `truss_3lights` |

The RGB bars glow over a distance set by `rgbBarBeamLength` in the [config file](/guide/config-file).

## LED Facade (`led_facade`)

A pixel-mapped wall. Right-click opens a canvas where you paint the lit pixels with a brush of 1, 2, 3 or 5 pixels, choose the **resolution** (16, 32, 64, 128 or 256), the **smoothing** (Sharp, Soft, Very soft), the universe, address and network. The footprint line reads `N px · N ch · N universe(s)`.

Each lit pixel takes **4 channels** in row-major order, spilling into the next universe every 512 channels, up to `ledFacadeMaxUniverses` (default 64):

| Ch | Function |
|---|---|
| 1 | Pixel dimmer |
| 2 | Pixel red |
| 3 | Pixel green |
| 4 | Pixel blue |

Map it on the console as a pixel bar or LED matrix with 4-channel RGB pixels. The facade emits one aggregated coloured light in front of the wall.
