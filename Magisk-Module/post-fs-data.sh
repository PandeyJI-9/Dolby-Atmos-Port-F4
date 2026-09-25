#!/system/bin/sh
MODDIR=${0%/*}
mkdir -p /data/vendor/dolby
chown -R media:media /data/vendor/dolby
chmod -R 0770 /data/vendor/dolby
mkdir -p /data/vendor/multimedia
chown -R system:system /data/vendor/multimedia
chmod -R 0775 /data/vendor/multimedia
