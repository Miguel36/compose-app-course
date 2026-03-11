package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skyfallen.myfirstcomposeapp.components.model.MenuItem
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable () -> Unit) {

    val scope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }

    val menuItems = listOf(
        MenuItem(Icons.Default.Notifications, "Notifications", 3),
        MenuItem(Icons.Default.Place, "Location", 0),
        MenuItem(Icons.Default.Settings, "Settings", 1)
    )

    // Container del navigationDrawer
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Menu desplegable (navigation-drawer)
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEndPercent = 4, bottomEndPercent = 4),
                drawerContentColor = Color.Red.copy(0.80f),
                drawerContainerColor = Color.White,
            ) {
                Spacer(Modifier.height(30.dp))
                menuItems.forEachIndexed { index, menuItem ->
                    MyMenuItem(index == selectedIndex, menuItem) {
                        selectedIndex = index

                        scope.launch { drawerState.close() }
                    }
                }
            }
        },
        scrimColor = Color.Black.copy(alpha = 0.70f)
    ) {
        content()
    }
}

@Composable
fun MyMenuItem(isMenuItemSelected: Boolean, menuItem: MenuItem, onItemSelected: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(text = menuItem.text) },
        selected = isMenuItemSelected,
        onClick = { onItemSelected() },
        icon = { Icon(imageVector = menuItem.icon, contentDescription = "") },
        badge = {
            if (menuItem.notificationsNumber > 0)
                Badge(
                    containerColor = if (isMenuItemSelected) Color.Blue else Color.White,
                    contentColor = if (isMenuItemSelected) Color.White else Color.Blue
                ) {
                    Text(text = menuItem.notificationsNumber.toString())
                }
        },
        shape = RoundedCornerShape(4),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.Blue.copy(0.15f),
            selectedTextColor = Color.Blue,
            selectedIconColor = Color.Black,
            selectedBadgeColor = Color.White,
            unselectedContainerColor = Color.Blue.copy(0.02f),
            unselectedTextColor = Color.Black,
            unselectedIconColor = Color.Blue
        )
    )
}