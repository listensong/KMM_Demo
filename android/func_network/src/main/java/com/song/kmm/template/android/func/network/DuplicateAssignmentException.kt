package com.song.kmm.template.android.func.network

class DuplicateAssignmentException(
    message: String
) : RuntimeException("$message, should be assignment only once") {}