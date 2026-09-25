#!/system/bin/sh
MODDIR=${0%/*}

# Wait for boot completion
while [ "$(getprop sys.boot_completed)" != "1" ]; do
    sleep 2
done

# Restart audioserver to hook the newly patched audio_effects.xml and libs
setprop ctl.restart audioserver

sleep 2

# Check if dms-hal-2-0 is running (it should be started by magisk injecting the rc file)
# If not, start it manually just in case
if ! pidof vendor.dolby.hardware.dms@2.0-service > /dev/null; then
    /vendor/bin/hw/vendor.dolby.hardware.dms@2.0-service &
fi
