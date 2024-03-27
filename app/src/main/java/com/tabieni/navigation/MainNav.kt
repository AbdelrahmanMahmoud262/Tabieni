package com.tabieni.navigation

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.tabieni.presentation_home.HomeScreen
import com.tabieni.presentation_plan.PlanScreen


fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = MainNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.HomeScreen.name) {
            HomeScreen(drawerState)
        }
        composable(MainNavOption.PlanScreen.name) {
            PlanScreen(drawerState = drawerState)
        }
    }
}

enum class MainNavOption {
    HomeScreen,
    PlanScreen
}