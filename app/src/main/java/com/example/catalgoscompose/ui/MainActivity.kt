package com.example.catalgoscompose.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.catalgoscompose.api.ApiClient
import com.example.catalgoscompose.models.bo.CharacterBo
import com.example.catalgoscompose.models.dto.CharacterDto
import com.example.catalgoscompose.ui.theme.CatalgosComposeTheme
import com.example.catalgoscompose.util.BASE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("viewState","onCreate")

        val api = connectRetrofit()

        setContent {
            CatalgosComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {


                    /*var dataList: List<CharacterBo> by rememberSaveable { mutableStateOf(emptyList()) }
                    CharacterList(list = dataList)
                    getAllCharactersRemote(api, onSuccess = {
                        dataList = it
                    })*/
                    MySwitch()


                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("viewState","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("viewState","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("viewState","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("viewState","onStop")
    }

    override fun onRestart() {
        Log.i("viewState","onRestart")
        super.onRestart()

    }

    override fun onDestroy() {
        Log.i("viewState","onDestroy")
        super.onDestroy()

    }
}


