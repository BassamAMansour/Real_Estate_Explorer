package org.sweng.realestateexplorer.data.users

import android.os.Parcelable
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: String = "",
    @get:PropertyName("first_name") @set:PropertyName("first_name")
    var firstName: String = "",
    @get:PropertyName("last_name") @set:PropertyName("last_name")
    var lastName: String = "",
    var email: String = "",
    var phone: String = "",
    @get:PropertyName("img_url") @set:PropertyName("img_url")
    var imgUrl: String = "",
    @get:PropertyName("listing_ids") @set:PropertyName("listings_ids")
    var listingIds: List<String> = emptyList()
) : Parcelable