package com.example.kalkulatorapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kalkulatorapp.databinding.ActivityInputBinding

class Input : AppCompatActivity() {

    private val binding : ActivityInputBinding by lazy {
        ActivityInputBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val clear = binding.btnClear
        clear.setOnClickListener {
            var input1 = binding.InputAngka1
            var input2 = binding.InputAngka2

            input1.text = null
            input2.text = null
        }

        val tambah = binding.btnPlus
        tambah.setOnClickListener {
            var input1 = binding.InputAngka1.text.toString()
            var input2 = binding.InputAngka2.text.toString()

            if (input1.isEmpty()){
                binding.InputAngka1.setError("Angka 1 harus di isi")
            }else if (input2.isEmpty()){
                binding.InputAngka2.setError("Angka 2 harus di isi")
            }else{
                var hasil = input1.toDouble() + input2.toDouble()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("hasil", hasil)
                startActivity(intent)
            }
        }
        val kurang = binding.btnMinus
        kurang.setOnClickListener {
            var input1 = binding.InputAngka1.text.toString()
            var input2 = binding.InputAngka2.text.toString()

            if (input1.isEmpty()){
                binding.InputAngka1.setError("Angka 1 harus di isi")
            }else if (input2.isEmpty()){
                binding.InputAngka2.setError("Angka 2 harus di isi")
            }else{
                var hasil = input1.toDouble() - input2.toDouble()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("hasil", hasil)
                startActivity(intent)
            }
        }
        val kali = binding.btnMultiple
        kali.setOnClickListener {
            var input1 = binding.InputAngka1.text.toString()
            var input2 = binding.InputAngka2.text.toString()

            if (input1.isEmpty()){
                binding.InputAngka1.setError("Angka 1 harus di isi")
            }else if (input2.isEmpty()){
                binding.InputAngka2.setError("Angka 2 harus di isi")
            }else{
                var hasil = input1.toDouble() * input2.toDouble()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("hasil", hasil)
                startActivity(intent)
            }
        }
        val bagi = binding.btnDivide
        bagi.setOnClickListener {
            var input1 = binding.InputAngka1.text.toString()
            var input2 = binding.InputAngka2.text.toString()

            if (input1.isEmpty()){
                binding.InputAngka1.setError("Angka 1 harus di isi")
            }else if (input2.isEmpty()){
                binding.InputAngka2.setError("Angka 2 harus di isi")
            }else{
                var hasil = input1.toDouble() / input2.toDouble()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("hasil",hasil)
                startActivity(intent)
            }
        }
    }
}