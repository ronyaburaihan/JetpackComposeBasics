package com.primebazar.jetpackcomposebasic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
            UserCard()
        }
    }
}

@Composable
fun Title() {
    val context = LocalContext.current
    Text(
        text = "Prime IT",
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
fun UserCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .border(width = 1.dp, color = Color.Gray)
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
            Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "John Doe")
            Text(text = "Android Developer")
            Button(onClick = {

            }) {
                Text(text = "View Profile")
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
        UserCard()
    }
}