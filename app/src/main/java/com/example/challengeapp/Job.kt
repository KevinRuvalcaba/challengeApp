package com.example.challengeapp

import java.io.Serializable

data class Job (val title:String, val vacants:String, val hours : String, val location: String,
                val description:String, val skills:String) : Serializable