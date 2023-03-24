package com.example.sorteioplay

class Sorteio {
    private val palavras = mutableListOf<String>()

    fun sortear(): String? {
        if (this.palavras.isEmpty())
            return null
        return this.palavras.random()
    }

    fun addPalavra(palavra: String) {
        if (palavra.isNotEmpty() && palavra.isNotBlank())
            this.palavras.add(palavra)
    }
}
