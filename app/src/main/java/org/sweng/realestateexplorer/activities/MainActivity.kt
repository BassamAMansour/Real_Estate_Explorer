package org.sweng.realestateexplorer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.ui.estatelist.EstateListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EstateListFragment.newInstance())
                .commitNow()
        }
    }
}
