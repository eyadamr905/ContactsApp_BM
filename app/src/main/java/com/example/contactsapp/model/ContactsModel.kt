package com.example.contactsapp.model

import androidx.annotation.DrawableRes

data class ContactsModel(
    val name : String,
    val phoneNumber : String,
    @DrawableRes val image : Int,
)