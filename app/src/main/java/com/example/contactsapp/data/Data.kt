package com.example.contactsapp.data

import com.example.contactsapp.R
import com.example.contactsapp.model.ContactsModel

class Data {
    fun getContactsData(): List<ContactsModel> {
        return listOf(
         ContactsModel("Auntie", "01014240322", R.drawable.auntie),
         ContactsModel("Friend 1", "01014240322", R.drawable.friend_1),
         ContactsModel("Friend 2", "01014240322", R.drawable.friend_2),
         ContactsModel("Brother", "01014240322", R.drawable.brother),
         ContactsModel("Sister", "01014240322", R.drawable.sister),
         ContactsModel("Son", "01014240322", R.drawable.son),
         ContactsModel("Grand Father", "01014240322", R.drawable.grandfather),
         ContactsModel("Grand Mother", "01014240322", R.drawable.granny),
         ContactsModel("Uncle", "01014240322", R.drawable.uncle),
         ContactsModel("Daughter", "01014240322", R.drawable.daughter),
         ContactsModel("Neighbour", "01014240322", R.drawable.neigbour)
        )
    }
}
