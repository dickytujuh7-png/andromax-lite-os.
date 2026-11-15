# Device profile

## Confirmed project requirements

| Item | Value | Confidence |
|---|---|---|
| Manufacturer | Smartfren | User-provided |
| Device name | Andromax Prime | User-provided |
| Target model | F17A1H | User-provided |
| Recovery identifier | F17ALH | Previously reported; not yet reconciled with F17A1H |
| RAM target | 512 MB | User-provided project target |
| Storage | Not yet verified | Unknown |
| Input | Physical keypad | Required |
| Flashlight | Must remain functional | Required |

## Must be collected from stock firmware/device

- Exact SoC and board/platform identifier.
- CPU architecture and ABI.
- Kernel version and configuration.
- OS family/version and build fingerprint.
- Boot image format, page size, header version, and ramdisk format.
- Partition names, sizes, filesystem types, and mount points.
- Device tree / DTB / DTBO details, if present.
- Display resolution, input key layout, audio, camera, Wi-Fi, cellular, GPS, and flashlight interfaces.
- Verified firmware checksum and source.

## Compatibility rule

Do not assume F17A1H and F17ALH are interchangeable. Treat them as separate identifiers until stock build properties, partition metadata, and hardware identifiers establish their relationship.
