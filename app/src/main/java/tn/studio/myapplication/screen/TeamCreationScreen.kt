package tn.studio.myapplication.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import tn.studio.myapplication.ui.theme.MyApplicationTheme


object TeamCreationRoute : NavKey

@Composable
fun TeamCreationScreen(padding: PaddingValues, onClick: (String, String) -> Unit) {
    Column(modifier = Modifier.padding(padding)) {
        var teamOneName by remember { mutableStateOf("") }
        var teamTwoName by remember { mutableStateOf("") }
        TextField(
            value = teamOneName,
            onValueChange = { value ->
                teamOneName = value
            }
        )

        TextField(
            value = teamTwoName,
            onValueChange = { value ->
                teamTwoName = value
            }
        )

        Button(onClick = {
            onClick(teamOneName, teamTwoName)
        }) {
            Icon(
                Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun PreviewTeamCreationScreen() {
    MyApplicationTheme {
        TeamCreationScreen(PaddingValues(8.dp)) { _, _ ->

        }
    }
}