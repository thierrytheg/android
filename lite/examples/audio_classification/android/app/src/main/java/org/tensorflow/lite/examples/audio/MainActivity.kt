/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tensorflow.lite.examples.audio

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.audio.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)



        val file = File("/storage/emulated/0/Android/data/tensorflow_audio/audio_tracking.txt")


        if (!file.exists())
        {
            file.createNewFile()
            //val data: String = "time,label,score,\n"
            val data: String = "time_label_score_db_status\n"

            file.appendText("$data")

        }

    }


    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }


}
