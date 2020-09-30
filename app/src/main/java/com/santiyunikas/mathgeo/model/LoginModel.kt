package com.santiyunikas.mathgeo.model

import com.santiyunikas.mathgeo.contract.ContractInterface

class LoginModel:ContractInterface.Model {
    lateinit var email: String
    lateinit var password: String
    lateinit var confirmPassword: String

    constructor()

    constructor(email: String, password: String){
        this.email = email
        this.password = password
    }

    constructor(email: String, password: String, confirmPassword: String){
        this.email = email
        this.password = password
        this.confirmPassword = confirmPassword
    }
}