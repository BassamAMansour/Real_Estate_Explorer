package org.sweng.realestateexplorer.data.estates

import android.os.Parcelable
import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*

@Parcelize
data class Estate(
    var id: String = "",
    var title: String = "",
    var address: Address = Address(),
    @get:PropertyName("img_url") @set:PropertyName("img_url")
    var imgUrl: List<String> = emptyList(),
    @get:PropertyName("owner_id") @set:PropertyName("owner_id")
    var ownerId: String = "",
    var price: Int = 0,
    @get:PropertyName("creation_time") @set:PropertyName("creation_time")
    var creationTime: Timestamp = Timestamp(Date())
) : Parcelable

@Parcelize
data class Address(
    var address: String = "",
    var city: String = "",
    var country: String = "",
    var zip: String = "",
    var location: @RawValue GeoPoint = GeoPoint(0.0, 0.0)
) : Parcelable

