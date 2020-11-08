package com.santiyunikas.mathgeo.view.content.materi

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.santiyunikas.mathgeo.BlankFragment
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*

class DetailMateri2Activity : AppCompatActivity(), IView, CustomView, View.OnClickListener {
    private lateinit var btnRusuk: Button
    private lateinit var btnBidangSisi: Button
    private lateinit var btnTitikSudut: Button
    private lateinit var btnBidangDiagonal: Button
    private lateinit var btnDiagonalRuang: Button
    private lateinit var btnDiagonalSisi: Button

    private lateinit var crdRusuk: CardView
    private lateinit var crdBidangSisi: CardView
    private lateinit var crdTitikSudut: CardView
    private lateinit var crdBidangDiagonal: CardView
    private lateinit var crdDiagonalRuang: CardView
    private lateinit var crdDiagonalSisi: CardView

    private lateinit var btnAb: Button
    private lateinit var btnAd: Button
    private lateinit var btnBc: Button
    private lateinit var btnDc: Button
    private lateinit var btnEf: Button
    private lateinit var btnFg: Button
    private lateinit var btnHg: Button
    private lateinit var btnEh: Button
    private lateinit var btnAe: Button
    private lateinit var btnBf: Button
    private lateinit var btnCg: Button
    private lateinit var btnDh: Button

    private lateinit var btnAbfe: Button
    private lateinit var btnAdhe: Button
    private lateinit var btnEfgh: Button
    private lateinit var btnAbcd: Button
    private lateinit var btnDcgh: Button
    private lateinit var btnBfgc: Button

    private lateinit var btnA: Button
    private lateinit var btnB: Button
    private lateinit var btnC: Button
    private lateinit var btnD: Button
    private lateinit var btnE: Button
    private lateinit var btnF: Button
    private lateinit var btnG: Button
    private lateinit var btnH: Button

    private lateinit var btnDbfh: Button
    private lateinit var btnEhcb: Button
    private lateinit var btnAdgf: Button
    private lateinit var btnEfcd: Button
    private lateinit var btnAegc: Button
    private lateinit var btnAbgh: Button

    private lateinit var btnDf: Button
    private lateinit var btnAg: Button
    private lateinit var btnEc: Button
    private lateinit var btnBh: Button

    private lateinit var btnAf: Button
    private lateinit var btnBe: Button
    private lateinit var btnBg: Button
    private lateinit var btnCf: Button
    private lateinit var btnAh: Button
    private lateinit var btnDe: Button
    private lateinit var btnEg: Button
    private lateinit var btnFh: Button
    private lateinit var btnAc: Button
    private lateinit var btnBd: Button
    private lateinit var btnDg: Button
    private lateinit var btnCh: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Materi Bangun Ruang"
        initView()
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

    override fun getImageView(url: String) {
        val bundle = Bundle()
        bundle.putString("IMAGE_KUBUS_URL", url)
        val fragment = BlankFragment()
        fragment.arguments = bundle
        val fm: FragmentManager = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.frame_kubus, fragment)
        transaction.commit()
    }

    override fun getButton(name: String) {

    }

    override fun getTextview(text: String?) {

    }

    private fun horizontalScrollButton(){
        btnRusuk = findViewById(R.id.btn_rusuk)
        btnBidangSisi = findViewById(R.id.btn_bidang_sisi)
        btnTitikSudut = findViewById(R.id.btn_titik_sudut)
        btnBidangDiagonal = findViewById(R.id.btn_bidang_diagonal)
        btnDiagonalRuang = findViewById(R.id.btn_diagonal_ruang)
        btnDiagonalSisi = findViewById(R.id.btn_diagonal_sisi)

        btnRusuk.setOnClickListener(this)
        btnBidangSisi.setOnClickListener(this)
        btnTitikSudut.setOnClickListener(this)
        btnBidangDiagonal.setOnClickListener(this)
        btnDiagonalRuang.setOnClickListener(this)
        btnDiagonalSisi.setOnClickListener(this)

        btnRusuk.setBackgroundResource(R.drawable.button_rounded)
        btnRusuk.setTextColor(Color.parseColor("#FFFFFF"))
    }

    private fun cardView(){
        crdRusuk = findViewById(R.id.cont_rusuk)
        crdBidangSisi = findViewById(R.id.cont_sisi)
        crdTitikSudut = findViewById(R.id.cont_titik_sudut)
        crdBidangDiagonal = findViewById(R.id.cont_bidang_diagonal)
        crdDiagonalRuang = findViewById(R.id.cont_diagonal_ruang)
        crdDiagonalSisi = findViewById(R.id.cont_diagonal_sisi)

        crdRusuk.visibility = View.VISIBLE
        crdBidangSisi.visibility = View.GONE
        crdTitikSudut.visibility = View.GONE
        crdBidangDiagonal.visibility = View.GONE
        crdDiagonalRuang.visibility = View.GONE
        crdDiagonalSisi.visibility = View.GONE
    }

    private fun rusuk(){
        btnAb = findViewById(R.id.btn_ab)
        btnAd = findViewById(R.id.btn_ad)
        btnBc = findViewById(R.id.btn_bc)
        btnDc = findViewById(R.id.btn_dc)
        btnEf = findViewById(R.id.btn_ef)
        btnFg = findViewById(R.id.btn_fg)
        btnHg = findViewById(R.id.btn_hg)
        btnEh = findViewById(R.id.btn_eh)
        btnAe = findViewById(R.id.btn_ae)
        btnBf = findViewById(R.id.btn_bf)
        btnCg = findViewById(R.id.btn_cg)
        btnDh = findViewById(R.id.btn_dh)

        btnAb.setOnClickListener(this)
        btnAd.setOnClickListener(this)
        btnBc.setOnClickListener(this)
        btnDc.setOnClickListener(this)
        btnEf.setOnClickListener(this)
        btnFg.setOnClickListener(this)
        btnHg.setOnClickListener(this)
        btnEh.setOnClickListener(this)
        btnAe.setOnClickListener(this)
        btnBf.setOnClickListener(this)
        btnCg.setOnClickListener(this)
        btnDh.setOnClickListener(this)
    }

    private fun bidangSisi(){
        btnAbfe = findViewById(R.id.btn_abfe)
        btnAdhe = findViewById(R.id.btn_adhe)
        btnEfgh = findViewById(R.id.btn_efgh)
        btnAbcd = findViewById(R.id.btn_abcd)
        btnDcgh = findViewById(R.id.btn_dcgh)
        btnBfgc = findViewById(R.id.btn_bfgc)

        btnAbfe.setOnClickListener(this)
        btnAdhe.setOnClickListener(this)
        btnEfgh.setOnClickListener(this)
        btnAbcd.setOnClickListener(this)
        btnDcgh.setOnClickListener(this)
        btnBfgc.setOnClickListener(this)
    }

    private fun titikSudut(){
        btnA = findViewById(R.id.btn_a)
        btnB = findViewById(R.id.btn_b)
        btnC = findViewById(R.id.btn_c)
        btnD = findViewById(R.id.btn_d)
        btnE = findViewById(R.id.btn_e)
        btnF = findViewById(R.id.btn_f)
        btnG = findViewById(R.id.btn_g)
        btnH = findViewById(R.id.btn_h)

        btnA.setOnClickListener(this)
        btnB.setOnClickListener(this)
        btnC.setOnClickListener(this)
        btnD.setOnClickListener(this)
        btnE.setOnClickListener(this)
        btnF.setOnClickListener(this)
        btnG.setOnClickListener(this)
        btnH.setOnClickListener(this)
    }

    private fun diagonalRuang(){
        btnDf = findViewById(R.id.btn_df)
        btnAg = findViewById(R.id.btn_ag)
        btnEc = findViewById(R.id.btn_ec)
        btnBh = findViewById(R.id.btn_bh)

        btnDf.setOnClickListener(this)
        btnAg.setOnClickListener(this)
        btnEc.setOnClickListener(this)
        btnBh.setOnClickListener(this)
    }

    private fun bidangDiagonal(){
        btnDbfh = findViewById(R.id.btn_dbfh)
        btnEhcb = findViewById(R.id.btn_ehcb)
        btnAdgf = findViewById(R.id.btn_adgf)
        btnEfcd = findViewById(R.id.btn_efcd)
        btnAegc = findViewById(R.id.btn_aegc)
        btnAbgh = findViewById(R.id.btn_abgh)

        btnDbfh.setOnClickListener(this)
        btnEhcb.setOnClickListener(this)
        btnAdgf.setOnClickListener(this)
        btnEfcd.setOnClickListener(this)
        btnAegc.setOnClickListener(this)
        btnAbgh.setOnClickListener(this)
    }

    private fun diagonalSisi(){
        btnAf = findViewById(R.id.btn_af)
        btnBe = findViewById(R.id.btn_be)
        btnBg = findViewById(R.id.btn_bg)
        btnCf = findViewById(R.id.btn_cf)
        btnAh = findViewById(R.id.btn_ah)
        btnDe = findViewById(R.id.btn_de)
        btnEg = findViewById(R.id.btn_eg)
        btnFh = findViewById(R.id.btn_fh)
        btnAc = findViewById(R.id.btn_ac)
        btnBd = findViewById(R.id.btn_bd)
        btnDg = findViewById(R.id.btn_dg)
        btnCh = findViewById(R.id.btn_ch)

        btnAf.setOnClickListener(this)
        btnBe.setOnClickListener(this)
        btnBg.setOnClickListener(this)
        btnCf.setOnClickListener(this)
        btnAh.setOnClickListener(this)
        btnDe.setOnClickListener(this)
        btnEg.setOnClickListener(this)
        btnFh.setOnClickListener(this)
        btnAc.setOnClickListener(this)
        btnBd.setOnClickListener(this)
        btnDg.setOnClickListener(this)
        btnCh.setOnClickListener(this)
    }

    override fun initView() {
        getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/kubus-1.png")
        horizontalScrollButton()
        cardView()
        rusuk()
        bidangSisi()
        titikSudut()
        bidangDiagonal()
        diagonalRuang()
        diagonalSisi()
    }

    override fun updateViewData() {
    }

    override fun onSuccess(msg: String?) {
    }

    override fun onError(msg: String?) {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_rusuk->{
                crdRusuk.visibility = View.VISIBLE
                crdBidangSisi.visibility = View.GONE
                crdTitikSudut.visibility = View.GONE
                crdBidangDiagonal.visibility = View.GONE
                crdDiagonalRuang.visibility = View.GONE
                crdDiagonalSisi.visibility = View.GONE

                btnRusuk.setBackgroundResource(R.drawable.button_rounded)
                btnBidangSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnTitikSudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangDiagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalRuang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnRusuk.setTextColor(Color.parseColor("#FFFFFF"))
                btnBidangSisi.setTextColor(Color.parseColor("#000000"))
                btnTitikSudut.setTextColor(Color.parseColor("#000000"))
                btnBidangDiagonal.setTextColor(Color.parseColor("#000000"))
                btnDiagonalRuang.setTextColor(Color.parseColor("#000000"))
                btnDiagonalSisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bidang_sisi->{
                crdRusuk.visibility = View.GONE
                crdBidangSisi.visibility = View.VISIBLE
                crdTitikSudut.visibility = View.GONE
                crdBidangDiagonal.visibility = View.GONE
                crdDiagonalRuang.visibility = View.GONE
                crdDiagonalSisi.visibility = View.GONE

                btnRusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangSisi.setBackgroundResource(R.drawable.button_rounded)
                btnTitikSudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangDiagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalRuang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnRusuk.setTextColor(Color.parseColor("#000000"))
                btnBidangSisi.setTextColor(Color.parseColor("#ffffff"))
                btnTitikSudut.setTextColor(Color.parseColor("#000000"))
                btnBidangDiagonal.setTextColor(Color.parseColor("#000000"))
                btnDiagonalRuang.setTextColor(Color.parseColor("#000000"))
                btnDiagonalSisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_titik_sudut->{
                crdRusuk.visibility = View.GONE
                crdBidangSisi.visibility = View.GONE
                crdTitikSudut.visibility = View.VISIBLE
                crdBidangDiagonal.visibility = View.GONE
                crdDiagonalRuang.visibility = View.GONE
                crdDiagonalSisi.visibility = View.GONE

                btnRusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnTitikSudut.setBackgroundResource(R.drawable.button_rounded)
                btnBidangDiagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalRuang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnRusuk.setTextColor(Color.parseColor("#000000"))
                btnBidangSisi.setTextColor(Color.parseColor("#000000"))
                btnTitikSudut.setTextColor(Color.parseColor("#ffffff"))
                btnBidangDiagonal.setTextColor(Color.parseColor("#000000"))
                btnDiagonalRuang.setTextColor(Color.parseColor("#000000"))
                btnDiagonalSisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bidang_diagonal->{
                crdRusuk.visibility = View.GONE
                crdBidangSisi.visibility = View.GONE
                crdTitikSudut.visibility = View.GONE
                crdBidangDiagonal.visibility = View.VISIBLE
                crdDiagonalRuang.visibility = View.GONE
                crdDiagonalSisi.visibility = View.GONE

                btnRusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnTitikSudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangDiagonal.setBackgroundResource(R.drawable.button_rounded)
                btnDiagonalRuang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnRusuk.setTextColor(Color.parseColor("#000000"))
                btnBidangSisi.setTextColor(Color.parseColor("#000000"))
                btnTitikSudut.setTextColor(Color.parseColor("#000000"))
                btnBidangDiagonal.setTextColor(Color.parseColor("#ffffff"))
                btnDiagonalRuang.setTextColor(Color.parseColor("#000000"))
                btnDiagonalSisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_diagonal_ruang->{
                crdRusuk.visibility = View.GONE
                crdBidangSisi.visibility = View.GONE
                crdTitikSudut.visibility = View.GONE
                crdBidangDiagonal.visibility = View.GONE
                crdDiagonalRuang.visibility = View.VISIBLE
                crdDiagonalSisi.visibility = View.GONE

                btnRusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnTitikSudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangDiagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalRuang.setBackgroundResource(R.drawable.button_rounded)
                btnDiagonalSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnRusuk.setTextColor(Color.parseColor("#000000"))
                btnBidangSisi.setTextColor(Color.parseColor("#000000"))
                btnTitikSudut.setTextColor(Color.parseColor("#000000"))
                btnBidangDiagonal.setTextColor(Color.parseColor("#000000"))
                btnDiagonalRuang.setTextColor(Color.parseColor("#ffffff"))
                btnDiagonalSisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_diagonal_sisi->{
                crdRusuk.visibility = View.GONE
                crdBidangSisi.visibility = View.GONE
                crdTitikSudut.visibility = View.GONE
                crdBidangDiagonal.visibility = View.GONE
                crdDiagonalRuang.visibility = View.GONE
                crdDiagonalSisi.visibility = View.VISIBLE

                btnRusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangSisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnTitikSudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBidangDiagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalRuang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDiagonalSisi.setBackgroundResource(R.drawable.button_rounded)

                btnRusuk.setTextColor(Color.parseColor("#000000"))
                btnBidangSisi.setTextColor(Color.parseColor("#000000"))
                btnTitikSudut.setTextColor(Color.parseColor("#000000"))
                btnBidangDiagonal.setTextColor(Color.parseColor("#000000"))
                btnDiagonalRuang.setTextColor(Color.parseColor("#000000"))
                btnDiagonalSisi.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ab->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ab.png")

                btnAb.setBackgroundResource(R.drawable.button_rounded)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#ffffff"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ad->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ad.png")

                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#ffffff"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_bc.png")

                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#ffffff"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_dc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_dc.png")

                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#ffffff"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ef->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ef.png")
                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#ffffff"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_fg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_fg.png")

                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#ffffff"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_hg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_hg.png")
                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#ffffff"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_eh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_eh.png")
                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#ffffff"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ae->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ae.png")
                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#ffffff"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bf->{
                getImageView("https:///mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_bf.png")

                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#ffffff"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_cg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_cg.png")
                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded)
                btnDh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#ffffff"))
                btnDh.setTextColor(Color.parseColor("#000000"))
        }
            R.id.btn_dh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_dh.png")
                btnAb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnHg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDh.setBackgroundResource(R.drawable.button_rounded)

                btnAb.setTextColor(Color.parseColor("#000000"))
                btnAd.setTextColor(Color.parseColor("#000000"))
                btnBc.setTextColor(Color.parseColor("#000000"))
                btnDc.setTextColor(Color.parseColor("#000000"))
                btnEf.setTextColor(Color.parseColor("#000000"))
                btnFg.setTextColor(Color.parseColor("#000000"))
                btnHg.setTextColor(Color.parseColor("#000000"))
                btnEh.setTextColor(Color.parseColor("#000000"))
                btnAe.setTextColor(Color.parseColor("#000000"))
                btnBf.setTextColor(Color.parseColor("#000000"))
                btnCg.setTextColor(Color.parseColor("#000000"))
                btnDh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_abfe->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_abfe.png")
                btnAbfe.setBackgroundResource(R.drawable.button_rounded)
                btnAdhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAbfe.setTextColor(Color.parseColor("#ffffff"))
                btnAdhe.setTextColor(Color.parseColor("#000000"))
                btnEfgh.setTextColor(Color.parseColor("#000000"))
                btnAbcd.setTextColor(Color.parseColor("#000000"))
                btnDcgh.setTextColor(Color.parseColor("#000000"))
                btnBfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_adhe->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_adhe.png")
                btnAbfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdhe.setBackgroundResource(R.drawable.button_rounded)
                btnEfgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAbfe.setTextColor(Color.parseColor("#000000"))
                btnAdhe.setTextColor(Color.parseColor("#ffffff"))
                btnEfgh.setTextColor(Color.parseColor("#000000"))
                btnAbcd.setTextColor(Color.parseColor("#000000"))
                btnDcgh.setTextColor(Color.parseColor("#000000"))
                btnBfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_efgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_efgh.png")
                btnAbfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfgh.setBackgroundResource(R.drawable.button_rounded)
                btnAbcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAbfe.setTextColor(Color.parseColor("#000000"))
                btnAdhe.setTextColor(Color.parseColor("#000000"))
                btnEfgh.setTextColor(Color.parseColor("#ffffff"))
                btnAbcd.setTextColor(Color.parseColor("#000000"))
                btnDcgh.setTextColor(Color.parseColor("#000000"))
                btnBfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_abcd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_abcd.png")
                btnAbfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbcd.setBackgroundResource(R.drawable.button_rounded)
                btnDcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAbfe.setTextColor(Color.parseColor("#000000"))
                btnAdhe.setTextColor(Color.parseColor("#000000"))
                btnEfgh.setTextColor(Color.parseColor("#000000"))
                btnAbcd.setTextColor(Color.parseColor("#ffffff"))
                btnDcgh.setTextColor(Color.parseColor("#000000"))
                btnBfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_dcgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_dcgh.png")
                btnAbfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDcgh.setBackgroundResource(R.drawable.button_rounded)
                btnBfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAbfe.setTextColor(Color.parseColor("#000000"))
                btnAdhe.setTextColor(Color.parseColor("#000000"))
                btnEfgh.setTextColor(Color.parseColor("#000000"))
                btnAbcd.setTextColor(Color.parseColor("#000000"))
                btnDcgh.setTextColor(Color.parseColor("#ffffff"))
                btnBfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bfgc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_bfgc.png")
                btnAbfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBfgc.setBackgroundResource(R.drawable.button_rounded)

                btnAbfe.setTextColor(Color.parseColor("#000000"))
                btnAdhe.setTextColor(Color.parseColor("#000000"))
                btnEfgh.setTextColor(Color.parseColor("#000000"))
                btnAbcd.setTextColor(Color.parseColor("#000000"))
                btnDcgh.setTextColor(Color.parseColor("#000000"))
                btnBfgc.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_a->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusA.png")
                btnA.setBackgroundResource(R.drawable.button_rounded)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#ffffff"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_b->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusB.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#ffffff"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_c->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusC.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#ffffff"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_d->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusD.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#ffffff"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_e->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusE.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#ffffff"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_f->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusF.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#ffffff"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_g->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusG.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded)
                btnH.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#ffffff"))
                btnH.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_h->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusH.png")
                btnA.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnB.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnC.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnD.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnE.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnF.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnG.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnH.setBackgroundResource(R.drawable.button_rounded)

                btnA.setTextColor(Color.parseColor("#000000"))
                btnB.setTextColor(Color.parseColor("#000000"))
                btnC.setTextColor(Color.parseColor("#000000"))
                btnD.setTextColor(Color.parseColor("#000000"))
                btnE.setTextColor(Color.parseColor("#000000"))
                btnF.setTextColor(Color.parseColor("#000000"))
                btnG.setTextColor(Color.parseColor("#000000"))
                btnH.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_dbfh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_dbfh.png")
                btnDbfh.setBackgroundResource(R.drawable.button_rounded)
                btnEhcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDbfh.setTextColor(Color.parseColor("#ffffff"))
                btnEhcb.setTextColor(Color.parseColor("#000000"))
                btnAdgf.setTextColor(Color.parseColor("#000000"))
                btnEfcd.setTextColor(Color.parseColor("#000000"))
                btnAegc.setTextColor(Color.parseColor("#000000"))
                btnAbgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ehcb->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_ehcb.png")
                btnDbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEhcb.setBackgroundResource(R.drawable.button_rounded)
                btnAdgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDbfh.setTextColor(Color.parseColor("#000000"))
                btnEhcb.setTextColor(Color.parseColor("#ffffff"))
                btnAdgf.setTextColor(Color.parseColor("#000000"))
                btnEfcd.setTextColor(Color.parseColor("#000000"))
                btnAegc.setTextColor(Color.parseColor("#000000"))
                btnAbgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_adgf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_adgf.png")
                btnDbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEhcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdgf.setBackgroundResource(R.drawable.button_rounded)
                btnEfcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDbfh.setTextColor(Color.parseColor("#000000"))
                btnEhcb.setTextColor(Color.parseColor("#000000"))
                btnAdgf.setTextColor(Color.parseColor("#ffffff"))
                btnEfcd.setTextColor(Color.parseColor("#000000"))
                btnAegc.setTextColor(Color.parseColor("#000000"))
                btnAbgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_efcd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_efcd.png")
                btnDbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEhcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfcd.setBackgroundResource(R.drawable.button_rounded)
                btnAegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDbfh.setTextColor(Color.parseColor("#000000"))
                btnEhcb.setTextColor(Color.parseColor("#000000"))
                btnAdgf.setTextColor(Color.parseColor("#000000"))
                btnEfcd.setTextColor(Color.parseColor("#ffffff"))
                btnAegc.setTextColor(Color.parseColor("#000000"))
                btnAbgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_aegc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_aegc.png")
                btnDbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEhcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAegc.setBackgroundResource(R.drawable.button_rounded)
                btnAbgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDbfh.setTextColor(Color.parseColor("#000000"))
                btnEhcb.setTextColor(Color.parseColor("#000000"))
                btnAdgf.setTextColor(Color.parseColor("#000000"))
                btnEfcd.setTextColor(Color.parseColor("#000000"))
                btnAegc.setTextColor(Color.parseColor("#ffffff"))
                btnAbgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_abgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_abgh.png")
                btnDbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEhcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAdgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEfcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAbgh.setBackgroundResource(R.drawable.button_rounded)

                btnDbfh.setTextColor(Color.parseColor("#000000"))
                btnEhcb.setTextColor(Color.parseColor("#000000"))
                btnAdgf.setTextColor(Color.parseColor("#000000"))
                btnEfcd.setTextColor(Color.parseColor("#000000"))
                btnAegc.setTextColor(Color.parseColor("#000000"))
                btnAbgh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_df->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_df.png")
                btnDf.setBackgroundResource(R.drawable.button_rounded)
                btnAg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDf.setTextColor(Color.parseColor("#ffffff"))
                btnAg.setTextColor(Color.parseColor("#000000"))
                btnEc.setTextColor(Color.parseColor("#000000"))
                btnBh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ag->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_ag.png")
                btnDf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAg.setBackgroundResource(R.drawable.button_rounded)
                btnEc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDf.setTextColor(Color.parseColor("#000000"))
                btnAg.setTextColor(Color.parseColor("#ffffff"))
                btnEc.setTextColor(Color.parseColor("#000000"))
                btnBh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ec->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_ec.png")
                btnDf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEc.setBackgroundResource(R.drawable.button_rounded)
                btnBh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnDf.setTextColor(Color.parseColor("#000000"))
                btnAg.setTextColor(Color.parseColor("#000000"))
                btnEc.setTextColor(Color.parseColor("#ffffff"))
                btnBh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_bh.png")
                btnDf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBh.setBackgroundResource(R.drawable.button_rounded)

                btnDf.setTextColor(Color.parseColor("#000000"))
                btnAg.setTextColor(Color.parseColor("#000000"))
                btnEc.setTextColor(Color.parseColor("#000000"))
                btnBh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_af->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_af.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#ffffff"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_be->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_be.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#ffffff"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_bg.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#ffffff"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_cf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_cf.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#ffffff"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ah->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ah.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#ffffff"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_de->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_de.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#ffffff"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_eg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_eg.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#ffffff"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_fh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_fh.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#ffffff"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ac->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ac.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#ffffff"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_bd.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#ffffff"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_dg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_dg.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded)
                btnCh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#ffffff"))
                btnCh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ch->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ch.png")
                btnAf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnEg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnFh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnAc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnBd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnDg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btnCh.setBackgroundResource(R.drawable.button_rounded)

                btnAf.setTextColor(Color.parseColor("#000000"))
                btnBe.setTextColor(Color.parseColor("#000000"))
                btnBg.setTextColor(Color.parseColor("#000000"))
                btnCf.setTextColor(Color.parseColor("#000000"))
                btnAh.setTextColor(Color.parseColor("#000000"))
                btnDe.setTextColor(Color.parseColor("#000000"))
                btnEg.setTextColor(Color.parseColor("#000000"))
                btnFh.setTextColor(Color.parseColor("#000000"))
                btnAc.setTextColor(Color.parseColor("#000000"))
                btnBd.setTextColor(Color.parseColor("#000000"))
                btnDg.setTextColor(Color.parseColor("#000000"))
                btnCh.setTextColor(Color.parseColor("#ffffff"))
            }
        }
    }
}
