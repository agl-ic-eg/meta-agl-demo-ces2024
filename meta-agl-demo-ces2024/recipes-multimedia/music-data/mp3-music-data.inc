DEPENDS = "python3-eyed3-native"

# Tag Data
MP3_MUSIC_DATA_ARTWORK ??= "artwork.jpg"
MP3_MUSIC_DATA_TITLE ??= "Title"
MP3_MUSIC_DATA_AIRTIST ??= "Artist"
MP3_MUSIC_DATA_ALBUM ??= "Album"

SRC_URI:append = " file://${MP3_MUSIC_DATA_ARTWORK}"

EYED3_OPTIONS = " \
    --remove-all-images --add-image='${S}/${MP3_MUSIC_DATA_ARTWORK}:FRONT_COVER' \
    -t '${MP3_MUSIC_DATA_TITLE}' \
    -a '${MP3_MUSIC_DATA_AIRTIST}' \
    -A '${MP3_MUSIC_DATA_ALBUM}' \
    "

# Extra options
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
ERROR_QA:remove = "empty-dirs"
