package com.fahimshahrierrasel.photoapp

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.fahimshahrierrasel.photoapp.models.Photo
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Making Activity FullScreen on Top and Bottom
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val photo = intent.getSerializableExtra(PHOTO) as Photo?


        photo?.webformatURL.let {
             Glide.with(this)
                     .asBitmap()
                     .load(photo?.webformatURL)
                     .into(object : SimpleTarget<Bitmap>(photo?.imageWidth!!, photo.imageHeight) {
                        override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                            progressBar.visibility = View.GONE
                            failedText.visibility = View.GONE
                            imageView.setImageBitmap(resource)
                            Palette.from(resource)
                                    .generate(Palette.PaletteAsyncListener { palette ->
                                        val textSwatch = palette.mutedSwatch ?: return@PaletteAsyncListener
                                        parentView.setBackgroundColor(textSwatch.rgb)
                                    })
                        }

                        override fun onLoadStarted(placeholder: Drawable?) {
                            super.onLoadStarted(placeholder)
                            progressBar.visibility = View.VISIBLE
                        }

                        override fun onLoadFailed(errorDrawable: Drawable?) {
                            super.onLoadFailed(errorDrawable)
                            failedText.text = "Failed :("
                            failedText.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                        }
                    })
        }

        imageView.setOnClickListener {
            finish()
        }
    }

    companion object {
        val PHOTO = "PHOTO"
    }
}
