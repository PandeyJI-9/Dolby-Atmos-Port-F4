# 🎧 Dolby Atmos Port for Poco F4 (Munch)

![Android 16](https://img.shields.io/badge/Android-16-green.svg)
![HyperOS 3](https://img.shields.io/badge/HyperOS-3-orange.svg)
![Status](https://img.shields.io/badge/Status-Stable%20%26%20Tested-brightgreen.svg)
![Magisk](https://img.shields.io/badge/Magisk-Module-blue.svg)

Welcome to the ultimate **Dolby Atmos Hardware Port** specifically optimized and tuned for the **Poco F4 (Munch)**. 

This repository provides a deeply integrated, zero-latency audio solution that brings back the authentic, rich, and punchy Dolby Atmos sound on ported ROMs, specifically resolving audio degradation on **HyperOS 3 (Android 16)**.

---

## 🌟 Key Features

* **True Hardware DSP Processing:** Hooks directly into the Snapdragon Hexagon DSP via `vendor.dolby.hardware.dms@2.0-service`. This ensures **Zero Audio Delay** (perfect for BGMI/PUBG/CoD) and zero background RAM overhead.
* **Tested on HyperOS 3:** Fully verified on Android 16 (HyperOS 3 ports). 
* **VNDK 33 Bypass:** Native Android 13 (`v33`) binaries have been meticulously ELF-patched to link against Android 16's native `libstagefright_foundation.so`. This guarantees **No Bootloops** and **No Crashes**.
* **Advance System Persistence:** The audio effect state is injected directly into the HAL. Even if the Dolby App is Force Stopped or cleared from memory, your tuned EQ and Dolby profile will **never stop** until you reboot. Super smooth quality, always!
* **Golden Tuning:** Includes the authentic `dax-default.xml` tailored for Poco F4's AW88261 Smart PAs, seamlessly handling landscape/portrait dual-speaker rotation.

---

## 📁 Repository Structure

### 1. `Magisk-Module/`
Contains the flashable zip (`Dolby-Atmos-PocoF4-HyperOS3.zip`) and the raw module files. 
* Automatically patches your `audio_effects.xml`.
* Injects necessary `sepolicy.rule` for Android 16 permissions.
* Configures `service.sh` for seamless initialization on boot.

### 2. `App-Source/`
The complete Kotlin/Jetpack Compose source code for the standalone **Lunaris Dolby App**.
* Modified to run without system signature constraints (`sharedUserId` removed).
* Includes GitHub Actions workflow for automatic APK compilation on the cloud (no local Android Studio required).
* Features custom UI modifications and credits.

---

## 🚀 Installation & Usage

### Flashing the Magisk Module
1. Download `Dolby-Atmos-PocoF4-HyperOS3.zip` from the `Magisk-Module` folder (or the Releases tab).
2. Open **Magisk**, **KernelSU**, or **APatch**.
3. Go to Modules -> **Install from Storage**.
4. Select the Zip file and flash.
5. **Reboot** your device.
6. *HyperOS Native Integration:* You can now go to `Settings -> Sound & Vibration -> Sound Effects` and use the native MiSound interface to control Dolby!

### Compiling the Standalone App (Optional)
If you wish to use the dedicated App UI instead of the native HyperOS Settings:
1. Fork or push this repository to your GitHub account.
2. Go to the **Actions** tab in your repository.
3. Click on the **Build Lunaris Dolby APK** workflow.
4. Click **Run workflow**.
5. Within 2-3 minutes, GitHub will compile the app and provide an `app-debug.apk` artifact for you to download and install!

---

## 👨‍💻 Developer & Credits

* **Modified & Developed by:** [@pandey_ji_8](https://t.me/pandey_ji_8) (Telegram)
* **Testing & Tuning:** Extensively tested on Poco F4 (munch) running HyperOS 3.

*Enjoy the ultimate, immersive sound experience on your Poco F4!* 🚀
