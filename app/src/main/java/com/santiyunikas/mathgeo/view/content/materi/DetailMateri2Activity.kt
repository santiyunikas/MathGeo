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
        btn_ad.setOnClickListener(this)
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

    private fun btnDefaultForHorizontalScroll(){
        cont_rusuk.visibility = View.GONE
        cont_sisi.visibility = View.GONE
        cont_titik_sudut.visibility = View.GONE
        cont_bidang_diagonal.visibility = View.GONE
        cont_diagonal_ruang.visibility = View.GONE
        cont_diagonal_sisi.visibility = View.GONE

        btn_rusuk.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded_beforeclick)

        btn_rusuk.setTextColor(Color.parseColor("#000000"))
        btn_bidang_sisi.setTextColor(Color.parseColor("#000000"))
        btn_titik_sudut.setTextColor(Color.parseColor("#000000"))
        btn_bidang_diagonal.setTextColor(Color.parseColor("#000000"))
        btn_diagonal_ruang.setTextColor(Color.parseColor("#000000"))
        btn_diagonal_sisi.setTextColor(Color.parseColor("#000000"))
    }

    private fun btnDefaultForContent(){
        //rusuk
        btn_ab.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_ad.setBackgroundResource(R.drawable.button_rounded_beforeclick)
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
        btn_ad.setTextColor(Color.parseColor("#000000"))
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

        //bidang sisi
        btn_abfe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_adhe.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_efgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_abcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_dcgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_bfgc.setBackgroundResource(R.drawable.button_rounded_beforeclick)

        btn_abfe.setTextColor(Color.parseColor("#000000"))
        btn_adhe.setTextColor(Color.parseColor("#000000"))
        btn_efgh.setTextColor(Color.parseColor("#000000"))
        btn_abcd.setTextColor(Color.parseColor("#000000"))
        btn_dcgh.setTextColor(Color.parseColor("#000000"))
        btn_bfgc.setTextColor(Color.parseColor("#000000"))

        //titik sudut
        btn_a.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_b.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_c.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_d.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_e.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_f.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_g.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_h.setBackgroundResource(R.drawable.button_rounded_beforeclick)

        btn_a.setTextColor(Color.parseColor("#000000"))
        btn_b.setTextColor(Color.parseColor("#000000"))
        btn_c.setTextColor(Color.parseColor("#000000"))
        btn_d.setTextColor(Color.parseColor("#000000"))
        btn_e.setTextColor(Color.parseColor("#000000"))
        btn_f.setTextColor(Color.parseColor("#000000"))
        btn_g.setTextColor(Color.parseColor("#000000"))
        btn_h.setTextColor(Color.parseColor("#000000"))

        //diagonal ruang
        btn_dbfh.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_ehcb.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_adgf.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_efcd.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_aegc.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_abgh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

        btn_dbfh.setTextColor(Color.parseColor("#000000"))
        btn_ehcb.setTextColor(Color.parseColor("#000000"))
        btn_adgf.setTextColor(Color.parseColor("#000000"))
        btn_efcd.setTextColor(Color.parseColor("#000000"))
        btn_aegc.setTextColor(Color.parseColor("#000000"))
        btn_abgh.setTextColor(Color.parseColor("#000000"))

        //bidang diagonal
        btn_df.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_ag.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_ec.setBackgroundResource(R.drawable.button_rounded_beforeclick)
        btn_bh.setBackgroundResource(R.drawable.button_rounded_beforeclick)

        btn_df.setTextColor(Color.parseColor("#000000"))
        btn_ag.setTextColor(Color.parseColor("#000000"))
        btn_ec.setTextColor(Color.parseColor("#000000"))
        btn_bh.setTextColor(Color.parseColor("#000000"))

        //diagonal sisi
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
        btn_dg.setTextColor(Color.parseColor("#000000"))
        btn_ch.setTextColor(Color.parseColor("#000000"))
    }

    override fun onClick(v: View?) {
        when(v?.id){
            //horizontalscroll
            R.id.btn_rusuk->{
                btnDefaultForHorizontalScroll()

                cont_rusuk.visibility = View.VISIBLE
                btn_rusuk.setBackgroundResource(R.drawable.button_rounded)
                btn_rusuk.setTextColor(Color.parseColor("#FFFFFF"))
            }
            R.id.btn_bidang_sisi->{
                btnDefaultForHorizontalScroll()

                cont_sisi.visibility = View.VISIBLE
                btn_bidang_sisi.setBackgroundResource(R.drawable.button_rounded)
                btn_bidang_sisi.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_titik_sudut->{
                btnDefaultForHorizontalScroll()

                cont_titik_sudut.visibility = View.VISIBLE
                btn_titik_sudut.setBackgroundResource(R.drawable.button_rounded)
                btn_titik_sudut.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bidang_diagonal->{
                btnDefaultForHorizontalScroll()

                cont_bidang_diagonal.visibility = View.VISIBLE
                btn_bidang_diagonal.setBackgroundResource(R.drawable.button_rounded)
                btn_bidang_diagonal.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_diagonal_ruang->{
                btnDefaultForHorizontalScroll()

                cont_diagonal_ruang.visibility = View.VISIBLE
                btn_diagonal_ruang.setBackgroundResource(R.drawable.button_rounded)
                btn_diagonal_ruang.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_diagonal_sisi->{
                btnDefaultForHorizontalScroll()

                cont_diagonal_sisi.visibility = View.VISIBLE
                btn_diagonal_sisi.setBackgroundResource(R.drawable.button_rounded)
                btn_diagonal_sisi.setTextColor(Color.parseColor("#ffffff"))
            }

            //rusuk
            R.id.btn_ab->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ab.png")
                btnDefaultForContent()
                btn_ab.setBackgroundResource(R.drawable.button_rounded)
                btn_ab.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ad->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ad.png")
                btnDefaultForContent()
                btn_ad.setBackgroundResource(R.drawable.button_rounded)
                btn_ad.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_bc.png")
                btnDefaultForContent()
                btn_bc.setBackgroundResource(R.drawable.button_rounded)
                btn_bc.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_dc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_dc.png")
                btnDefaultForContent()
                btn_dc.setBackgroundResource(R.drawable.button_rounded)
                btn_dc.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ef->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ef.png")
                btnDefaultForContent()
                btn_ef.setBackgroundResource(R.drawable.button_rounded)
                btn_ef.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_fg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_fg.png")
                btnDefaultForContent()
                btn_fg.setBackgroundResource(R.drawable.button_rounded)
                btn_fg.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_hg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_hg.png")
                btnDefaultForContent()
                btn_hg.setBackgroundResource(R.drawable.button_rounded)
                btn_hg.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_eh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_eh.png")
                btnDefaultForContent()
                btn_eh.setBackgroundResource(R.drawable.button_rounded)
                btn_eh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ae->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_ae.png")
                btnDefaultForContent()
                btn_ae.setBackgroundResource(R.drawable.button_rounded)
                btn_ae.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bf->{
                getImageView("https:///mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_bf.png")
                btnDefaultForContent()
                btn_bf.setBackgroundResource(R.drawable.button_rounded)
                btn_bf.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_cg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_cg.png")
                btnDefaultForContent()
                btn_cg.setBackgroundResource(R.drawable.button_rounded)
                btn_cg.setTextColor(Color.parseColor("#ffffff"))
        }
            R.id.btn_dh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/rusuk_dh.png")
                btnDefaultForContent()
                btn_dh.setBackgroundResource(R.drawable.button_rounded)
                btn_dh.setTextColor(Color.parseColor("#ffffff"))
            }

            //bidang sisi
            R.id.btn_abfe->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_abfe.png")
                btnDefaultForContent()
                btn_abfe.setBackgroundResource(R.drawable.button_rounded)
                btn_abfe.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_adhe->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_adhe.png")
                btnDefaultForContent()
                btn_adhe.setBackgroundResource(R.drawable.button_rounded)
                btn_adhe.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_efgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_efgh.png")
                btnDefaultForContent()
                btn_efgh.setBackgroundResource(R.drawable.button_rounded)
                btn_efgh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_abcd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_abcd.png")
                btnDefaultForContent()
                btn_abcd.setBackgroundResource(R.drawable.button_rounded)
                btn_abcd.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_dcgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_dcgh.png")
                btnDefaultForContent()
                btn_dcgh.setBackgroundResource(R.drawable.button_rounded)
                btn_dcgh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bfgc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/sisi_bfgc.png")
                btnDefaultForContent()
                btn_bfgc.setBackgroundResource(R.drawable.button_rounded)
                btn_bfgc.setTextColor(Color.parseColor("#ffffff"))
            }

            //titik sudut
            R.id.btn_a->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusA.png")
                btnDefaultForContent()
                btn_a.setBackgroundResource(R.drawable.button_rounded)
                btn_a.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_b->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusB.png")
                btnDefaultForContent()
                btn_b.setBackgroundResource(R.drawable.button_rounded)
                btn_b.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_c->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusC.png")
                btnDefaultForContent()
                btn_c.setBackgroundResource(R.drawable.button_rounded)
                btn_c.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_d->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusD.png")
                btnDefaultForContent()
                btn_d.setBackgroundResource(R.drawable.button_rounded)
                btn_d.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_e->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusE.png")
                btnDefaultForContent()
                btn_e.setBackgroundResource(R.drawable.button_rounded)
                btn_e.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_f->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusF.png")
                btnDefaultForContent()
                btn_f.setBackgroundResource(R.drawable.button_rounded)
                btn_f.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_g->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusG.png")
                btnDefaultForContent()
                btn_g.setBackgroundResource(R.drawable.button_rounded)
                btn_g.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_h->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/KubusH.png")
                btnDefaultForContent()
                btn_h.setBackgroundResource(R.drawable.button_rounded)
                btn_h.setTextColor(Color.parseColor("#ffffff"))
            }

            //diagonal ruang
            R.id.btn_dbfh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_dbfh.png")
                btnDefaultForContent()
                btn_dbfh.setBackgroundResource(R.drawable.button_rounded)
                btn_dbfh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ehcb->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_ehcb.png")
                btnDefaultForContent()
                btn_ehcb.setBackgroundResource(R.drawable.button_rounded)
                btn_ehcb.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_adgf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_adgf.png")
                btnDefaultForContent()
                btn_adgf.setBackgroundResource(R.drawable.button_rounded)
                btn_adgf.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_efcd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_efcd.png")
                btnDefaultForContent()
                btn_efcd.setBackgroundResource(R.drawable.button_rounded)
                btn_efcd.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_aegc->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_aegc.png")
                btnDefaultForContent()
                btn_aegc.setBackgroundResource(R.drawable.button_rounded)
                btn_aegc.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_abgh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/bidang_diagonal_abgh.png")
                btnDefaultForContent()
                btn_abgh.setBackgroundResource(R.drawable.button_rounded)
                btn_abgh.setTextColor(Color.parseColor("#ffffff"))
            }

            //bidang diagonal
            R.id.btn_df->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_df.png")
                btnDefaultForContent()
                btn_df.setBackgroundResource(R.drawable.button_rounded)
                btn_df.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ag->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_ag.png")
                btnDefaultForContent()
                btn_ag.setBackgroundResource(R.drawable.button_rounded)
                btn_ag.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ec->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_ec.png")
                btnDefaultForContent()
                btn_ec.setBackgroundResource(R.drawable.button_rounded)
                btn_ec.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_ruang_bh.png")
                btnDefaultForContent()
                btn_bh.setBackgroundResource(R.drawable.button_rounded)
                btn_bh.setTextColor(Color.parseColor("#ffffff"))
            }

            //diagonal sisi
            R.id.btn_af->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_af.png")
                btnDefaultForContent()
                btn_af.setBackgroundResource(R.drawable.button_rounded)
                btn_af.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_be->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_be.png")
                btnDefaultForContent()
                btn_be.setBackgroundResource(R.drawable.button_rounded)
                btn_be.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_bg.png")
                btnDefaultForContent()
                btn_bg.setBackgroundResource(R.drawable.button_rounded)
                btn_bg.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_cf->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_cf.png")
                btnDefaultForContent()
                btn_cf.setBackgroundResource(R.drawable.button_rounded)
                btn_cf.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ah->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ah.png")
                btnDefaultForContent()
                btn_ah.setBackgroundResource(R.drawable.button_rounded)
                btn_ah.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_de->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_de.png")
                btnDefaultForContent()
                btn_de.setBackgroundResource(R.drawable.button_rounded)
                btn_de.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_eg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_eg.png")
                btnDefaultForContent()
                btn_eg.setBackgroundResource(R.drawable.button_rounded)
                btn_eg.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_fh->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_fh.png")
                btnDefaultForContent()
                btn_fh.setBackgroundResource(R.drawable.button_rounded)
                btn_fh.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ac->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ac.png")
                btnDefaultForContent()
                btn_ac.setBackgroundResource(R.drawable.button_rounded)
                btn_ac.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_bd->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_bd.png")
                btnDefaultForContent()
                btn_bd.setBackgroundResource(R.drawable.button_rounded)
                btn_bd.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_dg->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_dg.png")
                btnDefaultForContent()
                btn_dg.setBackgroundResource(R.drawable.button_rounded)
                btn_dg.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.btn_ch->{
                getImageView("https://mathgeo.ub-learningtechnology.com/asset/materi2/diagonal_sisi_ch.png")
                btnDefaultForContent()
                btn_ch.setBackgroundResource(R.drawable.button_rounded)
                btn_ch.setTextColor(Color.parseColor("#ffffff"))
            }
        }
    }
}
