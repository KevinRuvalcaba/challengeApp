package com.example.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {
    private lateinit var jobRecyclerAdapter: JobRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView() //Adapter instanciado
        Log.i("MCUMARVEL API", getJobURL())
        JobVolley(getJobURL(), this, jobRecyclerAdapter).callJobAPI()
    }

    private fun setRecyclerView(){
        recycler_view_job.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            jobRecyclerAdapter = JobRecyclerAdapter()
            adapter = jobRecyclerAdapter
        }
    }

    fun getJobURL(): String{

        val jobAPI : String = "https://data.cityofnewyork.us/api/views/kpav-sd4t"
        return jobAPI
    }
}
