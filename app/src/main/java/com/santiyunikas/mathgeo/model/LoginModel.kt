package com.santiyunikas.mathgeo.model

import com.santiyunikas.mathgeo.contract.ContractInterface

class LoginModel:ContractInterface.Model {
    lateinit var email: String
    lateinit var password: String

    constructor()

    constructor(email: String, password: String){
        this.email = email
        this.password = password
    }
}