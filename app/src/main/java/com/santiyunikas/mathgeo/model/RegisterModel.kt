package com.santiyunikas.mathgeo.model

import com.santiyunikas.mathgeo.contract.ContractInterface


class RegisterModel: ContractInterface.Model {
    var fullname: String
        get(){
            return field
        }
        set(value) {
            field = value
        }

    var numberPhone: String
        get(){
            return field
        }
        set(value) {
            field = value
        }

    var email: String
        get(){
            return field
        }
        set(value) {
            field = value
        }

    var password: String
        get(){
            return field
        }
        set(value) {
            field = value
        }

    var confirmPassword: String
        get(){
            return field
        }
        set(value) {
            field = value
        }
    constructor(fullname: String, numberPhone: String, email: String, password: String, confirmPassword: String){
        this.fullname = fullname
        this.numberPhone = numberPhone
        this.email = email
        this.password = password
        this.confirmPassword = confirmPassword
    }


}