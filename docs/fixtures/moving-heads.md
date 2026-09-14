# Moving heads & beams

Conventional moving heads without a gobo wheel. For the eight gobo heads see [Gobo moving heads](/fixtures/gobo-heads).

## 7ch / 10ch heads

These eleven fixtures share two personalities, **7ch - Standard** and **10ch - Extended**:

| Fixture | Registry id |
|---|---|
| Moving VL6 | `moving_vl6` |
| Moving VL2 | `moving_vl2c` |
| Moving Beam | `moving_beam` |
| Moving Scan | `moving_scan` |
| Beam 7R | `beam_7r` |
| Mac Vip | `mac_vip` |
| Sharplus | `sharplus` |
| Moving 500 | `moving500` |
| Robit Spot | `robitspot` |
| Verve Spot | `vervespot` |
| Searchlight | `searchlight` |

### 7ch - Standard

| Ch | Function | Values |
|---|---|---|
| 1 | Intensity | 0 to 255 |
| 2 | Red | |
| 3 | Green | |
| 4 | Blue | |
| 5 | Focus | 0 tight to 255 wide |
| 6 | Pan | −180° to 180° |
| 7 | Tilt | −225° to 45° |

### 10ch - Extended

Channels 1 to 7 as above, then:

| Ch | Function | Values |
|---|---|---|
| 8 | Prism / gobo select | 0 to 255 |
| 9 | Prism zoom | 0 to 255 |
| 10 | Prism rotation | 0 stop, 1 to 255 speed |

The Mac Vip draws its slot 8 from its own gobo wheel and accepts [custom gobos](/guide/custom-gobos).

## 7ch only heads

Same 7-channel layout, single personality **7-Channel Mode**:

| Fixture | Registry id |
|---|---|
| VL 6000 | `vl6000` |
| Wash FX648 | `washlight` |
| Wash LED | `washled` |
| Mini Wash | `miniwash` |
| Moving Bar | `moving_bar` |

## Atomic Tilt (`atomictilt`)

A tilt-only strobe head, no pan.

**6-Channel RGB + Focus + Tilt**

| Ch | Function |
|---|---|
| 1 | Intensity |
| 2 | Red |
| 3 | Green |
| 4 | Blue |
| 5 | Focus |
| 6 | Tilt |

**7-Channel RGB + Focus + Strobe + Tilt**: channels 1 to 5 as above, 6 Strobe (0 closed, 1 to 254 strobe, 255 open), 7 Tilt.

## Moving Mini Bar (`moving_mini_bar`)

Seven beams on a tilting bar.

**5ch - Unite Beam**: all beams together.

| Ch | Function |
|---|---|
| 1 | Intensity |
| 2 | Tilt |
| 3 | Red |
| 4 | Green |
| 5 | Blue |

**35ch - Alone Beam**: the same five channels repeated for beams 1 to 7 (1 to 5 beam 1, 6 to 10 beam 2, … 31 to 35 beam 7).

## Moving Panel Par64 DWT (`dwt_panel`)

**6-Channel Mode**

| Ch | Function | Values |
|---|---|---|
| 1 | Section 1 | |
| 2 | Section 2 | |
| 3 | Section 3 | |
| 4 | Section 4 | |
| 5 | Warm section | Tinted warm white |
| 6 | Pan | 0 to 255 = 0° to 360° |
