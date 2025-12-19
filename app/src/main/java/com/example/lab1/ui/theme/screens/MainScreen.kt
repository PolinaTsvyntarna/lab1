package com.example.lab1.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun MainScreen(onButtonClick: () -> Unit) {
    // Зберігаємо стан тексту навіть при повороті екрану
    var text by rememberSaveable { mutableStateOf("Головний екран") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            text = "Текст змінено!"
            onButtonClick()  // переходимо на екран профілю
        }) {
            Text("Перейти до профілю")
        }
    }
}
