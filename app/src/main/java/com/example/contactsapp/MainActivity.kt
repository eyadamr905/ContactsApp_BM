package com.example.contactsapp

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.contactsapp.data.Data
import com.example.contactsapp.model.ContactsModel
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {

                    ContactScreen(homePhoneNumber = "01014240322")

                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(homePhoneNumber: String) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Contacts App")
                },
                actions = {
                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:$homePhoneNumber")
                        }
                        context.startActivity(intent)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        ContactApp(
            contacts = Data().getContactsData(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun ContactApp(contacts: List<ContactsModel>, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    LazyVerticalGrid(

        columns = if (isLandscape) GridCells.Fixed(5) else GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
    ) {
        items(contacts.size) { index ->
            val contact = contacts[index]
            ContactsListItem(contact)

        }
    }
}


@Composable
fun ContactsListItem(contact: ContactsModel) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .clickable {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${contact.phoneNumber}")
                }
                context.startActivity(intent)
            }
    ) {
        Image(
            painter = painterResource(id = contact.image),
            contentDescription = null
        )
        Text(text = contact.name)
        SelectionContainer {
            Text(text = contact.phoneNumber)
        }
    }
}
