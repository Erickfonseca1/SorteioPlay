package com.example.sorteioplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etInputSorteio: EditText
    private lateinit var btCadastrar: Button
    private lateinit var btSortear: Button
    private lateinit var tvPalavraSorteio: TextView
    private lateinit var sorteio: Sorteio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etInputSorteio = findViewById(R.id.etInputSorteio)
        this.btCadastrar = findViewById(R.id.btCadastrar)
        this.sorteio = Sorteio()


        this.btSortear = findViewById(R.id.btSortear)
        this.btSortear.setOnClickListener { this.sortear() }

        this.tvPalavraSorteio = findViewById(R.id.tvPalavraSorteio)
        this.btCadastrar.setOnClickListener { this.cadastrar() }

    }

    private fun sortear() {
        val palavra = this.sorteio.sortear()

        if (palavra.isNullOrEmpty()) {
            Toast.makeText(this, "Não há palavras cadastradas", Toast.LENGTH_SHORT).show()
        } else {
            this.tvPalavraSorteio.text = palavra
        }

        this.etInputSorteio.setText("")
    }

    private fun cadastrar() {
        val palavra = this.etInputSorteio.text.toString()

        if (palavra.isEmpty()) {
            Toast.makeText(this, "Campo vazio, insira uma palavra", Toast.LENGTH_SHORT).show()
        } else {
            this.tvPalavraSorteio.text = palavra
        }
    }
}
