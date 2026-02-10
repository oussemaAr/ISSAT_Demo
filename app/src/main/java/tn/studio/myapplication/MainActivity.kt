package tn.studio.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import tn.studio.myapplication.composables.TeamScoreCard
import tn.studio.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { padding ->
                    val orientation = LocalConfiguration.current.orientation
                    var scoreTeamOne by remember { mutableIntStateOf(0) }
                    var scoreTeamTwo by remember { mutableIntStateOf(0) }
                    Box(modifier = Modifier.padding(padding)) {
                        if (orientation == Configuration.ORIENTATION_PORTRAIT)
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                TeamScoreCard(
                                    teamName = "TeamOne",
                                    score = scoreTeamOne,
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxSize()
                                        .background(Color(0xFF22CED1))
                                        .clickable {
                                            scoreTeamOne += 1
                                        }
                                )

                                TeamScoreCard(
                                    teamName = "TeamTwo",
                                    score = scoreTeamTwo,
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxSize()
                                        .background(Color(0xFFF4980A))
                                        .clickable {
                                            scoreTeamTwo += 1
                                        }
                                )
                            }
                        else Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            TeamScoreCard(
                                teamName = "TeamOne",
                                score = scoreTeamOne,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                                    .background(Color(0xFF22CED1))
                                    .clickable {
                                        scoreTeamOne += 1
                                    }
                            )

                            TeamScoreCard(
                                teamName = "TeamTwo",
                                score = scoreTeamTwo,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                                    .background(Color(0xFFF4980A))
                                    .clickable {
                                        scoreTeamTwo += 1
                                    }
                            )
                        }
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(64.dp)
                                .clickable {
                                    scoreTeamOne = 0
                                    scoreTeamTwo = 0
                                }
                        )
                    }
                }
            }
        }
    }
}
