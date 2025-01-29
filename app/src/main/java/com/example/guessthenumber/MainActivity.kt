package com.example.guessthenumber

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var min=0
    var max=100
    var num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gues:TextView=findViewById(R.id.tap)
        val down:Button=findViewById(R.id.down)
        val up:Button=findViewById(R.id.up)
        val gene:Button=findViewById(R.id.gene)
        val guessed:Button=findViewById(R.id.guessed)

        gene.setOnClickListener {
            num = Random.nextInt(min,max)
            gues.text=num.toString()
            gene.visibility= View.INVISIBLE
            guessed.visibility=View.VISIBLE
        }

        up.setOnClickListener{
            min=num
            if (checkingLimits()) {
                num = Random.nextInt(min, max)
                gues.text = num.toString()
            } else gues.text = "Ganaste"
        }

        down.setOnClickListener {
            max=num
            if (checkingLimits()) {
                num = Random.nextInt(min, max)
                gues.text = num.toString()
            } else gues.text = "Ganaste"
        }

        guessed.setOnClickListener {
            gues.text = "tu numero es: ${num}"
            

        }




    }
    fun checkingLimits():Boolean{
        return min != max
    }
}