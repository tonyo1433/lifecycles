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

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView

import com.example.android.codelabs.lifecycle.R


class ChronoActivity3 : AppCompatActivity() {

    private var mLiveDataTimerViewModel: LiveDataTimerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.chrono_activity_3)

        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)

        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long> { aLong ->
            val newText = this@ChronoActivity3.resources.getString(
                    R.string.seconds, aLong)
            (findViewById<View>(R.id.timer_textview) as TextView).text = newText
            Log.d("ChronoActivity3", "Updating timer")
        }

        //TODO: observe the ViewModel's elapsed time
    }
}
