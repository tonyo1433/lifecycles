/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step3

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock

import java.util.Timer
import java.util.TimerTask

/**
 * A ViewModel used for the [ChronoActivity3].
 */
class LiveDataTimerViewModel : ViewModel() {

    private val mElapsedTime = MutableLiveData<Long>()

    private val mInitialTime: Long

    // Will be used when step is completed
    val elapsedTime: LiveData<Long>
        get() = mElapsedTime

    init {
        mInitialTime = SystemClock.elapsedRealtime()
        val timer = Timer()

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000

                // setValue() cannot be called from a background thread so post to main thread.
                //TODO post the new value with LiveData.postValue()
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())

    }

    companion object {

        private val ONE_SECOND = 1000
    }
}
