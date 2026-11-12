package com.example.myapplication.presentation.ui

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.presentation.viewModel.InstallState

@Composable
fun InstallButton(
    installState: InstallState,
    onInstallClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (installState) {
        is InstallState.NotInstalled -> {
            Button(onClick = onInstallClick, modifier = modifier) {
                Text("Установить")
            }
        }
        is InstallState.Installing -> {

            Button(
                onClick = onInstallClick,
                modifier = modifier,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {

                Text("Отменить (${installState.progress}%)")
            }
        }
        is InstallState.Installed -> {
            Button(onClick = {}, enabled = false, modifier = modifier) {
                Text("Установлено")
            }
        }
    }
}