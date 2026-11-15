#!/usr/bin/env python3
"""Read-only inventory of a firmware ZIP; does not extract or modify files."""

import argparse
import hashlib
import sys
import zipfile
from pathlib import Path


def sha256_file(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for chunk in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("archive", type=Path, help="Path to stock firmware ZIP")
    args = parser.parse_args()

    if not args.archive.is_file():
        print(f"ERROR: file not found: {args.archive}", file=sys.stderr)
        return 2

    print(f"File: {args.archive}")
    print(f"Size: {args.archive.stat().st_size} bytes")
    print(f"SHA256: {sha256_file(args.archive)}")

    if not zipfile.is_zipfile(args.archive):
        print("The file is not a ZIP archive (or uses another firmware container).")
        return 1

    with zipfile.ZipFile(args.archive) as archive:
        entries = archive.infolist()
        print(f"ZIP entries: {len(entries)}")
        for entry in entries:
            print(f"{entry.file_size:12d}  {entry.filename}")

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
