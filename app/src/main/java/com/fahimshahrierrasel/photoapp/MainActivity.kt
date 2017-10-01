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
                Log.e("MainActivity", "Problem calling API", t)
            }

        }
        retriever.getNaturePhotos(callback)

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

        drawer.addItems(PrimaryDrawerItem().withName("Nature").withIdentifier(1),
                PrimaryDrawerItem().withName("Backgrounds").withIdentifier(2),
                PrimaryDrawerItem().withName("Science").withIdentifier(3))

        drawer.setOnDrawerItemClickListener { view, position, drawerItem ->
            when (position){
                1 -> retriever.getNaturePhotos(callback)
                2 -> retriever.getBackgroundsPhotos(callback)
                3 -> retriever.getSciencePhotos(callback)
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
