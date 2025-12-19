package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab1.ui.theme.Lab1Theme
import com.example.lab1.ui.theme.screens.MainScreen
import com.example.lab1.ui.theme.screens.ProfileScreen
import com.example.lab1.navigation.AppDestinations

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = AppDestinations.MAIN.name
                ) {
                    composable(AppDestinations.MAIN.name) {
                        MainScreen(
                            onButtonClick = { navController.navigate(AppDestinations.PROFILE.name) }
                        )
                    }
                    composable(AppDestinations.PROFILE.name) {
                        ProfileScreen(
                            onButtonClick = { navController.navigate(AppDestinations.MAIN.name) }
                        )
                    }
                }
            }
        }
    }
}
