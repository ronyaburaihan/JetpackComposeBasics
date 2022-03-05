package com.primebazar.jetpackcomposebasic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }
    }
}

data class User(
    val id: Int,
    val name: String,
    val designation: String,
)

val userList = listOf(
    User(1, "Abu Raihan Rony", "Android Developer"),
    User(2, "Tanimul Islam", "Android Developer"),
    User(3, "Kawser Ahmed", "Android Developer"),
    User(4, "Shakil Ahmed", "Digital Marketing Expert"),
    User(5, "Hasibul Hasan Shanto", "Graphic Designer"),
    User(6, "Noyon Sarkar", "Digital Marketing Expert"),
    User(7, "Kamrul Hasan", "Web Designer"),
    User(8, "Ariful Islam", "Web Designer"),
    User(9, "Sojol Islam", "Web Designer"),
    User(10, "XYZ", "Web Designer")
)

@Composable
fun Title() {
    val context = LocalContext.current
    Text(
        text = "Hello Compose!",
        fontSize = 32.sp,
        fontFamily = FontFamily.Cursive,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.purple_700),
        modifier = Modifier.clickable {
            Toast.makeText(context, "Title Clicked", Toast.LENGTH_SHORT).show()
        }
    )
}

@Composable
fun UserList() {
    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (i in 1..12) {
            UserCard()
        }
    }*/

    LazyColumn {
        items(userList) { user ->
            UserCard(user)
        }
    }
}

@Composable
fun UserCard(user: User) {
    val context = LocalContext.current
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = user.name, fontSize = 20.sp)
                Text(text = user.designation, fontSize = 16.sp)
                Button(onClick = {
                    Toast.makeText(context, "${user.id}", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Show ID")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        UserList()
    }
}