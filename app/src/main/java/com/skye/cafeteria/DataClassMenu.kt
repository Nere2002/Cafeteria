package com.skye.cafeteria

import android.os.Parcel
import android.os.Parcelable

data class DataClassMenu(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagen: String,

) : Parcelable {
    // Implementación del constructor secundario para la parcelación
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: ""
    )

    // Implementación del método describeContents requerido por Parcelable
    override fun describeContents(): Int {
        return 0
    }

    // Implementación del método writeToParcel para escribir los datos en el Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeDouble(precio)
        parcel.writeString(imagen)
    }

    // Objeto compañero para crear instancias y leer desde el Parcel
    companion object CREATOR : Parcelable.Creator<DataClassMenu> {
        override fun createFromParcel(parcel: Parcel): DataClassMenu {
            return DataClassMenu(parcel)
        }

        override fun newArray(size: Int): Array<DataClassMenu?> {
            return arrayOfNulls(size)
        }
    }
}

