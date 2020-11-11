package com.santiyunikas.mathgeo.view.content.materi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.jstarczewski.pc.mathview.src.MathView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import kotlinx.android.synthetic.main.activity_detail_materi2.*

class DetailMateri2Activity : AppCompatActivity(), IView, CustomView, View.OnClickListener {

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
        val fragment = MateriImageDialogFragment()
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

    override fun setImageView(url: String, image: ImageView) {
        TODO("Not yet implemented")
    }

    override fun setButton(name: String, btn: Button) {
        TODO("Not yet implemented")
    }

    override fun setTextview(tx: String?, tv: TextView) {
        TODO("Not yet implemented")
    }

    override fun setMathview(tx: String?, mv: MathView) {
        TODO("Not yet implemented")
    }

    private fun horizontalScrollButton(){
        btn_rusuk.setOnClickListener(this)
        btn_bidang_sisi.setOnClickListener(this)
        btn_titik_sudut.setOnClickListener(this)
        btn_bidang_diagonal.setOnClickListener(this)
        btn_diagonal_ruang.setOnClickListener(this)
        btn_diagonal_sisi.setOnClickListener(this)

        btn_rusuk.setBackgroundResource(R.drawable.button_rounded)
        btn_rusuk.setTextColor(Color.parseColor("#FFFFFF"))
    }

    private fun cardView(){
        cont_rusuk.visibility = View.VISIBLE
        cont_sisi.visibility = View.GONE
        cont_titik_sudut.visibility = View.GONE
        cont_bidang_diagonal.visibility = View.GONE
        cont_diagonal_ruang.visibility = View.GONE
        cont_diagonal_sisi.visibility = View.GONE
    }

    private fun rusuk(){
        btn_ab.setOnClickListener(this)
        btn_bc.setOnClickListener(this)
        btn_bc.setOnClickListener(this)
        btn_dc.setOnClickListener(this)
        btn_ef.setOnClickListener(this)
        btn_fg.setOnClickListener(this)
        btn_hg.setOnClickListener(this)
        btn_eh.setOnClickListener(this)
        btn_ae.setOnClickListener(this)
        btn_bf.setOnClickListener(this)
        btn_cg.setOnClickListener(this)
        btn_dh.setOnClickListener(this)
    }

    private fun bidangSisi(){
        btn_abfe.setOnClickListener(this)
        btn_adhe.setOnClickListener(this)
        btn_efgh.setOnClickListener(this)
        btn_abcd.setOnClickListener(this)
        btn_dcgh.setOnClickListener(this)
        btn_bfgc.setOnClickListener(this)
    }

    private fun titikSudut(){
        btn_a.setOnClickListener(this)
        btn_b.setOnClickListener(this)
        btn_c.setOnClickListener(this)
        btn_d.setOnClickListener(this)
        btn_e.setOnClickListener(this)
        btn_f.setOnClickListener(this)
        btn_g.setOnClickListener(this)
        btn_h.setOnClickListener(this)
    }

    private fun diagonalRuang(){
        btn_df.setOnClickListener(this)
        btn_ag.setOnClickListener(this)
        btn_ec.setOnClickListener(this)
        btn_bh.setOnClickListener(this)
    }

    private fun bidangDiagonal(){
        btn_dbfh.setOnClickListener(this)
        btn_ehcb.setOnClickListener(this)
        btn_adgf.setOnClickListener(this)
        btn_efcd.setOnClickListener(this)
        btn_aegc.setOnClickListener(this)
        btn_abgh.setOnClickListener(this)
    }

    private fun diagonalSisi(){
        btn_af.setOnClickListener(this)
        btn_be.setOnClickListener(this)
        btn_bg.setOnClickListener(this)
        btn_cf.setOnClickListener(this)
        btn_ah.setOnClickListener(this)
        btn_de.setOnClickListener(this)
        btn_eg.setOnClickListener(this)
        btn_fh.setOnClickListener(this)
        btn_ac.setOnClickListener(this)
        btn_bd.setOnClickListener(this)
        btn_dg.setOnClickListener(this)
        btn_ch.setOnClickListener(this)
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
                cont_rusuk.visibility = View.VISIBLE
                cont_sisi.visibility = View.GONE
                cont_titik_sudut.visibility = View.GONE
                cont_bidang_diagonal.visibility = View.GONE
                cont_diagonal_ruang.visibility = View.GONE
                cont_diagonal_sisi.visibility = View.GONE

                btn_rusuk.setBackgroundResource(R.drawable.button_rounded)
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_rusuk.setTextColor(Color.parseColor("#FFFFFF"))
                btn_bidang_sisi.setTextColor(Color.parseColor("#000000"))
                btn_titik_sudut.setTextColor(Color.parseColor("#000000"))
                btn_bidang_diagonal.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_ruang.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_sisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bidang_sisi->{
                cont_rusuk.visibility = View.GONE
                cont_sisi.visibility = View.VISIBLE
                cont_titik_sudut.visibility = View.GONE
                cont_bidang_diagonal.visibility = View.GONE
                cont_diagonal_ruang.visibility = View.GONE
                cont_diagonal_sisi.visibility = View.GONE

                btn_rusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded)
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_rusuk.setTextColor(Color.parseColor("#000000"))
                btn_bidang_sisi.setTextColor(Color.parseColor("#ffffff"))
                btn_titik_sudut.setTextColor(Color.parseColor("#000000"))
                btn_bidang_diagonal.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_ruang.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_sisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_titik_sudut->{
                cont_rusuk.visibility = View.GONE
                cont_sisi.visibility = View.GONE
                cont_titik_sudut.visibility = View.VISIBLE
                cont_bidang_diagonal.visibility = View.GONE
                cont_diagonal_ruang.visibility = View.GONE
                cont_diagonal_sisi.visibility = View.GONE

                btn_rusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded)
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_rusuk.setTextColor(Color.parseColor("#000000"))
                btn_bidang_sisi.setTextColor(Color.parseColor("#000000"))
                btn_titik_sudut.setTextColor(Color.parseColor("#ffffff"))
                btn_bidang_diagonal.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_ruang.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_sisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bidang_diagonal->{
                cont_rusuk.visibility = View.GONE
                cont_sisi.visibility = View.GONE
                cont_titik_sudut.visibility = View.GONE
                cont_bidang_diagonal.visibility = View.VISIBLE
                cont_diagonal_ruang.visibility = View.GONE
                cont_diagonal_sisi.visibility = View.GONE

                btn_rusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded)
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_rusuk.setTextColor(Color.parseColor("#000000"))
                btn_bidang_sisi.setTextColor(Color.parseColor("#000000"))
                btn_titik_sudut.setTextColor(Color.parseColor("#000000"))
                btn_bidang_diagonal.setTextColor(Color.parseColor("#ffffff"))
                btn_diagonal_ruang.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_sisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_diagonal_ruang->{
                cont_rusuk.visibility = View.GONE
                cont_sisi.visibility = View.GONE
                cont_titik_sudut.visibility = View.GONE
                cont_bidang_diagonal.visibility = View.GONE
                cont_diagonal_ruang.visibility = View.VISIBLE
                cont_diagonal_sisi.visibility = View.GONE

                btn_rusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded)
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_rusuk.setTextColor(Color.parseColor("#000000"))
                btn_bidang_sisi.setTextColor(Color.parseColor("#000000"))
                btn_titik_sudut.setTextColor(Color.parseColor("#000000"))
                btn_bidang_diagonal.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_ruang.setTextColor(Color.parseColor("#ffffff"))
                btn_diagonal_sisi.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_diagonal_sisi->{
                cont_rusuk.visibility = View.GONE
                cont_sisi.visibility = View.GONE
                cont_titik_sudut.visibility = View.GONE
                cont_bidang_diagonal.visibility = View.GONE
                cont_diagonal_ruang.visibility = View.GONE
                cont_diagonal_sisi.visibility = View.VISIBLE

                btn_rusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded)

                btn_rusuk.setTextColor(Color.parseColor("#000000"))
                btn_bidang_sisi.setTextColor(Color.parseColor("#000000"))
                btn_titik_sudut.setTextColor(Color.parseColor("#000000"))
                btn_bidang_diagonal.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_ruang.setTextColor(Color.parseColor("#000000"))
                btn_diagonal_sisi.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ab->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ab.png")

                btn_ab.setBackgroundResource(R.drawable.button_rounded)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#ffffff"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ad->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ad.png")

                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#ffffff"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_bc.png")

                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#ffffff"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_dc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_dc.png")

                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#ffffff"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ef->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ef.png")
                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#ffffff"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_fg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_fg.png")

                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#ffffff"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_hg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_hg.png")
                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#ffffff"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_eh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_eh.png")
                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#ffffff"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ae->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ae.png")
                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#ffffff"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bf->{
                getImageView("https:///mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_bf.png")

                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#ffffff"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_cg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_cg.png")
                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded)
                btn_dh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#ffffff"))
                btn_dh.setTextColor(Color.parseColor("#000000"))
        }
            R.id.btn_dh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_dh.png")
                btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ef.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_hg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ae.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dh.setBackgroundResource(R.drawable.button_rounded)

                btn_ab.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_bc.setTextColor(Color.parseColor("#000000"))
                btn_dc.setTextColor(Color.parseColor("#000000"))
                btn_ef.setTextColor(Color.parseColor("#000000"))
                btn_fg.setTextColor(Color.parseColor("#000000"))
                btn_hg.setTextColor(Color.parseColor("#000000"))
                btn_eh.setTextColor(Color.parseColor("#000000"))
                btn_ae.setTextColor(Color.parseColor("#000000"))
                btn_bf.setTextColor(Color.parseColor("#000000"))
                btn_cg.setTextColor(Color.parseColor("#000000"))
                btn_dh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_abfe->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_abfe.png")
                btn_abfe.setBackgroundResource(R.drawable.button_rounded)
                btn_adhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_abfe.setTextColor(Color.parseColor("#ffffff"))
                btn_adhe.setTextColor(Color.parseColor("#000000"))
                btn_efgh.setTextColor(Color.parseColor("#000000"))
                btn_abcd.setTextColor(Color.parseColor("#000000"))
                btn_dcgh.setTextColor(Color.parseColor("#000000"))
                btn_bfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_adhe->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_adhe.png")
                btn_abfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adhe.setBackgroundResource(R.drawable.button_rounded)
                btn_efgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_abfe.setTextColor(Color.parseColor("#000000"))
                btn_adhe.setTextColor(Color.parseColor("#ffffff"))
                btn_efgh.setTextColor(Color.parseColor("#000000"))
                btn_abcd.setTextColor(Color.parseColor("#000000"))
                btn_dcgh.setTextColor(Color.parseColor("#000000"))
                btn_bfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_efgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_efgh.png")
                btn_abfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efgh.setBackgroundResource(R.drawable.button_rounded)
                btn_abcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_abfe.setTextColor(Color.parseColor("#000000"))
                btn_adhe.setTextColor(Color.parseColor("#000000"))
                btn_efgh.setTextColor(Color.parseColor("#ffffff"))
                btn_abcd.setTextColor(Color.parseColor("#000000"))
                btn_dcgh.setTextColor(Color.parseColor("#000000"))
                btn_bfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_abcd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_abcd.png")
                btn_abfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abcd.setBackgroundResource(R.drawable.button_rounded)
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_abfe.setTextColor(Color.parseColor("#000000"))
                btn_adhe.setTextColor(Color.parseColor("#000000"))
                btn_efgh.setTextColor(Color.parseColor("#000000"))
                btn_abcd.setTextColor(Color.parseColor("#ffffff"))
                btn_dcgh.setTextColor(Color.parseColor("#000000"))
                btn_bfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_dcgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_dcgh.png")
                btn_abfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded)
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_abfe.setTextColor(Color.parseColor("#000000"))
                btn_adhe.setTextColor(Color.parseColor("#000000"))
                btn_efgh.setTextColor(Color.parseColor("#000000"))
                btn_abcd.setTextColor(Color.parseColor("#000000"))
                btn_dcgh.setTextColor(Color.parseColor("#ffffff"))
                btn_bfgc.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bfgc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_bfgc.png")
                btn_abfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded)

                btn_abfe.setTextColor(Color.parseColor("#000000"))
                btn_adhe.setTextColor(Color.parseColor("#000000"))
                btn_efgh.setTextColor(Color.parseColor("#000000"))
                btn_abcd.setTextColor(Color.parseColor("#000000"))
                btn_dcgh.setTextColor(Color.parseColor("#000000"))
                btn_bfgc.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_a->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusA.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#ffffff"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_b->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusB.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#ffffff"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_c->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusC.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#ffffff"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_d->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusD.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#ffffff"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_e->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusE.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#ffffff"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_f->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusF.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#ffffff"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_g->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusG.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded)
                btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#ffffff"))
                btn_h.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_h->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusH.png")
                btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_h.setBackgroundResource(R.drawable.button_rounded)

                btn_a.setTextColor(Color.parseColor("#000000"))
                btn_b.setTextColor(Color.parseColor("#000000"))
                btn_c.setTextColor(Color.parseColor("#000000"))
                btn_d.setTextColor(Color.parseColor("#000000"))
                btn_e.setTextColor(Color.parseColor("#000000"))
                btn_f.setTextColor(Color.parseColor("#000000"))
                btn_g.setTextColor(Color.parseColor("#000000"))
                btn_h.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_dbfh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_dbfh.png")
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded)
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_aegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_dbfh.setTextColor(Color.parseColor("#ffffff"))
                btn_ehcb.setTextColor(Color.parseColor("#000000"))
                btn_adgf.setTextColor(Color.parseColor("#000000"))
                btn_efcd.setTextColor(Color.parseColor("#000000"))
                btn_aegc.setTextColor(Color.parseColor("#000000"))
                btn_abgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ehcb->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_ehcb.png")
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded)
                btn_adgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_aegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_dbfh.setTextColor(Color.parseColor("#000000"))
                btn_ehcb.setTextColor(Color.parseColor("#ffffff"))
                btn_adgf.setTextColor(Color.parseColor("#000000"))
                btn_efcd.setTextColor(Color.parseColor("#000000"))
                btn_aegc.setTextColor(Color.parseColor("#000000"))
                btn_abgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_adgf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_adgf.png")
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adgf.setBackgroundResource(R.drawable.button_rounded)
                btn_efcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_aegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_dbfh.setTextColor(Color.parseColor("#000000"))
                btn_ehcb.setTextColor(Color.parseColor("#000000"))
                btn_adgf.setTextColor(Color.parseColor("#ffffff"))
                btn_efcd.setTextColor(Color.parseColor("#000000"))
                btn_aegc.setTextColor(Color.parseColor("#000000"))
                btn_abgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_efcd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_efcd.png")
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efcd.setBackgroundResource(R.drawable.button_rounded)
                btn_aegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_dbfh.setTextColor(Color.parseColor("#000000"))
                btn_ehcb.setTextColor(Color.parseColor("#000000"))
                btn_adgf.setTextColor(Color.parseColor("#000000"))
                btn_efcd.setTextColor(Color.parseColor("#ffffff"))
                btn_aegc.setTextColor(Color.parseColor("#000000"))
                btn_abgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_aegc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_aegc.png")
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_aegc.setBackgroundResource(R.drawable.button_rounded)
                btn_abgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_dbfh.setTextColor(Color.parseColor("#000000"))
                btn_ehcb.setTextColor(Color.parseColor("#000000"))
                btn_adgf.setTextColor(Color.parseColor("#000000"))
                btn_efcd.setTextColor(Color.parseColor("#000000"))
                btn_aegc.setTextColor(Color.parseColor("#ffffff"))
                btn_abgh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_abgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_abgh.png")
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_adgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_efcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_aegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_abgh.setBackgroundResource(R.drawable.button_rounded)

                btn_dbfh.setTextColor(Color.parseColor("#000000"))
                btn_ehcb.setTextColor(Color.parseColor("#000000"))
                btn_adgf.setTextColor(Color.parseColor("#000000"))
                btn_efcd.setTextColor(Color.parseColor("#000000"))
                btn_aegc.setTextColor(Color.parseColor("#000000"))
                btn_abgh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_df->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_df.png")
                btn_df.setBackgroundResource(R.drawable.button_rounded)
                btn_ag.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ec.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_df.setTextColor(Color.parseColor("#ffffff"))
                btn_ag.setTextColor(Color.parseColor("#000000"))
                btn_ec.setTextColor(Color.parseColor("#000000"))
                btn_bh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ag->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_ag.png")
                btn_df.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ag.setBackgroundResource(R.drawable.button_rounded)
                btn_ec.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_df.setTextColor(Color.parseColor("#000000"))
                btn_ag.setTextColor(Color.parseColor("#ffffff"))
                btn_ec.setTextColor(Color.parseColor("#000000"))
                btn_bh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ec->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_ec.png")
                btn_df.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ag.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ec.setBackgroundResource(R.drawable.button_rounded)
                btn_bh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_df.setTextColor(Color.parseColor("#000000"))
                btn_ag.setTextColor(Color.parseColor("#000000"))
                btn_ec.setTextColor(Color.parseColor("#ffffff"))
                btn_bh.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_bh.png")
                btn_df.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ag.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ec.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bh.setBackgroundResource(R.drawable.button_rounded)

                btn_df.setTextColor(Color.parseColor("#000000"))
                btn_ag.setTextColor(Color.parseColor("#000000"))
                btn_ec.setTextColor(Color.parseColor("#000000"))
                btn_bh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_af->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_af.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#ffffff"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_be->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_be.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#ffffff"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_bg.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#ffffff"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_cf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_cf.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#ffffff"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ah->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ah.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#ffffff"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_de->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_de.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#ffffff"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_eg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_eg.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#ffffff"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_fh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_fh.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#ffffff"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ac->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ac.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#ffffff"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_bd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_bd.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#ffffff"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_dg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_dg.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded)
                btn_ch.setBackgroundResource(R.drawable.button_rounded_beforeclick)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#ffffff"))
                btn_ch.setTextColor(Color.parseColor("#000000"))
            }
            R.id.btn_ch->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ch.png")
                btn_af.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_be.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_cf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ah.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_de.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_eg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_fh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ac.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_bd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_dg.setBackgroundResource(R.drawable.button_rounded_beforeclick)
                btn_ch.setBackgroundResource(R.drawable.button_rounded)

                btn_af.setTextColor(Color.parseColor("#000000"))
                btn_be.setTextColor(Color.parseColor("#000000"))
                btn_bg.setTextColor(Color.parseColor("#000000"))
                btn_cf.setTextColor(Color.parseColor("#000000"))
                btn_ah.setTextColor(Color.parseColor("#000000"))
                btn_de.setTextColor(Color.parseColor("#000000"))
                btn_eg.setTextColor(Color.parseColor("#000000"))
                btn_fh.setTextColor(Color.parseColor("#000000"))
                btn_ac.setTextColor(Color.parseColor("#000000"))
                btn_bd.setTextColor(Color.parseColor("#000000"))
                btn_dg.setTextColor(Color.parseColor("#000000"))
                btn_ch.setTextColor(Color.parseColor("#ffffff"))
            }
        }
    }
}
