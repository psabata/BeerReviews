package info.petrsabata.beer.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

//[
//  {
//    "id": 1571,
//    "uid": "476640d7-e524-4502-aea3-23a6957b69aa",
//    "brand": "Coors lite",
//    "name": "Sapporo Premium",
//    "style": "Belgian Strong Ale",
//    "hop": "Ultra",
//    "yeast": "3942 - Belgian Wheat",
//    "malts": "Munich",
//    "ibu": "93 IBU",
//    "alcohol": "8.4%",
//    "blg": "12.5°Blg"
//  }
//]
@JsonIgnoreProperties(ignoreUnknown = true)
data class Beer(
        val id: Int,
        val brand: String,
        val name: String,
        val alcohol: String,
)