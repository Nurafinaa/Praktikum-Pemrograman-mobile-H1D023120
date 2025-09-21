package com.example.ifunsoedmobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.ifunsoedmobile.databinding.ActivityHalaman2Binding
import com.example.ifunsoedmobile.databinding.LayoutMenuBinding

class Halaman2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHalaman2Binding

    private val latitude = "-7.429427"
    private val longitude = "109.338082"
    private val gMapsUrl = "https://maps.google.com/maps?q=loc:"
    private val packageMaps = "com.google.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        val phone = LayoutMenuBinding.bind(binding.layoutPhone.root)
        val email = LayoutMenuBinding.bind(binding.layoutEmail.root)
        val ig = LayoutMenuBinding.bind(binding.layoutIg.root)
        val location = LayoutMenuBinding.bind(binding.layoutLocation.root)

        location.imgIcon.setImageResource(R.drawable.ic_location)
        location.tvLayout.setText(R.string.alamat)

        email.imgIcon.setImageResource(R.drawable.ic_email)
        email.tvLayout.setText(R.string.email)

        ig.imgIcon.setImageResource(R.drawable.ic_himpunan)
        ig.tvLayout.setText(R.string.ig_himpunan)

        phone.imgIcon.setImageResource(R.drawable.ic_phone)
        phone.tvLayout.setText(R.string.telepon)
    }

    private fun initListener() {
        val phone = LayoutMenuBinding.bind(binding.layoutPhone.root)
        val email = LayoutMenuBinding.bind(binding.layoutEmail.root)
        val ig = LayoutMenuBinding.bind(binding.layoutIg.root)
        val location = LayoutMenuBinding.bind(binding.layoutLocation.root)

        location.root.setOnClickListener {
            val gMapsIntentUri = "$gMapsUrl$latitude,$longitude".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, gMapsIntentUri)
            startActivity(mapIntent.setPackage(packageMaps))
        }

        ig.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = getString(R.string.ig_himpunan).toUri()
            startActivity(intent)
        }

        email.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "mailto:${getString(R.string.email)}".toUri()
            }
            startActivity(intent)
        }

        phone.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = "tel:${getString(R.string.telepon)}".toUri()
            }
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
