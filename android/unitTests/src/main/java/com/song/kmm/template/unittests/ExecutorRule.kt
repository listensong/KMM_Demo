package com.song.kmm.template.unittests

import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 *  @author HelloWorld
 *  ExecutorRule
 */
@Suppress("unused")
class ExecutorRule : TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
    }

    override fun finished(description: Description?) {
        super.finished(description)
    }
}