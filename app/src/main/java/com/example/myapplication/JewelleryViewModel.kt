package com.example.myapplication

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class JewelleryViewModel : ViewModel() {
    var jewelleryList by mutableStateOf(
       listOf<Jewellery>(
           Jewellery(
        "necklaces1",
        "3,00,000",
        "Necklaces"
        ),
        Jewellery(
            "diamond necklaces1",
            "3,00,000",
            "Necklaces"
        ),
        Jewellery(
            "necklaces2",
            "3,00,000",
            "Necklaces"
        ),
        Jewellery(
            "neckless3",
            "3,00,000",
            "Necklaces"
        ),
        Jewellery(
            "diamond necklaces2",
            "3,00,000",
            "Necklaces"
        ),
        Jewellery(
            "earrings1",
            "3,00,000",
            "Earrings"
        ),
        Jewellery(
            "earrings2",
            "3,00,000",
            "Earrings"
        )
       )
    )

    val necklacesList = mutableListOf<Jewellery>(
        Jewellery(
            "necklaces1",
            "3,00,000",
            "Necklaces"
        ),
        Jewellery(
            "necklaces2",
            "5,00,000",
            "Necklaces"
        ),
        Jewellery(
            "necklaces3",
            "4,00,000",
            "Necklaces"
        )

    )

    fun onchangeList(category: String )
    {
        if(category == "Necklaces") {
            jewelleryList = necklacesList
        }
    }


}

