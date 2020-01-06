package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.com.example.myapplication.CounterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        //declare an instance of the viewmodel
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d ("MainActivity", "onCreate")


        //initialise the viewmodel
        counterViewModel = ViewModelProvider.of(this).get(CounterViewModel::class.java)



        //Add an observer to the ViewModel
        counterViewModel.counter.observe(
            this, observe{
                if (counterViewModel.counter.value == 10)
                    goodJob()
            }
        )

        button.setOnClickListener{
            textView.text = counterViewModel.counter.value.toString()

        }
        button2.setOnClickListener {
            textView.text = counterViewModel.counter.value.toString()
        }

    }

    private fun goodJob() {
        Toast.makeText(applicationContext, "Congratulation!!!",
            Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
