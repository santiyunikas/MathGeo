package com.santiyunikas.mathgeo.presenter.quiz

import android.util.Log
import com.santiyunikas.mathgeo.model.*
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.santiyunikas.mathgeo.view.content.quiz.DetailQuizActivity

class DetailQuizPresenter(context: DetailQuizActivity) {
    private var view = context
    fun getDetailQuiz(id_quiz: Int) {
        NetworkConfig
            .serviceConnection()
            .getDetailQuiz(id_quiz)
            .enqueue(object : Callback<List<DetailQuiz>> {
                override fun onResponse(
                    call: Call<List<DetailQuiz>>,
                    response: Response<List<DetailQuiz>>
                ) {
                    val n = response.body()?.size
                    var it = 0
                    if (n != null) {
                        while (it < n) {
//                            Log.d("isiSoal",response.body()?.get(it)?.id_soal!!)
                            view.passingData(
                                response.body()?.get(it)?.id_soal!!,
                                response.body()?.get(it)?.id_quiz!!,
                                response.body()?.get(it)?.soal!!,
                                response.body()?.get(it)?.kunci!!,
                                response.body()?.get(it)?.pilihan_ganda!!,
                                response.body()?.get(it)?.gambar!!
                            )
                            it++
                        }
                    }
                    view.onSuccess("passingDataDone")
                }

                override fun onFailure(call: Call<List<DetailQuiz>>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }

            })
    }

    fun simpanReviewQuiz(jawaban: ArrayList<String>, soal: ArrayList<DetailQuiz>) {
        var jmlBenar = 0
        var jmlSalah = 0
        repeat(jawaban.size) {
            if (jawaban[it] == soal[it].kunci) {
                jmlBenar++
            } else {
                jmlSalah++
            }
        }
        view.onSuccess(jmlBenar.toString())

        NetworkConfig
            .serviceConnection()
            .getStatusMengerjakanQuiz(
                Preferences.getRegisteredIdUser(view.applicationContext!!).toString(),
                soal[0].id_quiz
            )
            .enqueue(object : Callback<List<StatusMengerjakanQuiz>> {
                override fun onResponse(
                    call: Call<List<StatusMengerjakanQuiz>>,
                    response: Response<List<StatusMengerjakanQuiz>>
                ) {
                    if (response.body()?.size!! > 0) {
                        Preferences.getRegisteredIdUser(view.applicationContext!!)?.let {
                            Log.d("jmlbenar", jmlBenar.toString())
                            updateReview(it, soal[0].id_quiz, jmlBenar)
                        }
                    } else if (response.body()?.size!! == 0) {
                        Preferences.getRegisteredIdUser(view.applicationContext!!)?.let {
                            postReview(it, soal[0].id_quiz, jmlBenar)
                        }
                    }
                }

                override fun onFailure(call: Call<List<StatusMengerjakanQuiz>>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }


            })


        view.showReviewDialog(jmlBenar)

    }

    private fun postReview(id_member: Int, id_quiz: String, nilai: Int) {
        NetworkConfig
            .serviceConnection()
            .addNilaiQuiz(id_member.toString(), id_quiz, nilai.toString())
            .enqueue(object : Callback<StatusMengerjakanQuiz> {
                override fun onResponse(
                    call: Call<StatusMengerjakanQuiz>,
                    response: Response<StatusMengerjakanQuiz>
                ) {
                    if (response.body()?.id_quiz != null) {
                        Log.d("successAddNilai", response.body().toString())
                        view.onSuccess("successAddNilai")
                    } else {
                        view.onError("Gagal Tambah Nilai")
                    }

                }

                override fun onFailure(call: Call<StatusMengerjakanQuiz>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }

            })
    }

    private fun updateReview(id_member: Int, id_quiz: String, nilai: Int) {
        NetworkConfig
            .serviceConnection()
            .updateNilaiQuiz(id_member.toString(), id_quiz, nilai.toString())
            .enqueue(object : Callback<StatusMengerjakanQuiz> {
                override fun onResponse(
                    call: Call<StatusMengerjakanQuiz>,
                    response: Response<StatusMengerjakanQuiz>
                ) {
                    if (response.body()?.toString()?.isNotEmpty()!!) {
                        Log.d("successUpdateNilai", response.body().toString())
                        view.onSuccess("successUpdateNilai")
                    } else {
                        view.onError("Gagal Update Nilai")
                    }
                }

                override fun onFailure(call: Call<StatusMengerjakanQuiz>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }
            })
    }

    fun updateJumlahKoin(nKoin: String){
        NetworkConfig.serviceConnection()
            .addNCoin(Preferences.getRegisteredEmail(view), nKoin)
            .enqueue(object: Callback<Member> {
                override fun onFailure(call: Call<Member>, t: Throwable) {
                    Log.d("eror",t.localizedMessage!!)
                }
                override fun onResponse(
                    call: Call<Member>,
                    response: Response<Member>
                ) {
                    if(response.body()?.jumlah_koin.toString().isNotEmpty()){
                        val koin = response.body()?.jumlah_koin.toString().toInt()
                        view.let { Preferences.setRegisteredJumlahKoin(it, koin) }
                        Log.d("jmlkoin1", Preferences.getRegisteredJumlahKoin(view).toString())
                    }else{
                        Log.d("eror2",response.message())
                    }
                }

            })
    }

}