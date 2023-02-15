package com.example.myapplication2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.myapplication2.Model.TeamModelClass
import com.example.myapplication2.Model.Teams
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detailed.ddt_team
import kotlinx.android.synthetic.main.activity_detailed.ddt_town
import kotlinx.android.synthetic.main.activity_main.rvTeamsList
import kotlinx.android.synthetic.main.item_user_layout.view.t_team
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList


class TeamDetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detailed)
        val navBarTitle = intent.getStringExtra(TeamAdapter.ViewHolder.dtTeam)
        supportActionBar?.title = navBarTitle

        val team = intent.getStringExtra("dtTeam")
        val teamTextView2: TextView = findViewById(R.id.ddt_team)
        teamTextView2.text = team

        val town = intent.getStringExtra("dtTown")
        val townTextView: TextView = findViewById(R.id.ddt_town)
        townTextView.text = town

        val colors = intent.getStringExtra("dtColors")
        val colorsTextView: TextView = findViewById(R.id.ddt_colors)
        colorsTextView.text = colors

        val since = intent.getStringExtra("dtSince")
        val sinceTextView: TextView = findViewById(R.id.ddt_since)
        sinceTextView.text = since

        val trophies = intent.getStringExtra("dtTrophies")
        val trophiesTextView: TextView = findViewById(R.id.ddt_trophies)
        trophiesTextView.text = trophies

        val kit1 = intent.getStringExtra("dtKit1")
        val kit1TextView: TextView = findViewById(R.id.ddt_kit1)
        kit1TextView.text = kit1

        val kit2 = intent.getStringExtra("dtKit2")
        val kit2TextView: TextView = findViewById(R.id.ddt_kit2)
        kit2TextView.text = kit2
    }
}