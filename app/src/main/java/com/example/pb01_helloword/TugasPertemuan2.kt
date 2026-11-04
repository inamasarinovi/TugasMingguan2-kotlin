package com.example.pb01_helloword

data class Buku(
    val judul: String,
    val penulis: String,
    val tahunTerbit: Int,
    val jumlahHalaman: Int,
    val genre: String,
    val rating: Double?
)

fun validasiInput(judul: String, penulis: String): Boolean {
    return judul.isNotBlank() && penulis.isNotBlank()
}

fun prosesDaftarBuku(): String {
    val daftarBuku = listOf(
        Buku("Laut Bercerita", "Leila S. Chudori", 2017, 379, "Novel", 4.8),
        Buku("Bumi", "Tere Liye", 2014, 440, "Fantasi", 4.7),
        Buku("Laskar Pelangi", "Andrea Hirata", 2005, 529, "Novel", 4.9),
        Buku("Atomic Habits", "James Clear", 2018, 320, "Pengembangan Diri", 4.6),
        Buku("Hujan", "Tere Liye", 2016, 320, "Novel", 4.5),
        Buku("Filosofi Teras", "Henry Manampiring", 2018, 320, "Filsafat", 4.7),
        Buku("Dilan 1990", "Pidi Baiq", 2014, 332, "Romansa", null),
        Buku("Negeri 5 Menara", "Ahmad Fuadi", 2009, 423, "Novel", 4.8)
    )

    val hasil = StringBuilder()

    // Validasi input
    hasil.append("=== VALIDASI INPUT ===\n")
    val judulInput = "Laut Bercerita"
    val penulisInput = "Leila S. Chudori"

    if (validasiInput(judulInput, penulisInput)) {
        hasil.append("Input valid\n")
    } else {
        hasil.append("Judul dan penulis wajib diisi\n")
    }

    // Filter buku berdasarkan genre
    hasil.append("\n=== BUKU GENRE NOVEL ===\n")
    val bukuNovel = daftarBuku.filter { it.genre == "Novel" }
    bukuNovel.forEach {
        hasil.append("${it.judul} - ${it.penulis}\n")
    }

    // Sort buku berdasarkan tahun terbit
    hasil.append("\n=== BUKU BERDASARKAN TAHUN ===\n")
    val bukuTerurut = daftarBuku.sortedBy { it.tahunTerbit }
    bukuTerurut.forEach {
        hasil.append("${it.tahunTerbit} | ${it.judul}\n")
    }

    // Transform/map data buku
    hasil.append("\n=== RINGKASAN BUKU ===\n")
    val ringkasanBuku = daftarBuku.map {
        val ratingText = it.rating?.toString() ?: "Belum ada rating"
        "${it.judul} (${it.tahunTerbit}) - ${it.genre} | Rating: $ratingText"
    }

    ringkasanBuku.forEachIndexed { index, ringkasan ->
        hasil.append("${index + 1}. $ringkasan\n")
    }

    return hasil.toString()
}
