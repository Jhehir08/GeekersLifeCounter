package com.example.geekerslifecounter

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geekerslifecounter.ui.theme.GeekersLifeCounterTheme

// Constants
const val HALF_RATIO_MODIFIER = 0.5f
const val LIFE_TEXT_SIZE = 40
const val DIVIDER_HEIGHT = 10
const val PLAYER_1 = 0
const val PLAYER_2 = 1
const val PLAYER_3 = 2
const val PLAYER_4 = 3

@ExperimentalStdlibApi
@Composable
fun TwoPlayerLayout(counterViewModel: CounterViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        /**
         * This is the parent container for the life counter views
         */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(HALF_RATIO_MODIFIER)
                .background(Color.Red)
        ) {
            /**
             * This is the wrapper for the top half (player1) touch area
             */
            Box {
                /**
                 * The purpose of this Box is to be able to place the Text
                 * over the touch area Columns in the center of the parent Row
                 */
                Row {
                    /**
                     * Wrapper for the invisible touch area Columns
                     */
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(HALF_RATIO_MODIFIER)
                            .clickable {
                                Log.i(
                                    "TAG",
                                    "Subtract from player 1 - ${counterViewModel.playerLifeCounters.value[PLAYER_1]}"
                                )
                                counterViewModel.subtractLife(PLAYER_1)
                            }
                    ) {}

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .clickable {
                                Log.i(
                                    "TAG",
                                    "Add to player 1 - ${counterViewModel.playerLifeCounters.value[PLAYER_1]}"
                                )
                                counterViewModel.addLife(PLAYER_1)
                            }
                    ) {}
                }

                val player1Life = remember {
                    counterViewModel.playerLifeCounters.value[PLAYER_1]
                }

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = player1Life.toString(),
                    fontSize = LIFE_TEXT_SIZE.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Divider(
            color = Color.Black, modifier = Modifier
                .fillMaxWidth()
                .height(DIVIDER_HEIGHT.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        ) {
            /**
             * This is the wrapper for the bottom half (player2) touch area
             */
            Box {
                /**
                 * The purpose of this Box is to be able to place the Text
                 * over the touch area Columns in the center of the parent Row
                 */
                Row {
                    /**
                     * Wrapper for the invisible touch area Columns
                     */
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(HALF_RATIO_MODIFIER)
                            .clickable {
                                Log.i(
                                    "TAG",
                                    "Subtract from player 2 - ${counterViewModel.playerLifeCounters.value[PLAYER_2]}"
                                )
                                counterViewModel.subtractLife(PLAYER_2)
                            }
                    ) {}

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .clickable {
                                Log.i(
                                    "TAG",
                                    "Add to player 2 - ${counterViewModel.playerLifeCounters.value[PLAYER_2]}"
                                )
                                counterViewModel.addLife(PLAYER_2)
                            }
                    ) {}
                }

                val player2Life = remember {
                    counterViewModel.playerLifeCounters.value[PLAYER_2]
                }

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = player2Life.toString(),
                    fontSize = LIFE_TEXT_SIZE.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@ExperimentalStdlibApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeekersLifeCounterTheme {
        TwoPlayerLayout(
            CounterViewModel(CounterViewModel.Companion.Variant.TWO_PLAYER_COMMANDER)
        )
    }
}
