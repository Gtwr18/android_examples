package com.example.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The activity is being created.
    }

    override fun onStart() {
        super.onStart()
        // The activity is about to become visible.
    }

    override fun onResume() {
        super.onResume()
        // The activity has become visible (it is now "resumed").
    }

    override fun onPause() {
        super.onPause()
        // Another activity is taking focus (this activity is about to be "paused").
    }

    override fun onStop() {
        super.onStop()
        // The activity is no longer visible (it is now "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        // The activity is about to be destroyed.
    }
}