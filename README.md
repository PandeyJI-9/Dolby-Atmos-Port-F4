# 🎧 Dolby Atmos Port for Poco F4 (Munch)

![Android 16](https://img.shields.io/badge/Android-16-green.svg)
![HyperOS 3](https://img.shields.io/badge/HyperOS-3-orange.svg)
![Status](https://img.shields.io/badge/Status-Stable%20%26%20Tested-brightgreen.svg)
![Magisk](https://img.shields.io/badge/Magisk-Module-blue.svg)

Welcome to the ultimate **Dolby Atmos Hardware Port** specifically optimized and tuned for the **Poco F4 (Munch)**. 

This repository provides a deeply integrated, zero-latency audio solution that brings back the authentic, rich, and punchy Dolby Atmos sound on ported ROMs, specifically resolving audio degradation on **HyperOS 3 (Android 16)**.

---

## 📥 Downloads (Ready-Made)

* 📦 **[Download Magisk Module (Dolby-Atmos-PocoF4-HyperOS3.zip)](https://github.com/PandeyJI-9/Dolby-Atmos-Port-F4/releases/latest/download/Dolby-Atmos-PocoF4-HyperOS3.zip)**
* 📱 **[Download Dolby UI App (LunarisDolby-v1.0.apk)](https://github.com/PandeyJI-9/Dolby-Atmos-Port-F4/releases/latest/download/LunarisDolby-v1.0.apk)**

---

## 🌟 Key Features

* **True Hardware DSP Processing:** Hooks directly into the Snapdragon Hexagon DSP via `vendor.dolby.hardware.dms@2.0-service`. This ensures **Zero Audio Delay** (perfect for BGMI/PUBG/CoD) and zero background RAM overhead.
* **Tested on HyperOS 3:** Fully verified on Android 16 (HyperOS 3 ports). 
* **VNDK 33 Bypass:** Native Android 13 (`v33`) binaries have been meticulously ELF-patched to link against Android 16's native `libstagefright_foundation.so`. This guarantees **No Bootloops** and **No Crashes**.
* **Advance System Persistence:** The audio effect state is injected directly into the HAL. Even if the Dolby App is Force Stopped or cleared from memory, your tuned EQ and Dolby profile will **never stop** until you reboot. Super smooth quality, always!
* **Golden Tuning:** Includes the authentic `dax-default.xml` tailored for Poco F4's AW88261 Smart PAs, seamlessly handling landscape/portrait dual-speaker rotation.

---

## 🚀 Installation & Usage

### 1. Flashing the Magisk Module (Required)
1. Download the Magisk Module Zip from the Downloads section above.
2. Open **Magisk**, **KernelSU**, or **APatch**.
3. Go to Modules -> **Install from Storage**.
4. Select the Zip file and flash.
5. **Reboot** your device.
*(Note: Once installed, you can natively control Dolby from `Settings -> Sound & Vibration -> Sound Effects` without any extra app if you prefer!)*

### 2. Installing the Standalone App (Optional)
If you want the dedicated advanced UI to control Dolby instead of the system settings:
1. Download the `LunarisDolby-v1.0.apk` from the Downloads section above.
2. Install the APK normally.
3. Open the app and grant necessary permissions.
4. Enjoy full control over Equalizer, Dialogue Enhancer, and Profiles!

---

## 👨‍💻 Developer & Credits

* **Modified & Developed by:** [@pandey_ji_8](https://t.me/pandey_ji_8) (Telegram)
* **Testing & Tuning:** Extensively tested on Poco F4 (munch) running HyperOS 3.

*Enjoy the ultimate, immersive sound experience on your Poco F4!* 🚀
