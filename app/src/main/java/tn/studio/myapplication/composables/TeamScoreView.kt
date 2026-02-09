package tn.studio.myapplication.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tn.studio.myapplication.ui.theme.MyApplicationTheme

@Composable
fun TeamScoreCard(teamName: String, score: Int, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(teamName, style = TextStyle(fontSize = 48.sp, color = Color.White))
        Text(
            score.toString(),
            modifier = Modifier.padding(
                top = 16.dp
            ),
            style = TextStyle(
                fontSize = 180.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}

@Preview
@Composable
fun PreviewTeamScoreCard() {
    MyApplicationTheme {
        TeamScoreCard(
            teamName = "TeamOne",
            score = 20,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun PreviewTeamScoreCardGreen() {
    MyApplicationTheme {
        TeamScoreCard(
            teamName = "TeamOne",
            score = 20,
            modifier = Modifier
        )
    }
}