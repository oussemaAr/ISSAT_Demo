package tn.studio.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class TeamResultDTO(
    @PrimaryKey val id : Long,
    @ColumnInfo(name = "home_team") val teamOneName: String,
    @ColumnInfo(name = "away_team") val teamTwoName: String,
    @ColumnInfo(name = "home_team_score") val teamOneScore: Int,
    @ColumnInfo(name = "away_team_score") val teamTwoScore: Int,
)