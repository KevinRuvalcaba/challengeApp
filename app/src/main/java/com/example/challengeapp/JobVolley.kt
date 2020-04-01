package com.example.challengeapp

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class JobVolley(val url: String, val context: Context, val jobAdapter: JobRecyclerAdapter){
    val queue = Volley.newRequestQueue(context)

    fun callJobAPI(){
        val dataJobs = ArrayList<Job>()

        val requestJob = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener<JSONObject>{
                    response ->

                val jobInfo = response.getJSONArray("columns")
                val PoI = setOf("Agency", "# Of Positions", "Business Title", "Job Category", "Division/Work Unit", "Job Description", "Hours/Shift", "Preferred Skills", "Work Location")
                val relevantInfo =  JSONObject()
                for(i in 0..jobInfo.length()-1){
                    val column = jobInfo.getJSONObject(i)
                    val name = column.getString("name")
                    if(PoI.contains(name)){
                        val x = column.getJSONObject("cachedContents")
                        val fields = x.getJSONArray("top")
                        relevantInfo.put(name, fields )
                    }
                }

                for (j in 0..relevantInfo.length() - 1) {
                    val agency = relevantInfo.getJSONArray("Agency").getJSONObject(j).getString("item")
                    val vacants = relevantInfo.getJSONArray("# Of Positions").getJSONObject(j).getString("item")
                    val businessTitle = relevantInfo.getJSONArray("Business Title").getJSONObject(j).getString("item")
                    val jobCategory = relevantInfo.getJSONArray("Job Category").getJSONObject(j).getString("item")
                    val divisionWork = relevantInfo.getJSONArray( "Division/Work Unit").getJSONObject(j).getString("item")
                    val description = relevantInfo.getJSONArray("Job Description").getJSONObject(j).getString("item")
                    val hours = relevantInfo.getJSONArray("Hours/Shift").getJSONObject(j).getString("item")
                    val preferredSkills = relevantInfo.getJSONArray("Preferred Skills").getJSONObject(j).getString("item")
                    val location = relevantInfo.getJSONArray("Work Location").getJSONObject(j).getString("item")
                    val currentJob = Job(businessTitle, vacants, hours, location, description, preferredSkills)
                    dataJobs.add(currentJob)
                    println(currentJob)
                }

                jobAdapter.setData(dataJobs)
            }, Response.ErrorListener {
                Toast.makeText(context, "Hubo un error", Toast.LENGTH_LONG).show()
            })

        queue.add(requestJob)
    }
}