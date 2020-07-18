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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBigH(i : Int, scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf2 : Float = sf.divideScale(1, parts)
    val size : Float = Math.min(w, h) / sizeFactor
    save()
    scale(1f - 2 * i, 1f)
    for (j in 0..1) {
        save()
        translate(-w / 2, - h / 2 + (h / 2 + size / 2) * j)
        drawRect(0f, 0f, size, (h / 2 - size / 2) * sf.divideScale(j * 2, parts), paint)
        restore()
    }
    drawRect(RectF(0f, -size / 2, (w / 2) * sf2, size / 2), paint)
    restore()
}

fun Canvas.drawBHNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    save()
    translate(w / 2, h / 2)
    for (j in 0..1) {
        drawBigH(j, scale, w, h, paint)
    }
    restore()
}
