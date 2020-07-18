package com.anwesh.uiprojects.bighview

/**
 * Created by anweshmishra on 19/07/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val colors : Array<String> = arrayOf("#3F51B5", "#F44336", "#2196F3", "#009688", "#673AB7")
val parts : Int = 3
val scGap : Float = 0.02f / parts
val strokeFactor : Int = 90
val sizeFactor : Float = 5.9f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
