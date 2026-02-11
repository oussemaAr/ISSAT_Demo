package tn.studio.myapplication.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tn.studio.myapplication.ResultModel

object TeamResultRoute

val fakeData = listOf(
    ResultModel("TeamOne", "TeamTwo", 20, 20),
    ResultModel("TeamOne", "TeamTwo", 20, 20),
    ResultModel("TeamOne", "TeamTwo", 20, 20),
    ResultModel("TeamOne", "TeamTwo", 20, 20),
)

@Composable
fun TeamResultScreen() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(fakeData) { item ->
            TeamResultItem(item)
        }
    }
}


@Composable
fun TeamResultItem(result: ResultModel) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(result.teamNameOne, style = MaterialTheme.typography.headlineLarge)
                Text(result.teamScoreOne.toString())
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(result.teamNameTwo, style = MaterialTheme.typography.headlineLarge)
                Text(result.teamScoreTwo.toString())
            }
        }
    }
}