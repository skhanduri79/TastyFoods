package com.example.sakshi.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.sakshi.R
import com.example.sakshi.adapter.DashboardRecyclerAdapter
import com.example.sakshi.model.Restaurant
import com.example.sakshi.util.ConnectionManager



class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView

    lateinit var layoutManager:RecyclerView.LayoutManager

    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    lateinit var btnCheckInternet:Button

   val restaurantInfoList= arrayListOf<Restaurant>(
        Restaurant("ABC","RAJMA CHAWAL","300","4.0",R.drawable.bgmfruits)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view=inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard= view.findViewById(R.id.recyclerDashboard)

        btnCheckInternet=view.findViewById(R.id.btnCheckInternet)

        btnCheckInternet.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context)) {
                //net available
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("success")
                dialog.setMessage("net connection found")
                dialog.setPositiveButton("ok") { text, listener -> }

                dialog.setNegativeButton("cancel") { text, listener -> }
                dialog.create()
                dialog.show()
            } else {
            //internet is not available
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("error")
                dialog.setMessage("net connection not found")
                dialog.setPositiveButton("ok") { text, listener -> }

                dialog.setNegativeButton("cancel") { text, listener -> }
                dialog.create()
                dialog.show()

        }
        }




        layoutManager=LinearLayoutManager(activity)

        recyclerAdapter= DashboardRecyclerAdapter(
            activity as Context,
            restaurantInfoList
        )

        recyclerDashboard.adapter=recyclerAdapter

        recyclerDashboard.layoutManager=layoutManager

        recyclerDashboard.addItemDecoration(DividerItemDecoration(recyclerDashboard.context,(layoutManager as LinearLayoutManager).orientation
        ))

        val queue= Volley.newRequestQueue(activity as Context)

        val url="<http://13.235.250.119/v2/restaurants/fetch_result/"
        val jsonObjectRequest= object : JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener{
                println("response is $it")
            },
            Response.ErrorListener{
                println("error is $it")

        }) {
             override fun getHeaders():MutableMap<String, String>{
                val headers=HashMap<String,String>()
                headers["Content-type"]="application/json"
                headers["token"]="6d0a7c4ba50a0c"
                return headers
            }
            
        }

        queue.add(jsonObjectRequest)



        return view
    }


}