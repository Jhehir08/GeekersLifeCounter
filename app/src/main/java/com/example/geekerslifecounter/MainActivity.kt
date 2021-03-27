package com.example.geekerslifecounter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.geekerslifecounter.ui.theme.GeekersLifeCounterTheme
import com.example.geekerslifecounter.CounterViewModel.Companion.Variant.TWO_PLAYER_COMMANDER

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {

    val viewModel = CounterViewModel(TWO_PLAYER_COMMANDER)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeekersLifeCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TwoPlayerLayout(viewModel)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        GeekersLifeCounterTheme {
            TwoPlayerLayout(viewModel)
        }
    }
}
