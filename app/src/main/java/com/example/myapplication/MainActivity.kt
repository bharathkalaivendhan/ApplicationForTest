package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

/*
val JewelleryCategoryList = mutableListOf<String>(
    "Necklaces",
    "Ear rings",
    "Rings",
    "bangles"
)
 */

//lateinit var jewellery : MutableList<Jewellery>


class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

         val viewModel = JewelleryViewModel()
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    ContentView(viewModel,this)

                }
            }
        }
    }

}



@ExperimentalMaterialApi
@Composable
fun ContentView(viewModel: JewelleryViewModel, mainActivity: MainActivity)
{
    /*
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = Color.Red,
        contentColor = Color.Blue
    )
    */
    Column {

        LazyRow()
        {

            itemsIndexed(
                items = viewModel.jewelleryList,
                itemContent = { index, item -> CategoryCard(Category = item.Category, viewModel) }
            )

        }

        JewelleryCardListView(viewModel, mainActivity)
    }
}


@Composable
fun CategoryCard(Category: String, viewModel: JewelleryViewModel)
{
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .width(100.dp)
            .height(50.dp)
            .clickable { viewModel.onchangeList(Category) },
        elevation = 3.dp,
        backgroundColor = androidx.compose.ui.graphics.Color.LightGray,
    )
    {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = Category)
        }

    }
}


@ExperimentalMaterialApi
@Composable
fun JewelleryCardListView(viewModel: JewelleryViewModel, mainActivity: MainActivity)
{


    LazyColumn(
            //contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
        ){
            itemsIndexed(
                items = viewModel.jewelleryList,
                itemContent = {index, item -> JewelleryCard(jewellery = item, viewModel, mainActivity) }
            )
        }
}

@ExperimentalMaterialApi
@Composable
fun JewelleryCard(jewellery: Jewellery, viewModel: JewelleryViewModel, mainActivity: MainActivity)
{
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
        backgroundColor = androidx.compose.ui.graphics.Color.Black,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {takeToNextActivity(mainActivity,context,jewellery)}
    ) {

        Row {

            Image(
                painter = painterResource(id = R.drawable.jewel),
                contentDescription = "jewelly image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.50f)
                    .height(150.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = jewellery.JewellryName,
                    style = MaterialTheme.typography.h5,
                    color = androidx.compose.ui.graphics.Color.Red

                )
                Text(
                    text = jewellery.Price,
                    style = MaterialTheme.typography.h6,
                    color = androidx.compose.ui.graphics.Color.Red
                )
            }

        }

    }
}

fun takeToNextActivity(mainActivity: MainActivity, context: Context, jewellery: Jewellery,) {
    val intent = Intent(mainActivity,DetailsActivity::class.java)
    intent.putExtra( "jewelleryInfo", jewellery )
    context.startActivity(intent)
}




