package com.example.challengeapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.job_layout.view.*

class JobRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var jobs: List<Job> = ArrayList()

    override fun getItemCount(): Int {
        return jobs.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is JobViewHolder -> {
                holder.bind(jobs.get(position))
                holder.itemView.setOnClickListener {
                    val intent = Intent(it.context, JobActivity::class.java)
                    intent.putExtra("job", jobs[position])
                    it.context.startActivity(intent)
                    Toast.makeText(it.context, "INSIDE JOB!!!!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return JobViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.job_layout, parent, false)
        )
    }

    fun setData(listJobs: List<Job>){
        jobs = listJobs
        notifyDataSetChanged()
    }

    class JobViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val vacants = itemView.vacants
        val hours = itemView.hours

        fun bind(job: Job) {
            title.text = job.title
            vacants.text = job.vacants
            hours.text = job.vacants
        }

    }
}