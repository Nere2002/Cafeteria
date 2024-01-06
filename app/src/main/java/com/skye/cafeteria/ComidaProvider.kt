package com.skye.cafeteria

class ComidaProvider {
    companion object{

        val comidaList = listOf<DataClassMenu>(
            DataClassMenu(
                "Pastel de Limon",
                "Glaseado de limon",
                6.0,
                "C:\\Users\\Nerea\\Desktop\\ADAM2.2\\Cafeteria\\app\\src\\main\\java\\com\\skye\\cafeteria\\imagenesMenu\\PastelDeLimon.png"
            ),
            DataClassMenu(
                "Tarta de fresa",
                "Glaseado de freas",
                10.0,
                "C:\\Users\\Nerea\\Desktop\\ADAM2.2\\Cafeteria\\app\\src\\main\\java\\com\\skye\\cafeteria\\imagenesMenu\\TartaDeFresa.png"
            ),
            DataClassMenu(
                "Panini",
                "jamon dulce i queso",
                5.0,
                "https://google.com/loquesea.jpg"
            ),
            DataClassMenu(
                "Panini",
                "atun con queso",
                5.0,
                "https://google.com/loquesea.jpg"
            ),
            DataClassMenu(
                "Ensaimada",
                "Azucar glass",
                2.0,
                "https://imag.bonviveur.com/ensaimada-de-mallorca-casera.jpg"
            ),

        )
    }
}