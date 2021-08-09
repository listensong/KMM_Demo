package com.song.kmm.template

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}