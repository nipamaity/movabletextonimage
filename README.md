# movabletextonimage
movabletextonimage is an Android application that enables users to display movable and hoverable text on an image view. 
Users can customize the text , changing its color, background color, and size dynamically.

## Features

- Movable and hoverable text on an image view.
- Dynamic customization of text, color, background color, and size.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine.

First add to app gradle file to user library:
 implementation project(':movabletextonimage')

xml Page write below code:


    <com.nipa.movabletextonimage.MovableTextOnImage
        android:id="@+id/movableImage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

        In Activity class : 

          var movableTextOnImage:MovableTextOnImage=findViewById(R.id.movableImage)

        movableTextOnImage.setMovableText("I want to set this text to this ")
        movableTextOnImage.setMovableTextColor(Color.parseColor("#FF0000"))
        movableTextOnImage.setMovableTextBackgroundColor(Color.parseColor("#2F8D46"))
        movableTextOnImage.setMovableTextSize(25f)

        
