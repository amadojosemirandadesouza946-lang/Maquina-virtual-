Aurora Roleplay Launcher - minimal Android Studio project
--------------------------------------------------------
- Location: /mnt/data/aurora_launcher_project
- To build (example from project root using terminal/VM):
    1) Install Android SDK & JDK 17 and set ANDROID_HOME / PATH.
    2) Open a terminal in /mnt/data/aurora_launcher_project/AuroraLauncher and run: ./gradlew :app:assembleDebug
    3) The APK will be at app/build/outputs/apk/debug/app-debug.apk (if wrapper and SDK set up).

Notes:
- This project is a lightweight starter focused on UI. The Play button attempts to open a samp:// URI
  (samp://188.165.192.24:5644). If no app handles it, a dialog offers to open a fallback web URL.
- Replace FALLBACK_URL in MainActivity.kt with your real streaming endpoint if you have one.
- The provided image was used as background (if available).
- Orientation is locked to landscape.