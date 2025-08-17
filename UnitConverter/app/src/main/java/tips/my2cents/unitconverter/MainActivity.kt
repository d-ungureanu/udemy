package tips.my2cents.unitconverter


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tips.my2cents.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    UnitConverter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val customTextStyle = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 32.sp,
    color = Color.Red
)

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var inputExpanded by remember { mutableStateOf(false) }
    var outputExpanded by remember { mutableStateOf(false) }
    val inputConversionFactor = remember { mutableDoubleStateOf(1.00) }
    val outputConversionFactor = remember { mutableDoubleStateOf(1.00) }

    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * inputConversionFactor.doubleValue * 100.0 / outputConversionFactor.doubleValue).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // All UI elements will be stacked below each other
        Text(
            "Unit Converter",
            style = customTextStyle
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = {
                Text("Enter value to convert")
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            // Input Box
            Box {
                // Input unit selector
                Button(onClick = { inputExpanded = true }) {
                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Convert from unit selector",
                    )
                    DropdownMenu(
                        expanded = inputExpanded, onDismissRequest = { inputExpanded = false }) {
                        DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                            inputUnit = "Centimeters"
                            inputExpanded = false
                            inputConversionFactor.doubleValue = 0.01
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Meters") }, onClick = {
                            inputUnit = "Meters"
                            inputExpanded = false
                            inputConversionFactor.doubleValue = 1.0
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Feet") }, onClick = {
                            inputUnit = "Feet"
                            inputExpanded = false
                            inputConversionFactor.doubleValue = 3.048
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Millimeters") }, onClick = {
                            inputUnit = "Millimeters"
                            inputExpanded = false
                            inputConversionFactor.doubleValue = 0.001
                            convertUnits()
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            // output Box
            Box {
                // Output unit selector
                Button(onClick = { outputExpanded = true }) {
                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Convert into unit selector",
                    )
                    DropdownMenu(
                        expanded = outputExpanded, onDismissRequest = { outputExpanded = false }) {
                        DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                            outputUnit = "Centimeters"
                            outputExpanded = false
                            outputConversionFactor.doubleValue = 0.01
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Meters") }, onClick = {
                            outputUnit = "Meters"
                            outputExpanded = false
                            outputConversionFactor.doubleValue = 1.0
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Feet") }, onClick = {
                            outputUnit = "Feet"
                            outputExpanded = false
                            outputConversionFactor.doubleValue = 0.3048
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Millimeters") }, onClick = {
                            outputUnit = "Millimeters"
                            outputExpanded = false
                            outputConversionFactor.doubleValue = 0.001
                            convertUnits()
                        })
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}