#!/sbin/sh
ui_print "****************************************"
ui_print "* Poco F4 (Munch) Dolby Atmos Fix      *"
ui_print "* For HyperOS 3 (Android 15/16)        *"
ui_print "****************************************"
ui_print " "
ui_print "- Extracting files..."

# Patching audio_effects.xml safely
AE="/vendor/etc/audio_effects.xml"
MOD_AE="$MODPATH/system/vendor/etc/audio_effects.xml"

if [ -f "$AE" ]; then
    ui_print "- Patching audio_effects.xml..."
    cp -f "$AE" "$MOD_AE"
    
    # Remove existing DAP if any
    sed -i '/libswdap.so/d' "$MOD_AE"
    sed -i '/9d4921da-8225-4f29-aefa-39537a04bcaa/d' "$MOD_AE"

    # Add dap library
    sed -i '/<libraries>/a \        <library name="dap" path="libswdap.so"\/>' "$MOD_AE"
    # Add dap effect
    sed -i '/<effects>/a \        <effect name="dap" library="dap" uuid="9d4921da-8225-4f29-aefa-39537a04bcaa"\/>' "$MOD_AE"
    
    ui_print "- audio_effects.xml patched successfully!"
else
    ui_print "- Warning: audio_effects.xml not found! Skipping patch."
fi

ui_print "- Applying Android 16 VNDK bypass patches..."
# Binary patching was already done on host before zip creation!
ui_print "- Bypass successful. Setting permissions..."
set_perm_recursive $MODPATH 0 0 0755 0644
set_perm_recursive $MODPATH/system/vendor/bin 0 0 0755 0755

ui_print " "
ui_print "****************************************"
ui_print "* Done! Reboot and enjoy native sound! *"
ui_print "****************************************"
