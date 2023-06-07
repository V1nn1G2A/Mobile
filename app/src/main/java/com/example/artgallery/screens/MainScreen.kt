package com.example.artgallery.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.artgallery.MainViewModel
import com.example.artgallery.data.models.Image
import com.example.artgallery.navigation.Screens

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allArts = viewModel.allArts.observeAsState(listOf()).value
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(15.dp)
        ) {
            items(allArts) {item ->
                ArtCard(item = item, navController = navController)
            }
        }
    }

}

@Composable
fun ArtCard(item: Image, navController: NavController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.Details.route + "/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.urls.small),
                contentDescription = "",
                modifier = Modifier.size(128.dp)
            )
            Column {
                Text(
                    text = item.alt_description,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = "Likes: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.likes.toString())
                }
                Row {
                    Text(
                        text = "Date: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.created_at.toString())
                }
            }
        }
    }
}