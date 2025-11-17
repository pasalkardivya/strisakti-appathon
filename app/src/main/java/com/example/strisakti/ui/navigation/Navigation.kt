package com.example.strisakti.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.strisakti.ui.screen.AdvantagesForWomenScreen
import com.example.strisakti.ui.screen.HomeScreen
import com.example.strisakti.ui.screen.LawForWomen
import com.example.strisakti.ui.screen.NewUpdatesScreen
import com.example.strisakti.ui.screen.PeriodsDateTreak
import com.example.strisakti.ui.screen.StartForWomens

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, "home") {
        composable("home") {
            HomeScreen(modifier, navController)
        }
        composable("new_updates") {
            NewUpdatesScreen(modifier, navController)
        }
        composable(route = "start_for_women") {
            StartForWomens (modifier, navController )

        }
        composable(route = "advantages_for_women"){
            AdvantagesForWomenScreen(modifier,navController)
        }
        composable (route = "periods_track"){
            PeriodsDateTreak(modifier,navController)
        }
        composable (route = "law_for_women"){
            LawForWomen(modifier,navController)
        }

    }
}

