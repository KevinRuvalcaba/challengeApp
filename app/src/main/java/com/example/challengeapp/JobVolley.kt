package com.example.challengeapp

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class JobVolley(val url: String, val context: Context, val mcuAdapter: JobRecyclerAdapter){
    val queue = Volley.newRequestQueue(context)

    fun callJobAPI(){
        val dataJobs = ArrayList<Job>()

        val requestMarvel = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener<JSONObject>{
                    response ->
                val jobs = response.getJSONArray("columns")

                for(i in 0..jobs.length()-1){
                    /*
                    val character = jobs.getJSONObject(i)
                    val image = character.getJSONObject("thumbnail")
                    val thumbnail = image.getString("path") + "." + image.getString("extension")
                    val mcuDude = Job(character.getString("name"), character.getString("description"), thumbnail)
                    dataJobs.add(mcuDude)
                     */
                }
                mcuAdapter.setData(dataJobs)
            }, Response.ErrorListener {
                Toast.makeText(context, "Hubo un error", Toast.LENGTH_LONG).show()
            })

        queue.add(requestMarvel)
    }
}