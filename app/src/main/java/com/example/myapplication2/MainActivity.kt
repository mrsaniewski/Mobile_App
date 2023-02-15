package com.example.myapplication2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication2.Model.TeamModelClass
import com.example.myapplication2.Model.Teams
import kotlinx.android.synthetic.main.activity_main.*
import com.google.gson.Gson
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            val jsonString = getJSONFromAssets()
            val teams = Gson().fromJson(jsonString, Teams::class.java)

            rvTeamsList.layoutManager = LinearLayoutManager(this)

            val itemAdapter = TeamAdapter(this, teams.teams)

            rvTeamsList.adapter = itemAdapter
        } catch (e: JSONException) {

            e.printStackTrace()
        }

    }

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("Teams.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}