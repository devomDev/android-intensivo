package com.example.catalgoscompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.catalgoscompose.api.ApiClient
import com.example.catalgoscompose.models.bo.CharacterBo
import com.example.catalgoscompose.models.dto.CharacterDto
import com.example.catalgoscompose.util.BASE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun connectRetrofit(): ApiClient {
    val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    return retrofit.create(ApiClient::class.java)
}

fun getAllCharactersRemote(api: ApiClient, onSuccess: (List<CharacterBo>) -> Unit) {

    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        val listChars: ArrayList<CharacterDto> = api.getAllCharacterApi().results
        val listBo = mutableListOf<CharacterBo>()
        listChars.map {
            val item = CharacterBo(name = it.name!!, url = it.image!!)
            listBo.add(item)
        }
        onSuccess(listBo)
    }
}

@Composable
fun CharacterList(list: List<CharacterBo>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(list) {
            CharacterItem(imageUrl = it.url, name = it.name)
        }
    })
}

@Composable
fun CharacterItem(imageUrl: String, name: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (boxBg, boxBand) = createRefs()
            val topGuideBand = createGuidelineFromBottom(0.2f)
            val bottomGuideBand = createGuidelineFromBottom(0.03f)

            Box(modifier = Modifier
                .fillMaxSize()
                .constrainAs(boxBg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .constrainAs(boxBand) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topGuideBand)
                    bottom.linkTo(bottomGuideBand)

                }) {
                Text(
                    text = name,
                    color = Color.DarkGray,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.White, Color.Unspecified
                                )
                            )
                        )
                )
            }

        }
    }
}