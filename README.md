# Andromax Lite OS

Custom lightweight operating-system project for the Smartfren Andromax Prime (target model F17A1H).

> **Status: project scaffold only.** No bootable ROM has been built or tested yet. Hardware identifiers, partition layout, boot image format, kernel compatibility, and the exact base firmware still need verification from the original firmware.

## Goals

- Target device: Smartfren Andromax Prime, model F17A1H (recovery has also been reported as F17ALH; relationship unverified).
- Target memory: 512 MB RAM.
- ROM size goal: at most 200 MB, if the verified base platform permits it.
- Keypad-first operation: all menus and apps must be usable without a touchscreen.
- Launcher: three-column application grid inspired by feature-phone interfaces.
- Preserve working flashlight functionality.
- Keep background services and bundled apps minimal.

## Repository map

- `device/` — verified device-specific configuration and hardware notes.
- `docs/` — architecture, compatibility, build, and test records.
- `config/` — project targets and feature policy.
- `tools/` — host-side inspection utilities.
- `vendor/` — device/vendor files extracted from a legally obtained stock firmware (not committed until reviewed).

## Current next step

Obtain and inspect the stock F17A1H firmware. Record its checksum, archive contents, build properties, partition metadata, boot image format, kernel version, and Android/KaiOS/Linux base before choosing a build strategy.

See [BUILD_PLAN.md](docs/BUILD_PLAN.md) and [DEVICE_PROFILE.md](docs/DEVICE_PROFILE.md).

## Safety and integrity

Do not flash experimental images until they have been checked against the exact device variant and a recovery path is available. Keep the original firmware and verified backups untouched.
