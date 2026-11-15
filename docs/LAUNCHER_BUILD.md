# Andromax Lite Launcher v0.1

A keypad-first, three-column Android launcher prototype targeting Android 4.4.4 (API 19).

## Build
GitHub Actions workflow: `.github/workflows/build-launcher.yml`.
It builds a debug APK using JDK 17, Gradle 8.2.1 and Android SDK 34. The app retains minSdk 19 and targetSdk 28.

## Controls
- D-pad: move selection
- Center / Enter: launch selected app
- Number keys 1-9: launch first nine apps
- Menu: refresh app list

## Important
This is a standalone prototype, not a replacement for the stock SimpleHome yet. Install/test it separately first. Do not delete or overwrite SimpleHome until tested on the exact F17A1H handset. APK signing/build success does not prove hardware compatibility.
