package com.example.myapplication2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.Model.TeamModelClass
import com.example.myapplication2.Model.Teams
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user_layout.view.*
import java.util.*

class TeamAdapter(val context: Context, val items: ArrayList<TeamModelClass>) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user_layout,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        Picasso.get().load(item.logo).into(holder.tLogo)

        holder.tId.text = item.id.toString()
        holder.tTeam.text = item.team
        holder.tTown.text = item.town
        holder.tColors.text = item.colors
       holder.tSince.text = item.description.since.toString()
        holder.tTrophies.text = item.description.trophies
        holder.tKit1.text = item.kitscolor.first
       holder.tKit2.text = item.kitscolor.second

       //holder.tTeam.text = ttTeam
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(val view: View, var ttTeam: Teams?=null) : RecyclerView.ViewHolder(view) {
        val tLogo = view.team_logo
        val tId = view.t_id
        val tTeam = view.t_team
        val tTown = view.t_town
        val tColors = view.t_colors
        val tSince = view.t_since
        val tTrophies = view.t_trophies
        val tKit1 = view.t_kit1
        val tKit2 = view.t_kit2

        companion object{
            val dtTeam = "dtTeam"
        }
        init{
           view.setOnClickListener{
               val intent = Intent(view.context, TeamDetail::class.java)

               val team =tTeam.text.toString()
               val town =tTown.text.toString()
               val colors =tColors.text.toString()
               val since =tSince.text.toString()
               val trophies =tTrophies.text.toString()
               val kit1 =tKit1.text.toString()
               val kit2 =tKit2.text.toString()


               intent.putExtra(dtTeam,tTeam.text)
               intent.putExtra("dtTeam",team)
               intent.putExtra("dtTown",town)
               intent.putExtra("dtColors",colors)
               intent.putExtra("dtSince",since)
               intent.putExtra("dtTrophies",trophies)
               intent.putExtra("dtKit1",kit1)
               intent.putExtra("dtKit2",kit2)


                   view.context.startActivity(intent)
           }
       }

    }
}