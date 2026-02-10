package tn.studio.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import tn.studio.myapplication.screen.TeamCreationRoute
import tn.studio.myapplication.screen.TeamCreationScreen
import tn.studio.myapplication.screen.TeamScoringRoute
import tn.studio.myapplication.screen.TeamScoringScreen
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
                    val backStack = remember { mutableStateListOf<Any>(TeamCreationRoute) }
                    NavDisplay(
                        backStack = backStack,
                        onBack = { backStack.removeLastOrNull() },
                        entryProvider = entryProvider {
                            entry<TeamCreationRoute> {
                                TeamCreationScreen(padding) { teamOneName, teamTwoName ->
                                    backStack.add(TeamScoringRoute(teamOneName, teamTwoName))
                                }
                            }
                            entry<TeamScoringRoute> { value ->
                                TeamScoringScreen(
                                    padding = padding,
                                    teamOneName = value.teamOneName,
                                    teamTwoName = value.teamTwoName
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}
