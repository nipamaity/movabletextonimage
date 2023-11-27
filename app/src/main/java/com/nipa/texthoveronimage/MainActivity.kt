package com.nipa.texthoveronimage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nipa.movabletextonimage.MovableTextOnImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var movableTextOnImage:MovableTextOnImage=findViewById(R.id.movableImage)

        movableTextOnImage.setMovableText("I want to set this text to this ")
        movableTextOnImage.setMovableTextColor(Color.parseColor("#FF0000"))
        movableTextOnImage.setMovableTextBackgroundColor(Color.parseColor("#2F8D46"))
        movableTextOnImage.setMovableTextSize(25f)
    }
}