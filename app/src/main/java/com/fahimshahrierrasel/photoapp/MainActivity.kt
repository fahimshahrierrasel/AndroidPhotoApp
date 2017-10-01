package com.fahimshahrierrasel.photoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.fahimshahrierrasel.photoapp.api.PhotoRetriever
import com.fahimshahrierrasel.photoapp.models.Photo
import com.fahimshahrierrasel.photoapp.models.PhotoList
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var photos: List<Photo>? = null
    val retriever = PhotoRetriever()
    val photoCategory = arrayOf("fashion", "nature", "backgrounds", "science", "education", "people",
            "feelings", "health", "places", "animals", "industry", "food", "computer",
            "sports", "transportation", "travel", "buildings", "business", "music")

    var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val callback = object : Callback<PhotoList>{
            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photos = response?.body()?.hits
                    mainAdapter = MainAdapter(this@MainActivity.photos!!, this@MainActivity)
                    recyclerView.adapter = mainAdapter
                }
            }

            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                failedTextView.visibility = View.VISIBLE
                Log.e("MainActivity", "Problem calling API", t)
            }

        }
        retriever.getPhotoByCategory(photoCategory[1], callback)

        val accountHeader = AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.pixabay)
                .build()

        val drawer = DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(accountHeader)
                .withToolbar(toolbar)
                .build()

        drawer.addItems(PrimaryDrawerItem().withName(photoCategory[0].capitalize()).withIdentifier(0),
                PrimaryDrawerItem().withName(photoCategory[1].capitalize()).withIdentifier(1),
                PrimaryDrawerItem().withName(photoCategory[2].capitalize()).withIdentifier(2),
                PrimaryDrawerItem().withName(photoCategory[3].capitalize()).withIdentifier(3),
                PrimaryDrawerItem().withName(photoCategory[4].capitalize()).withIdentifier(4),
                PrimaryDrawerItem().withName(photoCategory[5].capitalize()).withIdentifier(5),
                PrimaryDrawerItem().withName(photoCategory[6].capitalize()).withIdentifier(6),
                PrimaryDrawerItem().withName(photoCategory[7].capitalize()).withIdentifier(7),
                PrimaryDrawerItem().withName(photoCategory[8].capitalize()).withIdentifier(8),
                PrimaryDrawerItem().withName(photoCategory[9].capitalize()).withIdentifier(9),
                PrimaryDrawerItem().withName(photoCategory[10].capitalize()).withIdentifier(10),
                PrimaryDrawerItem().withName(photoCategory[11].capitalize()).withIdentifier(11),
                PrimaryDrawerItem().withName(photoCategory[12].capitalize()).withIdentifier(12),
                PrimaryDrawerItem().withName(photoCategory[13].capitalize()).withIdentifier(13),
                PrimaryDrawerItem().withName(photoCategory[14].capitalize()).withIdentifier(14),
                PrimaryDrawerItem().withName(photoCategory[15].capitalize()).withIdentifier(15),
                PrimaryDrawerItem().withName(photoCategory[16].capitalize()).withIdentifier(16),
                PrimaryDrawerItem().withName(photoCategory[17].capitalize()).withIdentifier(17),
                PrimaryDrawerItem().withName(photoCategory[18].capitalize()).withIdentifier(18)
        )

        drawer.setOnDrawerItemClickListener { view, position, drawerItem ->
            retriever.getPhotoByCategory(photoCategory[position-1], callback)

            if(supportActionBar != null){
                supportActionBar?.title = photoCategory[position-1].capitalize()
            }

            drawer.closeDrawer()
            true
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onClick(view: View?) {
        val intent = Intent(this, DetailActivity::class.java)
        val holder = view?.tag as MainAdapter.PhotoViewHolder
        intent.putExtra(DetailActivity.PHOTO, mainAdapter?.getPhoto(holder.adapterPosition))
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
