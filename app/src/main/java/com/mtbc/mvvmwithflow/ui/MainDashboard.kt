package com.mtbc.mvvmwithflow.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mtbc.mvvmwithflow.Adapter.ExploreAdapter
import com.mtbc.mvvmwithflow.R
import com.mtbc.mvvmwithflow.appointments.adapter.PatientAppointmentsAdapter
import com.mtbc.mvvmwithflow.appointments.model.AppointmentsModel
import com.mtbc.mvvmwithflow.databinding.ActivityDashboardBinding
import com.mtbc.mvvmwithflow.slidingNav.CenteredTextFragment
import com.mtbc.mvvmwithflow.slidingNav.menu.DrawerAdapter
import com.mtbc.mvvmwithflow.slidingNav.menu.DrawerItem
import com.mtbc.mvvmwithflow.slidingNav.menu.SimpleItem
import com.mtbc.mvvmwithflow.slidingNav.menu.SpaceItem
import com.mtbc.mvvmwithflow.slidingNav.slidingrootnav.SlidingRootNav
import com.mtbc.mvvmwithflow.slidingNav.slidingrootnav.SlidingRootNavBuilder


class MainDashboard : AppCompatActivity(), DrawerAdapter.OnItemSelectedListener {

    companion object {
        private const val POS_DASHBOARD = 0
        private const val POS_ACCOUNT = 1
        private const val POS_MESSAGES = 2
        private const val POS_CART = 3
        private const val POS_LOGOUT = 5
    }

    private lateinit var screenTitles: Array<String>
    private lateinit var screenIcons: Array<Drawable?>

    private lateinit var slidingRootNav: SlidingRootNav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dashboard)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        slidingRootNav = SlidingRootNavBuilder(this)
            .withToolbarMenuToggle(toolbar)
            .withMenuOpened(false)
            .withContentClickableWhenMenuOpened(false)
            .withSavedState(savedInstanceState)
            .withMenuLayout(R.layout.menu_left_drawer)
            .inject()

        screenIcons = loadScreenIcons()
        screenTitles = loadScreenTitles()

        val adapter = DrawerAdapter(
            listOf(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_ACCOUNT),
                createItemFor(POS_MESSAGES),
                createItemFor(POS_CART),
                SpaceItem(48),
                createItemFor(POS_LOGOUT)
            )
        )
        adapter.setListener(this)

        val list: RecyclerView = findViewById(R.id.list)
        list.isNestedScrollingEnabled = false
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        adapter.setSelected(POS_DASHBOARD)
    }

    override fun onItemSelected(position: Int) {
        if (position == POS_LOGOUT) {
            finish()
        }
        slidingRootNav.closeMenu()
        val selectedScreen = CenteredTextFragment.createFor(screenTitles[position])
        showFragment(selectedScreen)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun createItemFor(position: Int): DrawerItem<*> {
        return SimpleItem(screenIcons[position]!!, screenTitles[position])
            .withIconTint(color(R.color.textColorSecondary))
            .withTextTint(color(R.color.textColorPrimary))
            .withSelectedIconTint(color(R.color.colorAccent))
            .withSelectedTextTint(color(R.color.colorAccent))
    }

    private fun loadScreenTitles(): Array<String> {
        return resources.getStringArray(R.array.ld_activityScreenTitles)
    }

    private fun loadScreenIcons(): Array<Drawable?> {
        val ta = resources.obtainTypedArray(R.array.ld_activityScreenIcons)
        return Array(ta.length()) { i ->
            val id = ta.getResourceId(i, 0)
            if (id != 0) ContextCompat.getDrawable(this, id) else null
        }.also {
            ta.recycle()
        }
    }

    @ColorInt
    private fun color(@ColorRes res: Int): Int {
        return ContextCompat.getColor(this, res)
    }
}
