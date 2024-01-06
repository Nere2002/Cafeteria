package com.skye.cafeteria

class BebidaProvider {
    companion object{
        val bebidaList = listOf<DataClassMenu>(
            DataClassMenu(
                "Cafe",
                "Cafe solo",
                6.0,
                "https://img.freepik.com/foto-gratis/deliciosos-granos-cafe-taza_23-2150691429.jpg?size=626&ext=jpg&ga=GA1.1.1687694167.1702771200&semt=sph"),
            DataClassMenu(
                "Cafe con leche",
                "cortado corto de cafe",
                10.0,
                "https://www.coffeecorner.es/wp-content/uploads/2019/10/LATTE.jpg"
            ),
            DataClassMenu(
                "capuchino",
                "cafe",
                5.0,
                "https://todocafe.es/wp-content/uploads/2020/04/Cafe_capuchino-1140x760.jpg"
            ),
            DataClassMenu(
                "Batido de fresa",
                "fresa con nata ",
                5.0,
                "https://okdiario.com/img/2019/12/19/receta-de-batido-refrescante-de-fresa-y-leche-condensada.jpg"
            ),
            DataClassMenu(
                "Batido de chocolate",
                "chocolate con nata",
                2.0,
                "https://milvalles.es/wp-content/uploads/2021/07/batido-web.jpg"
            ),

            )
    }
}