package com.example.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_job.*

class JobActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)

        val job = intent.getSerializableExtra("job") as? Job
        textView.setText(job!!.title)
        locationView.setText(job!!.location)
        descView.setText(job!!.description)
        skillsView.setText(job!!.skills)
    }

}
