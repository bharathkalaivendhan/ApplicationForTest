package com.example.myapplication

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class DetailsActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {

        val myIntent = intent
        val jewelleryInfo = myIntent.getSerializableExtra("jewelleryInfo") as Jewellery

        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    MainView(jewelleryInfo = jewelleryInfo)

                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainView(jewelleryInfo: Jewellery)
{
    val image = painterResource(id = R.drawable.jewel)

    Image(
        painter = image,
        contentDescription = "jewelly image",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )

    BottomSheetScaffoldVeiw(jewelleryInfo)

}

@ExperimentalMaterialApi
@Composable
fun BottomSheetScaffoldVeiw(jewelleryInfo: Jewellery) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    //val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        sheetContent = {
            BottomSheetContent(jewelleryInfo)
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = Color.Blue,
        sheetPeekHeight = 200.dp,
        // scrimColor = Color.Red,  // Color for the fade background when you open/close the bottom sheet
    ) {
        /* Add code later */
    }
}


@ExperimentalMaterialApi
@Composable
fun BottomSheetContent(jewelleryInfo: Jewellery) {


    Box(
       modifier = Modifier
           .verticalScroll(rememberScrollState())

    )
    {
        Column{
            Text(text = "text1")
            Spacer(modifier = Modifier.size(250.dp))

            Text(text = "text2")
            Spacer(modifier = Modifier.size(250.dp))

            Text(text = "text3")
            Spacer(modifier = Modifier.size(250.dp))

            Text(text = "text4")
            Spacer(modifier = Modifier.size(250.dp))

            Text(text = "text5")
            Spacer(modifier = Modifier.size(250.dp))

        }
    }

}


