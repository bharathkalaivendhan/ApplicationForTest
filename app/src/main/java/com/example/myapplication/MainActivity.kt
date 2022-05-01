package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    JewelleryRecycleView()

                }
            }
        }
    }

}

@Composable
fun JewelleryRecycleView()
{
    val jewellery = remember {
        JewelleryInfoProvider.JewelleryList
    }

    LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
     itemsIndexed(
         items = jewellery,
         itemContent = {index, item -> JewelleryCard(jewel = item) }
     )
    }
}

//@Preview (showBackground = true)
@Composable
fun JewelleryCard(jewel : JewelleryInfo)
{
    val hasToGoFullDetailsScreen : () -> Unit = {}

    Card(
        /*
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxSize()
            .clickable(onClick = hasToGoFullDetailsScreen),
         */
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        elevation = 3.dp,
        backgroundColor = androidx.compose.ui.graphics.Color.Black,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Row {

            Image(
                painter = painterResource(id = R.drawable.jewel),
                contentDescription = "jewelly image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(90.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                //contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = jewel.JewellryName.toString(),
                    /*
                    modifier = Modifier
                        .fillMaxHeight(0.70f)
                        .wrapContentHeight(Alignment.Top)
                        .align(Alignment.CenterHorizontally),

                     */
                    style = MaterialTheme.typography.h6,
                    color = androidx.compose.ui.graphics.Color.Red

                )
                Text(
                    text = jewel.Price.toString(),
                    /*
                    modifier = Modifier
                        .fillMaxHeight(0.30f)
                        // .wrapContentHeight(Alignment.Bottom)
                        .align(Alignment.End),
                     */
                    style = MaterialTheme.typography.caption,
                    color = androidx.compose.ui.graphics.Color.Red
                )
            }

        }

    }
}




