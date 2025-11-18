package com.example.strisakti.ui.navigation
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.strisakti.ui.future_build.FutureBuildScreen
import com.example.strisakti.ui.screen.AdvantagesForWomenScreen
import com.example.strisakti.ui.screen.HomeScreen
import com.example.strisakti.ui.screen.LawForWomen
import com.example.strisakti.ui.screen.NewUpdatesScreen
import com.example.strisakti.ui.screen.PeriodsDateTreak
import com.example.strisakti.ui.screen.StartForWomens
import com.example.strisakti.ui.study_app.StudyAppScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val route = navBackStackEntry?.destination?.route ?: ""
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    route == BottomNavItem.WomenSafety.route,
                    { navController.navigate(BottomNavItem.WomenSafety.route) },
                    icon = { Icon(Icons.Default.Person, "women")},
                    label = { Text(BottomNavItem.WomenSafety.label) }
                )
                NavigationBarItem(
                    route == BottomNavItem.StudyApp.route,
                    { navController.navigate(BottomNavItem.StudyApp.route) },
                    icon = { Icon(Icons.Default.Book, BottomNavItem.StudyApp.label)},
                    label = { Text(BottomNavItem.StudyApp.label) }
                )
                NavigationBarItem(
                    route == BottomNavItem.FutureBuild.route,
                    { navController.navigate(BottomNavItem.FutureBuild.route) },
                    icon = { Icon(Icons.Default.RocketLaunch, BottomNavItem.FutureBuild.label)},
                    label = { Text(BottomNavItem.FutureBuild.label) }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.WomenSafety.route
        ) {
            // Provide a canonical "home" route as well for compatibility
            composable("home") {
                HomeScreen(modifier.padding(innerPadding), navController)
            }
            // ---------- WOMEN SAFETY (bottom-nav) ----------
            composable(BottomNavItem.WomenSafety.route) {
                HomeScreen(modifier.padding(innerPadding) ,navController)
            }
            composable("new_updates") {
                NewUpdatesScreen(modifier.padding(innerPadding), navController)
            }
            composable("start_for_women") {
                StartForWomens(modifier.padding(innerPadding), navController)
            }
            composable("advantages_for_women") {
                AdvantagesForWomenScreen(modifier.padding(innerPadding), navController)
            }
            composable("periods_track") {
                PeriodsDateTreak(modifier.padding(innerPadding), navController)
            }
            composable("law_for_women") {
                LawForWomen(modifier.padding(innerPadding), navController)
            }
            // ---------- STUDY APP ----------
            composable(BottomNavItem.StudyApp.route) {
                StudyAppScreen(modifier, navController)
            }
            // ---------- FUTURE BUILD ----------
            composable(BottomNavItem.FutureBuild.route) {
                FutureBuildScreen()
            }
        }
    }
}

sealed class BottomNavItem(var route: String, val label: String) {
    object WomenSafety : BottomNavItem("women_safety_home", "Safety")
    object StudyApp : BottomNavItem("study_app", "Study")
    object FutureBuild : BottomNavItem("future_build", "Future")
}