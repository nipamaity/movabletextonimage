package com.nipa.movabletextonimage

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

 class MovableTextOnImage :ConstraintLayout {
    private var offsetX: Float = 0f
    private var offsetY: Float = 0f
    private lateinit var customTextView: TextView
    private lateinit var ivSelectedImage: ImageView
    private var textText:String= DEFAULT_TEXT
    private  var textColor:Int=0
     lateinit var contextView: Context
    private var textSize= DEFAULT_TEXT_SIZE
    private var textMargin= DEFAULT_TEXT_MARGIN

    constructor(context: Context) : super(context) {
        this.contextView=context
        init(null)
    }

    constructor( context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.contextView=context
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.contextView=context
        init(attrs)
    }
    private fun init(attrs: AttributeSet?) {
        inflate(context, R.layout.custom_frame, this)
        customTextView = findViewById(R.id.customTextView)
        ivSelectedImage = findViewById(R.id.ivSelectedImage)
        ivSelectedImage.setOnTouchListener { _, event ->
            handleTouchEvent(event)
        }
    }
    private fun handleTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Save the initial touch position
                offsetX = event.x - customTextView.x
                offsetY = event.y - customTextView.y
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                // Update the position of the TextView based on touch movement
                customTextView.x = event.x - offsetX
                customTextView.y = event.y - offsetY
                return true
            }
            else -> return false
        }
    }
    fun setMovableText(text: String)=apply {customTextView.text = text  }
    fun setMovableTextSize(textSize: Float){customTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize)  }
    fun setMovableTextColor(textColor: Int){
        customTextView.setTextColor(textColor)
    }
     fun setMovableTextBackgroundColor(textColor: Int){
         customTextView.setBackgroundColor(textColor)
     }
  /*  fun setMovableTextMargin(txtMargin: String) {customTextView.setM  =  textMargin  }*/

    fun setImageSrc(uriImage: String) {
        // dynamicImageUriData = uriImage
        // Log.d("nipaerror","dynamicImageUri -"+dynamicImageUri)
        loadImage(uriImage)
    }
    fun  loadImage(uriImage: String){
        if (this::ivSelectedImage.isInitialized) {
            if (uriImage.isNotBlank()) {
                val uri: Uri = Uri.parse(uriImage)
                ivSelectedImage.setImageURI(uri)
            }
        }
    }
    companion object{
        const val DEFAULT_TEXT="Test Text You can change text"
       // const val DEFAULT_TEXT_COLOR=
        const val DEFAULT_TEXT_SIZE="12dp"
        const val DEFAULT_TEXT_MARGIN="5dp"
    }
}