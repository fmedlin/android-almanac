package org.fmedlin.almanac.jpc_adaptive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.fmedlin.almanac.jpc_adaptive.ui.theme.AndroidAlmanacTheme
import org.fmedlin.almanac_core.presentation.util.DeviceConfiguration
import org.fmedlin.almanac_core.presentation.util.currentDeviceConfiguration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAlmanacTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val configuration = currentDeviceConfiguration()
    val (text, style) = when(configuration) {
        DeviceConfiguration.Compact -> "Compact" to TextStyle(fontSize = 26.sp)
        DeviceConfiguration.Medium -> "Medium" to TextStyle(fontSize = 46.sp)
        DeviceConfiguration.Expanded -> "Expanded" to TextStyle(fontSize = 66.sp)
        DeviceConfiguration.Large -> "Large" to TextStyle(fontSize = 86.sp)
        DeviceConfiguration.ExtraLarge -> "Extra Large" to TextStyle(fontSize = 106.sp)
    }
    Text(
        text = text,
        style = style,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidAlmanacTheme {
        Greeting()
    }
}