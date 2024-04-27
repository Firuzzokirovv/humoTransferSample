package com.firuz.humotransfersample.ChooseCountry.model

import android.os.Parcel
import android.os.Parcelable

data class ChooseCountryModel(
    val countryName: String,
    val image: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(countryName)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChooseCountryModel> {
        override fun createFromParcel(parcel: Parcel): ChooseCountryModel {
            return ChooseCountryModel(parcel)
        }

        override fun newArray(size: Int): Array<ChooseCountryModel?> {
            return arrayOfNulls(size)
        }
    }
}
