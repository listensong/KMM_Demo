package com.song.kmm.template.network

class DuplicateAssignmentException(
    message: String
) : RuntimeException("$message, should be assignment only once.")