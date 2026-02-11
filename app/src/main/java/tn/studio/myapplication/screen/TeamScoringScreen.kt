package tn.studio.myapplication.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.room.Room
import tn.studio.myapplication.composables.TeamScoreCard
import tn.studio.myapplication.data.ResultDatabase
import tn.studio.myapplication.data.TeamResultDTO

data class TeamScoringRoute(
    val teamOneName: String,
    val teamTwoName: String
) : NavKey

@Composable
fun TeamScoringScreen(
    teamOneName: String,
    teamTwoName: String,
    padding: PaddingValues,
    onPartyOver: () -> Unit
) {
    val orientation = LocalConfiguration.current.orientation
    var scoreTeamOne by remember { mutableIntStateOf(0) }
    var scoreTeamTwo by remember { mutableIntStateOf(0) }
    Box(modifier = Modifier.padding(padding)) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                val context = LocalContext.current

                if (scoreTeamOne >= 15 || scoreTeamTwo >= 15) {
                    val db = Room.databaseBuilder(
                        context = context.applicationContext,
                        klass = ResultDatabase::class.java,
                        name = "result_db"
                    ).build()

                    db.resultDao().insertResult(
                        TeamResultDTO(
                            id = System.currentTimeMillis(),
                            teamOneName = teamOneName,
                            teamTwoName = teamTwoName,
                            teamOneScore = scoreTeamOne,
                            teamTwoScore = scoreTeamTwo
                        )
                    )

                    onPartyOver()
                }

                TeamScoreCard(
                    teamName = teamOneName,
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
                    teamName = teamTwoName,
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
