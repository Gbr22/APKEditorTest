package com.example.apkeditortest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.apkeditortest.ui.theme.APKEditorTestTheme
import org.json.JSONObject
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APKEditorTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val stringValue = getString(R.string.test_string);
                    val tabulated = stringValue.replace("\t","    "); // convert tab to 4 spaces because "Text" cannot properly display tabs
                    Greeting(tabulated);
                }
            }
        }
    }
}

@Composable
fun Greeting(str: String, modifier: Modifier = Modifier) {
    val o = JSONObject();

    Log.d("log.txt","${Json.encodeToString(str)}");
    Text(
        text = "$str",
        modifier = modifier,
        fontFamily = FontFamily.Monospace,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    APKEditorTestTheme {
        Greeting("Android")
    }
}