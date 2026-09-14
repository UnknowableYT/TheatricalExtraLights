# Water jets

Fountain effects for water shows. Almost all of them are **1 channel**: channel 1 is the jet level (0 off, 255 full). Their geometry is not on DMX: right-click a jet to set its **height**, **thickness** and, on cone jets, the **cone angle** in the fixture screen.

![Water jet screen](/images/water-jet-screen.png)

## Single-channel jets

| Fixture | Registry id | Adjustable in the screen |
|---|---|---|
| Water Jet (25 m) | `water_jet` | fixed |
| Water Jet 1 (Adjustable) | `water_jet_thin` | height, thickness |
| Water Jet 2 (Adjustable) | `water_jet_spread` | height, thickness |
| Conifer Water Jet | `water_jet_big` | height, thickness |
| Central Water Jet | `water_jet_central` | height, thickness |
| Water Jet Cone | `water_jet_cone` | height, thickness, cone angle |
| Bloom Jet | `water_jet_bloom` | height, thickness, cone angle |
| Fog Cone Jet | `water_jet_fog` | height, thickness, cone angle |
| Fan Water Jet | `fan_water_jet` | height, thickness |
| Wedding Cake Water Jet | `cake_water_jet` | height, thickness |
| Vase Water Jet | `vase_water_jet` | height, thickness |
| Spinner | `spinner` | height, thickness |
| Organ Pipes | `organpipes` | height, thickness, spread |
| Organ Pipes Inverted | `organpipes_inv` | height, thickness |

## Moving Jet (`moving_jet`)

A jet on a pan/tilt head. **3-Channel Mode**:

| Ch | Function | Values |
|---|---|---|
| 1 | Jet level | |
| 2 | Pan | 0 to 255 = −180° to 180° |
| 3 | Tilt | 0 to 255 = −90° to 90° |

Height, thickness and spread are set in the screen.

## Waltzes and Waltz Curtain

**9 Waltzes Water Jets** (`waltzes_water_jet`) and **Waltz Curtain Water Jets** (`waltz_curtain`) swing their jets. Three channels (the mode label still reads *2-Channel Mode*; the footprint is 3):

| Ch | Function |
|---|---|
| 1 | Jet level |
| 2 | Tilt |
| 3 | Swing speed |
