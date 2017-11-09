package de.max.flashlight

import android.annotation.TargetApi
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Policy
import android.hardware.camera2.CameraManager
import android.os.Build
import android.support.annotation.RequiresApi


class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    closeButton.setOnClickListener {
        this.finishAffinity()
    }

        this.packageManager

         var isFlashLightOn = false

        val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = camManager.cameraIdList[0] // Usually front camera is at 0 position.



            imageButtonFlashlight.setOnClickListener {


                if (isFlashLightOn == false) {
                    imageButtonFlashlight.setImageResource(R.drawable.ic_flashlight_on)
                    isFlashLightOn = true
                    println("muss angehen")


                    camManager.setTorchMode(cameraId, true)

               } else {

                imageButtonFlashlight.setImageResource(R.drawable.ic_flashlight)
                println("muss ausgehen")
                    isFlashLightOn=false
                    camManager.setTorchMode(cameraId, false)
            }
            }




    }



}
