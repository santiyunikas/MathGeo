package com.santiyunikas.mathgeo.view.content.materi

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jstarczewski.pc.mathview.src.MathView
import com.jstarczewski.pc.mathview.src.TextAlign
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface
import com.santiyunikas.mathgeo.util.network.InternetConnection
import kotlinx.android.synthetic.main.activity_pembahasan.*

class PembahasanActivity : AppCompatActivity(), ContractInterface.IView, ContractInterface.CustomView,
    View.OnClickListener {
    private var idMateri: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembahasan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Materi Bangun Ruang"
        idMateri = intent.getIntExtra("EXTRA_ID_MATERI", 0)
        Log.d("idmateripembahasan", idMateri.toString())
        if(InternetConnection.isConnected(this)){
            initView()
            updateViewData()
        }else{
            finish()
        }
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
        val fragment = PembahasanMateriImageFragment()
        fragment.arguments = bundle
        val fm = supportFragmentManager
        fragment.show(fm, MateriImageDialogFragment::class.java.simpleName)
    }

    override fun getButton(name: String) {
        TODO("Not yet implemented")
    }

    override fun getTextview(text: String?) {
        TODO("Not yet implemented")
    }

    override fun setImageView(url: String, image: ImageView) {
        Glide.with(this)
            .load(url)
            .into(image)
    }

    override fun setButton(name: String, btn: Button) {
        TODO("Not yet implemented")
    }

    override fun setTextview(text: String?, tv: TextView) {
        tv.text = text
    }

    override fun setMathview(tx: String?, mv: MathView) {
        mv.apply {
            textColor = "#000000"
            text = tx
            textZoom = 80
            textAlign = TextAlign.LEFT
        }
    }

    private fun initPembahasan3(){
        btn_pb.setOnClickListener(this)
        btn_ap.setOnClickListener(this)
        btn_ap2.setOnClickListener(this)
        btn_ap3.setOnClickListener(this)
        setMathview(" = $√{6^2+3^2}$", jawaban1)
        setMathview(" = $√{36+9} = √45$", jawaban2)
        setMathview(" = $√{9x5} = 3√5$", jawaban3)
        setMathview(" = $1/2 x 6 = 3$", soal1)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan3/kubus_p_segitiga.png",img_pembahasan3)
    }

    private fun initPembahasan4(){
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan4/kubus_diagonal_sisi.png",img_pembahasan41)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan4/segitiga_cfh.png",img_pembahasan42)
        btn_ch.setOnClickListener(this)
        btn_cf.setOnClickListener(this)
        btn_fh.setOnClickListener(this)
        setMathview("<p>$ CC’ = √{{6√2}^2⋅{{6}/{2√2}}^2}$</p>"+
                        "<p>$ CC’ = √{{6√2}^2⋅{3√2}^2}$</p>"+
                        "<p>$ CC’ = √{72-18}$</p>"+
                        "<p>$ CC’ = √54 = √{9x6} = 3√6$</p>", mv41)
    }

    private fun initPembahasan5(){
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan5/titik_d_ke_bidang_ach.png", img_pembahasan51)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan5/segitiga_ach.png", img_pembahasan52)
        btn_hdh_aksen.setOnClickListener(this)
        var text = """Jarak titik D terhadap bidang ACH sama dengan jarak DD’, dengan D’ merupakan titik proyeksi D pada bidang ACH yang terletak pada garis HH’
                                |BD = diagonal bidang = 6√2 cm
                                |Sehingga, 
                                |DH’ = ½BD = 3√2
                                |Selanjutnya,""".trimMargin()
        setTextview(text, tx_pembahasan51)
        setMathview("<p>$ HH’ = √{(DH)^2 + (DH’)^2}$</p>"+
                        "<p>$ HH’ = √{6^2 + (3√2)^2}$</p>"+
                        "<p>$ HH’ = √{36 + 18}$</p>"+
                        "<p>$ HH’ = √54 = √{9x6} = 3√6$</p>", mv51)
        text = """Berdasarkan luas segitiga HDH’ akan diperoleh
                                |½HH’DD’ = ½DH’DH
                                |HH’DD’ = DH’DH""".trimMargin()
        setTextview(text, tx_pembahasan52)
        setMathview("<p>$ DD’ = {DH’ DH}/{HH’}$</p>"+
                "<p>$ DD’ = {3√2x6}/{3√6}$</p>"+
                "<p>$ DD’ = {18√2}/{3√6}$</p>"+
                "<p>$ DD’ = {6√2/√6}x{√6/√6}$</p>"+
                "<p>$ DD’ = {6√12}/{6}$</p>"+
                "<p>$ DD’ = √12$</p>"+
                "<p>$ DD’ = √{4x3}$</p>"+
                "<p>$ DD’ = 2√3$</p>", mv52)
        text = """Ingat kembali ya, kalian tidak perlu mencari diagonal sisi atau diagonal ruang pada suatu kubus, karena secara pasti diagonal sisi suatu kubus = s√2 dan diagonal ruang suatu kubus = s√3""".trimMargin()
        setTextview(text, tx_pembahasan53)
    }

    private fun initPembahasan6(){
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Kubus_atas.png", img_pembahasan61)
        var text = """Jarak garis PQ terhadap garis EG sama dengan jarak titik M ke titik N
                                |Sebelum menentukan panjang MN, kita perlu menghitung panjang beberapa ruas garis terlebih dahulu""".trimMargin()
        setTextview(text, tx_pembahasan61)
        btn_pq.setOnClickListener(this)
        setMathview("<p>$ PQ = √{BP^2 + BQ^2}$</p>"+
                        "<p>$ PQ = √{5^2 + 5^2}$</p>"+
                        "<p>$ PQ = √{50} = √{25x2} = 5√{2}$</p>", mv61)
        btn_qn.setOnClickListener(this)
        setMathview("<p>$ QN = {1/2 PQ}$</p>"+
                        "<p>$ QN = {1/2}x{5√2}$</p>"+
                        "<p>$ QN = {5√2}/{2} cm$</p>", mvQn)
        btn_bn.setOnClickListener(this)
        setMathview("<p>$ BN = √{BQ^2-QN^2}$</p>"+
                "<p>$ BN = √{5^2-{(5/2√{2})}^2}$</p>"+
                "<p>$ BN = √{25-{25/2}}$</p>"+
                "<p>$ BN = √{{50/2}-{25/2}}$</p>"+
                "<p>$ BN = √{25/2}$</p>"+
                "<p>$ BN = 5/√{2}$</p>"+
                "<p>$ BN = {{5/√{2}} x {√{2}/√{2}} = {5√2/2}}$</p>", mvBn)
        btn_fm.setOnClickListener(this)
        text = """Mencari panjang FM:
                                    |FM merupakan setengah panjang diagonal sisi kubus (sisi EG), sehingga panjangnya adalah 
                                    |FM = 1/2 x 10√2 = 5√2
                                    |
                                    |Selanjutnya perhatikan gambar berikut!""".trimMargin()
        setTextview(text, tx_pembahasan62)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/kubus_bawah.png", img_pembahasan62)
        btn_mf_aksen.setOnClickListener(this)
        setMathview("<p>$ MF’ = {5√2 - {5√2}/2}$</p>"+
                "<p>$ MF’ = {{10√2}/2 - {5√2}/2}$</p>"+
                "<p>$ MF’ = {{5√2}/2}$</p>", mvMf_aksen)
        btn_mn.setOnClickListener(this)
        setMathview("<p>$ MN = √{MF^2+NF^2}$</p>" +
                        "<p>$ MN = √{({{5√2}/2})^2+10^2}$</p>" +
                        "<p>$ MN = √{{25/4}x2+100}$</p>"+
                        "<p>$ MN = √{{50/4}+100}$</p>"+
                        "<p>$ MN = √{{50/4}+{100/4}}$</p>"+
                        "<p>$ MN = √{450/4} = √{225x2/4}$</p>"+
                        "<p>$ MN = {15√2}/2$</p>", mvMn)
    }

    private fun initPembahasan7(){
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/kubus_1.png", img_pembahasan71)
        setTextview("""Keterangan :
                        |Garis QR merupakan jarak antara bidang DMN dengan garis KL
                        |DP tegak lurus dengan garis QR (karena QR adalah garis tinggi segitiga DQP)
                        |KB = BL = ½AB = ½(6) = 3cm""".trimMargin(), tx_pembahasan71)
        setTextview("""Berdasarkan teorema phytagoras, maka dapat diperoleh panjang KL dengan cara berikut.""".trimMargin(), tx_pembahasan72)
        setTextview("""Panjang QL = ½KL = ½3√2 = 3/2√2
                        |(karena BQ adalah garis tinggi dan garis berat segitiga KLB)""".trimMargin(), tx_pembahasan73)
        btn_klb.setOnClickListener(this)
        setMathview("<p> $ KL = √{BK^2+BL^2} $ </p>"+
                        "<p> $ KL = √{3^2+3^2} $ </p>"+
                        "<p> $ KL = √{9+9} $ </p>"+
                        "<p> $ KL = √{18} = 3√2 $ </p>", mv71)
        btn_hp.setOnClickListener(this)
        setTextview("""Berdasarkan teorema phytagoras maka dapat diperoleh persamaan dibawah""".trimMargin(), tx_pembahasan74)
        setMathview("<p> $ BQ = √{BL^2-QL^2} $ </p>"+
                        "<p> $ BQ = √{3^2-{3/2√2}^2} $ </p>"+
                        "<p> $ BQ = √{9-{9x{2/4}}} $ </p>"+
                        "<p> $ BQ = √{{36/4}-{18/4}} $ </p>"+
                        "<p> $ BQ = √{18/4} = √{9{2/4}} = {3√2}/2 $ </p>"+
                        "<p> $ Panjang HP = BQ = {3√2}/2 $ </p>",mv72)
        btn_dq.setOnClickListener(this)
        setMathview("<p> $ DQ = BD - BQ $ </p>"+
                        "<p> $ DQ = 6√2 - {3√2}/2 $ </p>"+
                        "<p> $ DQ = {12√2}/2 - {3√2}/2 $ </p>"+
                        "<p> $ DQ = {9√2}/2 $ </p>", mv73)
        setTextview("""Perhatikan gambar berikut!""".trimMargin(), tx_pembahasan75)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/kubus_2.png", img_pembahasan72)
        btn_pf_aksen.setOnClickListener(this)
        setTextview("""Sebelumnya, cari panjang HF terlebih dahulu, FH = diagonal sisi = 6√2
                        |FF' = BQ = HP = {3√2}/2""".trimMargin(), tx_pembahasan76)
        setMathview("<p> $ PF’ = FH - (FF’ + HP) $ </p>"+
                        "<p> $ PF’ = 6√2 - ({3√2}/2 + {3√2}/2) $ </p>"+
                        "<p> $ PF’ = 6√2 - ({6√2}/2) $ </p>"+
                        "<p> $ PF’ = 6√2 - 3√2 = 3√2 $ </p>", mv74)
        setTextview("""Mencari panjang PQ
                        |BF = QF' = 6 cm""".trimMargin(), tx_pembahasan77)
        setMathview("<p> $ PQ = √{QF’^2 + PF’^2} $ </p>"+
                        "<p> $ PQ = √{6^2 + (3√2)^2} $ </p>"+
                        "<p> $ PQ = √{36 + (9 x 2)} $ </p>"+
                        "<p> $ PQ = √{36 + 18} $ </p>"+
                        "<p> $ PQ = √54 $ </p>"+
                        "<p> $ PQ = √{9x6} $ </p>"+
                        "<p> $ PQ = 3√6 $ </p>", mv75)
        setTextview(""""Perhatikan gambar berikut!""".trimMargin(), tx_pembahasan78)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/kubus_3.png", img_pembahasan73)
        btn_dp.setOnClickListener(this)
        setMathview("<p> $ DP = √{HP^2 + HD^2} $ </p>"+
                        "<p> $ DP = √{({{3√2}/2})^2 + 6^2} $ </p>"+
                        "<p> $ DP = √{{({9/4}) x 2} + 36} $ </p>"+
                        "<p> $ DP = √{{18/4} + {36}} $ </p>"+
                        "<p> $ DP = √{{18/4} + {144/4}} $ </p>"+
                        "<p> $ DP = √{162/4} = √{{81x2}/4} $ </p>"+
                        "<p> $ DP = {9√{2}}/2 $ </p>", mv76)
        setTextview("Selanjutnya perhatikan gambar berikut!", tx_pembahasan78)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/segitiga.png", img_pembahasan74)
        setTextview("""OP = OQ karena segitiga DQP merupakan segitiga sama kaki, sehingga DO adalah garis tinggi dan garis berat.
                        |Panjang QO = 1/2 PQ = 1/2 x 3√6
                        |
                        |Mencari panjang DO :""".trimMargin(), tx_pembahasan79)
        setMathview("<p> $ DO = √{DQ^2 - QO^2} $ </p>"+
                "<p> $ DO = √{({{9√2}/2})^2 - ({{3√6}/2})^2} $ </p>"+
                "<p> $ DO = √{{{81x2/4}} - {{9x6/4}}} $ </p>"+
                "<p> $ DO = √{{162/4} - {54/4}} $ </p>"+
                "<p> $ DO = √{108/4} = √{{36x3}/4} $ </p>"+
                "<p> $ DO = {6√{3}}/2 = 3√3 $ </p>", mv77)
        setTextview("""Mencari panjang QR :
                        |Berdasarkan luas segitiga akan diperoleh hasil dari QR seperti terlihat pada cara berikut
                        """.trimMargin(), tx_pembahasan80)
        setMathview("<p> $ {1/2}DP x QR = {1/2}PQ x DO $ </p>"+
                        "<p> $ DP x QR = PQ x DO $ </p>"+
                        "<p> $ {{9√{2}}/2} x QR = {3√6} x {3√3} $ </p>"+
                        "<p> $ QR = {{3√6} x {3√3}}/{{9√{2}}/2} $ </p>"+
                        "<p> $ QR = {9√18}/{{9√{2}}/2} $ </p>"+
                        "<p> $ QR = {9.3√2}/{{9√{2}}/2} $ </p>"+
                        "<p> $ QR = {27√2}/{{9√{2}}/2} $ </p>"+
                        "<p> $ QR = {{27√2}/{9√{2}}x2 $ </p>"+
                        "<p> $ QR = 3x2 = 6 $ </p>", mv78)
    }

    private fun initPembahasan8(){
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/kubus_utama.png", img_pembahasan81)
        setTextview("""Jarak bidang FPQ ke bidang DRS sama dengan jarak titik M ke titik L. Sebelum menentukan nilai ML diperlukan beberapa langkah perhitungan terlebih dahulu seperti berikut.""".trimMargin(), tx_pembahasan81)
        btn_pq_pembahasan8.setOnClickListener(this)
        setTextview("""PB = BQ = ½ x panjang rusuk kubus = ½ x 8 = 4cm
                        |Sehingga diperoleh persamaan dibawah panjang KL dengan cara berikut.""".trimMargin(), tx_pembahasan82)
        setMathview("<p>$ PQ = √{BP^2 + BQ^2}$</p>"+
                        "<p>$ PQ = √{4^2 + 4^2}$</p>"+
                        "<p>$ PQ = √{16 + 16}$</p>"+
                        "<p>$ PQ = √{16 x 2}$</p>"+
                        "<p>$ PQ = 4√{2}$</p>", mv81)
        setTextview("""Segitiga PBQ adalah segitiga sama kaki, sehingga BM merupakan garis tinggi dan PQ adalah garis berat
                        |Jadi PM = MQ = ½PQ = ½ . 4√2 = 2√2cm""".trimMargin(), tx_pembahasan83)
        btn_bm_pembahasan8.setOnClickListener(this)
        setTextview("""Perhatikan segitiga BMQ siku siku di M.""".trimMargin(), tx_pembahasan84)
        setMathview("<p>$ BM = √{BQ^2 - MQ^2}$</p>"+
                "<p>$ BM = √{4^2 - ({2√2})^2}$</p>"+
                "<p>$ BM = √{16 - 8} = √{8}$</p>"+
                "<p>$ BM = √{4 x 2} = 2√2 cm$</p>", mv82)
        btn_fm_pembahasan8.setOnClickListener(this)
        setTextview("""Perhatikan segitiga FBM siku siku di B.""".trimMargin(), tx_pembahasan85)
        setMathview("<p>$ FM = √{BM^2 + BF^2}$</p>"+
                "<p>$ FM = √{({2√2})^2 + 8^2}$</p>"+
                "<p>$ FM = √{8 + 64}$</p>"+
                "<p>$ FM = √{72} = √{36 x 2} = 6√2 cm$</p>", mv83)
        btn_bd_pembahasan8.setOnClickListener(this)
        setTextview("""BD = diagonal sisi = sisi√2 = 8√2cm""".trimMargin(), tx_pembahasan86)
        btn_dm_pembahasan8.setOnClickListener(this)
        setTextview("""DM = BD - BM
                        |DM = 8√2 - 2√2 = 6√2cm""".trimMargin(), tx_pembahasan87)
        btn_dmfk_pembahasan8.setOnClickListener(this)
        setImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/kubus_utama.png", img_pembahasan82)
        btn_ml_pembahasan8.setOnClickListener(this)
        setTextview("""DK x ML = DM x KT
                        |ML = (DM x KT) / DK
                        |ML = (6√2 x 8) / 6√2 = 8 cm""".trimMargin(), tx_pembahasan88)
        setTextview("""Jadi jarak bidang FPQ ke bidang DRS adalah 8 cm""".trimMargin(), tx_pembahasan89)
    }

    override fun initView() {
        cont_pembahasan3.visibility = View.GONE
        cont_pembahasan4.visibility = View.GONE
        cont_pembahasan5.visibility = View.GONE
        cont_pembahasan6.visibility = View.GONE
        cont_pembahasan7.visibility = View.GONE
        cont_pembahasan8.visibility = View.GONE
    }

    override fun updateViewData() {
        when(idMateri){
            3->{
                cont_pembahasan3.visibility = View.VISIBLE
                initPembahasan3()
            }
            4->{
                cont_pembahasan4.visibility = View.VISIBLE
                initPembahasan4()

            }
            5->{
                cont_pembahasan5.visibility = View.VISIBLE
                initPembahasan5()

            }
            6->{
                cont_pembahasan6.visibility = View.VISIBLE
                initPembahasan6()
            }
            7->{
                cont_pembahasan7.visibility = View.VISIBLE
                initPembahasan7()
            }
            8->{
                cont_pembahasan8.visibility = View.VISIBLE
                initPembahasan8()
            }
        }
    }

    override fun onSuccess(msg: String?) {
    }

    override fun onError(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_pb -> {
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan3/kubus_pb.png")
            }
            R.id.btn_ap -> {
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan3/kubus_ap.png")
            }
            R.id.btn_ap2 -> {
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan3/kubus_ap.png")
            }
            R.id.btn_ap3 -> {
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan3/kubus_ap.png")
            }
            R.id.btn_ch->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan4/kubus_2.png")
            }
            R.id.btn_cf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan4/kubus_2.png")
            }
            R.id.btn_fh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan4/kubus_2.png")
            }
            R.id.btn_hdh_aksen->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan5/Kubus-1.png")
            }
            R.id.btn_pq->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Kubus_PQ.png")
            }
            R.id.btn_qn->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Kubus_QN.png")
            }
            R.id.btn_bn->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Kubus_BN.png")
            }
            R.id.btn_fm->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Kubus_FM.png")
            }
            R.id.btn_mf_aksen->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Garis_MF'.png")
            }
            R.id.btn_mn->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan6/Garis_MN.png")
            }
            R.id.btn_klb->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/klb.png")
            }
            R.id.btn_hp->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/hp.png")
            }
            R.id.btn_dq->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/dq.png")
            }
            R.id.btn_pf_aksen->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/pf.png")
            }
            R.id.btn_dp->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan7/dp.png")
            }
            R.id.btn_pq_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/pq.png")
            }
            R.id.btn_bm_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/bm.png")
            }
            R.id.btn_fm_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/fm.png")
            }
            R.id.btn_bd_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/bd.png")
            }
            R.id.btn_dm_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/dm.png")
            }
            R.id.btn_dmfk_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/dmfk.png")
            }
            R.id.btn_ml_pembahasan8->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/pembahasan8/ml.png")
            }
        }
    }
}