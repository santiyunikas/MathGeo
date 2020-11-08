package com.santiyunikas.mathgeo.view.content.materi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.contract.ContractInterface.*

class DetailMateriActivity : AppCompatActivity(), IView, CustomView, View.OnClickListener {
    private lateinit var container: LinearLayout
    private lateinit var judulMateri: TextView
    private lateinit var btnPembahasan: Button
    private var idMateri: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Materi Bangun Ruang"
        initView()
        updateViewData()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun initView() {
        container = findViewById(R.id.lyt_detail_materi)
        judulMateri = findViewById(R.id.judul_materi)
        btnPembahasan = findViewById(R.id.btn_pembahasan_materi)
        btnPembahasan.visibility = View.GONE
        btnPembahasan.setOnClickListener(this)
        idMateri = intent.getIntExtra("EXTRA_SESSION_ID", 0)
        judulMateri.text = intent.getStringExtra("EXTRA_SESSION_JUDUL_MATERI")
        Log.d("idMateri", idMateri.toString())
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun updateViewData() {
        when (idMateri) {
            1 -> {
                var text = """
                    1.	Garis dikatakan terletak pada bidang jika garis dan bidang sekurang-kurangnya mempunyai dua titik persekutuan
                    
                    2.	Garis dikatakan sejajar bidang, jika garis dan bidang tidak mempunyai titik persekutuan.
                    
                    3.	Garis menembus bidang, jika garis dan bidang hanya mempunyai sebuah titik persekutuan
                    
                    4.	Sebuah garis tegak pada sebuah lurus bidang jika garis itu tegak lurus pada semua garis yang terletak pada bidang tersebut
                    
                    5.	Dua bidang α dan ß dikatakan berimpit jika titik yang terletak pada bidang ß juga terletak pada bidang α, atau setiap titik pada bidang ß juga terletak pada bidang α.
                    
                    6.	Dua bidang dikatakan sejajar jika kedua bidang tersebut tidak mempunyai titik persekutuan.
                    
                    7.	Dua bidang dikatakan berpotongan jika kedua bidang itu tepat memiliki sebuah garis persekutuan.
                    
                    8.	Rumus Pythagoras dan luas pada segitiga siku-siku yaitu
                    
                """.trimIndent()
                getTextview(text)

                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi1/materi1.png")

                text = """
                    9. Terdapat 6 bagian pada suatu kubus yaitu:
                       a. rusuk
                       b. sisi
                       c. titik sudut
                       d. bidang diagonal
                       e. diagonal ruang
                       f. diagonal sisi
                """.trimIndent()
                getTextview(text)

                text = """
                    10. Apabila diketahui rusuk suatu kubus yaitu a maka panjang digonal bidangnya yaitu a√2, dan panjang diagonal bidangnya yaitu a√3
                """.trimIndent()
                getTextview(text)
            }
            2 -> {
                val intent = Intent(this, DetailMateri2Activity::class.java)
                startActivity(intent)
                finish()
            }
            3 -> {
                var text =
                    """Misalkan diketahui dua titik yaitu titik A dan titik B yang di seperti disajikan pada gambar"""
                getTextview(text)

                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi3/Gambar.png")

                text =
                    """Peragaan ini menunjukkan jarak titik A ke B adalah panjang ruas garis yang menghubungkan titik A ke B, Panjang AB dapat diperoleh dengan menggunakan rumus pythagoras berikut :"""
                getTextview(text)

                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi3/rumus_pythagoras.png")

                text = """Contoh:
                        |Perhatikan gambar berikut!""".trimMargin()
                getTextview(text)

                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi3/Kubus.png")

                text =
                    """Jika titik P berada pada tengah-tengah garis BF, maka jarak antara titik A dan P adalah..."""
                getTextview(text)

                text = """a. 5√3
                    |b. 5√2
                    |c. 3√7
                    |d. 3√5
                    |e. 7√3
                """.trimMargin()
                getTextview(text)

                getButton("Cek Pembahasan")

            }
            4 -> {
                var text =
                    """Jarak antara titik A ke garis g merupakan panjang garis tegak lurus titik A ke garis g. Namun, agar kalian menemukan jarak yang tepat, kalian perlu melakukan proyeksi titik A pada garis g terlebih dahulu.
                                    |
                                    |Tarik sebuah garis yang menghubungkan titik A pada garis g, kalian harus mengingat kembali bahwa tarikan garis tersebut harus tegak lurus pada garis g. Maka, garis inilah yang menjadi jarak titik A ke garis g
                                    |
                                    |Untuk lebih jelasnya perhatikan gambar berikut!""".trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi4/titik_a_ke_ga.png")
                text = """Proyeksi titik A pada garis g adalah A’
                        |
                        |Contoh:
                """.trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi4/kubus.png")
                text =
                    """Diketahui kubus ABCD EFGH dengan panjang rusuk 6 cm. Jarak titik C ke garis FH adalah..."""
                getTextview(text)
                text = """a. 3√6
                    |b. 4√2
                    |c. 3√7
                    |d. 7√7
                    |e. 6√7
                """.trimMargin()
                getTextview(text)
                getButton("Cek Pembahasan")
            }
            5 -> {
                var text =
                    """Cara untuk menentukan jarak titik ke bidang, hampir sama dengan jarak titik ke garis. Langkah pertama yang harus dilakukan adalah melakukan proyeksi titik pada bidang terkait. Jarak titik ke bidang dinyatakan oleh jarak titik ke proyeksi titik pada bidang. Dengan kata lain dapat disimpulkan bahwa jarak antara titik A ke bidang a adalah panjang garis tegak  lurus dari titik A ke bidang a
                                    |
                                    |Perhatikan gambar dibawah ini agar dapat menggambarkan ilustrasi diatas lebih jelasnya""".trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi5/titik_a_ke_bidang_a.png")
                text =
                    """Jarak titik A pada bidang a sama dengan jarak AA’ dengan titik A’ merupakan proyeksi A pada bidang a
                    |
                    |Contoh:
                """.trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi5/kubus_materi_5.png")
                text =
                    """Sebuah kubus ABCD.EFGH mempunyai panjang rusuk 6cm, maka jarak titik D terhadap bidang ACH adalah... (Soal UN tahun 2016)
                """.trimMargin()
                getTextview(text)
                text = """a. 2 cm
                    |b. 2√3 cm
                    |c. 3 cm
                    |d. 3√3 cm
                    |e. 4√3
                """.trimMargin()
                getTextview(text)
                getButton("Cek Pembahasan")

            }
            6 -> {
                var text =
                    """Jarak antar dua garis atau jarak garis ke garis adalah panjang ruas garis yang menghubungkan antara garis pertama dan garis kedua, dimana ruas garis tersebut tegak lurus dengan garis pertama dan garis kedua.
                                    |
                                    |Cara yang harus dilakukan yakni mengambil sebuah titik yang merupakan bagian dari garis pertama. Kemudian, proyeksikan titik tersebut pada garis kedua. Sekarang dua titik tersebut tehubung oleh sebuah garis yang tegak lurus. Garis inilah yang menyatakan jarak garis ke garis. Untuk lebih detail, kalian dapat melihat gambar dibawah
                    """.trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi6/Garis_Materi6.png")
                text =
                    """Langsung saja, mari kita simak contoh soal dan pembahasan jarak antara dua garis
                    |Contoh:
                    |Perhatikan gambar berikut!
                """.trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi6/kubus_materi6.png")
                text =
                    """Diketahui panjang rusuk kubus diatas adalah 10 cm. Titik P dan titik Q berturut-turut merupakan titik tengah dari rusuk AB dan BC. Jarak garis PQ ke garis EG adalah ...""".trimMargin()
                getTextview(text)
                text = """a. 10 cm
                    |b. 23√3 cm
                    |c. 15 cm
                    |d. 10/2 √3 cm
                    |e. 15/2 √2
                """.trimMargin()
                getTextview(text)
                getButton("Cek Pembahasan")
            }
            7 -> {
                var text =
                    """Jarak antara garis dan bidang merupakan jarak antara garis dengan garis proyeksinya pada bidang. Prinsip cara mencari mencari jarak garis ke bidang hampir sama dengan mencari jarak garis ke garis. Bedanya, proyeksi garis ke bidang dilakukan antara garis ke bidang. Lebih jelasnya perhatikan gambar dibawah.""".trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi7/jarak_antara_garis_ke_bidang_materi7.png")
                text = """Contoh:""".trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi7/kubus_materi7.png")
                text =
                    """Diketahui panjang rusuk kubus di atas adalah 6 cm. Titik K, titik L, titik M, dan titik N berturut-turut merupakan titik tengah dari rusuk AB, BC, EH, dan GH. Jarak garis KL ke bidang DMN adalah...
                            |a.	10 cm
                            |b.	8 cm
                            |c.	6 cm
                            |d.	4 cm
                            |e.	3 cm
                        """.trimMargin()
                getTextview(text)
                getButton("Cek Pembahasan")
            }
            8 -> {
                var text =
                    """Jarak antara dua bidang atau jarak bidang ke bidang adalah panjang ruas garis yang saling tegak lurus pada kedua bidang tersebut. Sama seperti materi sebelumnya, kalian perlu melakukan proyeksi titik yang merupakan bagian dari bidang ke dua. Sehingga, jika kedua titik tersebut ditarik garis lurus akan saling tegak lurus dengan kedua bidang. Lebih jelasnya perhatikan gambar dibawah.
                """.trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi8/garis_materi8.png")
                text = """Contoh:""".trimMargin()
                getTextview(text)
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi8/kubus_materi8.png")
                text =
                    """Diketahui panjang rusuk kubus di atas adalah 8 cm. Titik P, titik Q, titik R, dan titik S berturut-turut merupakan titik tengah dari rusuk AB, BC, EH, dan GH. Jarak bidang FPQ ke bidang DRS adalah...
                    |a.	16 cm
                    |b.	14 cm
                    |c.	12 cm
                    |d.	10 cm
                    |e.	8 cm
                """.trimMargin()
                getTextview(text)
                getButton("Cek Pembahasan")
            }
        }
    }

    override fun onSuccess(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun onError(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun getImageView(url: String) {
        val view = ImageView(applicationContext)
        Glide.with(applicationContext)
            .load(url)
            .placeholder(R.drawable.not_ready_yet)
            .into(view)
        view.setPadding(10)
        container.addView(view)
    }

    override fun getButton(text: String) {
        btnPembahasan.text = text
        btnPembahasan.visibility = View.VISIBLE
    }

    @SuppressLint("ResourceAsColor")
    override fun getTextview(text: String?) {
        val view = TextView(applicationContext)
        view.text = text
        view.textSize = 18F
        view.setPadding(10)
        view.setTextColor(R.color.black)
        view.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        container.addView(view)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pembahasan_materi -> {
                val intent = Intent(this, PembahasanActivity::class.java)
                intent.putExtra("EXTRA_ID_MATERI", idMateri + 1)
                startActivity(intent)
            }
        }
    }
}