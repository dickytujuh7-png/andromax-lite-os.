# Build plan

## Phase 0 — Firmware identification (not started)

1. Locate the original stock firmware archive.
2. Record SHA-256 and archive listing.
3. Identify firmware format and platform.
4. Extract only to a controlled working directory.
5. Read build properties, partition metadata, boot image header, kernel and ramdisk metadata.
6. Confirm whether the device is Android-based, KaiOS-based, or another platform.

**Exit condition:** verified device/platform profile and a reproducible firmware inventory.

## Phase 1 — Feasibility and base selection

- Select the safest compatible base: modify stock firmware where possible rather than attempting an unsupported platform port.
- Confirm bootloader/recovery constraints and available restore procedure.
- Identify proprietary components required for radio, audio, camera, Wi-Fi, and flashlight.
- Establish a minimal bootable baseline.

**Exit condition:** documented build path with known required blobs and partition limits.

## Phase 2 — Minimal system

- Remove only verified nonessential components.
- Preserve telephony and hardware services.
- Tune memory use conservatively for 512 MB RAM.
- Keep the image within the 200 MB goal only if the base and required components allow it.

**Exit condition:** repeatable build and boot test.

## Phase 3 — Keypad-first interface

- Implement a three-column app grid.
- Define directional navigation, select, back, call/end and soft-key behavior.
- Ensure focus is always visible and no core flow requires touch.
- Add accessible settings and status indicators.

**Exit condition:** launcher and core navigation fully operable with physical keys.

## Phase 4 — Hardware validation

Test flashlight, display, keypad, audio, microphone, camera, Wi-Fi, Bluetooth, cellular calls/data, SMS, battery reporting, charging, and sleep/wake.

**Exit condition:** results recorded per feature; no unverified feature described as working.

## Phase 5 — Release candidate

- Verify image integrity and partition sizes.
- Document installation and recovery steps for the exact variant.
- Keep stock firmware backup and checksums.
- Publish test notes and known issues.

## Current blockers

- Stock firmware archive has not yet been made available to the build workspace in this repository.
- SoC, platform, partition map, boot format, and kernel are unverified.
- No build system or bootable image has been produced yet.
