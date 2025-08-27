package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.components.model.NavItem

@Composable
fun MyNavigationBar() {
    val itemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Favorites", Icons.Default.Favorite),
        NavItem("Profile", Icons.Default.Person)
    )
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(tonalElevation = 2.dp) {
        itemList.forEachIndexed { index, item ->
            SkyFallenItem(item, index == selectedIndex) {
                selectedIndex = index
            }
        }
    }

}

@Composable
fun RowScope.SkyFallenItem(navItem: NavItem, isSelected: Boolean, onItemClick: () -> Unit ) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onItemClick() },
        icon = {
            Icon(imageVector = navItem.icon, contentDescription = "")
        },
        label = { Text(text = navItem.name)  },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red,
            selectedTextColor = Color.Red,
            indicatorColor = Color.White,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.DarkGray,
            disabledIconColor = Color.White,
            disabledTextColor = Color.DarkGray
        )
    )
}
