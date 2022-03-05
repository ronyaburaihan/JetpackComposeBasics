package com.primebazar.jetpackcomposebasic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (i in 1..12) {
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
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
                Text(text = "John Doe", fontSize = 20.sp)
                Text(text = "Android Developer", fontSize = 16.sp)
                Button(onClick = {

                }) {
                    Text(text = "View Profile")
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