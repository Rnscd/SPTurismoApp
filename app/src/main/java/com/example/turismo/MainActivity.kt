package com.example.turismo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.turismo.model.Turistico
import com.example.turismo.model.turisticos
import com.example.turismo.ui.theme.TurismoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TurismoApp()
        }
    }
}

@Composable
fun TurismoApp() {
    var light by remember {
        mutableStateOf(false)
    }
    TurismoTheme(light) {
        Scaffold(topBar = {
            Row(modifier = Modifier.height(50.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(
                    "Pontos Turisticos de São Paulo", style = TextStyle(
                        fontFamily = FontFamily.Cursive,
                        fontSize = 25.sp, textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(6.dp)
                )
                IconButton(onClick = { light = !light }) {
                    Icon(imageVector = if (light) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                        contentDescription = "Theme")
                }
        }
        }
        ) {
            LazyColumn(modifier = Modifier.padding(top = 15.dp)) {
                items(turisticos) {
                    CaTurismo(turistico = it)
                }
            }
        }
    }
}

@Composable
fun CaTurismo(turistico: Turistico ){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 15.dp, horizontal = 6.dp), elevation = 10.dp) {

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            CoTurismo(nome = turistico.nome, foto = turistico.foto, sobre = turistico.sobre)
        }
    }
}

@Composable
fun CoTurismo(@StringRes nome: Int, @StringRes sobre: Int, @DrawableRes foto: Int){

    var expandido by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMedium)))
    {

        Row(modifier = Modifier.clickable { expandido = !expandido }) {
            Text(text = stringResource(id = nome), style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .width(250.dp)
                        .weight(1f))
            Icon(imageVector = if(expandido) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = "expanda", modifier = Modifier.padding(horizontal = 5.dp))

        }
        Image(painter = painterResource(id = foto), contentDescription = "foto")
        if (expandido) {
            Text(text = stringResource(id = sobre), style = MaterialTheme.typography.body1)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TurismoTheme {
        TurismoApp()
    }
}
