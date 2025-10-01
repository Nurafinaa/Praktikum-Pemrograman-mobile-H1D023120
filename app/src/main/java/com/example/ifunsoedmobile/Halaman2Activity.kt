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

    private fun initLayout() = with(binding) {
        val phone = LayoutMenuBinding.bind(layoutPhone.root)
        val email = LayoutMenuBinding.bind(layoutEmail.root)
        val ig = LayoutMenuBinding.bind(layoutIg.root)
        val location = LayoutMenuBinding.bind(layoutLocation.root)
        val buku = LayoutMenuBinding.bind(layoutBuku.root) // ✅ menu buku


        location.imgIcon.setImageResource(R.drawable.ic_location)
        location.tvLayout.setText(R.string.alamat)

        email.imgIcon.setImageResource(R.drawable.ic_email)
        email.tvLayout.setText(R.string.email)

        ig.imgIcon.setImageResource(R.drawable.ic_himpunan)
        ig.tvLayout.setText(R.string.ig_himpunan)

        phone.imgIcon.setImageResource(R.drawable.ic_phone)
        phone.tvLayout.setText(R.string.telepon)

        buku.imgIcon.setImageResource(R.drawable.ic_book)
        buku.tvLayout.setText(R.string.daftar_buku)
    }

    private fun initListener() = with(binding) {
        val phone = LayoutMenuBinding.bind(layoutPhone.root)
        val email = LayoutMenuBinding.bind(layoutEmail.root)
        val ig = LayoutMenuBinding.bind(layoutIg.root)
        val location = LayoutMenuBinding.bind(layoutLocation.root)
        val buku = LayoutMenuBinding.bind(layoutBuku.root)


        location.root.setOnClickListener {
            val gMapsIntentUri = "$gMapsUrl$latitude,$longitude".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, gMapsIntentUri)
            startActivity(mapIntent.setPackage(packageMaps))
        }


        ig.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = getString(R.string.ig_himpunan).toUri()
            }
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


        buku.root.setOnClickListener {
            startActivity(Intent(this@Halaman2Activity, DaftarBukuActivity::class.java))
        }


        btnBack.setOnClickListener {
            finish()
        }
    }
}
