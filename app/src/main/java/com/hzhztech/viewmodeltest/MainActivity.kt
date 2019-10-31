package com.hzhztech.viewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders;
import com.hzhztech.viewmodeltest.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        //重新创建的时候 也需要取回属性
        textView.text = myViewModel.number.toString()

        var textView = findViewById<TextView>(R.id.textView)
        var button = findViewById<Button>(R.id.button)
        var button2 = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            myViewModel.number++
            textView.text = myViewModel.number.toString()
        }

        button2.setOnClickListener {
            myViewModel.number += 2
            textView.text = myViewModel.number.toString()
        }
    }
}
