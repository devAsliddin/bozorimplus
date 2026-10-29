BOZORIM ONLAYN DO‘KON — ANDROID LOYIHA (APK qilish)
======================================
Kerak: Android Studio (bepul) — https://developer.android.com/studio

DEBUG APK (telefonga o'rnatish uchun, eng oson):
1. Android Studio -> File -> Open -> shu papkani (BozorimPlus_Android) tanlang.
2. Gradle sync tugashini kuting (birinchi marta internet kerak, 3-10 daqiqa).
3. Menyu: Build -> Build Bundle(s) / APK(s) -> Build APK(s).
4. "locate" bosing. Fayl: app/build/outputs/apk/debug/app-debug.apk
5. APK ni telefonga yuboring va o'rnating ("noma'lum manbalardan" ruxsat bering).

Telefonda to'g'ridan-to'g'ri sinash: telefonni USB bilan ulang (USB debugging yoqilgan) va yashil Run ▶ tugmasini bosing.

SAYTNI O'ZGARTIRISH: faqat shu faylni tahrirlang:
app/src/main/assets/index.html
Keyin APK ni qayta yig'ing.

SAYTNI BRAUZERDA KO'RISH: ../BozorimPlus_Website/index.html ni oching.


ANDROID STUDIOSIZ APK (GitHub orqali, bepul):
1. github.com da akkaunt oching va yangi repository yarating.
2. Shu papkadagi hamma fayllarni (".github" papkasi bilan) repository'ga yuklang.
   Agar ".github" yuklanmasa: Add file -> Create new file, nomiga
   .github/workflows/build.yml yozing va build.yml faylining matnini joylang.
3. Repository'da "Actions" bo'limiga kiring, "APK yigish" ishga tushishini kuting (3-5 daqiqa).
4. Tugagach ishga tushish ustiga bosing, pastdagi "Artifacts" dan
   BozorimOnlaynDokon-apk ni yuklab oling (zip ichida app-debug.apk).
