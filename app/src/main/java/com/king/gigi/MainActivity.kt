package com.king.gigi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.king.gigi.ui.theme.GigiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GigiTheme {
                Greeting(profile = Profile("Gigi", R.drawable.sun_cloud, "28", "Cloudy", "Sidoluhor, Godean", 31,65,3,1009))
            }
        }
    }
}
data class Profile(val name: String, var weatherPix: Int, var weatherDegree: String, var weatherDescription: String, var location: String, var sensible: Int, var humidity: Int, var wind: Int, var hp: Int)

@Composable
fun Greeting(profile: Profile) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(colors = listOf(
            Color(31, 31, 31),
            Color(61, 61, 61),
        )), shape = RectangleShape)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            Column(Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row (Modifier.weight(0.6F)){
                        Text(text = "Hey, ", fontSize = 30.sp, fontWeight = FontWeight.Light, color = Color(199, 199, 199))
                        Text(text = "${profile.name}!", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color(199, 199, 199))
                    }
                    Image(painter = painterResource(id = R.drawable.dashboard_24), contentDescription = "", alignment = Alignment.CenterEnd, modifier = Modifier.size(40.dp))
                }
                Text(text = "Today, Dec 29, 2020", modifier = Modifier.padding(0.dp,10.dp,0.dp,6.dp), color = Color(150, 150, 150), textAlign = TextAlign.Start)
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.25F)
                .background(brush = Brush.verticalGradient(colors = listOf(
                    Color(94, 94, 94),
                    Color(38, 38, 38),
                )), shape = RoundedCornerShape(20.dp)),
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(2.dp)){
                Row(Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxHeight(0.5f), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Row(Modifier.fillMaxWidth(0.7F), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Row(Modifier.fillMaxWidth(0.4F)){
                            Image(painter = painterResource(id = profile.weatherPix), modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp), contentDescription = "", contentScale = ContentScale.FillBounds)
                        }
                        Column(Modifier.fillMaxWidth()) {
                            Text(text = profile.weatherDescription, textAlign = TextAlign.Start, color = Color.White)
                            Text(text = profile.location, textAlign = TextAlign.Start, color = Color(150, 150, 150))
                        }
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "${profile.weatherDegree}°", modifier = Modifier.fillMaxWidth(), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White, textAlign = TextAlign.Center)
                    }
                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxHeight(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Row(Modifier.fillMaxWidth(0.7F), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row(Modifier.fillMaxWidth(0.33F)){
                            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "${profile.sensible}°", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                                Text(text = "Sensible", fontSize = 12.sp ,color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                            }
                        }
                        Row(Modifier.fillMaxWidth(0.50F)){
                            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "${profile.humidity}%", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                                Text(text = "Humidity", fontSize = 12.sp , color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                            }
                        }
                        Row(Modifier.fillMaxWidth()){
                            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "${profile.wind}", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                                Text(text = "W.Force", fontSize = 12.sp , color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                            }
                        }
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "${profile.hp} hPa", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                            Text(text = "pressure", color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                        }
                    }
                }
            }

            Row(Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp, 0.dp, 5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                Row(modifier = Modifier.fillMaxWidth(.30f)){
                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Living room", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 15.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Image(painter = painterResource(id = R.drawable.ic_baseline_circle_24), contentDescription = "", Modifier.size(15.dp))
                    }
                }
                Row(Modifier.fillMaxWidth(.333F)){
                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Bedroom", fontWeight = FontWeight.Normal, color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 15.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "", color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                    }
                }
                Row(Modifier.fillMaxWidth(.50F)){
                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Bathroom", fontWeight = FontWeight.Normal, color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 15.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "", color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                    }
                }
                Row(Modifier.fillMaxWidth(1F)){
                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Kitchen", fontWeight = FontWeight.Normal, color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 15.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "", color = Color(150, 150, 150), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                    }
                }
            }

            Column(modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(.48F), verticalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier
                    .fillMaxHeight(.5F)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    AirCondition()
                    Lamp()
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.92F), horizontalArrangement = Arrangement.SpaceBetween) {
                    Smart()
                    Router()
                }
            }
        }
    }
}


@Composable
fun AirCondition(){

    var checkedState = remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth(.48F)) {
        Column(Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(
                Color(33, 32, 38),
                Color(50, 50, 50),
            )), shape = RoundedCornerShape(20.dp, 50.dp, 20.dp, 50.dp))) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                Column(Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.47F), verticalArrangement = Arrangement.SpaceEvenly) {
                    Icon(painter = painterResource(id = R.drawable.air_conditioner), contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp))
                    Text(text = "Air Conditioner", fontWeight = FontWeight.Normal, color = Color.White, fontSize = 20.sp)
                }
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = if (checkedState.value){"on"}else{"off"}, color = Color(150, 150, 150), fontSize = 18.sp)

                        Box(modifier = Modifier.fillMaxWidth(),
                            contentAlignment= Alignment.TopEnd) {
                            Switch(
                                checked= checkedState.value,
                                enabled = true,
                                onCheckedChange = { checkedState.value = it },

                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color(181, 98, 56),
                                    checkedTrackColor = Color(144, 77, 161),
                                    checkedTrackAlpha= 0.2f,
                                    uncheckedTrackColor = Color.Black,
                                    uncheckedThumbColor = Color(37, 23, 41),
                                    uncheckedTrackAlpha= 0.2f,
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Smart(){

    var checkedState = remember {
        mutableStateOf(false)
    }
    Row(modifier = Modifier.fillMaxWidth(.48F)) {
        Column(Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(
                Color(94, 94, 94),
                Color(38, 38, 38),
            )), shape = RoundedCornerShape(20.dp, 50.dp, 20.dp, 50.dp))) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                Column(Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.47F), verticalArrangement = Arrangement.SpaceEvenly) {
                    Icon(painter = painterResource(id = R.drawable.smart_tv), contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp))
                    Text(text = "Smart Tv", fontWeight = FontWeight.Normal, color = Color.White, fontSize = 20.sp)
                }
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = if (checkedState.value){"on"}else{"off"}, color = Color(150, 150, 150), fontSize = 18.sp)

                        Box(modifier = Modifier.fillMaxWidth(),
                            contentAlignment= Alignment.TopEnd) {
                            Switch(
                                checked= checkedState.value,
                                enabled = true,
                                onCheckedChange = { checkedState.value = it },

                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color(181, 98, 56),
                                    checkedTrackColor = Color(144, 77, 161),
                                    checkedTrackAlpha= 0.2f,
                                    uncheckedTrackColor = Color.Black,
                                    uncheckedThumbColor = Color(37, 23, 41),
                                    uncheckedTrackAlpha= 0.2f,
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Lamp(){

    var checkedState = remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth(.90F)) {
        Column(Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(
                Color(94, 94, 94),
                Color(38, 38, 38),
            )), shape = RoundedCornerShape(50.dp, 20.dp, 50.dp, 20.dp))) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                Column(Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.45F), verticalArrangement = Arrangement.SpaceEvenly) {
                    Icon(painter = painterResource(id = R.drawable.lamp), contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp))
                    Text(text = "Lamp", fontWeight = FontWeight.Normal, color = Color.White, fontSize = 20.sp)
                }
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = if (checkedState.value){"on"}else{"off"}, color = Color(150, 150, 150), fontSize = 18.sp)

                        Box(modifier = Modifier.fillMaxWidth(),
                            contentAlignment= Alignment.TopEnd) {
                            Switch(
                                checked= checkedState.value,
                                enabled = true,
                                onCheckedChange = { checkedState.value = it },

                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color(181, 98, 56),
                                    checkedTrackColor = Color(144, 77, 161),
                                    checkedTrackAlpha= 0.2f,
                                    uncheckedTrackColor = Color.Black,
                                    uncheckedThumbColor = Color(37, 23, 41),
                                    uncheckedTrackAlpha= 0.2f,
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Router(){

    val checkedState= remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth(.90F)) {
        Column(Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(
                Color(94, 94, 94),
                Color(38, 38, 38),
            )), shape = RoundedCornerShape(50.dp, 20.dp, 50.dp, 20.dp))) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                Column(Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.45F), verticalArrangement = Arrangement.SpaceEvenly) {
                    Icon(painter = painterResource(id = R.drawable.router), contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp))
                    Text(text = "Router", fontWeight = FontWeight.Normal, color = Color.White, fontSize = 20.sp)
                }
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = if (checkedState.value){"on"}else{"off"}, color = Color(150, 150, 150), fontSize = 18.sp)

                        Box(modifier = Modifier.fillMaxWidth(),
                            contentAlignment= Alignment.TopEnd) {
                            Switch(
                                checked= checkedState.value,
                                enabled = true,
                                onCheckedChange = { checkedState.value = it },

                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color(181, 98, 56),
                                    checkedTrackColor = Color(144, 77, 161),
                                    checkedTrackAlpha= 0.2f,
                                    uncheckedTrackColor = Color.Black,
                                    uncheckedThumbColor = Color(37, 23, 41),
                                    uncheckedTrackAlpha= 0.2f,
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GigiTheme {
        Greeting(profile = Profile("Gigi", R.drawable.sun_cloud, "28", "Cloudy", "Sidoluhor, Godean", 31,65,3,1009))
    }
}