package org.sweng.realestateexplorer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.ui.estatedetail.EstateDetailFragment

class EstateDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estate_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EstateDetailFragment.newInstance())
                .commitNow()
        }
    }
}
