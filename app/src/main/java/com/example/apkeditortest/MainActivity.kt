package com.example.apkeditortest

import android.os.Bundle
import android.text.Annotation
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.SpannedString
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.getSpans
import com.example.apkeditortest.ui.theme.APKEditorTestTheme
import org.json.JSONObject
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val stringValue = getString(R.string.test_string);
        val spannedString = getText(R.string.test_string) as SpannedString;
        val spannableString = SpannableString(spannedString);

        Log.d("apkeditor_test","${Json.encodeToString(stringValue)}");

        setContent {
            APKEditorTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AndroidView(
                        factory = { context ->
                            TextView(context).apply {
                                this.setText(spannableString);
                            }
                        },
                    )
                }
            }
        }
    }
}